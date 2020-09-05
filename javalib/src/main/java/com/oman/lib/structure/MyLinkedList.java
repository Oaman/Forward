package com.oman.lib.structure;

public class MyLinkedList<E> {
    private int size;
    private Node<E> head;
    private Node<E> last;


    public Node<E> get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("illegal index:" + index);
        }
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void add(E e) {
        Node<E> newNode = new Node<>(e);
        //如果沒有元素，就插在头部
        if (size == 0) {
            head = newNode;
        } else {
            //否则插在链表的尾部
            last.next = newNode;
        }
        last = newNode;
        size++;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("illegal index:" + index);
        }
        Node<E> newNode = new Node<>(e);
        //如果沒有元素，就插在头部
        if (size == 0) {
            head = newNode;
            last = newNode;
        } else if (index == 0) {
            //如果想要插在头部第一个位置
            newNode.next = head;
            head = newNode;
        } else if (index == size) {
            //如果想要插在链表的尾部
            last.next = newNode;
            last = newNode;
        } else {
            //如果是中间插入  这里的赋值顺序不能变化，否则会造成死循环
            Node<E> preNode = get(index - 1);
            newNode.next = preNode.next;
            preNode.next = newNode;
        }
        size++;
    }

    public Node<E> remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("illegal index:" + index);
        }
        Node<E> remove = get(index);
        if (index == 0) {
            //移除头部
            head = remove.next;
        } else if (index == size - 1) {
            //移除尾部
            Node<E> perNode = get(index - 1);
            last = perNode;
            perNode.next = null;
        } else {
            //移除中间节点
            Node<E> perNode = get(index - 1);
            perNode.next = remove.next;
            remove.next = null;
        }
        size--;
        return remove;
    }


    public boolean remove(E data) {
        Node<E> node = head;
        for (int i = 0; i < size; i++) {
            if (node.date.equals(data)) {
                remove(i);
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (Node<E> node = head; node != null; node = node.next) {
            builder.append(node.date).append(" ");
        }
        builder.append("]");
        return builder.toString();
    }

    private static class Node<E> {
        E date;
        Node<E> next;

        public Node(E e) {
            this.date = e;
        }
    }

    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("4");
        list.add(0, "1");
        list.add(1, "2");
        list.add(2, "3");
        list.add(2, "4");
        list.add(2, "5");

        list.remove(1);
        list.remove("3");
        System.out.println(list.toString());
    }
}

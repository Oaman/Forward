package com.oman.lib.structure;

public class MyDequeLinkedList<E> {
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
        if (last == null) {
            head = newNode;
        } else {
            last.next = newNode;
            newNode.pre = last;
        }
        last = newNode;
        size++;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("illegal index:" + index);
        }
        if (index == size) {
            add(e);
        } else {
            Node<E> curr = get(index);
            Node<E> pre = curr.pre;
            Node<E> newNode = new Node<>(e);
            newNode.next = curr;
            curr.pre = newNode;
            if (pre != null) {
                pre.next = newNode;
                newNode.pre = pre;
            }
            size++;
        }
    }

    public Node<E> remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("illegal index:" + index);
        }
        Node<E> curr = get(index);
        if (index == 0) {
            //移除头部
            head = curr.next;
            curr.next = null;
        } else if (index == size - 1) {
            //移除尾部
            last = curr.pre;
            curr.pre.next = null;
            curr.pre = null;
        } else {
            //移除中间节点
            curr.pre.next = curr.next;
            curr.next.pre = curr.pre;
        }
        size--;
        return curr;
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
        Node<E> pre;
        Node<E> next;

        public Node(E date) {
            this.date = date;
        }
    }

    public static void main(String[] args) {
        MyDequeLinkedList<String> list = new MyDequeLinkedList<>();
        list.add(0, "4");
        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println(list.get(3).date);
        System.out.println(list.toString());
//        list.remove("4");
        list.remove("3");
        System.out.println(list.toString());
//        list.remove("3");
//        System.out.println(list.toString());
    }
}

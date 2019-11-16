package com.oman.forward.pattern.structure.composite;

public class Test {
    public static void main(String[] args) {
        /**
         * 需求：有三种书籍  总书籍下面有小说类和科技类书籍
         * 科技类下面有计算机和医学类书籍
         * 要分别统计每类书籍小说类 计算机类 医学类  和总的书籍的浏览量和销售量 实现这个功能
         * 组合模式：将对象组合成树形结构以表示“部分-整体”的层次结构。组合模式使得用户对单个对象和组合对象的使用具有一致性。
         */
        NovelBookStatistic novelBookStatistic = new NovelBookStatistic();
        int novelBrowseCount = novelBookStatistic.countBrowse();
        int novelSaleCount = novelBookStatistic.countSale();
        System.out.println("小说类书籍浏览量为:" + novelBrowseCount + "--销售量为：" + novelSaleCount);

        ComputerBookStatistic computerBookStatistic = new ComputerBookStatistic();
        int computerBrowseCount = computerBookStatistic.countBrowse();
        int computerSaleCount = computerBookStatistic.countSale();
        System.out.println("计算机类书籍浏览量为:" + computerBrowseCount + "--销售量为：" + computerSaleCount);


        MedicalBookStatistic medicalBookStatistic = new MedicalBookStatistic();
        int medicalBrowseCount =medicalBookStatistic.countBrowse();
        int medicalSaleCount = medicalBookStatistic.countSale();
        System.out.println("医学类书籍浏览量为:" + medicalBrowseCount + "--销售量为：" + medicalSaleCount);

        TechnologyBookStatistic technologyBookStatistic = new TechnologyBookStatistic();
        int technologyBrowseCount = technologyBookStatistic.countBrowse();
        int technologySaleCount = technologyBookStatistic.countSale();
        System.out.println("技术类(计算机和医学)书籍浏览量为:" + technologyBrowseCount + "--销售量为：" + technologySaleCount);

        AllBookStatistic allBookStatistic = new AllBookStatistic();
        int allBrowseCount = allBookStatistic.countBrowse();
        int allSaleCount = allBookStatistic.countSale();
        System.out.println("所有书籍浏览量为:" + allBrowseCount + "--销售量为：" + allSaleCount);

    }
}

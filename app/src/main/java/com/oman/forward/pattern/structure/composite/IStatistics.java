package com.oman.forward.pattern.structure.composite;

public interface IStatistics {
    /**
     * 现在有这么一个需求，就是有三种书籍  总书籍下面有小说类和科技类书籍
     * 科技类下面有计算机和医学类书籍
     * 要分别统计每类书籍小说类 计算机类 医学类  和总的书籍的浏览量和销售量 实现这个功能
     * @return
     */
    int countBrowse();
    int countSale();
}

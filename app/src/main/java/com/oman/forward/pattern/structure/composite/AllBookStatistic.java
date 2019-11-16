package com.oman.forward.pattern.structure.composite;

import java.util.ArrayList;
import java.util.List;

public class AllBookStatistic implements IStatistics {

    List<IStatistics> mStatistics = new ArrayList<>();

    /**
     * 此类是将计算机类书籍和医学类书籍归并为技术类书籍
     */
    public AllBookStatistic() {
        mStatistics.add(new TechnologyBookStatistic());
        mStatistics.add(new MedicalBookStatistic());
    }

    @Override
    public int countBrowse() {
        int browseCount = 0;
        for (IStatistics statistics : mStatistics) {
            browseCount += statistics.countBrowse();
        }
        return browseCount;
    }

    @Override
    public int countSale() {
        int saleCount = 0;
        for (IStatistics statistics : mStatistics) {
            saleCount += statistics.countSale();
        }
        return saleCount;
    }
}

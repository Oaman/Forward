package com.oman.forward.pattern.structure.composite;

public class MedicalBookStatistic implements IStatistics {
    /**
     * 医学类的书籍统计
     *
     * @return
     */
    @Override
    public int countBrowse() {
        int browseCount = 0;
        String[] allMedical = getAllMedicals();
        for (String s : allMedical) {
            browseCount += countBrowse(s);
        }
        return browseCount;
    }

    @Override
    public int countSale() {
        int saleCount = 0;
        String[] allMedicals = getAllMedicals();
        for (String s : allMedicals) {
            saleCount += countSale(s);
        }
        return saleCount;
    }

    private String[] getAllMedicals() {

        return new String[]{"《细胞的神奇之处》", "《如何有效降低血糖》"};
    }

    private int countBrowse(String s) {
        return 3;
    }

    private int countSale(String s) {
        return 2;
    }
}

package com.oman.forward.pattern.structure.composite;

public class ComputerBookStatistic implements IStatistics {
    /**
     * 电脑的书籍统计
     *
     * @return
     */
    @Override
    public int countBrowse() {
        int browseCount = 0;
        String[] allComputer = getAllComputers();
        for (String s : allComputer) {
            browseCount += countBrowse(s);
        }
        return browseCount;
    }

    @Override
    public int countSale() {
        int saleCount = 0;
        String[] allComputers = getAllComputers();
        for (String s : allComputers) {
            saleCount += countSale(s);
        }
        return saleCount;
    }

    private String[] getAllComputers() {

        return new String[]{"《敏捷软件开发》", "《深入理解JAVA虚拟机》"};
    }

    private int countBrowse(String s) {
        return 4;
    }

    private int countSale(String s) {
        return 3;
    }
}

package com.oman.forward.pattern.structure.composite;

public class NovelBookStatistic implements IStatistics {
    /**
     * 小说类的书籍统计
     *
     * @return
     */
    @Override
    public int countBrowse() {
        int browseCount = 0;
        String[] allNovel = getAllNovels();
        for (String s : allNovel) {
            browseCount += countBrowse(s);
        }
        return browseCount;
    }

    @Override
    public int countSale() {
        int saleCount = 0;
        String[] allNovels = getAllNovels();
        for (String s : allNovels) {
            saleCount += countSale(s);
        }
        return saleCount;
    }

    private String[] getAllNovels() {

        return new String[]{"平凡的世界", "梦里花落知多少"};
    }

    private int countBrowse(String s) {
        return 2;
    }

    private int countSale(String s) {
        return 2;
    }
}

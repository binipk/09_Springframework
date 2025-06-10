package com.ohgiraffers.datajpa.common;

import org.springframework.data.domain.Page;

public class Pagenation {
    /*어떤 페이지를 들어가든 1~10페이지까지만 표시되게끔*/
    public static PagingButton getPagingButtonInfo(Page page) {
        int currentPage = page.getNumber() + 1;
        int defaultButtonCount = 10;
        int startPage
                = (int) (Math.ceil((double) currentPage / defaultButtonCount) - 1)
                * defaultButtonCount + 1;
        int endPage = startPage + defaultButtonCount - 1;
        if(page.getTotalPages() < endPage) endPage = page.getTotalPages();
        if(page.getTotalPages() == 0 && endPage == 0) endPage = startPage;
        return new PagingButton(currentPage, startPage, endPage);
    }
}

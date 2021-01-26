package com.example.android.testing.espresso.Test.page;

public class Page {

    public PageCommon common;
    public PageMain main;
    public PageSearch search;

    public Page () {
        common = new PageCommon();
        main = new PageMain();
        search = new PageSearch();
    }

}

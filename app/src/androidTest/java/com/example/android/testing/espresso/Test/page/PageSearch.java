package com.example.android.testing.espresso.Test.page;

import androidx.test.espresso.ViewInteraction;

import co.fun.testgiphy.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


public class PageSearch extends PageCommon {

    public ViewInteraction txtSearch() {
        return onView(withId(R.id.etSearchToolbar));
    }

    public ViewInteraction btnBack() {
        return onView(nthChildOf(withId(R.id.tbFragmentSearch), 1));
    }

    public ViewInteraction lable() {
        return onView(withId(R.id.tvEmptyListVH));
    }


    public void searchText(String text) {
        txtSearch().perform(clearText());
        txtSearch().perform(typeText(text), closeSoftKeyboard());
    }

    public ViewInteraction firstGif() {
        return onView(nthChildOf(withId(R.id.rvFragmentSearch), 0));
    }

}

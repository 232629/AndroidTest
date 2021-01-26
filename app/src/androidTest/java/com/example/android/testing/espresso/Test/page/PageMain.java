package com.example.android.testing.espresso.Test.page;

import androidx.test.espresso.ViewInteraction;

import co.fun.testgiphy.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class PageMain extends PageCommon {

    public ViewInteraction title() {
        return onView(withText("Giphy"));
    }

    public ViewInteraction btnSearch() {
        return onView(nthChildOf(withId(R.id.tbFragmentTrending), 1));
    }

    public ViewInteraction firstGif() {
        return onView(nthChildOf(withId(R.id.rvFragmentTrending), 0));
    }


}

/*
 * Copyright 2015, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.testing.espresso.Test;

import android.app.Activity;
import android.view.KeyEvent;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.example.android.testing.espresso.Test.page.Page;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import co.fun.testgiphy.MainActivity;
import co.fun.testgiphy.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.pressKey;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;



@RunWith(AndroidJUnit4.class)
@LargeTest
public class GlphyClientTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    static Page page;

    @BeforeClass
    static public void beforeClass () throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        page = new Page();
    }

    @Before
    public void before () {
        page.main.title().check(matches(isDisplayed()));
    }

    @Test
    public void checkBackButton()  {

        page.main.btnSearch().perform(click());

        page.search.txtSearch().check(matches(withText("")));
        page.search.btnBack().perform(click());

        page.main.title().check(matches(isDisplayed()));
    }

    @Test
    public void checkBackButtonClearSearch()  {

        page.main.btnSearch().perform(click());

        page.search.searchText("Hello");
        page.search.btnBack().perform(click());

        page.main.title().check(matches(isDisplayed()));
        page.main.btnSearch().perform(click());

        page.search.txtSearch().check(matches(withText("")));
    }

    @Test
    public void searchInvalidValue()  {

        page.main.btnSearch().perform(click());

        page.search.searchText("#$%^");
        page.search.lable().check(matches(withText("Empty list")));
    }


    // test fall
    @Test
    public void checkEmptyList()  {

        page.main.btnSearch().perform(click());

        for (int i = 0; i < 50; i ++)
            page.search.txtSearch().perform(pressKey(KeyEvent.KEYCODE_ENTER));
        page.search.lable().check(matches(withText("Empty list")));
    }

    @Test
    public void checkNotExistEmptyList()  {

        page.main.btnSearch().perform(click());

        page.search.lable().check((doesNotExist()));
    }



    @Test
    public void checkDefaultGif()  {

        page.main.firstGif().check(matches(isDisplayed()));
    }

    @Test
    public void checkValidSearch()  {

        page.main.btnSearch().perform(click());

        page.search.searchText("Hello");
        page.search.firstGif().check(matches(isDisplayed()));
    }

    @Test
    public void checkNativeBack()  {

        page.main.btnSearch().perform(click());

        page.search.txtSearch().check(matches(withText("")));
        Espresso.pressBack();

        page.main.title().check(matches(isDisplayed()));

    }

}
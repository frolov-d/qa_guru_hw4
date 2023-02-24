package com.jsd;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class SolutionsEnterpriseTest {

    private static final String GITHUB_PAGE = "https://github.com/";
    private static final String EXPECTED_PAGE = "https://github.com/enterprise";
    private static final String EXPECTED_STRING = "Build like the best";

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
//        Configuration.holdBrowserOpen = true;
    }

    @Test
    void enterprisePageShouldBeOpened() {
        open(GITHUB_PAGE);
        $("div.header-menu-wrapper").$(byText("Solutions")).hover();
        $("a.HeaderMenu-dropdown-link[href='/enterprise']").click();
        webdriver().shouldHave(url(EXPECTED_PAGE));
        $(".application-main ").shouldHave(text(EXPECTED_STRING));
    }
 }

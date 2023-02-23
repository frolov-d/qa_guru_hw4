package com.jsd;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SoftAssertionsTest {

    private static final String selenidePage = "https://github.com/selenide/selenide";
    private static final String exampleToCheck = """
            @ExtendWith({SoftAssertsExtension.class})
            class Tests {
              @Test
              void test() {
                Configuration.assertionMode = SOFT;
                open("page.html");
                        
                $("#first").should(visible).click();
                $("#second").should(visible).click();
              }
            }
            """;

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
//        Configuration.holdBrowserOpen = true;
    }

    @Test
    void softAssertionsPageShouldHaveJUnit5ExampleCode() {
        open(selenidePage);
        $("#wiki-tab").click();
        $("#wiki-pages-box").$("button").click();
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        $(byText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text(exampleToCheck));
    }
}

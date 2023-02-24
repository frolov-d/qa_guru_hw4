package com.jsd;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    public static final String FIGURE_PAGE = "https://the-internet.herokuapp.com/drag_and_drop";

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
//        Configuration.holdBrowserOpen = true;
    }

    @Test
    void figuresShouldBeSwappedByDragAndDropTest() {
        open(FIGURE_PAGE);
        $("#column-a").dragAndDropTo($("#column-b"));
        $("#column-b").shouldHave(text("A"));
    }

    @Test
    void figuresShouldBeSwappedByActionsTest() {
        open(FIGURE_PAGE);
        actions().clickAndHold($("#column-a"))
                .moveToElement($("#column-b")).release().build().perform();
        $("#column-b").shouldHave(text("A"));
    }
}

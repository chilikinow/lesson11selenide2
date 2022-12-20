package ru.qa.guru;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

/*

2. (опциональное) Запрограммируйте Drag&Drop с помощью Selenide.actions()

        - Откройте https://the-internet.herokuapp.com/drag_and_drop

        - Перенесите прямоугольник А на место В

        - Проверьте, что прямоугольники действительно поменялись

        - В Selenide есть команда $(element).dragAndDrop($(to-element)), проверьте работает ли тест, если использовать её вместо actions()

        Раньше такой тест не работал из-за ошибки в ChromeDriver, но, может быть, уже починили?

 */

public class HerokuappWebPageTest {

    @BeforeEach
    void setUp() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
    }

    @Disabled
    @Tag("Не работает")
    @Test
    void selenideActionsTest() {

        actions()
                .moveToElement($("#column-a"))
                .clickAndHold()
                .moveByOffset(300, 0)
                .release()
                .perform();


        $("#column-a").shouldHave(text("B"));
    }

    @Test
    void dragAndDropTest() {

        $("#column-a")
                .dragAndDropTo("#column-b")
                .shouldHave(text("B"));
    }

}

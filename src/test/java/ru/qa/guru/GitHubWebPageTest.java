package ru.qa.guru;

/*

1. На главной странице GitHub выберите меню Solutions -> Enterprize с помощью команды hover для Solutions.
Убедитесь что загрузилась нужная страница (например что заголовок - "Build like the best."

 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class GitHubWebPageTest {

    @BeforeEach
    void setUp() {
        open("https://github.com/");
        $(withText("Solutions")).hover();
        $(withText("Enterprise")).click();
    }

    @Test
    @DisplayName("Убедитесь что загрузилась нужная страница")
    void checkOpenEnterpriseWebPageTest() {
        webdriver().shouldHave(url("https://github.com/enterprise"));
    }

    @Test
    @DisplayName("Убедитесь что загрузилась нужная страница (например что заголовок - Build like the best)")
    void checkHeaderOnWebPageTest() {
        $x("//h1[text()='Build like the best'][1]").shouldBe(exist);
    }
}

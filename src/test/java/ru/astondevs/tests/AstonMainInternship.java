package ru.astondevs.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AstonMainInternship {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://astondevs.ru";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void astonInternship() {
        open("/");
        $(".chakra-stack.css-azggd9").$(byText("Стажировка")).click();
        $(".Intro_layout__kKzSe").shouldHave(text("Заявка на стажировку"));
        $(byName("surname")).setValue("Самусев");
        $(byName("name")).setValue("Владислав");
        executeJavaScript("arguments[0].value = '26.10.1995';", //arguments[0] представляет собой DOM-элемент,переданный после запятой.
                $(By.name("birthdate")));

        $(".Select_button__WYjox:first-child").click();
        $(".Select_list__3_1Nd").$(byText("Беларусь")).click();
        $(byName("city")).setValue("Новополоцк");



    }
}

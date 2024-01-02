package ru.astondevs.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AstonMainInternship {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://astondevs.ru";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;
    }

    @Test
    void astonInternship() {
        open("/");
        $(".chakra-stack.css-azggd9").$(byText("Стажировка")).click();
        $(".Intro_layout__kKzSe").shouldHave(text("Заявка на стажировку"));

        $(byName("surname")).setValue("Самусев");
        $(byName("name")).setValue("Владислав");

        $("[name='birthdate']").parent().click();
        $("[name='birthdate']").sendKeys("26.10.1995");


        $(".Select_button__WYjox:first-child").click();
        $(".Select_list__3_1Nd").$(byText("Беларусь")).click();

        $(byName("city")).setValue("Новополоцк");
        $(byName("aboutMe")).setValue("Прошел курсы Вадима Ксендзова по ручному тестированию, изучил теорию по книгам Куликова и Савина, " +
                "сам же обучался, как по урокам Руссова и Маршала, автоматизацию изучал по курсам qa.quru.Двигаюсь в направлении автоматизации, так как для меня это больше чем профессия. Она интересна и увлекательна.");

        $(".Select_button__WYjox.Select_withPrependedTooltip__25x8t").click();
        $("[name='informationSource']").$(byText("Рекомендации знакомых-сотрудников Aston")).click();

        $("[name='skype']").setValue("Vlad Samuseu");
        $("[name='phone']").setValue("375333924180");
        $("[name='email']").setValue("s67.freelance@gmail.com");
        $("[name='socialNetworks']").setValue("VK = https://vk.com/kilovat_67, Telegram = @Samus67");
        $("[name='agreement']").parent().click();
        $(".Trainee_navigation__u_Y5I").$(byText("Далее")).click();
        sleep(2000);
    }
}

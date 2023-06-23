package ru.netology.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;

public class DebitCardApplicationTest {
    @Test

    void shouldTest() throws InterruptedException {
        open ("http://localhost:9999");

        SelenideElement form = $("[id=root]");
        form.$("[data-test-id=name] input").setValue("Петров Иван");
        form.$("[data-test-id=phone] input").setValue("+79011234567");
        form.$("[data-test-id=agreement]").click();
        form.$("[role=button]").click();
        form.$("[data-test-id=order-success]").shouldHave(Condition.exactText("  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

        Thread.sleep(5000);


    }
}

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
public class TitleTest extends BaseTest {

    @ParameterizedTest(name = "{1} -  Title checked")
    @CsvFileSource(resources = "/testData.csv")
    @DisplayName("Testing Website titles")
    @Tag("Regression")
    public void shouldValidateCorrectWebsiteTitles(String url, String expectedTitle) {
        driver.get(url);
        log.info("URL address is: " + url);

        String actualTitle = driver.getTitle();
        log.info("Actual title is: " + actualTitle);
        log.trace("You should trace all the paths here");
        log.debug("Debug this");
        log.error("Some error! You have to check that ASAP");

        assertThat(actualTitle).isEqualTo(expectedTitle);
    }

    @Test
    @DisplayName("Testing Sii Website")
    @Tag("Regression")
    @Tag("1")
    public void textSendInquiryShouldBeVisible() {
        driver.get("https://www.sii.pl");
        log.info("URL address is: https://www.sii.pl");

        WebElement button = driver.findElement(By.cssSelector("a.sii-a-button.-small.-secondary.js-contact-button"));
        button.click();
        log.info("Contact button clicked");
        log.debug("Debug this");

        String name = "Agata";
        WebElement inputName = driver.findElement(By.cssSelector("input#name"));
        inputName.sendKeys(name);
        log.info("Name has been entered: " + name);

        log.warn("Please remember to clear the input first");
        inputName.clear();

        String name2 = "Ada";
        inputName.sendKeys(name2);
        log.info("Name has been entered: " + name2);

        WebElement textSendInquiry = driver.findElement(By.cssSelector("h1.sii-m-section-header__title.sii-a-heading.-h1"));
        log.info("Text Send Inquiry is visible");
        log.trace("You should trace all the paths here");
        log.warn("All hands on deck, here could be a problem");
        log.error("Some error! You have to check that ASAP");

        assertThat(inputName.getAttribute("value")).isEqualTo(name2);
        assertThat(textSendInquiry.isDisplayed()).isTrue();
    }

    @Test
    @DisplayName("Testing Sii Website")
    @Tag("Regression")
    @Tag("2")
    public void trainingsForTestersShouldBeVisible() {
        driver.get("https://www.sii.pl");
        log.info("URL address is: https://www.sii.pl");
        log.warn("All hands on deck, here could be a problem");

        WebElement trainingButton = driver.findElement(By.cssSelector("li#sii-m-nav-menu__item--20393"));
        trainingButton.click();
        log.info("Button has been clicked");
        log.trace("You should trace all the paths here");
        log.debug("Debug this");

        String actualTitle = driver.getTitle();
        log.info("Actual title is: " + actualTitle);
        String expectedTitle = "Szkolenia | Sii Polska";

        WebElement trainingForTesters = driver.findElement(By.cssSelector("a.sii-m-card-menu-subtitle__item__link"));
        log.error("Some error! You have to check that ASAP");

        assertThat(trainingForTesters.isDisplayed()).isTrue();
        assertThat(actualTitle).isEqualTo(expectedTitle);
    }
}
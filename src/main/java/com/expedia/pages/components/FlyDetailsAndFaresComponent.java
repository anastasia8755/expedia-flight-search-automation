package com.expedia.pages.components;

import com.expedia.pages.CheckoutPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FlyDetailsAndFaresComponent extends BaseComponent{

    @FindBy(css = "button[data-test-id='select-button']")
    private List<WebElement> selectButtons;

    @FindBy(css = "a[data-test-id='forcedChoiceNoThanks']")
    private WebElement noThanksButton;

    public FlyDetailsAndFaresComponent(WebDriver driver, String baseLocator) {
        super(driver, baseLocator);
    }

    public FlyDetailsAndFaresComponent selectCheapestOption() {
        selectButtons.get(0).click();

        return this;
    }

    public FlyDetailsAndFaresComponent selectBetterOption() {
        if (selectButtons.size() == 2) {
            selectButtons.get(1).click();
        } else {
            throw new RuntimeException("Better option doesn't exist");
        }

        return this;
    }

    public FlyDetailsAndFaresComponent selectMaxOption() {
        if (selectButtons.size() == 3) {
            selectButtons.get(2).click();
        } else {
            throw new RuntimeException("Max option doesn't exist");
        }

        return this;
    }

    public CheckoutPage clickNoThanks() {
        noThanksButton.click();

        return new CheckoutPage(driver);
    }
}

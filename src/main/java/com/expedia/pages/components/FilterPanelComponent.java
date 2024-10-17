package com.expedia.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class FilterPanelComponent extends BaseComponent {

    private final Map<String, WebElement> filters = new HashMap<>();

    public FilterPanelComponent(WebDriver driver, String baseLocator) {
        super(driver, baseLocator);
        for (WebElement element : baseElement.findElements(By.cssSelector("div.uitk-checkbox"))) {
            String text = element.findElement(By.cssSelector("p.uitk-checkbox-label-content")).getText()
                    .replaceAll("\\s*\\(.*\\)$", "");
            WebElement checkbox = element.findElement(By.cssSelector("input[type='checkbox']"));
            filters.put(text, checkbox);
        }
    }

    public FilterPanelComponent setFilter(String name, boolean checked) {
        WebElement checkbox = filters.get(name);

        if (checkbox != null) {
            boolean isChecked = checkbox.getAttribute("class").contains("checked");

            if ((checked && !isChecked) || (!checked && isChecked)) {
                checkbox.click();
            }
        } else {
            System.out.println("Checkbox with name '" + name + "' not found.");
        }

        return this;
    }
}

package com.jjh.selenium.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;

/**
 * This is a JUnit Selenium test.
 */
public class WelcomeWebPageTest {

    private static SeleniumConfig config;

    @BeforeAll
    public static void setUp() {
        config = new SeleniumConfig();
        config.getDriver().get("http://localhost:8080/index.html");
    }

    @AfterAll
    public static void tearDown() {
        config.close();
    }

    @Test
    public void check_page_title_is_Hello_World() {
        String actualTitle = config.getDriver().getTitle();
        assertEquals("Hello World", actualTitle);
    }

    @Test
    public void check_heading_is_Welcome() {
        String heading =
                config.getDriver()
                        .findElement(By.className("heading"))
                        .getText();
        assertEquals("Welcome", heading);
    }

}

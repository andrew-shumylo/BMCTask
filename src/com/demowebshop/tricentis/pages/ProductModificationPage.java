package com.demowebshop.tricentis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seleniumimplementation.SeleniumImplementation;

import java.util.concurrent.TimeUnit;

public class ProductModificationPage
{
    @FindBy(css = "#product_attribute_74_5_26_82")
    WebElement processorFast;
    @FindBy(css = "#product_attribute_74_6_27_85")
    WebElement ram8Gb;
    @FindBy(id = "product_attribute_74_8_29_88")
    WebElement softImageViewer;
    @FindBy(id = "product_attribute_74_8_29_89")
    WebElement softOfficeSuite;
    @FindBy(id = "product_attribute_74_8_29_90")
    WebElement softOtherOfficeSuite;
    @FindBy(className = "add-to-cart-panel")
    WebElement addToCartButton;
    @FindBy(xpath = "//*[@id=\"topcartlink\"]/a/span[1]")
    WebElement shoppingCart;
    @FindBy(xpath = "//*[@id=\"topcartlink\"]/a/span[2]")
    WebElement cartQty;
    @FindBy(className = "product-subtotal")
    WebElement totalPriceCheck;
    @FindBy(name = "removefromcart")
    WebElement removeFroCart;
    @FindBy(className = "button-2 update-cart-button")
    WebElement updateCart;
    SeleniumImplementation selenium;
    public ProductModificationPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        selenium = new SeleniumImplementation();
    }

    public boolean validateProductModification (WebDriver driver)
    {
        System.out.println("Selenium WebDriver UI \nPart -B- " +
                "\nModificate product and Add to Cart test(Check & Remove): ");
        selenium.click(processorFast);
        System.out.println("1.Set Processor: Fast");
        selenium.click(ram8Gb);
        System.out.println("2.Set RAM: 8GB");
        selenium.click(softImageViewer);
        selenium.click(softOfficeSuite);
        selenium.click(softOtherOfficeSuite);
        System.out.println("3.Select all available software");
        selenium.click(addToCartButton);
        System.out.println("4.Click \"Add to cart\"");
        selenium.click(shoppingCart);
        selenium.validateText(driver, cartQty, "(1)");
        System.out.println("5.Check the item is there");
        selenium.validateText(driver, totalPriceCheck, "1815.00");
        System.out.println("6.Check the price is correct");
        selenium.click(removeFroCart);
        selenium.click(updateCart);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        selenium.validateText(driver, cartQty, "(0)");
        System.out.println("7.Remove the item from the shopping cart.");
        return true;
    }
}
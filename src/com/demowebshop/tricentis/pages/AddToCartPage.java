package com.demowebshop.tricentis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seleniumimplementation.SeleniumImplementation;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddToCartPage
{
    @FindBy(xpath = "//a [@href=\"/computers\"]")
    WebElement computers;
    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[1]/div[1]/div/h2/a")
    WebElement desktops;
    @FindBy(id = "products-pagesize")
    WebElement selectProductsPagesize;
    @FindBy(id = "products-orderby")
    WebElement selectOrderBy;
    @FindBy(className = "item-box")
    WebElement productsPerPage;
    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[2]/div[3]/div[2]/input")
    WebElement theMostExpensiveComputer;
    @FindBy(className = "add-to-cart-panel")
    WebElement AddToCartButton;
    @FindBy(xpath = "//*[@id=\"topcartlink\"]/a/span[1]")
    WebElement shoppingCart;
    @FindBy(xpath = "//*[@id=\"topcartlink\"]/a/span[2]")
    WebElement cartQty;

    SeleniumImplementation selenium;
    public AddToCartPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        selenium = new SeleniumImplementation();
    }

    public boolean validateAddToCart(WebDriver driver)
    {
        System.out.println("BMC Test Task. \nSelenium WebDriver UI \nPart -A- \nAdd to Cart test: ");
        selenium.click(computers);
        System.out.println("1.In the categories menu open Computer");
        selenium.click(desktops);
        System.out.println("2.Select Desktops");
        selenium.selectByVisibleText(selectProductsPagesize, "4");
        System.out.println("3.Set Display to \"4\" per page");
        List<WebElement> list = driver.findElements(By.className("item-box"));
        int itemsCount = list.size();
        System.out.println("4.Quantity of products displayed per page is " + itemsCount);
        selenium.selectByVisibleText(selectOrderBy, "Price: High to Low");
        System.out.println("5.Sort \"Price: High to Low\"");
        selenium.click(theMostExpensiveComputer);
        System.out.println("6.Click add to cart the most expensive item");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        selenium.click(AddToCartButton);
        selenium.click(shoppingCart);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        selenium.validateText(driver, cartQty, "(1)");
        System.out.println("7.Check the item is in the shopping cart");
        System.out.println("!!! TEST PASS !!!");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return true;
    }
}

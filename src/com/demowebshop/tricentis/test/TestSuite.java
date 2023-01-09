package com.demowebshop.tricentis.test;

import com.demowebshop.tricentis.pages.AddToCartPage;
import com.demowebshop.tricentis.pages.ProductModificationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestSuite
{
    WebDriver driver = new ChromeDriver();
    AddToCartPage addToCartTest;
    ProductModificationPage productModificationTest;
    @BeforeTest
    public void setup()
    {
        driver.get("http://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        System.out.println("\n============================\nVisit Base URL");
    }
    @Test
    public void AddToCartTest ()
    {
        addToCartTest = new AddToCartPage(driver);
        System.out.println("----------------------------\nExecute 1-st test");
        System.out.println("USING Page-Object Pattern");
        Assert.assertTrue(addToCartTest.validateAddToCart(driver));
    }
    @Test
    public void ProductModificationTest()
    {
        driver.get("http://demowebshop.tricentis.com/build-your-own-expensive-computer-2");
        driver.manage().window().maximize();
        System.out.println("\n============================\nVisit 2-nd Base URL");
        System.out.println("----------------------------\nExecute 2-nd test");
        System.out.println("USING Simple way for implementation");
        System.out.println("BMC Test Task. \nSelenium WebDriver UI \nPart -B- " +
                "\nModificate product and Add to Cart test(Check & Remove): ");
        driver.findElement(By.cssSelector("#product_attribute_74_5_26_82")).click();
        System.out.println("1.Set Processor: Fast");
        driver.findElement(By.cssSelector("#product_attribute_74_6_27_85")).click();
        System.out.println("2.Set RAM: 8GB");
        driver.findElement(By.cssSelector("#product_attribute_74_8_29_88")).click();
        driver.findElement(By.cssSelector("#product_attribute_74_8_29_89")).click();
        driver.findElement(By.cssSelector("#product_attribute_74_8_29_90")).click();
        System.out.println("3.Select all available software");
        driver.findElement(By.className("add-to-cart-panel")).click();
        System.out.println("4.Click \"Add to cart\"");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("a[class='ico-cart'] span[class='cart-label']")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assert.assertEquals("input[value='2']", "input[value='2']");
        System.out.println("5.Check the items is there");
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr/td[6]/span[2]"));
        Assert.assertEquals("(//strong[contains(text(),'1815.00')])[2]", "(//strong[contains(text(),'1815.00')])[2]");
        System.out.println("6.Check the price is correct");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.name("removefromcart")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr[1]/td[1]/input")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        System.out.println("7.Remove the item from the shopping cart.");
        System.out.println("--------------------------");
    }
    /*
    @AfterTest
    public void closeBrowser()
    {
        System.out.println("Close browser");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.quit();
    }

     */
}

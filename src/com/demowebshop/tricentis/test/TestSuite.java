package com.demowebshop.tricentis.test;

import com.demowebshop.tricentis.pages.AddToCartPage;
import com.demowebshop.tricentis.pages.ProductModificationPage;
import jdk.jfr.Description;
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
    @BeforeTest
    @Description("Visit Base URL")
    public void setup()
    {
        driver.get("http://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
    }
    @Test
    @Description("Execute 1-st test |USING Page-Object Pattern|")
    public void AddToCartTest ()
    {
        addToCartTest = new AddToCartPage(driver);
        Assert.assertTrue(addToCartTest.validateAddToCart(driver));
    }
    @Test
    @Description("BMC Test Task. \nSelenium WebDriver UI \nPart -B- \nModificate product and Add to Cart test(Check & Remove)\n USING SIMPLE WAY OF IMPLEMENTATION")
    public void ProductModificationTest()
    {
        driver.get("http://demowebshop.tricentis.com/build-your-own-expensive-computer-2");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("#product_attribute_74_5_26_82")).click();
        driver.findElement(By.cssSelector("#product_attribute_74_6_27_85")).click();
        driver.findElement(By.cssSelector("#product_attribute_74_8_29_88")).click();
        driver.findElement(By.cssSelector("#product_attribute_74_8_29_89")).click();
        driver.findElement(By.cssSelector("#product_attribute_74_8_29_90")).click();
        driver.findElement(By.className("add-to-cart-panel")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("a[class='ico-cart'] span[class='cart-label']")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assert.assertEquals("input[value='2']", "input[value='2']");
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr/td[6]/span[2]"));
        Assert.assertEquals("(//strong[contains(text(),'1815.00')])[2]", "(//strong[contains(text(),'1815.00')])[2]");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        List<WebElement> checkboxes = driver.findElements(By.name("removefromcart"));
        driver.findElement(By.name("removefromcart")).click();
        driver.findElement(By.name("removefromcart")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr[1]/td[1]/input")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    @AfterTest
    @Description("Close browser")
    public void closeBrowser()
    {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.quit();
    }
}

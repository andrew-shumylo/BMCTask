package seleniumimplementation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;

public class SeleniumImplementation
{
    Actions action;

    public void click (WebElement element)
    {
        element.click();
    }

    public void selectByVisibleText (WebElement selectProductsPagesize, String text)
    {
        Select pagesize = new Select(selectProductsPagesize);
        pagesize.selectByVisibleText(text);
    }
    public boolean validateText (WebDriver driver, WebElement element, String expectedText)
    {
        String observedText = element.getText();
        if (observedText.equals(expectedText))
        {
            return true;
        }
        return false;
    }
}

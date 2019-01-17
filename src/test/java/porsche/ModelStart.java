package porsche;

import com.cybertek.utilities.Driver;
import com.cybertek.utilities.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModelStart  {

    // to be able to initialize all the  alements of the Page Object .
    public ModelStart(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//div[@class='b-teaser-wrapper']/a[1])[1]")
    public  WebElement model718;



}

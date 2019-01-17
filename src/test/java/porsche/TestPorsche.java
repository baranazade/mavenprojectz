package porsche;

import com.cybertek.utilities.TestBase;
import org.testng.annotations.Test;

public class TestPorsche extends TestBase {

    ModelStart modelStart = new ModelStart();


    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.porsche.com/usa/modelstart/");
        Thread.sleep(2000);
        modelStart.model718.click();
    }

    @Test
    public void test2(){


    }
}

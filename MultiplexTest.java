import org.hamcrest.JMock1Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class MultiplexTest {
    @Test
    public void checkmenuBtn() {
        System.setProperty("webdriver.chrome.driver", "D:\\java\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.manage().window().maximize();

        driver.get("https://multiplex.ua");

        driver.findElement(By.cssSelector("body > div.geo_veil > div > p.other > span")).click();
        driver.findElement(By.cssSelector("body > div.menu.right_menu.animatedlong.slideInUp > img")).click();

        driver.findElement(By.cssSelector(".menu-btn")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mob_container > .menu-block > .menu-block-heading")));

        String getmenutext = driver
                .findElement(By.cssSelector(".mob_container > .menu-block > .menu-block-heading"))
                .getText();

        assertThat(getmenutext, equalTo("ОСОБИСТИЙ КАБІНЕТ"));
        driver.quit();
    }
}
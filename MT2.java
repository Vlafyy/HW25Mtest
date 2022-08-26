import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class MT2 {
    @Test
    public void checklink() {
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

        driver.findElement(By.cssSelector("body > div.left_menu.js-left-menu.on > div > div.mob_container > div.menu_list > a:nth-child(8)")).click();
        driver.findElement(new By.ByLinkText("борд")).click();

        driver.quit();
    }
}
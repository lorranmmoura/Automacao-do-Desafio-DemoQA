import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;
import java.time.Duration;

public class FormularioTest {
    private WebDriver driver;


    @Before
    public void setUp() { //iniciar
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));

    }
    @After
    public void tearDown() { //finalizar
        driver.quit();
    }

    @Test //teste
    public void formulariotestando() {
        driver.get("https://demoqa.com/text-box");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.id("userName")).click();
        driver.findElement(By.id("userName")).sendKeys("Nome de Teste");
        driver.findElement(By.id("userEmail")).click();
        driver.findElement(By.id("userEmail")).sendKeys("emaildeteste@hotmail.com");
        driver.findElement(By.id("currentAddress")).click();
        driver.findElement(By.id("currentAddress")).sendKeys("Rua de Teste, 35");
        driver.findElement(By.id("permanentAddress")).click();
        driver.findElement(By.id("permanentAddress")).sendKeys("Rua de Teste, 36");
        driver.findElement(By.id("submit")).click();
        {
            WebElement element = driver.findElement(By.id("submit"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        //verificacao
        Assert.assertEquals("Name:Nome de Teste", driver.findElement(By.id("name")).getText());
        Assert.assertEquals("Email:emaildeteste@hotmail.com", driver.findElement(By.id("email")).getText());
        Assert.assertEquals("Current Address :Rua de Teste, 35", driver.findElement(By.cssSelector("p#currentAddress")).getText());
        Assert.assertEquals("Permananet Address :Rua de Teste, 36", driver.findElement(By.cssSelector("p#permanentAddress")).getText());
        System.out.println("Todos os asserts passaram! Validação concluída com sucesso.");


    }
}

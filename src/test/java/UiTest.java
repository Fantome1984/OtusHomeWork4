import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeOptions;
import pagers.Auth;
import helper.Logger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import helper.MethodsHelper;
import pagers.ProfilePage;


public class UiTest {
    public org.apache.logging.log4j.Logger logger = LogManager.getLogger(Logger.class);


    protected WebDriver driver;
    final private String OTUSURL = System.getProperty("base.url","https://otus.ru");


    @BeforeClass
    public static void driverSetup(){
        WebDriverManager.chromedriver().setup();

    }

    @Before
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-fullscreen");
        driver = new ChromeDriver(chromeOptions);



    }

    @After
    public void setDown() {
        if (driver != null) {
            driver.quit();
        }
    }


        @Test
        public void sectionCompletion () {
            Auth auth = new Auth(driver);
            ProfilePage profile = new ProfilePage(driver);
            MethodsHelper helper = new MethodsHelper(driver);
            driver.get(OTUSURL);
            auth.auth();
            logger.info("Произвели авторизацию на сайте Otus");
            profile.clickProfile();
            logger.info("Перешли в профиль");
            profile.profileFilling();
            logger.info("Заполнили профиль");
            helper.openingCleanBrowser(driver);
            driver.get(OTUSURL);
            auth.auth();
            logger.info("Открыли, чистый браузер и авторизовались в УЗ");
            profile.clickProfile();
            profile.chekProfile();
            logger.info("Перешли в профиль, и проверили ранее введенные данные");
        }

    }










import auth.Auth;
import helper.BaseUITest;
import helper.Logger;
import helper.MethodsHelper;
import org.apache.logging.log4j.LogManager;
import org.junit.Test;
import profile.ProfilePage;


public class UiTest extends BaseUITest {
    public org.apache.logging.log4j.Logger logger = LogManager.getLogger(Logger.class);

    final private String OTUSURL = "https://otus.ru";

    @Test
    public void sectionCompletion()  {
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
        auth.auth();
        logger.info("Открыли, чистый браузер и авторизовались в УЗ");
        profile.clickProfile();
        profile.chekProfile();
        logger.info("Перешли в профиль, и проверили ранее введенные данные");

    }

    }







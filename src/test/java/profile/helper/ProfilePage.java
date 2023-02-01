package profile.helper;

import profile.helper.MethodsHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ProfilePage {
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }
    private WebDriver driver;

    // Локаторы для перехода в профиль
    private By avatar = By.xpath("//span[@class='header3__user-info-name']");
    private By name = By.xpath("//div[@class=\"header3__user-info-popup-links\"]//a[1]");

    private By firstName = By.xpath("//input[@name='fname_latin']");
    private By lastName = By.xpath("//input[@name='lname_latin']");
    private By blogName = By.id("id_blog_name");
    ///Локаторы для класса calendar
    private By date_of_birth = By.xpath("//input[@name='date_of_birth']");
    private By day = By.xpath("//ul[@data-view='days']//li[text()='25']");
    private By yearCurrent = By.xpath("//div[@class='datepicker-panel']//li[2]");
    private By yearPrev = By.xpath("//div[@class='datepicker-panel']//li[1]");
    private By year = By.xpath("//div[@class='datepicker-panel']//ul[@data-view='years']//li[10]");
    private By mounth = By.xpath("//div[@class='datepicker-panel']//ul[@data-view='months']//li[text()='Ноя']");

    /// Локаторы для выбора страны
    private By сountryInputField = By.xpath( "//div[@data-slave-selector='.js-lk-cv-dependent-slave-city']");
    private By countrySelection = By.xpath("//button[@title='Россия'] ");
    /// Локаторы для выбора города
    private By cityInputField = By.cssSelector("[class*='js-lk-cv-dependent-slave-city']");
    private By citySelection = By.xpath("//button[@data-value='176']");
    /// Локаторы для выбора уровня языка
    private By languageInputField = By.xpath("//input[@data-title='Уровень знания английского языка']/../..");
    private By languageSelection = By.xpath("//button [@title='Начальный уровень (Beginner)']" );
    /// Локатор для готовности к переезду
    private By radioButton = By.xpath("//input[@id='id_ready_to_relocate_1']/..");
    /// Локатор для выбора формата работы
    private By checbox = By.xpath("//input[@title='Гибкий график']/../..");
    /// Локатор для выбора способов связи
    private By buttonAdd = By.xpath("//button[text()='Добавить']");
    private By сommunicationMethodOne = By.xpath("//span[text()='Способ связи']");
    private By сommunicationListOne = By.cssSelector("[class*='lk-cv-block__select-options_left']>div>button[title='Тelegram']");
    private By tg = By.xpath("//input[@name='contact-0-service']");

    private By сommunicationMethodTwo = By.cssSelector("[data-num='1'] [data-selected-option-class]");
    private By communicationListTwo = By.cssSelector("label ~*:not(.hide) button[title='VK']");
    private By vk = By.xpath("//input[@name='contact-1-service']");

    private By fieldContactsOne = By.id("id_contact-0-value");
    private By fieldContactsTwo = By.id("id_contact-1-value");
    /// Локаторы для выбора гендера
    private By listOfGenders = By.xpath("//div[@class='select select_full']");
    private By gender = By.xpath("//option[@value='m']");
    /// Локатор для компании
    private By fieldCompany = By.id("id_company");
    /// Локатор для должности
    private By fieldPosition = By.id("id_work");
    /// Локтор для опыта разработки
    private By addExperienceButton = By.xpath("//a[@title='Добавить']");
    private By listExperience = By.xpath("//div[@class='experience-row__col']/child::div[1]");
    private By javaLanguage = By.xpath("//option[text()='Java']");
    private By expLavel = By.xpath("//select[@id ='id_experience-0-level']//child::option[1]");
    private By saveButton = By.xpath("//button[@title='Сохранить и продолжить']");









    public void clickProfile(){
        MethodsHelper helper = new MethodsHelper(driver);
        helper.elementVisibility(avatar);
        helper.actionsMoveElement(avatar);
        driver.findElement(name).click();
    }

    public void profileFilling()  {
        MethodsHelper helper = new MethodsHelper(driver);
        helper.enterToTextArea(driver.findElement(firstName),"Nikita");
        helper.enterToTextArea(driver.findElement(lastName),"Shletkin");
        calendar();
        helper.elementVisibility(сountryInputField).click();
        helper.сlicker(countrySelection);
        helper.actionsMoveElement(cityInputField);
        helper.сlicker(cityInputField);
        helper.сlicker(citySelection);
        helper.сlicker(languageInputField);
        helper.сlicker(languageSelection);
        helper.сlicker(radioButton);
        helper.сlicker(checbox);
        helper.actionsMoveElement(buttonAdd);
        helper.сlicker(buttonAdd);
        helper.сlicker(сommunicationMethodOne);
        helper.elementVisibility(сommunicationListOne).click();
        helper.сlicker(сommunicationMethodTwo);
        helper.elementVisibility(communicationListTwo).click();
        helper.enterToTextArea(driver.findElement(fieldContactsOne),"88005555535");
        helper.enterToTextArea(driver.findElement(fieldContactsTwo),"fantome1966");
        helper.сlicker(listOfGenders);
        helper.сlicker(gender);
        helper.enterToTextArea(driver.findElement(fieldCompany),"RT-DC");
        helper.enterToTextArea(driver.findElement(fieldPosition),"Mobile app tester");
        helper.сlicker(addExperienceButton);
        helper.сlicker(listExperience);
        helper.сlicker(javaLanguage);
        helper.сlicker(saveButton);
    }

    public void chekProfile(){
        MethodsHelper helper = new MethodsHelper(driver);
        helper.fieldValidation(driver,firstName,"Nikita");
        helper.fieldValidation(driver,lastName,"Shletkin");
        helper.fieldValidation(driver,blogName,"Румпель");
        helper.fieldValidation(driver,date_of_birth,"25.11.1997");
        helper.listValidation(driver,сountryInputField,"Россия");
        helper.listValidation(driver,cityInputField,"Воронеж");
        helper.listValidation(driver,languageInputField,"Начальный уровень (Beginner)");
        helper.listValidation(driver,radioButton,"Да");
        helper.listValidation(driver,checbox,"Гибкий график");
        helper.fieldValidation(driver,tg,"telegram");
        helper.fieldValidation(driver,vk,"vk");
        helper.fieldValidation(driver,fieldContactsOne,"88005555535");
        helper.fieldValidation(driver,fieldContactsTwo,"fantome1966");
        helper.listValidation(driver,gender,"Мужской");
        helper.fieldValidation(driver,fieldCompany,"RT-DC");
        helper.fieldValidation(driver,fieldPosition,"Mobile app tester");
        helper.listValidation(driver,javaLanguage,"Java");
        helper.listValidation(driver,expLavel,"Только начал");






    }






    private void calendar(){
        // Кликнули по полю ввода даты
     driver.findElement(date_of_birth).click();
        // Выбрали день рождения
     driver.findElement(day).click();
        // Выбрали год рождения
         WebElement dobleClick = driver.findElement(yearCurrent);
          new Actions(driver).doubleClick(dobleClick).perform();
          WebElement dobleClckTwo = driver.findElement(yearPrev);
          new Actions(driver).doubleClick(dobleClckTwo).perform();
          dobleClckTwo = driver.findElement(yearPrev);
        new Actions(driver).click(dobleClckTwo).perform();
        driver.findElement(year).click();
      // Выбрали месяц рождения
      driver.findElement(mounth).click();


    }










}



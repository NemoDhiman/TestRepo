package pages;


import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.DateUtility;
import utilities.GeneralUtilFunctions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.MatcherAssert.assertThat;


@DefaultUrl("https://money.rediff.com/index.html")
public class RediffHomePage extends PageObject {

    Logger log = LoggerFactory.getLogger(this.getClass());
    GeneralUtilFunctions generalUtilFunctions = new GeneralUtilFunctions();

    @FindBy(id = "fullname")
    private WebElementFacade textInputBoxFullName;

    @FindBy(id = "emailid")
    private WebElementFacade textInputBoxEmailId;

    @FindBy(id = "pass")
    private WebElementFacade textInputBoxPassword;

    @FindBy(id = "repass")
    private WebElementFacade textInputBoxRetypePassword;

    @FindBy(xpath = "//a[contains(text(), 'Sign-up')]")
    private WebElementFacade linkSignUpHomePage;

    @FindBy(xpath = "//input[@value ='m']")
    private WebElementFacade radioButtonGenderMale;

    @FindBy(xpath = "//input[@value ='f']")
    private WebElementFacade radioButtonGenderFemale;

    @FindBy(id = "country")
    private WebElementFacade dropDownILiveInCity;

    @FindBy(id = "city")
    private WebElementFacade dropDownCity;

    @FindBy(id = "useremail")
    private WebElementFacade textInputBoxRegisteredEmailId;

    @FindBy(id = "userpass")
    private WebElementFacade textInputBoxRegisteredpassword;

    @FindBy(xpath = "//a[@title=\'Already a user? Sign in\']")
    private WebElementFacade linkSignIn;

    @FindBy(id = "createPortfolio")
    private WebElementFacade linkCreatePortfolio;

    @FindBy(id = "create")
    private WebElementFacade textInputBoxCreateProfile;

    @FindBy(id = "createPortfolioButton")
    private WebElementFacade btnCreatePortfolio;

    @FindBy(id = "portfolioid")
    private WebElementFacade selectPortfolio;

    @FindBy(id = "deletePortfolio")
    private WebElementFacade linkDeletePortfolio;

    @FindBy(id = "loginsubmit")
    private WebElementFacade btnRegisteredUserLogIn;

    @FindBy(id = "signin_info")
    private WebElementFacade linkSignOutHomePage;

    @FindBy(xpath = "//*[@id=\"headcontent\"]/div[1]/ul/li[2]/a")
////ul[@class='ul_top_tabs' and contains( text(), 'My Portfolio')]
    private WebElementFacade linkHeaderLinkMyPortFolio;

    @FindBy(name = "+ Add Stock")
    private WebElementFacade btnAddStock;

    @FindBy(id = "addstockname")
    private WebElementFacade textFieldStockName;

    @FindBy(id = "addstockqty")
    private WebElementFacade textFieldQuantity;

    @FindBy(id = "addstockprice")
    private WebElementFacade textFieldStockPrice;

    @FindBy(xpath = "//label[@for = 'bse']")
    private WebElementFacade btnBSEStockExchange;

    @FindBy(xpath = "//label[@for = 'nse']")
    private WebElementFacade btnNSEStockExchange;

    @FindBy(id = "addStockButton")
    private WebElementFacade btnAddStockDetailsStockDetailsScreen;

    @FindBy(id = "date_day")
    private WebElementFacade dropDownSelectDay;

    @FindBy(id = "date_mon")
    private WebElementFacade dropDownSelectMonth;

    @FindBy(id = "date_yr")
    private WebElementFacade dropDownSelectYear;

    @FindBy(id = "stockPurchaseDate")
    private WebElementFacade calendarPickUpStockPurchaseDate;

    @FindBy(xpath = "//div[@class = 'dpTitleText']")
    private WebElementFacade datePickMonthYearTitle;

    @FindBy(xpath = "//*[@id=\"datepicker\"]/table/tbody/tr[1]/td[4]/button")
    private WebElementFacade datePickerSelectingNextMonth;

    @FindBy(xpath = "//*[@id=\"datepicker\"]/table/tbody/tr[1]/td[2]/button")
    private WebElementFacade datePickerSelectingpreviousMonth;


    public void enterTextFullName(String fullName) {
        getDriver().navigate().refresh();
        textInputBoxFullName.typeAndTab(fullName);
    }

    public void enterTextEmailId(String emailId) {
        textInputBoxEmailId.waitUntilEnabled();
        textInputBoxEmailId.typeAndTab(emailId);
    }

    public void enterTextPassword(String password) {
        textInputBoxPassword.typeAndTab(password);
    }

    public void enterTextRetypePassword(String password) {
        textInputBoxRetypePassword.sendKeys(password);
    }


    public void clickLinkSignUp() {
        linkSignUpHomePage.click();
    }


    public void selectRadioButtonGender(String gender) {
        switch (gender) {
            case "M":
                radioButtonGenderMale.click();
                break;
            case "F":
                radioButtonGenderFemale.click();
                break;
            default:
                System.out.println("Please enter the correct gender type");
                break;
        }

    }

    public void selectILiveIncity(String ILiveIn) {
        Select dropDownILiveIn = new Select(dropDownILiveInCity);
        dropDownILiveIn.selectByVisibleText(ILiveIn);
    }


    public void selectCity(String city) {
        Select dropDownBoxCity = new Select(dropDownCity);
        dropDownBoxCity.selectByVisibleText(city);
    }

    public void clickLinkSignIn() {
        generalUtilFunctions.checkPageIsReady();
        linkSignIn.waitUntilEnabled();
        linkSignIn.click();
    }

    public void fillTextEmailId(String emailId) {
        textInputBoxRegisteredEmailId.typeAndEnter(emailId);
        generalUtilFunctions.checkPageIsReady();
    }

    public void fillTextPassword(String password) {
        generalUtilFunctions.wait(5);
        textInputBoxRegisteredpassword.waitUntilVisible();
        textInputBoxRegisteredpassword.sendKeys(password);
    }

    public void createProfile(List<String> profileName) {

        for (int i = 0; i < profileName.size(); i++) {
            String nameOfProfile = profileName.get(i);
            generalUtilFunctions.clickAndWait(10, "//*[@id=\"createPortfolio\"]", "//*[@id=\"create\"]");
            // clickAndWait(10, "//*[@id=\"createPortfolio\"]", "//*[@id=\"create\"]");
            textInputBoxCreateProfile.typeAndEnter(nameOfProfile);
            btnCreatePortfolio.click();
            generalUtilFunctions.checkPageIsReady();
            //checkPageIsReady();
            verifyCreatedPortfolio(nameOfProfile);
        }
    }

    public void verifyPortfolioList(List<String> listedPortfolios) {
        Select dropDownPortfolio = new Select(selectPortfolio);
        List<String> listDropDownPortfolio = new ArrayList<>();
        for (int i = 0; i < dropDownPortfolio.getOptions().size(); i++) {
            listDropDownPortfolio.add(dropDownPortfolio.getOptions().get(i).getText());
        }
        assertThat("VERIFYING THAT ADDED PORTFOLIOS ARE LISTED UNDER PORTFOLIOS", listDropDownPortfolio.containsAll(listedPortfolios));
    }


    public void verifyCreatedPortfolio(String profileName) {
        Select createdPortfolioInDropDown = new Select(selectPortfolio);
        String selectedValue = createdPortfolioInDropDown.getFirstSelectedOption().getText();
        assertThat("Verifying that created portfolio is the first portfolio shown under portfolios", selectedValue.equals(profileName));
    }


    public void verifyAddedPortfoliosWithExistingPortfolios(List<String> portfolioNames) {
        Select createdPortfolioInDropDown = new Select(selectPortfolio);
        for (int i = 0; i <= portfolioNames.size(); i++) {
            String portfolioName = portfolioNames.get(i);
            while (i <= createdPortfolioInDropDown.getOptions().size()) {
                if (createdPortfolioInDropDown.getOptions().get(i).getText().equals(portfolioName)) {
                    System.out.println(createdPortfolioInDropDown.getOptions().get(i + 1).getText() + " " + "is listed under portfolio");
                    break;
                }
                i++;
            }
        }
    }

    public void deletePortfolio(List<String> portfolioNames) {
        for (int i = 0; i < portfolioNames.size(); i++) {
            String portfolio = portfolioNames.get(i);
            System.out.println(portfolio);
            if ((generalUtilFunctions.IsElementPresent("//*[@id=\"portfolioid\"]")) && (getDriver().findElement(By.xpath("//*[@id=\"portfolioid\"]")).isDisplayed())) {
                Select dropDownPortfolio = new Select(selectPortfolio);
                dropDownPortfolio.selectByVisibleText(portfolio);
                linkDeletePortfolio.click();
                getDriver().switchTo().alert().accept();
                generalUtilFunctions.checkPageIsReady();
                getDriver().switchTo().defaultContent();
                generalUtilFunctions.checkPageIsReady();
                linkHeaderLinkMyPortFolio.isEnabled();
                linkHeaderLinkMyPortFolio.waitUntilClickable();
                linkHeaderLinkMyPortFolio.click();

            }
        }
    }

    public void clickLoginSubmit() {
        btnRegisteredUserLogIn.waitUntilVisible();
        btnRegisteredUserLogIn.click();
        generalUtilFunctions.checkPageIsReady();
        //  generalUtilFunctions.IsElementPresent("//*[@id=\"portfolioid\"]");
    }

    public void verifyPortfolioListAfterDeletePortfolio(List<String> portfolioName) {
        Select dropDownPortfolios = new Select(selectPortfolio);
        List<String> listdropdownPortfolios = new ArrayList<>();
        for (int i = 0; i < dropDownPortfolios.getOptions().size(); i++) {
            listdropdownPortfolios.add(dropDownPortfolios.getOptions().get(i).getText());
        }
        boolean result = listdropdownPortfolios.containsAll(portfolioName);
        System.out.println("result  " + result);
        if (result == true) {
            System.out.println("portfolios are not deleted from the list of portfolios");
        } else {
            System.out.println("porftfolios are deleted from the list of portfolios");
        }
    }

    public void clickSignOutLink() {
        linkSignOutHomePage.click();
    }

    public void selectPortfolioName(String portfolioName) {
        Select portfolioList = new Select(selectPortfolio);
        portfolioList.selectByVisibleText(portfolioName);
        generalUtilFunctions.checkPageIsReady();
    }

    public void clickButtonAddStockMyportfolioScreen() {
        btnAddStock.click();
    }


    public void fillTextNewStockName(String stockName) {
        textFieldStockName.sendKeys(stockName);

        WebElement stockFullName = getDriver().findElement(By.xpath("//div[@id='ajax_listOfOptions']/div[contains(text(),'" + stockName + "')]"));
        stockFullName.isSelected();
        stockFullName.click();
    }

    public void fillTextQuantity(String quantity) {
        textFieldQuantity.sendKeys(quantity);
    }


    public void fillTextPrice(String price) {
        textFieldStockPrice.sendKeys(price);
    }


    public void selectStockExchange(String stockExchange) {
        switch (stockExchange) {
            case "BSE":
                btnBSEStockExchange.click();
                break;
            case "NSE":
                btnNSEStockExchange.click();
                break;
            case "default":
                System.out.println("Enter a valid Stock Exchange Name");
                break;
        }
    }

    public void clickAddStockButtonNewStockScreen() {
        btnAddStockDetailsStockDetailsScreen.click();
    }


    public void selectDateOfBirth(String dob) {

        // Select day in the day dropdown field in date of birth details section
        String day = DateUtility.getDayOfDate(dob);
        Select dayDropDown = new Select(dropDownSelectDay);
        dayDropDown.selectByVisibleText(day);

        // Select day in the day dropdown field in date of birth details section
//        String month = DateUtility.getMonthOfDate(dob);
//        Select monthDropDown = new Select(dropDownSelectMonth);
//        monthDropDown.selectByVisibleText(month.toUpperCase());

        // Select day in the day dropdown field in date of birth details section
        String year = DateUtility.getYearOfDate(dob);
        Select yearDropDown = new Select(dropDownSelectYear);
        yearDropDown.selectByVisibleText(year);
    }

    public void enterSelectedDate(String date) {
        String day = DateUtility.getDayOfDate(date);
        String desiredMonthYear = DateUtility.getMonthYearOfDate_v1(date);
        calendarPickUpStockPurchaseDate.click();
        String displayedMonthYear = datePickMonthYearTitle.getText();
        Date currrentDate = new Date();
        Date selectedDate = DateUtility.convertSelectedDateToDateObject(date);


        if (desiredMonthYear.equals(displayedMonthYear)) {
            find(By.xpath("//td[text() ='" + day + "']")).click();
        } else if (currrentDate.compareTo(selectedDate) > 0) {
            do {
                datePickerSelectingpreviousMonth.click();
            } while (desiredMonthYear.equals(displayedMonthYear));
            find(By.xpath("//td[text() ='" + day + "']")).click();
        } else if (currrentDate.compareTo(selectedDate) < 0) {
            do {
                datePickerSelectingNextMonth.click();

            } while (desiredMonthYear.equals(displayedMonthYear));
            find(By.xpath("//td[text() ='" + day + "']")).click();
        }
    }
}
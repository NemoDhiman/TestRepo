package pages;

import com.google.common.base.Verify;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.jruby.RubyProcess;
import org.junit.Assert;
import org.mockito.exceptions.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;

public class MyPortfolioPage extends PageObject {

    @FindBy(xpath = "//*[contains(@id,'equityRow')]")
    private WebElementFacade listofrowsOfStockDetails;

    @FindBy(xpath = "//span[contains(@id, 'companyname')]/a[@target = 'companypage']")
    private List<WebElementFacade> companyNameUnderStockDetails;

    @FindBy(xpath = "//td[@class = 'gry numericalColumn']//span[contains(@id, 'qty')]")
    private List<WebElementFacade> qtyListUnderStockDetails;

    @FindBy(xpath = "//table [@class ='dataTable']//tr")
    private List<WebElementFacade> listTransactionHistoryDetailsForEachStock;

    @FindBy(xpath = "")


    public String findCompanyId(String companyName) {
        //Find the company Id against the companyName
        List<WebElement> companyWeList = getDriver().findElements(By.xpath("//span[contains(@id,'companyname')]//a[@target = 'companypage' and contains(text(), '" + companyName + "')]/.."));
        if (companyWeList.size() == 1)
            try {
                String companyNameAndId = (companyWeList.get(0).getAttribute("id"));
                String companyId = companyNameAndId.substring(11, 19);
                return companyId;
            } catch (NoSuchElementException e) {
                throw (e);
            }
        return null;
    }

    public void validateStockDetails(Map<String, String> validateEachStockItem) {
        String companyId = findCompanyId(validateEachStockItem.get("companyName"));

        // Validate Company name
        WebElement actualCompanyNameXpath = getDriver().findElement(By.xpath("//span[@id = '" + "companyname" + companyId + "']"));
        String actualCompanyName = actualCompanyNameXpath.getText();
        System.out.println("expected" + " " + validateEachStockItem.get("companyName") + " " + "actual Company name" + " " + actualCompanyName);
        assertThat("companyName" + " " + validateEachStockItem.get("companyName") + " " + "is not present under stock details", actualCompanyName.equals(validateEachStockItem.get("companyName")));

        //Validate company stock qty
        WebElement actualQtyXpath = getDriver().findElement(By.xpath("//span[@id = '" + "qty" + companyId + "']"));
        String actualQty = actualQtyXpath.getText();
        assertThat("expected qty" + " " + validateEachStockItem.get("qty") + " " + "does not match the actual qty of stock" + " " + actualQty + "", validateEachStockItem.get("qty").equals(actualQty));


        //Validate company stock price
        WebElement xpathActualPrice = getDriver().findElement(By.xpath("//span[@id = '" + "avg" + companyId + "']"));
        String actualPrice = xpathActualPrice.getText();
        assertThat("actual price" + " " + actualPrice + " " + "is different from the expected price" + " " + validateEachStockItem.get("price"), actualPrice.equals(validateEachStockItem.get("price")));

        //Validate company stock exchange
        WebElement xpathActualExchange = getDriver().findElement(By.xpath("//tr [@id = '" + "equityRow" + companyId + "'] //td[@class ='gry']//span"));
        String actualExchange = xpathActualExchange.getText();
        assertThat("actual exchange" + " " + actualExchange + "is different than the expected exchange" + " " + validateEachStockItem.get("exchange"), actualExchange.equals(validateEachStockItem.get("exchange")));

        //Validate company stock ValueAtAvg
        WebElement xpathActualValueAtAvg = getDriver().findElement(By.xpath("//span[@id = '" + "invested" + companyId + "']"));
        String actualValueAtAvg = xpathActualValueAtAvg.getText();
        assertThat("actual valueAtAvg" + " " + actualValueAtAvg + "is different from the expected valueAtAvg" + " " + validateEachStockItem.get("ValueAtAvg") + "", actualValueAtAvg.equals(validateEachStockItem.get("ValueAtAvg")));

    }

    public void deleteEachStockItem(List<String> deleteStockDetails) {
        for (int i = 1; i < deleteStockDetails.size(); i++) {
            String companyId = findCompanyId(deleteStockDetails.get(i));
            try {
                if (companyId != null) {
                    WebElement deleteCompanyXpath = getDriver().findElement(By.xpath("//input[@type ='radio' and @class = 'radio company-id rdmfid' and@class= 'radio company-id rdmfid' and @value = '" + companyId + "']"));
                    deleteCompanyXpath.isDisplayed();
                    deleteCompanyXpath.click();
                    WebElement deleteButtonXpath = getDriver().findElement(By.xpath("//input[@type ='button' and @name = 'Delete' and@title= 'Delete' and @value = 'Delete' and @class= 'deleteEquity' and @data-equityid = '" + companyId + "' ]"));
                    deleteButtonXpath.click();
                    getDriver().switchTo().alert().accept();
                }
            } catch (NoSuchElementException e) {
                Assert.fail(e.toString());
            }

        }
    }


    public void verifyDeletedStockDetails(List<String> deleteStockDetails) {
        try {
            List<WebElement> stockDetailsListXpath = getDriver().findElements(By.xpath("//span[contains(@id,'companyname')]//a[@target = 'companypage']"));
            if (stockDetailsListXpath.size() > 0) {
                List<String> eachListedStockName = new ArrayList<>();
                for (WebElement eachStock : stockDetailsListXpath) {
                    String eachStockName = eachStock.getText();
                    eachListedStockName.add(eachStockName);
                }
                for (int i = 1; i < deleteStockDetails.size(); i++) {
                    assertTrue("company" + " " + deleteStockDetails.get(i) + "is present under stock details section", eachListedStockName.contains(deleteStockDetails.get(i)));
                }

            } else
                System.out.println("No stocks present under the stock details section");
        } catch (AssertionError e) {
            Assert.fail(e.toString());

        }
    }

    public void deleteStockTransactionHistoryScreen(Map<String,String> deleteStockDetails) {
        for (int i = 1; i < deleteStockDetails.size(); i++) {
            String companyId = findCompanyId(deleteStockDetails.get("StockName"));
            String date = (deleteStockDetails.get("date"));
            try {
                if (companyId != null) {
                    WebElement radioButtonDeleteCompanyXpath = getDriver().findElement(By.xpath("//input[@type ='radio' and @class = 'radio company-id rdmfid' and@class= 'radio company-id rdmfid' and @value = '" + companyId + "']"));
                    radioButtonDeleteCompanyXpath.isDisplayed();
                    radioButtonDeleteCompanyXpath.click();
                    WebElement buttonTransactionHistoryXpath = getDriver().findElement(By.xpath("//input[@type = 'button' and @name= 'Transaction History' and @title = 'Transaction History' and @ value = 'Transaction History' and @data-equityid='\"+companyId+\"']"));
                    buttonTransactionHistoryXpath.isDisplayed();
                    buttonTransactionHistoryXpath.click();



                }

            }catch (){}
        }
    }


    public void deleteTransactionHistoryDetails(String date ){
        try{
        if(listTransactionHistoryDetailsForEachStock.size()>1) {
            WebElement transactionHistoryXpath = getDriver().findElement(By.xpath("//input[@class = 'checkbox' and @name = 'editTransId' and @data-date='" + date + "']"));
            String transactionId = ((transactionHistoryXpath.getAttribute("id")).substring(12, 19));
            WebElement deleteTransactionHistoryXpath = getDriver().findElement(By.xpath("//a[@class='equityTransactionDelete' and @data-id='" + transactionId + "' ]"));
            deleteTransactionHistoryXpath.click();
            getDriver().switchTo().alert().accept();
        }
       }catch(NoSuchElementException e){
            System.out.println(e);
            Assert.fail(e.toString());
           }

    }



}



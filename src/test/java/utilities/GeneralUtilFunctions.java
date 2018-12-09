package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class GeneralUtilFunctions {

      public void wait(int time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }


    public void clickAndWait(int maxTime, String targetElementXpath, String waitElementXpath) {
        getDriver().findElement(By.xpath(targetElementXpath)).click();
        for (int i = 0; i <= maxTime; i++) {
            if (((IsElementPresent(waitElementXpath)) == true) && (getDriver().findElement(By.xpath(waitElementXpath)).isDisplayed())) {
                return;
            }
            wait(1);
        }

    }


    public boolean IsElementPresent(String elementXpath) {
        int size = getDriver().findElements(By.xpath(elementXpath)).size();
        if (size == 0) {
            return false;
        } else
            return true;
    }

    public void checkPageIsReady() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        Long d = (Long) js.executeScript("return jQuery.active");
        //Return page load status
        String state = (String) js.executeScript("return document.readyState");
        //Return ajax jquery status
        for (int i = 0; i < 10; i++) {
            //Check if page is in ready state ("complete") and no ajax jquery are running (i.e. status=0)
            if (state.equals("complete") && d.longValue() == 0) {
                break;
            }
            wait(1);
        }
    }


}
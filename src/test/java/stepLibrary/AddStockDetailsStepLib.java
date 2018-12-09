package stepLibrary;

import net.thucydides.core.annotations.Steps;
import pages.MyPortfolioPage;
import pages.RediffHomePage;
import utilities.GeneralUtilFunctions;

import java.util.Map;

public class AddStockDetailsStepLib {
    @Steps
    GeneralUtilFunctions generalUtilFunctions;

    @Steps
    RediffHomePage rediffHomePage;

    @Steps
    MyPortfolioPage myPortfolioPage;

    public void addStockDetails(Map<String, String> newStockDetail) {
        rediffHomePage.clickButtonAddStockMyportfolioScreen();
        rediffHomePage.fillTextNewStockName(newStockDetail.get("StockName"));
        rediffHomePage.enterSelectedDate(newStockDetail.get("Date"));
        rediffHomePage.fillTextQuantity(newStockDetail.get("Quantity"));
        rediffHomePage.fillTextPrice(newStockDetail.get("Price"));
        rediffHomePage.selectStockExchange(newStockDetail.get("StockExchange"));
        rediffHomePage.clickAddStockButtonNewStockScreen();
        generalUtilFunctions.checkPageIsReady();

    }



//    public void validateStockDetails(Map<String, String> validateEachStockItem) {
//        myPortfolioPage.validateCompanyName(validateEachStockItem.get("companyName"));
//        myPortfolioPage.validateQty(validateEachStockItem.get("qty"), validateEachStockItem.get("companyName"));
//        myPortfolioPage.validatePrice(validateEachStockItem.get("price"), validateEachStockItem.get("companyName"));
//        myPortfolioPage.validateExchange(validateEachStockItem.get("exchange"), validateEachStockItem.get("companyName"));
//        myPortfolioPage.validateValueAtAvg(validateEachStockItem.get("ValueAtAvg"), validateEachStockItem.get("companyName"));
//    }
}
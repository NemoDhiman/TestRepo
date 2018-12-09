package stepLibrary;

import cucumber.api.DataTable;
import net.thucydides.core.annotations.Step;
import pages.RediffHomePage;

import java.util.List;
import java.util.Map;

public class RediffHomePageStepLib {

    RediffHomePage rediffHomePage;

//    @Step
//    public void addStockDetails(DataTable addStocksList) {
//        List<List<String>> addStocksParentList = addStocksList.raw();
//
//        //Checcking the table size and iterating the rows in the data table.Since row 1 is column header starting from row 1.
//        for (int i = 1; i < addStocksParentList.size(); i++) {
////            rediffHomePage.fillTextNewStockName(addStocksParentList.get(i).get(0));
//            rediffHomePage.enterSelectedDate(addStocksParentList.get(i).get(1));
////            rediffHomePage.fillTextQuantity(addStocksParentList.get(i).get(2));
////            rediffHomePage.fillTextPrice(addStocksParentList.get(i).get(3));
////            rediffHomePage.selectStockExchange(addStocksParentList.get(i).get(4));
////            rediffHomePage.clickAddStockButtonNewStockScreen();
//        }
    }

//    @Step
//    public void
//    addStockWithDetails(Map<String,String> stockDetails) {
//        rediffHomePage.fillTextNewStockName(stockDetails.get("stockName"));
//        rediffHomePage.enterSelectedDate(stockDetails.get("date"));
//        rediffHomePage.fillTextQuantity(stockDetails.get("quantity"));
//        rediffHomePage.fillTextPrice(stockDetails.get("price"));
//        rediffHomePage.selectStockExchange(stockDetails.get("stockExchange"));
//        rediffHomePage.clickAddStockButtonNewStockScreen();
//    }
//}

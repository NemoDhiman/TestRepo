package stepDef;


import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import pages.MyPortfolioPage;
import stepLibrary.AddStockDetailsStepLib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddStockStepDef {

    @Steps
    AddStockDetailsStepLib addStockDetailsStepLib;

    @Steps
    MyPortfolioPage myPortfolioPage;

    @And("^the user adds the below stock$")
    public void theUserAddsTheBelowStock(List<List<String>> stockDetails) {
        for (int i = 1; i < stockDetails.size(); i++) {
            Map<String, String> newStockDetail = new HashMap<>();
            newStockDetail.put("StockName", stockDetails.get(i).get(0));
            newStockDetail.put("Date", stockDetails.get(i).get(1));
            newStockDetail.put("Quantity", stockDetails.get(i).get(2));
            newStockDetail.put("Price", stockDetails.get(i).get(3));
            newStockDetail.put("StockExchange", stockDetails.get(i).get(4));
            addStockDetailsStepLib.addStockDetails(newStockDetail);
        }
    }

    @Then("^the below stocks should be listed under stocks$")
    public void theBelowStocksShouldBeListedUnderStocks(List<List<String>> validateStockDetails){
       for(int i =1;i<validateStockDetails.size();i++){
           Map<String,String> validateEachStockItem = new HashMap<>();
           validateEachStockItem.put("companyName",validateStockDetails.get(i).get(0));
           validateEachStockItem.put("qty",validateStockDetails.get(i).get(1));
           validateEachStockItem.put("price",validateStockDetails.get(i).get(2));
           validateEachStockItem.put("exchange",validateStockDetails.get(i).get(3));
           validateEachStockItem.put("ValueAtAvg",validateStockDetails.get(i).get(4));
           myPortfolioPage.validateStockDetails(validateEachStockItem);


       }

    }
}

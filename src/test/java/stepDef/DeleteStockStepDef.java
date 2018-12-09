package stepDef;


import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import pages.MyPortfolioPage;
import java.util.List;
import java.util.Map;

public class DeleteStockStepDef {
    @Steps
    MyPortfolioPage myPortfolioPage;



    @And("^the user deletes the below stock$")
    public void theUserDeletesTheBelowStock(List<String> deleteStockDetails){
    myPortfolioPage.deleteEachStockItem(deleteStockDetails);
        }


    @Then("^the below stocks should not be listed under stocks$")
    public void theBelowStocksShouldNotBeListedUnderStocks(List<String> deleteStockDetails){
        myPortfolioPage.verifyDeletedStockDetails(deleteStockDetails);

    }

    @And("^the user deletes the below stock from History screen$")
    public void theUserDeletesTheBelowStockFromHistoryScreen(Map<String,String> stockNames){
           myPortfolioPage.deleteStockTransactionHistoryScreen(stockNames);

    }
}

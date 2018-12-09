package stepDef;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.RediffHomePage;
import stepLibrary.RediffHomePageStepLib;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateProfileStepDef {
    Logger logger = LoggerFactory.getLogger(CreateProfileStepDef.class);
    RediffHomePage rediffHomePage;

    @Steps
    RediffHomePageStepLib rediffHomePageStepLib;

    @And("^I logon to the rediff site with below details$")
    public void ILogonToTheRediffSiteWithBelowDetails(Map<String, String> regDetails) {
        rediffHomePage.clickLinkSignIn();
        rediffHomePage.fillTextEmailId(regDetails.get("emailId"));
        rediffHomePage.fillTextPassword(regDetails.get("password"));
        rediffHomePage.clickLoginSubmit();
    }

    @And("^the user creates the a portfolio$")
    public void theUserCreatesTheAPortfolio(List<String> profileName) {
        rediffHomePage.createProfile(profileName);
    }

    @Then("^the portfolio name is listed under portfolio's$")
    public void thePortfolioNameIsListedUnderPortfolioS(List<String> listedPortfolios) {
        rediffHomePage.verifyPortfolioList(listedPortfolios);
    }

    @Then("^the added portfolio should be listed with the existing portfolios$")
    public void theAddedPortfolioShouldBeListedWithTheExistingPortfolios(List<String> portfolioNames) {
        rediffHomePage.verifyAddedPortfoliosWithExistingPortfolios(portfolioNames);
    }

    @When("^the user selects the \"([^\"]*)\"$")
    public void theUserSelectsThe(String portfolioName) {
        rediffHomePage.selectPortfolioName(portfolioName);
    }

    @And("^the user selects to add the stock$")
    public void theUserSelectsToAddTheStock() {
        rediffHomePage.clickButtonAddStockMyportfolioScreen();
    }



//    @And("^the user adds the below stock$")
//    public void theUserAddsTheBelowStock(DataTable addStocksList) {
//        List<List<String>> stocksParentList = addStocksList.raw();
//        for (List<String> stockDetails : stocksParentList){
//            logger.info(stockDetails.toString());
//            Map<String,String> stockMap = new HashMap<>();
//            stockMap.put("stockName",stockDetails.get(0));
//            stockMap.put("datre",stockDetails.get(1));
//            stockMap.put("quantity",stockDetails.get(2));
//            stockMap.put("price",stockDetails.get(3));
//            stockMap.put("stockExchange",stockDetails.get(4));
//            rediffHomePageStepLib.addStockWithDetails(stockMap);
//        }
////        rediffHomePageStepLib.addStockDetails(addStocksList);
//    }
//
//
//
//
//
//    }


}

package stepDef;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.RediffHomePage;

import java.util.ArrayList;
import java.util.List;

public class DeleteProfileStepDef {

    RediffHomePage rediffHomePage;

    @And("^the user selects to delete the below Portfolios$")
    public void theUserSelectsToDeleteThe(List<String> portfolioName){
        List <String> portfolioNames = new ArrayList<>();
        {
            for(String name : portfolioName)
                portfolioNames.add(name);
            System.out.println(portfolioNames);

        }

        rediffHomePage.deletePortfolio(portfolioNames);
    }

    @Then("^the below Portfolios should not be listed under portfolios$")
    public void theBelowShouldNotBeListedUnderPortfolios(List<String> portfolioName){
        rediffHomePage.verifyPortfolioListAfterDeletePortfolio(portfolioName);
    }


}

package stepDef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.RediffHomePage;


public class HomePageStepDef {
    Logger log = LoggerFactory.getLogger(this.getClass());
    RediffHomePage rediffHomePage;

    @Given("^User is on the rediff site home page$")
    public void userIsOnTheRediffSiteHomePage() {
        rediffHomePage.open();
        log.info("Rediff Portfolio site is launched");
    }

    @Given("^the user registers with the \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void theUserRegistersWithThe(String fullName, String emailId, String password, String RetypePassword, String DOB, String gender, String ILiveIn,String city){
        rediffHomePage.clickLinkSignUp();
        rediffHomePage.enterTextFullName(fullName);
        rediffHomePage.enterTextEmailId(emailId);
        rediffHomePage.enterTextPassword(password);
        rediffHomePage.enterTextRetypePassword(password);
        rediffHomePage.selectDateOfBirth(DOB);
        rediffHomePage.selectRadioButtonGender(gender);
        rediffHomePage.selectILiveIncity(ILiveIn);
        rediffHomePage.selectCity(city);
    }


    @And("^the user signs out of the application$")
    public void theUserSignsOutOfTheApplication(){
        rediffHomePage.clickSignOutLink();

    }
}

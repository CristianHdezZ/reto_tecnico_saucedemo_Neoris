package co.com.neoris.certification.front.steps;

import co.com.neoris.certification.front.model.Product;
import co.com.neoris.certification.front.questions.VerifyResult;
import co.com.neoris.certification.front.tasks.AddProductTask;
import co.com.neoris.certification.front.tasks.Login;
import co.com.neoris.certification.front.tasks.OpenThe;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;
import java.util.Map;

import static co.com.neoris.certification.front.util.Constants.FIRST_ITEM;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SaucedemoSteps {
    @Before
    public void setUp(){
        OnStage.setTheStage(new OnlineCast());
    }

    @DataTableType
    public Product productEntry(Map<String, String> entry){
        return new Product(entry.get("product"), entry.get("firstname"),entry.get("lastname"),entry.get("postalCode"));
    }

    @Given("The {string} enters the site")
    public void theEntersTheSite(String strActor) {
        theActorCalled(strActor).wasAbleTo(OpenThe.page());
    }
    @Given("User wants to login in saucedemo page")
    public void userWantsToLoginInSaucedemoPage() {
        theActorInTheSpotlight().attemptsTo(Login.inThePage());
    }
    @When("Buy a product")
    public void buyAProduct(List<Product> dtProduct) {
        theActorInTheSpotlight().attemptsTo(AddProductTask.in(dtProduct.get(FIRST_ITEM)));
    }
    @Then("Verify that the purchase successful {string}")
    public void verifyThatThePurchaseSuccessful(String strResult) {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(VerifyResult.with(strResult)));
    }
}

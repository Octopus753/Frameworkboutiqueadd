package cucumber;

import java.io.IOException;

import java.util.List;
import java.util.Map;
import io.cucumber.datatable.DataTable;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjectstestcases.addpage;
import pageobjectstestcases.base;

public class StepDefinition extends base {
    private addpage add;

    @Before
    public void setUp() throws IOException {
    	
        getDriver(); // Initialize your WebDriver

        add = new addpage(driver); // Initialize the page object
    }

    @Given("user landed on home page")
    public void user_landed_on_home_page() {
    	
        addpage.setup(); // homepage landing
        
    }

    @Given("user accepted cookies")
    public void user_accepted_cookies() {
    	
        add.acceptcookies(); // Accept cookies
        
    }

    @Given("the user navigates to the PLP page")
    public void user_navigates_to_plp() {
        add.plp(); // Click on navigation and verify the PLP page
        add.checkplp(); // Check that the user is on the PLP page
    }

    @Then("the user adds a product to the cart from the PLP")
    public void user_adds_product_from_plp() {
        add.add2cart1(); // Logic to add product from PLP
    }

    @Then("adds more products from the recommendations on the cart page")
    public void adding_more_products_from_recommendations() {
        add.add2cart2(); // Logic for adding more products from recommendations
    }

    @Then("adds another product from the product detail page")
    public void user_adds_product_from_pdp() {
        add.pdp(); // Logic to add product from the product detail page
    }


    @Given("user has products in my cart")
    public void user_have_products_cart() {
        add.extraction();
    }

    @When("^user proceeds to checkout and fills in email (.+)$")
    public void user_proceeds_to_checkout_and_fills_in_email(String email) {
        add.secondstep1(email);
    }

    @When("^user fills in password (.+) and confirm password (.+)$")
    public void user_fills_password_and_confirmpassword(String password, String cpassword) {
        add.secondstep2(password, cpassword);
    }

    @Then("the user fills in the address containing:")
    public void user_fills_address(DataTable dataTable) {
        List<Map<String, String>> addressData = dataTable.asMaps(String.class, String.class);
        Map<String, String> address = addressData.get(0);
        
        add.secondstep3(
            address.get("Name"),
            address.get("Surname"),
            address.get("Social"),
            address.get("Street"),
            address.get("Pincode"),
            address.get("City"),
            address.get("Phone Number")
        );
    }
}

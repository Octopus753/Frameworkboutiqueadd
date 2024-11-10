package pageobjectstestcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class addtest {
	private addpage add;
	WebDriver driver;	
	
	 @BeforeTest(alwaysRun=true)
	    public void setUp() throws IOException {
		 driver = base.getDriver();
	        add = new addpage(driver);
	         addpage.setup();
	         add.acceptcookies();
	    }
	

	@Test(priority = 1, groups = "checkout")
	public void adding() {		

//visiting  plp
	add.plp();

///check if user landed on page
    add.checkplp();

//displaying products and checking no of products displayed
add.checkproduct();

//add2cart
add.add2cart1();

//adding more products from cart page
add.add2cart2();
System.out.println("completed adding product to cart via reco box in the cart");

}
	@Test (priority = 2)
	public void pdp() {
		//adding product from reco of pdp
	//	setup();
		add.pdp();
		if (add.add2cart2()) {
		    System.out.println("completed adding product to cart via reco box in the cart");
		} else {
		    System.out.println("Failed to add product via cart.");
		}
	}
	
		@Test (priority = 3, groups = "checkout")
	public void checkout() {
		//extracting product names
				add.extraction();

				//proceeding to 2nd step & filling form in 2nd step
						//1st part email id
						add.secondstep1("pafekiv3931@almaxen.com");

						//2nd part password
						add.secondstep2("pafekiv393@almaxen.com", "pafekiv393@almaxen.com");


						//2nd step address
						//cant go henceforth due to google security check and also lack of payment details
						add.secondstep3("Test", "Test", "Test", "41 avenue de Provence", "59300", "Villeparisis", "0339630861");
						System.out.println("reached checkout process step till step 2 but beyond that there's google security check step");

	}
	@AfterTest(alwaysRun=true)
	public void testclose() {
		driver.quit();
	}
}

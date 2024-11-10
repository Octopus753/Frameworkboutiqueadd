package pageobjectstestcases;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class addpage extends base {
	   ChromeOptions chromeOptions;
	    static WebDriver driver;
	    WebDriverWait wait;
	    Actions a ;
	public addpage(WebDriver driver) {
		addpage.driver = driver; // Use the driver passed from the test case
	    wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	    a = new Actions(driver);
	    PageFactory.initElements(driver, this); 
		}

		
	//page factory elements
			@FindBy(id="didomi-notice-agree-button")
			WebElement cookie;
			
			@FindBy(css=".toggle-megamenu-desktop.px-2.w-fit.d-none.d-lg-flex.align-items-center")
			WebElement baby1;
			
			@FindBy(css=".animated.bounceIn.column4")
			WebElement displaye;
			
		@FindBy(css="a[href='https://www.boutique-dalloz.fr/codes.html']")
		WebElement codes;
		
		@FindBy(tagName="h1")
		WebElement decoration;
		
		@FindBy(xpath="//a[normalize-space()='Code du travail 2024, annoté, commenté en ligne']")
		WebElement product;
		
		@FindAll (@FindBy(xpath="//h3[@class='name']"))
		List<WebElement>  brand;
		
		@FindBy(css="div[class='top-toolbar'] p[id='toolbar-amount'] span:nth-child(2)")
		WebElement no;
		
		@FindBy(css="button[title=\"Ajouter au panier\"][data-product-id=\"15095\"]")
		WebElement add2cart;
		
		@FindBy(css=".message-success.success.message")
		WebElement added;
		
		@FindBy(css="strong span[class='price']")
		WebElement price;
		
		@FindBy(css=".btn.tocart.primary.w-full")
		WebElement profie;
			
		@FindAll (@FindBy(css="tr td.item.article div div.product-item-title strong a"))
		List<WebElement>  productname;
		
		@FindBy(css=".header__action.account")
		WebElement account;
		
		@FindBy(css=".action.create.btn.primary")
		WebElement title;
		
		@FindBy(id=".action.create.btn.primary")
		WebElement regis;
		
		@FindBy(name="firstname")
		WebElement first;

		@FindBy(name="lastname")
		WebElement last;
		
		@FindBy(name="raison_soc")
		WebElement soc;
		
		@FindBy(name="street[]")
		WebElement street1;
		
		@FindBy(name="telephone")
		WebElement tel1;

		@FindBy(name="postcode")
		WebElement post1;

		@FindBy(name="city")
		WebElement city1;
		
		@FindBy(name="fonction-s")
		WebElement select;
		
		@FindBy(name="fonction_sub-s")
		WebElement Niveau;
		
		@FindBy(css="div[data-ui-id='checkout-cart-validationmessages-message-success']")
		WebElement successMessage;
		
		@FindBy(css=".action.btn.primary.checkout")
		WebElement checkout;
		
		@FindBy(className="customer-informations")
		WebElement secon;
		
		@FindBy(name="email")
		WebElement email;
		
		@FindBy(name="password")
		WebElement password;
		
		@FindBy(name="send")
		WebElement send;
		
		@FindBy(name="password_confirmation")
		WebElement password_confirmation;
		
		@FindBy(className="heroTitle")
		WebElement title1;
		
		@FindBy(id="product-addtocart-button")
		WebElement addtocart;
		
		@FindBy(css="fieldset[class='fieldset create info'] div[class='block-title'] span")
		WebElement address;
		
		public static void setup() {
	 		driver.get("https://www.boutique-dalloz.fr/");
	 	}
		
		//actions
		public void acceptcookies() {
	     //   ChromeOptions options = new ChromeOptions();
			//options.addArguments("disable-notifications");	
			//driver.get("https://www.boutique-dalloz.fr/");
		//	driver.manage().window().maximize();
			waitforElementtoAppear(cookie);
			 if (cookie.isDisplayed()) {
	           click(cookie);
	           System.out.println("User landed on site and cookie is accepted");
	       }else {
	           System.out.println("User landed on site but cookie isn't accepted");
	           driver.quit();
	       }
		}
		
		//required for boutiquedalloz_products

		public void plp() {
			waitforElementtoAppear(baby1);
			a.moveToElement(baby1).build().perform();
			waitforElementtoAppear(displaye);
			if(displaye.isDisplayed()) {
				click(codes);
			}else {
				System.out.println("Navigation display isnt visible");
			}
			
		}
		
		public void checkplp() {
			waitforElementtoAppear(decoration);
			if (driver.getCurrentUrl().contains("/codes.html")&& getElementText(decoration).contains("Codes Dalloz"))
				{	
					 System.out.println("User landed on codes page");
				}
			else {
				System.out.println("User didn't landed on codes page");
			}
		}
		
		public void checkproduct() {
			waitforElementtoAppear(product);
			if(product.isDisplayed()) {
				long a1 = brand.stream().count();
				String no1 = no.getText().replace(" Produkte","" );
				//Converting String into long using Integer.parseInt()  
				long i=Long.parseLong(no1);  
				if(i==a1) {
					System.out.println("no. of " +i + " products are displayed in first page. They are as : ");
					brand.stream().map(s-> s.getText()).forEach(s-> System.out.print(s + " , "));
					
				}else {
					System.out.println("all " +i + " products aren't displayed instead " +a1 + " no of products are displayed on first page.");
				}}else {
					System.out.println("products arent displayed");
				}
		}
		
		public void add2cart1(){
			boolean has = brand.stream().anyMatch(s-> s.getText().contains("Code de commerce 2025, annoté"));
			if(has) {
				  System.out.println("Found brand with target text");
				  waitforElementtoAppear(add2cart);
		            scrollToElement(add2cart);
			    a.moveToElement(add2cart).click().build().perform();
			}else {
				  System.out.println("brand with target text not found");
			}
			
			 waitforElementtoAppear(added);
			if(driver.getCurrentUrl().contains("/checkout/cart/") && (added.isDisplayed())) {
				waitforElementtoAppear(price);
					  System.out.println("product is added and final price is " +(price.getText()));
				}else {
				  System.out.println("product isn't added");
			}
		}
		
		public boolean add2cart2() {
			waitforElementtoAppear(profie);
			a.moveToElement(profie).click().build().perform();	
			try {
				waitforElementtoAppear(successMessage);
			    
			    if (successMessage.isDisplayed()) {
					waitforElementtoAppear(price);
			        System.out.println("Products are added and the final price is: " + price.getText());
			        return true;
			    }
			} catch (NoSuchElementException e) {
			    System.out.println("Products aren't added.");
			}    return false; // Indicate failure

			}

		
		public void extraction() {
			System.out.println("Product addede to cart are : ");
			productname.stream().forEach(s-> System.out.println(s.getText()));
		}
		
		public void secondstep1(String useremail) {
            scrollToElement(checkout);
	        click(checkout);
	        waitforElementtoAppear(secon);
			if(driver.getCurrentUrl().contains("/register/index/index/")&& (secon.isDisplayed())) {
					System.out.println("User navigated to 2nd step >> email");
			        sendKeys(email, useremail);
			        click(send);
			        }else {
				System.out.println("User didnt navigated to 2nd step >> email");
				driver.quit();
			}
		}
		
		public void secondstep2(String pass, String passw) {
			waitforElementtoAppear(secon);
			if(driver.getCurrentUrl().contains("/register/index/password/")&& (secon.isDisplayed())) {
					System.out.println("User navigated to 2nd step >> password");
			        sendKeys(password, pass);
			        sendKeys(password_confirmation, passw);
					click(send);			} 
			else {
				System.out.println("User didnt navigated to 2nd step >> password");
				driver.quit();
			}
		}
		
		public void secondstep3(String firstn, String lastn,String doc, String street, String post, String city,String tel  ) {
			waitforElementtoAppear(address);
			if(driver.getCurrentUrl().contains("/register/index/address/")&& (address.getText().contains("Informations personnelles"))) {
					System.out.println("User navigated to 2nd step >> address");
					 sendKeys(first, firstn);
					 sendKeys(last, lastn);
					 sendKeys(soc, doc);
					WebElement select = driver.findElement(By.name("fonction-s"));
					Select st = new Select(select);
					st.selectByValue("3");
					 sendKeys(street1, street);
					 sendKeys(post1, post);
					 sendKeys(city1, city);
					 sendKeys(tel1, tel);
				}else {
				System.out.println("User didnt navigated to 2nd step >> password");
				driver.quit();		}
		}
		
		public void pdp() {
			driver.get("https://www.boutique-dalloz.fr/code-du-travail-p.html");
			
			//visiting to pdp
			waitforElementtoAppear(title1);
			if (driver.getCurrentUrl().contains("code-du-travail-p") && title1.getText().contains("Code du travail 2024, annoté, commenté en ligne")) {
				System.out.println("User landed on product page named " + title1.getText());
				waitforElementtoAppear(addtocart);
				scrollToElement(addtocart);
				click(addtocart);
				System.out.println("User added product via product page");
				
			}else {
				System.out.println("User didnt landed on product page & product not added");
				driver.quit();
			}
		}
}

package flipKartTestNGPack;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import FlipkartBaseClass.BaseClasses;
import FlipkartUtilityClass.FlipkartUtilityClasses;
import flipKartPOM.FlipkartMiPagePOM;

import flipKartPOM.flipkart_Home_Pom;

public class FlipkartTestNg1 extends BaseClasses {
	
		flipkart_Home_Pom home;
		FlipkartUtilityClasses util;
		FlipkartMiPagePOM Mipage;
		Actions act;
		@BeforeClass
		 public void launchbrowser() {
			  openbrowser();
			  home=new flipkart_Home_Pom(driver);
			  util=new FlipkartUtilityClasses();
			  Mipage=new FlipkartMiPagePOM(driver);
			  act=new Actions(driver);
		  }
		@BeforeMethod
		public void beforeTest() throws InterruptedException {
			Thread.sleep(1000);
			home.CancelLoginPopup();
			home.ClickonElectronics();
			Thread.sleep(1000);
			act.moveToElement(home.ElectronicsButton).clickAndHold().build().perform();
			home.clickonmiText();
			
		}
	  @Test(priority=1)
	  public void VerifyText() throws InterruptedException {
		  Thread.sleep(1000);
	    String ActualText = home.NewestMI();
	    String ExpectedText = "Newest First";
	    Assert.assertEquals(ActualText, ExpectedText,"TC failed Text didn't matched ");
	    Reporter.log("TC passed Text Matched",true);}
	  @Test(priority=2)
	  public void MoveSlider() throws InterruptedException {
	    //Changing Price filter Using actions class and Selecting 3rd Highest Price
		  Thread.sleep(1000);
	    act.moveToElement(Mipage.PriceSlider).clickAndHold().moveToElement(Mipage.MaxPrice).build().perform();
	    }
	  @Test(priority=3)
	  public void selectMax3rdPriceFromSelect() throws InterruptedException {
	    //selecting 3rd max price from dropbox
		  Thread.sleep(1000);
		  Mipage.Select3rdMaxPrice();
}
}
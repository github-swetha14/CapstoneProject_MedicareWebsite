package com.medicare.Test;

	import org.testng.Assert;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	import com.medicare.Scripts.AddToCart;
	import com.medicare.Scripts.HomePage;
	import com.medicare.Scripts.LoginPage;
	import com.medicare.Scripts.RegisterPage;
	import com.medicare.Scripts.TestBase;

	public class AddToCartTestPage extends TestBase {
		
		HomePage hp;
		RegisterPage rp;
		LoginPage lp;
		AddToCart ac;
		
		@BeforeTest
		public void start_browser()
		{
			OpenBrowser("Chrome");
			hp = new HomePage(driver);
			rp = new RegisterPage(driver);
			lp = new LoginPage(driver);
			ac = new AddToCart(driver);
		}
		
	    @Test
		public void test_login() throws InterruptedException
		{
			lp.user_login();
		}
		

		@Test(priority='2')
		public void test_add_product_to_cart() throws InterruptedException
		{
			ac.add_product_to_cart();
		}
		
		@Test(priority='3')
		public void test_validate_success_message()
		{
			String expected = "Message:Product Hamdard Safi Natural Blood Purifier Syrup Added Successfully to Cart";
		String actualText=	ac.validate_success_message();
		Assert.assertEquals(actualText, expected);
		}

}

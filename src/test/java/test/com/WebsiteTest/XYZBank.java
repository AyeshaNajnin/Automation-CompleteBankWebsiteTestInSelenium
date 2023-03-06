package test.com.WebsiteTest;

import java.io.ByteArrayInputStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;

public class XYZBank {

	WebDriver driver;

	@BeforeSuite
	public void startbeowser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void Screenshot(String name) {

		Allure.attachment("Any text",
				new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
	}

	@Test(description = "XYZ Bank Full Website Test")
	public void mainPage() throws InterruptedException {

		driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

		// Customer Login
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button")).click();
		Thread.sleep(1000);

		// Dropdown menu customer
		Select namelist = new Select(driver.findElement(By.xpath("//*[@id=\"userSelect\"]")));
		namelist.selectByValue("5");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/button")).click();

		// Dropdown menu
		Select id = new Select(driver.findElement(By.xpath("//*[@id=\"accountSelect\"]")));
		Thread.sleep(1000);
		id.selectByValue("number:1013");

		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[1]")).click();
		Thread.sleep(1000);

		// Transactions Menu
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[2]")).click();
		// Deposit
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input")).sendKeys("2000");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button")).click();
		Thread.sleep(1000);
		// Withdraw
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[3]")).click();
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input"));
		Thread.sleep(1000);

		driver.findElement(By.xpath("/html/body/div/div/div[1]/button[2]")).click();
		driver.findElement(By.xpath("/html/body/div/div/div[1]/button[1]")).click();

		// Bank Manager Login
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[2]/button")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]")).click();
		Thread.sleep(1000);

		// Customer add from
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input"))
				.sendKeys("Robart");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input"))
				.sendKeys("Browni");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input"))
				.sendKeys("12990");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button")).click();

		// verifying the alert box msg
		Alert alertmsg = driver.switchTo().alert();
		String msg = driver.switchTo().alert().getText();
		Thread.sleep(3000);
		// this mean: alert msg (Ok) directly accepted or rejected
		driver.switchTo().alert().accept();

		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[2]")).click();

		// Dropdown menu for customer
		Select customerlist = new Select(driver.findElement(By.xpath("//*[@id=\"userSelect\"]")));
		customerlist.selectByValue("1");
		// Dropdown menu currency
		Select currency = new Select(driver.findElement(By.xpath("//*[@id=\"currency\"]")));
		Thread.sleep(1000);
		currency.selectByValue("Dollar");

		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button")).click();
		Thread.sleep(1000);

		// verifying the alert box msg
		Alert alertmsg2 = driver.switchTo().alert();
		String msg2 = driver.switchTo().alert().getText();
		Thread.sleep(3000);
		// this mean: alert msg (Ok) directly accepted or rejected
		driver.switchTo().alert().accept();

		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[3]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/form/div/div/input"))
				.sendKeys("Md. Saiful");
		Thread.sleep(3000);

		driver.findElement(By.xpath("/html/body/div/div/div[1]/button[1]")).click();

	}

	@AfterSuite
	public void closeBrowser() throws InterruptedException {

		Thread.sleep(3000);
		driver.quit();
	}
}

package basePkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Login {

	@Test
	public void Testdatang() throws FileNotFoundException {

		System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		Properties properties = new Properties();
		String propertyFilePath = System.getProperty("user.dir") + ("/src/main/resources/Properties/Config.properties");
		File prps = new File(propertyFilePath);
		FileInputStream FIS = new FileInputStream(prps);
		try {
			properties.load(FIS);
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.get(properties.getProperty("Baseurl"));
		driver.findElement(By.xpath(properties.getProperty("UserId_Xpath"))).sendKeys(properties.getProperty("Userid"));
		driver.findElement(By.xpath(properties.getProperty("Password_Xpath"))).sendKeys(properties.getProperty("Password"));
		driver.findElement(By.xpath(properties.getProperty("LoginButton_Xpath"))).click();
	}

}

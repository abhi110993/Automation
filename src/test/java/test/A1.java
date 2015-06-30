package test;
import java.sql.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class A1 {
	
	
	@Test
public static void main(String... s) throws Exception{
	WebDriver wd=new FirefoxDriver();
	wd.manage().window().maximize();
	wd.navigate().to("http://10.0.1.86/tatoc/advanced/hover/menu");
	//wd.findElement(By.xpath("//span[@class='menutitle']"));
	/*
	Select dropdown = new Select(wd.findElement(By.xpath("//span[@class='menutitle']")));
     dropdown.selectByVisibleText("continuously");
     */
     
     Actions action = new Actions(wd);
     WebElement we = wd.findElement(By.xpath("//span[@class='menutitle']"));
     action.moveToElement(we).moveToElement(wd.findElement(By.xpath("//span[@onclick='gonext();']"))).click().build().perform();
}
	
}

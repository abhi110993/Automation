package test;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ParasProb {
public static void main(String... s) throws Exception{
	WebDriver wd=new FirefoxDriver();
	wd.manage().window().maximize();
	wd.navigate().to("http://the-internet.herokuapp.com/");
	wd.findElement(By.xpath("//a[@href='/key_presses']")).click();
	Actions action = new Actions(wd); 
	
	//action.keyDown(Keys.ENTER).perform();//.sendKeys(String.valueOf('\u0061')).perform();
	action.sendKeys(Keys.CONTROL).perform();
	String str= wd.findElement(By.xpath("html/body/div[2]/div/div/p[2]")).getText();
	
	System.out.println(str);
	//action.sendKeys(String.valueOf('a')).perform();
	
}
}

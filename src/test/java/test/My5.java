package test;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class My5 {
public static void main(String... s) throws Exception{
	WebDriver wd=new FirefoxDriver();
	wd.manage().window().maximize();
	wd.navigate().to("http://10.0.1.86/tatoc/basic/cookie");
	wd.findElement(By.xpath("//a[@onclick='generateToken();']")).click();
	String b= wd.findElement(By.xpath("//span[@id='token']")).getText();
	String c=b.substring(7,b.length());
	System.out.println(c); 
	
	Cookie coo	= new Cookie("Token",c);
	wd.manage().addCookie(coo);	
	wd.findElement(By.xpath("//a[@onclick='gonext();']")).click();
	
}
}

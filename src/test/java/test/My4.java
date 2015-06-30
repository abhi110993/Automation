package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class My4 {
public static void main(String... s) throws Exception{
	WebDriver wd=new FirefoxDriver();
	wd.manage().window().maximize();
	wd.navigate().to("http://10.0.1.86/tatoc/basic/windows");
	String parentHandle = wd.getWindowHandle();
	wd.findElement(By.xpath("//a[@onclick='launchwindow();']")).click();
	Thread.sleep(1000);
	for (String winHandle : wd.getWindowHandles()) {
		wd.switchTo().window(winHandle);
	}
	wd.findElement(By.xpath("//input[@id='name']")).sendKeys("abc");
	Thread.sleep(1000);
	wd.findElement(By.xpath("//input[@id='submit' and @value='Submit']")).click();
	
	wd.switchTo().window(parentHandle);
	wd.findElement(By.xpath("//a[@onclick='gonext();']")).click();
}
}

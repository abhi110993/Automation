package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sun.jna.platform.win32.Wdm;

public class My1 {
	
static WebDriver wd=new FirefoxDriver();
public static void main(String... s) throws Exception{
	/*wd.get("http://10.0.1.86/tatoc/basic/grid/gate");
	wd.findElement(By.xpath("//div[@onclick='passthru();']")).click();
	*/
	wd.manage().window().maximize();
	
	
	
}

}

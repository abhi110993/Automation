package test;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class My2 {
	
static WebDriver wd=new FirefoxDriver();
public static void main(String... s) throws Exception{
	
	wd.navigate().to("http://10.0.1.86/tatoc/basic/frame/dungeon");
	wd.manage().window().maximize();
	wd.switchTo().frame(wd.findElement(By.id("main")));
	
	while(true){
		Thread.sleep(2000);
		wd.switchTo().defaultContent();
		wd.switchTo().frame(wd.findElement(By.id("main")));
		String d=wd.findElement(By.id("answer")).getAttribute("class");
			
		wd.findElement(By.xpath("//a[@onclick='reloadChildFrame();']")).click();

		//wd.switchTo().defaultContent();
	wd.switchTo().frame(wd.findElement(By.id("child")));
	
	String e=wd.findElement(By.id("answer")).getAttribute("class");
		if(d.equals(e)){
		break;
	}
	}
	wd.switchTo().defaultContent();
	wd.switchTo().frame(wd.findElement(By.id("main")));
	wd.findElement(By.xpath("//a[@onclick='gonext();']")).click();
}

}	
	
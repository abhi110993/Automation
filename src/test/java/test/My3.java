package test;

import java.awt.Desktop.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class My3 {
public static void main(String... s){
	WebDriver wd=new FirefoxDriver();
	wd.navigate().to("http://10.0.1.86/tatoc/basic/drag");
    wd.manage().window().maximize();
    
    WebElement From = wd.findElement(By.xpath("//div[@id='dragbox' and @class='ui-draggable']"));
    WebElement To = wd.findElement(By.xpath("//div[@id='dropbox']"));
    
    Actions builder = new Actions(wd);
    org.openqa.selenium.interactions.Action dragAndDrop = builder.clickAndHold(From).moveToElement(To).release(To).build();
    dragAndDrop.perform();
    wd.findElement(By.xpath("//a[@onclick='gonext();']")).click();

	
}
}

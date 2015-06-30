package test;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

class FlashObjectWebDriver {
	 private final WebDriver webDriver;
	 private final String flashObjectId;
	 
	public FlashObjectWebDriver(final WebDriver webDriver, final String flashObjectId) {
	 this.webDriver = webDriver;
	 this.flashObjectId = flashObjectId;
	 }
	 
	 
	 
	public String callFlashObject(final String functionName, final String... args) {
	 final Object result =
	 ((JavascriptExecutor)webDriver).executeScript(
	 makeJsFunction(functionName, args),
	 new Object[0]);
	 
	return result != null ? result.toString() : null;
	 }
	 
	private String makeJsFunction(final String functionName, final String... args) {
	 final StringBuffer functionArgs = new StringBuffer();
	 
	if (args.length > 0) {
	 for (int i = 0; i < args.length; i++) {
	 if (i > 0) {
	 functionArgs.append(",");
	 }
	 functionArgs.append(String.format("'%1$s'", args[i]));
	 }
	 }
	 return String.format(
	 "return document.%1$s.%2$s(%3$s);",
	 flashObjectId,
	 functionName,
	 functionArgs);
	 }
	 
	}
public class A2{
	 public static void main(String[] args) throws InterruptedException {
	FirefoxDriver driver = new FirefoxDriver();
	 
	FlashObjectWebDriver flashApp = new FlashObjectWebDriver(driver, "Ooyala Video Player");
	 
	driver.get("http://10.0.1.86/tatoc/advanced/video/player");
	 Thread.sleep(2000L);
	 
	 // let the video load
	 
	 Thread.sleep(3000);
	 
	 
	 // Play the video for 10 seconds
	 Thread.sleep(5000);
	 flashApp.callFlashObject("pauseVideo");
	 Thread.sleep(5000);
	 flashApp.callFlashObject("playVideo");
	 Thread.sleep(5000);
	 flashApp.callFlashObject("seekTo","140","true");
	 Thread.sleep(5000);
	 flashApp.callFlashObject("mute");
	 Thread.sleep(5000);
	 flashApp.callFlashObject("setVolume","50");
	 Thread.sleep(5000);
	 
		/* WebDriver wd=new FirefoxDriver();
		 wd.navigate().to("http://10.0.1.86/tatoc/advanced/video/player");
		 Thread.sleep(9000);
		*/// wd.findElement(By.xpath("//div[@id='ooyalaplayer']"));
	}
	 
	}
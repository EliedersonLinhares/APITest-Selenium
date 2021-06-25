package com.br.esl.tasks.prod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HealthCheckIT {
	
	@Test
	public void healtCheck() throws MalformedURLException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		//DesiredCapabilities cap = DesiredCapabilities.chrome();
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.101:4444/wd/hub"), options);
	try {	
		driver.navigate().to("http://192.168.0.101:9999/tasks");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String version = driver.findElement(By.id("version")).getText();
		//System.out.println(version);
		Assert.assertTrue(version.startsWith("build"));
	}finally {
		driver.quit();
	}
	}

}

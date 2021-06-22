package com.br.esl.tasks.funcional;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TasksTest {
	
	
	public WebDriver acessarAplicacao() throws MalformedURLException {
		//WebDriver driver = new ChromeDriver();
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.101:4444/wd/hub"), cap);
		driver.navigate().to("http://192.168.0.101:8001/tasks");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	@Test
	public void deveSalvarTarefaComSucesso() throws MalformedURLException {
		WebDriver driver = acessarAplicacao();
		
		try {
		//clicar em Add todo
		driver.findElement(By.id("addTodo")).click();
		
		//escrever uma descri��o
		driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
		
		//escrever a data
		driver.findElement(By.id("dueDate")).sendKeys("21/06/2030");
		
		//clicar em salvar
		driver.findElement(By.id("saveButton")).click();
		
		//validar a mensagem de sucesso
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Success!", message);
		
		}finally{
			//clicar em sair
			driver.quit();
		}
		
	}
	
	@Test
	public void naodeveSalvarTarefaSemDescricao() throws MalformedURLException {
		WebDriver driver = acessarAplicacao();
		
		try {
		//clicar em Add todo
		driver.findElement(By.id("addTodo")).click();
		
		//escrever uma descri��o
		//driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
		
		//escrever a data
		driver.findElement(By.id("dueDate")).sendKeys("21/06/2030");
		
		//clicar em salvar
		driver.findElement(By.id("saveButton")).click();
		
		//validar a mensagem de sucesso
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Fill the task description", message);
		
		}finally{
			//clicar em sair
			driver.quit();
		}
		
	}
	
	@Test
	public void naodeveSalvarTarefaSemData() throws MalformedURLException {
		WebDriver driver = acessarAplicacao();
		
		try {
		//clicar em Add todo
		driver.findElement(By.id("addTodo")).click();
		
		//escrever uma descri��o
		driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
		
		//escrever a data
		//driver.findElement(By.id("dueDate")).sendKeys("21/06/2030");
		
		//clicar em salvar
		driver.findElement(By.id("saveButton")).click();
		
		//validar a mensagem de sucesso
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Fill the due date", message);
		
		}finally{
			//clicar em sair
			driver.quit();
		}
		
	}
	
	@Test
	public void naodeveSalvarTarefaComDataPassada() throws MalformedURLException {
		WebDriver driver = acessarAplicacao();
		
		try {
		//clicar em Add todo
		driver.findElement(By.id("addTodo")).click();
		
		//escrever uma descri��o
		driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
		
		//escrever a data
		driver.findElement(By.id("dueDate")).sendKeys("21/06/2018");
		
		//clicar em salvar
		driver.findElement(By.id("saveButton")).click();
		
		//validar a mensagem de sucesso
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Due date must not be in past", message);
		
		}finally{
			//clicar em sair
			driver.quit();
		}
		
	}
	
	
	
	
	

}

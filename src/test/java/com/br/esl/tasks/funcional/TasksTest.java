package com.br.esl.tasks.funcional;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TasksTest {
	
	
	public WebDriver acessarAplicacao() {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://localhost:8001/tasks");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	@Test
	public void deveSalvarTarefaComSucesso() {
		WebDriver driver = acessarAplicacao();
		
		try {
		//clicar em Add todo
		driver.findElement(By.id("addTodo")).click();
		
		//escrever uma descrição
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
	public void naodeveSalvarTarefaSemDescricao() {
		WebDriver driver = acessarAplicacao();
		
		try {
		//clicar em Add todo
		driver.findElement(By.id("addTodo")).click();
		
		//escrever uma descrição
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
	public void naodeveSalvarTarefaSemData() {
		WebDriver driver = acessarAplicacao();
		
		try {
		//clicar em Add todo
		driver.findElement(By.id("addTodo")).click();
		
		//escrever uma descrição
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
	public void naodeveSalvarTarefaComDataPassada() {
		WebDriver driver = acessarAplicacao();
		
		try {
		//clicar em Add todo
		driver.findElement(By.id("addTodo")).click();
		
		//escrever uma descrição
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

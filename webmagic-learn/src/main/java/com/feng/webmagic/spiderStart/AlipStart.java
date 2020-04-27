package com.feng.webmagic.spiderStart;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Component;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

@Component
public class AlipStart implements PageProcessor  { 

	//设置一个全局的参数存放登陆cookies
	  private Set<Cookie> cookies;
	 
	  private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
	 
	  public Site getSite() {
	    for (Cookie cookie : cookies) {
	      site.addCookie(cookie.getName().toString(), cookie.getValue().toString());
	    }
	    return site;
	  }
	 
	  public static void main(String[] args) throws Exception {
	    AlipStart test = new AlipStart();
	    test.Login();
	    Spider.create(test)
	          .addUrl("要爬取的页面")
	          .run();
	       // .runAsync();
	  }
	 
	  public void process(Page page) {
	 
	    String string = page.getHtml().xpath("body").toString();
	    String[] split = string.split("<body>");
	 
	    // ResultItems items = page.getResultItems();
	    // System.out.println(items.get("name"));
	  
	    // 部分三：从页面发现后续的url地址来抓取
	    // page.addTargetRequests(page.getHtml().links().all());
	 
	  }
	 
	  // 登陆方法
	  public void Login() throws IOException {
	    System.setProperty("webdriver.chrome.driver",
	        "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
	 
	    WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("需要自动登陆的页面");
	    // 定义验证码变量
	    String verify = null;
	    try {
	      Thread.sleep(3000);
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    }
	    driver.findElement(By.xpath("//div[@class='layui-input-block']/input")).sendKeys("账号");
	    driver.findElement(By.id("userPwd")).sendKeys("密码");
	    //获取点击按钮
	    WebElement element = driver.findElement(By.xpath("//button[@class='layui-btn layui-btn-fluid']"));
	    //验证码获取破解....之后奉上
	    
	    //模拟点击
	    element.click();
	    //很重要的一步获取登陆后的cookies
	    cookies = driver.manage().getCookies();
	    driver.close();
	  }

  }
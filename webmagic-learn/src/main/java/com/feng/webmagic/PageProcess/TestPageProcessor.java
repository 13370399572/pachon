package com.feng.webmagic.PageProcess;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Component;

import com.github.pagehelper.util.StringUtil;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

@Component
public class TestPageProcessor implements PageProcessor{

	//设置一个全局的参数存放登陆cookies
	  private Set<Cookie> cookies;
	 
	  private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
	 
	  public Site getSite() {
	    for (Cookie cookie : cookies) {
	      site.addCookie(cookie.getName().toString(), cookie.getValue().toString());
	    }
	    return site;
	  }
	  
	@Override
	public void process(Page page) {
		// TODO Auto-generated method stub
		List<String> links = new ArrayList<String>();
		Html html = page.getHtml();
		String link  = html.xpath("//div[@class='desc-lazyload-container']/@data-tfs-url").toString();
		String title = html.xpath("//div[@id='mod-detail-title']//h1/text()").toString();
		List<Selectable> imgs  = html.xpath("//div[@class='vertical-img']").nodes();
		List<String> imges = new ArrayList<String>();
		
	
		//String ti = title.substring(0, 2);
		//System.out.println(ti);
		if (StringUtil.isNotEmpty(title)) {
		page.putField("zhang", title);
		}
		
		if (CollectionUtils.isNotEmpty(imgs)) {
			for (Selectable img : imgs) {
				String xx= disposeimg(img);
				imges.add(xx);
			}
			page.putField("imgs", imges);
		}
		
		if (StringUtil.isNotEmpty(link)) {
			page.addTargetRequest(link);
		}else {
			List<Selectable> xxString=	html.xpath("//img/@src").nodes();
			for (Selectable selectable : xxString) {
			String xx =	dispose(selectable);
			links.add(xx);
			}
			page.putField("links", links);
			System.out.println(xxString);
		}
	}



	private String disposeimg(Selectable img) {
		// TODO Auto-generated method stub
	    String xx =	img.xpath("//img/@src").toString().replaceAll("60x60", "400x400");
	    System.out.println(xx);
	    
	    return xx;
	}



	public String dispose(Selectable li) {
		// TODO Auto-generated method stub
	    String src  = 	li.toString();
		String string= src.replaceAll("\\\\", "").replaceAll("\"","");
	    System.out.println(string);
		return string;
	}


	/*
	 * @Override public Site getSite() { // TODO Auto-generated method stub return
	 * site; }
	 */
	
	 // 登陆方法
	  public void Login() {
			/*
			 * System.setProperty("webdriver.chrome.driver",
			 * "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe"
			 * );
			 */
	    WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	 //   driver.get("https://www.baidu.com/");
	    driver.get("https://login.1688.com/member/signin.htm?from=sm&Done=http%3A%2F%2Fdetail.1688.com%2Foffer%2F588461034948.html%3Fspm%3Da262eq.14421251.k99yqobl0.10.62531b27P60jaC%26udsPoolId%3D1823021%26resourceId%3D1442978&uuid=dd439fa5f33e35e737e1a1c33f63d2a7");
	    // 定义验证码变量
	    String verify = null;
	    try {
	      Thread.sleep(3000);
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    }
	    driver.findElement(By.xpath("//div[@class='input-plain-wrap input-wrap-loginid']/input")).sendKeys("珠宝采购");
	    driver.findElement(By.id("fm-login-password")).sendKeys("22zhang44");
	    //获取点击按钮
	    WebElement element = driver.findElement(By.xpath("//button[@class='fm-button fm-submit password-login']"));
	    //验证码获取破解....之后奉上
	    //模拟点击
	    element.click();
	    //很重要的一步获取登陆后的cookies
	    cookies = driver.manage().getCookies();
	    driver.close();
	  }

}

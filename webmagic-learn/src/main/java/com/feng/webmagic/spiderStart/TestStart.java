package com.feng.webmagic.spiderStart;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.feng.webmagic.PageProcess.TestPageProcessor;
import com.feng.webmagic.pipeline.TestPipeline;

import us.codecraft.webmagic.Spider;

@Component
public class TestStart {
	@Autowired
	private  TestPageProcessor testPageProcessor;
	
	@Autowired
	private  TestPipeline testPipeline;
	
	public  void zhang() {
		//登录页面
	//	https://login.1688.com/member/signin.htm?from=sm&Done=http%3A%2F%2Fdetail.1688.com%2Foffer%2F588461034948.html%3Fspm%3Da262eq.14421251.k99yqobl0.10.62531b27P60jaC%26udsPoolId%3D1823021%26resourceId%3D1442978&uuid=dd439fa5f33e35e737e1a1c33f63d2a7
		
		// TODO Auto-generated method stub
     //		testPageProcessor.Login();
		Spider.create(testPageProcessor).addUrl("https://detail.1688.com/offer/588461034948.html?spm=a262eq.14421251.k99yqobl0.10.62531b27P60jaC&udsPoolId=1823021&resourceId=1442978").addPipeline(testPipeline).thread(5).run();
	}
	
	
}

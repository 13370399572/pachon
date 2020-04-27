package com.feng.webmagic.PageProcess;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;


@Component
public class SligerPageProcessor implements PageProcessor {
	
	 
	 
	 private Site site = Site.me().setRetryTimes(3).setSleepTime(100)
	            .setUserAgent(
	                    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");
	@Override
	public void process(Page page) { 
	//List<String> link =		 	page.getHtml().links().all();
	List<String>  links =	  	page.getHtml().xpath("//div[@class='left']/a/@href").all();
	List<String> imgurl =       page.getHtml().xpath("//a[@class='avatar']/img/@src").all();
	List<String> title  =       page.getHtml().xpath("//a[@class='avatar']/img/@alt").all();
	page.putField("url",links );
	page.putField("imgurl",imgurl );
	page.putField("title",title );
	
	//List<String> linkSS =	 page.getUrl().all();
	}

	@Override
	public Site getSite() {
		// TODO Auto-generated method stub
		return site;
	}

}

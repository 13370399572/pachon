package com.feng.webmagic.PageProcess;

import java.util.Map;

import javax.servlet.http.Cookie;

import org.springframework.stereotype.Component;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

@Component
public class MusictextProcessTwo implements PageProcessor {
   
	private Site site = Site.me().setRetryTimes(3).setSleepTime(100)
			.setUserAgent(
					"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");
	;
	@Override
	public void process(Page page) {
		String url = page.getUrl().toString();
		Map<String, String> cookie= page.getRequest().getCookies();
		String cString= cookie.get("singerId");
		Long singerId = Long.valueOf(cString);
		page.putField("singerId", singerId);
		page.putField("name", page.getHtml().xpath("//em[@class='f-ff2']/text()"));
		page.putField("geshou", page.getHtml().xpath("//p[@class='des s-fc4']/span/a/text()"));
		page.putField("zhuanji", page.getHtml().xpath("//p[@class='des s-fc4']/a/text()"));
		page.putField("imgurl", page.getHtml().xpath("//div[@class='u-cover u-cover-6 f-fl']/img/@src"));
		
		page.putField("URL", url);
	}

	@Override
	public Site getSite() {
		// TODO Auto-generated method stub
		return site;
	}

}

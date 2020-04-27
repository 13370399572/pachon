package com.feng.webmagic.PageProcess;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.feng.entity.Cinema;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

@Component
public class CinemaPageProcessor implements PageProcessor {

	private Site site = Site.me().setRetryTimes(3).setSleepTime(100)
			.setUserAgent(
					"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");
	;

	@Override
	public void process(Page page) {
	//List<String> strings =	page.getHtml().links().all();
	//     //ul[@class='']/li
    
	List<String> strings2 = page.getHtml().links().
	regex("https://kkbbb1\\.com/list\\.php\\S+k=\\S+flid=\\d\\S+sort=default\\S+m=\\S+page=\\d").all();
	page.addTargetRequests(strings2);
	if (page.getUrl().regex("https://kkbbb1\\.com/list\\.php\\S+k=\\S+flid=\\d\\S+sort=default\\S+m=\\S+page=\\d").match()) {
	List<Selectable> lis= page.getHtml().xpath("ul[@class='piclist indexl2']/li ").nodes();
	 List<Cinema> cinemas = new ArrayList<>();
	for (Selectable li : lis) {
	 Cinema cinema =	resolveImgUrl(li);
	 cinemas.add(cinema);
	}
	page.putField("cinemas", cinemas);
	page.addTargetRequest(page.getUrl().toString());
	}
   System.out.println("aa");
	}
     
	private Cinema resolveImgUrl(Selectable li) {
	 String url=	li.xpath("//a[@class='pic']/@href").toString();
	 String name =  li.xpath("//a[@class='pic']/@title").toString();
	 String imgUrl =li.xpath("//a[@class='pic']/@style").toString();
	// background-image:url('https://www.188370aaa.com/20190927/MHhWqzwy/pic/006.jpg')
	 String url11="https://kkbbb1.com"+url;
	String zz=  imgUrl.split("'")[1];
	Cinema cinema = new Cinema();
	cinema.setName(name);
	cinema.setImgUrl(zz);
	cinema.setUrl(url11);
	return cinema;
	}

	@Override
	public Site getSite() {
		// TODO Auto-generated method stub
		return site;
	}

}

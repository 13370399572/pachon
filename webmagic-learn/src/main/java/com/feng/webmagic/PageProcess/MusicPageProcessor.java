package com.feng.webmagic.PageProcess;

import static org.assertj.core.api.Assertions.allOf;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.feng.dao.SligerDao;
import com.feng.entity.Film;
import com.feng.entity.Music;
import com.feng.entity.Singer;

import lombok.extern.slf4j.Slf4j;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

@Slf4j
@Component
public class MusicPageProcessor implements PageProcessor {

	@Autowired
	private MusictextProcessTwo musictextProcessTwo;

	@Autowired
	private SligerDao sligerDao;

	private Site site = Site.me().setRetryTimes(3).setSleepTime(100)
			.setUserAgent(
					"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");
	;
    
	private List<String> singerIds= new ArrayList<>();
	
	// Html html = page.getHtml();
	/*String singsTRING = String.valueOf(singerId);
	page.putField("name", page.getHtml().xpath("//em[@class='f-ff2']/text()").toString());
	page.putField("geshou", page.getHtml().xpath("//p[@class='des s-fc4']/span/a/text()"));
	page.putField("zhuanji", page.getHtml().xpath("//p[@class='des s-fc4']/a/text()"));
	page.putField("imgurl", page.getHtml().xpath("//div[@class='u-cover u-cover-6 f-fl']/img/@src"));
	page.putField("URL", page.getUrl().toString());
	page.putField("singerId", singsTRING);*/
	/*if (StringUtils.isEmpty(resultItems.get("name"))) {
	}else {*/
	@Override
	public void process(Page page) {
		List<String> urls=  page.getHtml().links().regex("https://music\\.163\\.com/song\\?id\\=\\d+").all();
		String url= page.getUrl().toString();
	//	List<String> singerIds= new ArrayList<>();
		singerIds.add(url);
		page.addTargetRequests(urls);
		//List<Music> filmList = new ArrayList<>();
		 if (page.getUrl().regex("https://music\\.163\\.com/song\\?id\\=\\d+").match()) {
			        Long singerId= sligerDao.findByUrl(singerIds.get(0)).get(0).getId();
	        		Music music = new Music();
	        		music.setTitle(page.getHtml().xpath("//em[@class='f-ff2']/text()").toString());
	        		music.setName(page.getHtml().xpath("//p[@class='des s-fc4']/span/a/text()").toString());
	        		music.setImgUrl(page.getHtml().xpath("//div[@class='u-cover u-cover-6 f-fl']/img/@src").toString());
	        		music.setZhuanji(page.getHtml().xpath("//p[@class='des s-fc4']/a/text()").toString());
	        	    String xx =	"https://link.hhtjim.com/163/"+ page.getUrl().toString().split("=")[1]+".mp3";
	        		music.setUrl(xx);
	        		music.setSingerId(singerId);
	        		page.putField("music", music);
	            	/*filmList.add(music);*/
	                page.addTargetRequest(page.getUrl().toString());
	                
	        }
		//
		System.out.println("jjjj");
	}

	@Override
	public Site getSite() {
		// TODO Auto-generated stub
		return site;
	}

}

package com.feng.webmagic.PageProcess;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import com.feng.entity.Game;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

@Component
public class GamePageProcessor implements PageProcessor {
	private Site site = Site.me().setRetryTimes(3).setSleepTime(100)
			.setUserAgent(
					"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");
	;
	
	@Override
	public void process(Page page) {
		List<Game> games = new ArrayList<>();
	List<Selectable> lis	 =page.getHtml().xpath("//ul[@class='game-list clearfix']/li").nodes();
	if (CollectionUtils.isNotEmpty(lis)) {
		for (Selectable li : lis) {
			games.add(resolveImgUrl(li));
		}
		page.putField("games", games);
	}
	}

	private Game resolveImgUrl(Selectable li) {
		// TODO Auto-generated method stub
		Game    geme = new Game();
	    String  title =	 li.xpath("//li[@class='g-gameCard-item']/@title").toString();
	    String  url   =  li.xpath("//a[@class='g-gameCard-link new-clickstat']/@href").toString();
	    String  imgUrl =        li.xpath("//img[@class='g-gameCard-img']/@src").toString();
	    geme.setTitle(title);
	    geme.setImgUrl(imgUrl);
	    geme.setUrl(url);
		return geme;
	}

	@Override
	public Site getSite() {
		// TODO Auto-generated method stub
		return site;
	}

}

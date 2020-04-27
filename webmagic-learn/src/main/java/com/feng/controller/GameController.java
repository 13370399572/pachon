package com.feng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.feng.webmagic.PageProcess.GamePageProcessor;
import com.feng.webmagic.pipeline.GamePipline;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

@Controller
@RequestMapping("/game")
public class GameController {
	
	@Autowired
	private GamePageProcessor gamePageProcessor;
	
	@Autowired
	private GamePipline gamePipline;
	
	@Scheduled(fixedRate=1000000)
	private void SpiderStart() {
		Spider.create(gamePageProcessor).addUrl("https://www.huya.com/g").addPipeline(gamePipline).thread(2).run();
	}
    
	
}

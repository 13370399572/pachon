package com.feng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.feng.entity.Cinema;
import com.feng.entity.Music;
import com.feng.servcie.CinemaService;
import com.feng.webmagic.PageProcess.CinemaPageProcessor;
import com.feng.webmagic.pipeline.CinemaPipeline;

import us.codecraft.webmagic.Spider;

@Controller
@RequestMapping("/cinema")
public class CinemaController {
    
	@Autowired
	private CinemaService cinemaService;
	
    @Autowired
	private CinemaPageProcessor cinemaPageProcessor;
    
    @Autowired
    private CinemaPipeline cinemaPipeline;
	
	
	@Scheduled(fixedRate=100000)
	public void CinemaSplder() {
		Spider.create(cinemaPageProcessor).addUrl("https://kkbbb1.com/list.php?flid=18").thread(2).addPipeline(cinemaPipeline).run();
	}
	
	@GetMapping("/list.htm")
	public String blogList(String name, Model model, @RequestParam(defaultValue = "1") int num,@RequestParam(defaultValue = "18") int size) {
		/*Singer singer =new Singer();
		singer.setTitle(title);*/
		Cinema cinema = new Cinema();
		cinema.setName(name);
		Page<Music> cinemapage= cinemaService.ListPage(cinema,num,size);
		model.addAttribute("cinemapage",cinemapage);
		return "cinema/list";
	}
	
	
}


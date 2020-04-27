package com.feng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.feng.entity.Music;
import com.feng.entity.Singer;
import com.feng.servcie.MusicService;

@Controller
@RequestMapping("/music1")
public class MusicController {

	@Autowired
	private MusicService musicService;

	@GetMapping("/list1.htm")
	public String blogList(String singerUrl, Model model, @RequestParam(defaultValue = "1") int num,@RequestParam(defaultValue = "18") int size) {
		/*Singer singer =new Singer();
		singer.setTitle(title);*/
		Page<Music> musicpage= musicService.ListPage(singerUrl,num,size);
		model.addAttribute("musicpage",musicpage);
		return "music/list1";
	}

}

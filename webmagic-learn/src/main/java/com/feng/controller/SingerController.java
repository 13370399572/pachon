package com.feng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.feng.entity.Blog;
import com.feng.entity.Singer;
import com.feng.servcie.SingerService;

@Controller
@RequestMapping("/music")
public class SingerController {

	@Autowired
	private SingerService singerService;
	@GetMapping("/list.htm")
	public String blogList(String title, Model model, @RequestParam(defaultValue = "1") int num,@RequestParam(defaultValue = "24") int size) {
		Singer singer =new Singer();
		singer.setTitle(title);
		Page<Singer> singerpage= singerService.ListPage(singer,num,size);
		model.addAttribute("singerpage",singerpage);
		return "music/list";
	}


}

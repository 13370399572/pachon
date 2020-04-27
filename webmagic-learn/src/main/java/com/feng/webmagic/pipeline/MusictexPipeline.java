package com.feng.webmagic.pipeline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.feng.dao.MusicDao;
import com.feng.entity.Music;

import lombok.extern.slf4j.Slf4j;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
@Slf4j
@Component
public class MusictexPipeline  implements Pipeline{
	
	@Autowired
    private  MusicDao musicDao;
	
	@Override
	public void process(ResultItems resultItems, Task task) {
		
		if (musicDao.findBytitle(((Music)resultItems.get("music")).getTitle()).size()>0) {
			log.error("该首歌已经存在,插入忽略");
		} else {
			musicDao.save((Music)resultItems.get("music"));
		}
		
	
		/*
		Music music = new Music();
		if (StringUtils.isEmpty(resultItems.get("name"))) {
			
		}else {
		music.setTitle(resultItems.get("name"));
		music.setName(resultItems.get("geshou"));
		music.setImgUrl(resultItems.get("imgurl"));
		music.setZhuanji(resultItems.get("zhuanji"));
		music.setUrl(resultItems.get("URL"));
		music.setSingerId(Long.valueOf(resultItems.get("singerId")));
		musicDao.save(music);
		}*/
	}

}

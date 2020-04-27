package com.feng.webmagic.pipeline;

import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.feng.dao.CinemaDao;
import com.feng.entity.Cinema;

import lombok.extern.slf4j.Slf4j;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

@Component
@Slf4j
public class CinemaPipeline implements Pipeline {
    
	@Autowired
	private CinemaDao cinemaDao;
	
	@Override
	public void process(ResultItems resultItems, Task task) {
		// TODO Auto-generated method stub
		List<Cinema> cinemas = resultItems.get("cinemas");
		if (CollectionUtils.isNotEmpty(cinemas)) {
			for (Cinema cinema : cinemas) {
				List<Cinema> cinemass = cinemaDao.findByUrl(cinema.getUrl());
				if (cinemass.size()>0) {
					log.error("该电影已经存在,插入忽略");
				}else {
					cinemaDao.save(cinema);
					log.error("黄片插入成功");
				}
				
			}
		}
	}

}

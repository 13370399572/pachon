package com.feng.webmagic.pipeline;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.feng.dao.GameDao;
import com.feng.entity.Game;

import lombok.extern.slf4j.Slf4j;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

@Component
@Slf4j
public class GamePipline  implements Pipeline{

	@Autowired
	private GameDao gameDao;
	
	@Override
	public void process(ResultItems resultItems, Task task) {
		// TODO Auto-generated method stub
	  List<Game> games = 	resultItems.get("games");
	  if (CollectionUtils.isNotEmpty(games)) {
		for (Game game : games) {
			List<Game> gamess= gameDao.findByUrl(game.getUrl());
			if (gamess.size()>0) {
				log.error("该数据已经存在,请不要插入");
			}else {
				gameDao.save(game);
				log.error("数据插入成功");
			}
		}
	}
	  
	}

}

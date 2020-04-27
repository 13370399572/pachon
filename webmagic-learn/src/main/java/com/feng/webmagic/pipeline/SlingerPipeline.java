package com.feng.webmagic.pipeline;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.feng.dao.SligerDao;
import com.feng.entity.Singer;

import lombok.extern.slf4j.Slf4j;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
@Slf4j
@Component
public class SlingerPipeline implements Pipeline{
	@Autowired
    private SligerDao sligerDao;
	
	@Override
	public void process(ResultItems resultItems, Task task) {
	List<String> urList     =	resultItems.get("url");
	List<String> imgurlList = resultItems.get("imgurl");
	List<String> titleLis   = resultItems.get("title");
	for (int i=0; i<urList.size();i++) {
		String url ="https://music.163.com/m"+urList.get(i);
		imgurlList.get(i);
		titleLis.get(i);
		Singer singer = new Singer(titleLis.get(i),url,imgurlList.get(i));
		List<Singer> ii= sligerDao.findBytitle(titleLis.get(i));
		if (ii.size()>0) {
			log.error("数据已经存在");
		}else {
			sligerDao.save(singer);
			log.error("数据插入成功");
		}
		
	}
		
	}

}

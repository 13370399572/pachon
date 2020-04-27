package com.feng.servcie.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.feng.dao.MusicDao;
import com.feng.dao.SligerDao;
import com.feng.entity.Music;
import com.feng.entity.Singer;
import com.feng.servcie.MusicService;
import com.feng.webmagic.PageProcess.MusicPageProcessor;
import com.feng.webmagic.pipeline.MusictexPipeline;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.scheduler.RedisScheduler;

@Service
public class MusicServiceImpl implements MusicService {
	@Autowired
	private MusicDao musicDao;

	@Autowired
	private SligerDao sligerDao;
	
    @Autowired
    private MusicPageProcessor musicPageProcessor;
    
    @Autowired
    private MusictexPipeline musictexPipeline;
	
	@Autowired
    private RedisScheduler redisScheduler;
	@Override
	public Page<Music> ListPage(String singerUrl, int num, int size) {
		
		
		Long singerId= sligerDao.findByUrl(singerUrl).get(0).getId();
		Music music = new Music();
		music.setSingerId(singerId);
		Pageable pageable = PageRequest.of(num - 1, size);
		int zz = musicDao.findBySingerId(singerId).size();
		if (zz <50) {
			zhang1(singerUrl);
		} 
		Specification specification = (Specification) (root, criteriaQuery, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
			if (java.util.Objects.nonNull(music) && java.util.Objects.nonNull(music.getSingerId())) {
				predicates.add(criteriaBuilder.equal(root.get("singerId"), music.getSingerId()));
			}
			return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
		};
		return musicDao.findAll(specification, pageable);
	}
	
	
    private void zhang1(String singerUrl) {
    	
    	Spider.create(musicPageProcessor).addUrl(singerUrl).addPipeline(musictexPipeline).thread(5).run();
		
	}

}

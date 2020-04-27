package com.feng.servcie;

import org.springframework.data.domain.Page;

import com.feng.entity.Music;
import com.feng.entity.Singer;

public interface MusicService {
	
	Page<Music> ListPage(String singerUrl, int num, int size);
}

package com.feng.servcie;

import org.springframework.data.domain.Page;

import com.feng.entity.Cinema;
import com.feng.entity.Music;

public interface CinemaService {

	Page<Music> ListPage(Cinema cinema, int num, int size);

}

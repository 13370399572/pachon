package com.feng.servcie;

import org.springframework.data.domain.Page;

import com.feng.entity.Film;
import com.feng.entity.Singer;

public interface SingerService {

	 Page<Singer> ListPage(Singer singer, int num, int size);
}

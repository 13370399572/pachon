package com.feng.servcie.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.feng.dao.FilmDao;
import com.feng.dao.SligerDao;
import com.feng.entity.Film;
import com.feng.entity.Singer;
import com.feng.servcie.SingerService;

@Service
public class SligerServiceImpl implements SingerService{

    @Autowired
	private SligerDao sligerDao;

    /**
     * springdata自身的分页方法
     */
	@Override
	public Page<Singer> ListPage(Singer singer, int num, int size) {
		 Pageable pageable = PageRequest.of(num - 1, size);
	        Specification specification = (Specification) (root, criteriaQuery, criteriaBuilder) -> {
	            List<Predicate> predicates = new ArrayList<>();
	            if (singer != null && StringUtils.isNotBlank(singer.getTitle())) {
	                predicates.add(criteriaBuilder.like(root.get("title"), "%" + singer.getTitle() + "%"));
	            }
	            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
	        };
	        return sligerDao.findAll(specification, pageable);
	}
	   
	   
}

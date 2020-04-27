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

import com.feng.dao.CinemaDao;
import com.feng.entity.Cinema;
import com.feng.entity.Music;
import com.feng.servcie.CinemaService;

@Service
public class CinemaServiceImpl implements CinemaService {
	
	@Autowired
	private CinemaDao cinemaDao;

	@Override
	public Page<Music> ListPage(Cinema cinema, int num, int size) {
		   Pageable pageable = PageRequest.of(num - 1, size);
	        Specification specification = (Specification) (root, criteriaQuery, criteriaBuilder) -> {
	            List<Predicate> predicates = new ArrayList<>();
	            if (cinema != null && StringUtils.isNotBlank(cinema.getName())) {
	                predicates.add(criteriaBuilder.like(root.get("name"), "%" + cinema.getName() + "%"));
	            }
	            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
	        };
	        return cinemaDao.findAll(specification, pageable);
	}

}

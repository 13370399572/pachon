package com.feng.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.feng.entity.Cinema;

public interface CinemaDao extends JpaRepository<Cinema, Long> ,JpaSpecificationExecutor<Cinema>  {

	@Query(value="select * from tb_cinema where url = ?1" ,  nativeQuery = true)
	List<Cinema> findByUrl (String url);
}

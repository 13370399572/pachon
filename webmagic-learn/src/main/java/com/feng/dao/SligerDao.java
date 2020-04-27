package com.feng.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.feng.entity.Singer;



public interface SligerDao   extends JpaRepository<Singer,Long>,JpaSpecificationExecutor<Singer>{
	
	@Query(value = "select * from tb_singer  where title = ?1 ", nativeQuery = true)
	List<Singer> findBytitle(String title);
	
	@Query(value = "select * from tb_singer  where url = ?1"  ,nativeQuery = true)
	List<Singer> findByUrl(String url);

}

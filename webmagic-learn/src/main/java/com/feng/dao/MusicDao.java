package com.feng.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.feng.entity.Music;
import com.feng.entity.Singer;

public interface MusicDao extends JpaRepository<Music,Long>,JpaSpecificationExecutor<Music> {
	
	@Query(value = "select * from tb_music  where title = ?1 ", nativeQuery = true)
	List<Music> findBytitle(String title);
	
	@Query(value = "select * from tb_music  where singer_id = ?1 ", nativeQuery = true)
	List<Music> findBySingerId(Long singerId);

}

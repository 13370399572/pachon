package com.feng.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.feng.entity.Game;

public interface GameDao extends JpaRepository<Game, Long> ,JpaSpecificationExecutor<Game> {

	
	@Query(value="select * from tb_game where url = ?1 ",nativeQuery= true )
	List<Game> findByUrl(String url);
}

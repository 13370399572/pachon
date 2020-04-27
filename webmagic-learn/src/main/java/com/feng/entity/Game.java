package com.feng.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name="tb_game")
public class Game {
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",length=32)
	private Long id;
	
	@Column(length=255)
	private String imgUrl;
	
	@Column(length=255)
	private String url;
	
	@Column(length=255)
	private String title;
}

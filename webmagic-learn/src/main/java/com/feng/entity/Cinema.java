package com.feng.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name="tb_cinema")
public class Cinema {
	@Id
    @Column(name="id" ,length=32)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=255)
	private String imgUrl;
	
	
	@Column(length=255)
	private String url;
	
	@Column(length=255)
	private String name;
}

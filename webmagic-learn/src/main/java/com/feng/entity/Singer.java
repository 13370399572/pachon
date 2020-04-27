package com.feng.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity(name = "tb_singer")
public class Singer {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id", length = 32)
	    private Long id;
	    @Column(length = 120)
	    private String title;
	    @Column(length = 170)
	    private String url;
	    @Column(length = 180)
	    private String imgUrl="";
	    
	   /* @JsonBackReference
	    @OneToMany(mappedBy="deviceManage" ,cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
	    private List<Music> deviceClasses;*/
	    
		public Singer( String title, String url, String imgUrl) {
			this.title = title;
			this.url = url;
			this.imgUrl = imgUrl;
		}

		public Singer() {
		}
	   
}

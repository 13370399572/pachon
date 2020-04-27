package com.feng.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity(name="tb_music")
public class Music {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id", length = 32)
	    private Long id;
	    @Column(length = 255)
	    private String title;
	    @Column(length = 255)
	    private String url;
	    @Column(length = 255)
	    private String imgUrl="";
	    private String score="";
	    @Column
	    private String urlSource="";
	    @Column
	    private String type="";
	    @Column
	    private String description="";
	    @Column
	    private String actor="";
	    
	    @Column
	    private Long singerId;
	    
	    @Column
	    private String name;
	    
	    @Column
	    private String zhuanji;
	    /*@ManyToOne
	    @JoinColumn(name = "singer_id", referencedColumnName = "id")
	    private Singer singer;*/


	    public Music(String title, String url, String imgUrl, String score) {
	        this.title = title;
	        this.url = url;
	        this.imgUrl = imgUrl;
	        this.score = score;
	    }

	    public Music() {
	    }
}

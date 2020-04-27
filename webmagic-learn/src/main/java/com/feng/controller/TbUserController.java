package com.feng.controller;

import java.util.UUID;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feng.entity.TbUser;
import com.feng.servcie.TbUserService;

/**
 * TbUser的路由接口服务
 * 
 * @author 
 *
 */
@RestController
public class TbUserController {

	/** TbUserService服务 */
	@Autowired
	private TbUserService tbUserService;
	
	/**
	 * 查询所有TbUser数据的方法
	 * @param value
	 * @return
	 */
	@GetMapping(value = "/TbUser", produces = {"application/json;charset=UTF-8"})
	public String find(TbUser value) {
		return tbUserService.find(value);
	}
	
	/**
	 * 通过id查询TbUser数据的方法
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/TbUser/{id}", produces = {"application/json;charset=UTF-8"})
	public String findOne(@PathVariable(name="id") Integer id) {
		return tbUserService.findOne(id);
	}
	
	/**
	 * 插入TbUser属性不为空的数据方法
	 * @param id
	 * @return
	 */
	@PostMapping(value = "/TbUser", produces = {"application/json;charset=UTF-8"})
	public String save(TbUser value) {
		
		String salt = UUID.randomUUID().toString();
		value.setValid(1);
		value.setSalt(salt);
		
 		SimpleHash sHash = new SimpleHash("MD5",value.getPasswd(),salt);
 		value.setPasswd(sHash.toString());
		return tbUserService.saveNotNull(value);
	}
	
	/**
	 * 更新TbUser属性不为空的数据方法
	 * @param id
	 * @return
	 */
	@PutMapping(value = "/TbUser", produces = {"application/json;charset=UTF-8"})
	public String update(TbUser value) {
		return tbUserService.updateNotNullById(value);
	}

	/**
	 * 通过id删除TbUser数据方法
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/TbUser/{id}", produces = {"application/json;charset=UTF-8"})
	public String delete(@PathVariable(name="id") Integer id) {
		return tbUserService.deleteById(id);
	}
}

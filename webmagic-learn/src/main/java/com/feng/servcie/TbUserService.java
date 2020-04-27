package com.feng.servcie;
import java.util.List;

import com.feng.common.Assist;
import com.feng.entity.TbUser;

/**
 * TbUser的服务接口
 * 
 * @author 
 *
 */
public interface TbUserService {
	
	TbUser selectTbUser(String name);
	/**
	 * 获得TbUser数据集,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * 
	 * @return
	 */
	String find(TbUser value);
	
	/**
	 * 通过TbUser的id获得TbUser对象
	 * 
	 * @param id
	 * @return
	 */
	String findOne(Integer id);
	
	/**
	 * 将TbUser中属性值不为null的数据到数据库
	 * 
	 * @param value
	 * @return
	 */
	String saveNotNull(TbUser value);
	
	/**
	 * 通过TbUser的id更新TbUser中属性不为null的数据
	 * 
	 * @param enti
	 * @return
	 */
	String updateNotNullById(TbUser enti);
	
	/**
	 * 通过TbUser的id删除TbUser
	 * 
	 * @param id
	 * @return
	 */
	String deleteById(Integer id);
}

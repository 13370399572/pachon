package com.feng.mybatisdao;
import java.util.List;

import com.feng.common.Assist;
import com.feng.entity.TbUser;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
/**
 * TbUser的Dao接口
 * 
 * @author 
 *
 */
public interface TbUserDao {

	/**
	 * 获得TbUser数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * 
	 * @param assist
	 * @return
	 */
	long getTbUserRowCount(Assist assist);
	
	/**
	 * 获得TbUser数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * 
	 * @param assist
	 * @return
	 */
	List<TbUser> selectTbUser(Assist assist);
	/**
	 * 通过TbUser的id获得TbUser对象
	 * 
	 * @param id
	 * @return
	 */
	TbUser selectTbUserById(Integer id);
	
	/**
	 * 获得一个TbUser对象,以参数TbUser对象中不为空的属性作为条件进行查询,返回符合条件的第一条
	 * 
	 * @param obj
	 * @return
	 */
	TbUser selectTbUserObjSingle(TbUser obj);
	
	/**
	 * 获得一个TbUser对象,以参数TbUser对象中不为空的属性作为条件进行查询
	 * 
	 * @param obj
	 * @return
	 */
	List<TbUser> selectTbUserByObj(TbUser obj);

	/**
	 * 插入TbUser到数据库,包括null值
	 * 
	 * @param value
	 * @return
	 */
	int insertTbUser(TbUser value);
	
	/**
	 * 插入TbUser中属性值不为null的数据到数据库
	 * 
	 * @param value
	 * @return
	 */
	int insertNotNullTbUser(TbUser value);
	
	/**
	 * 批量插入TbUser到数据库,包括null值
	 * 
	 * @param value
	 * @return
	 */
	int insertTbUserByBatch(List<TbUser> value);
	/**
	 * 通过TbUser的id删除TbUser
	 * 
	 * @param id
	 * @return
	 */
	int deleteTbUserById(Integer id);
	
	/**
	 * 通过辅助工具Assist的条件删除TbUser
	 * 
	 * @param assist
	 * @return
	 */
	int deleteTbUserByAssist(Assist assist);
	
	/**
	 * 通过TbUser的id更新TbUser中的数据,包括null值
	 * 
	 * @param enti
	 * @return
	 */
	int updateTbUserById(TbUser enti);
	
	/**
	 * 通过TbUser的id更新TbUser中属性不为null的数据
	 * 
	 * @param enti
	 * @return
	 */
	int updateNotNullTbUserById(TbUser enti);
	
	/**
	 * 通过辅助工具Assist的条件更新TbUser中的数据,包括null值
	 * 
	 * @param value
	 * @param assist
	 * @return
	 */
	int updateTbUser(@Param("enti") TbUser value, @Param("assist") Assist assist);
	
	/**
	 * 通过辅助工具Assist的条件更新TbUser中属性不为null的数据
	 * 
	 * @param value
	 * @param assist
	 * @return
	 */
	int updateNotNullTbUser(@Param("enti") TbUser value, @Param("assist") Assist assist);
}
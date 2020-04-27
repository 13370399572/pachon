package com.feng.servcie.impl;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.feng.common.Assist;
import com.feng.entity.TbUser;
import com.feng.mybatisdao.TbUserDao;
import com.feng.servcie.TbUserService;
/**
 * TbUser的服务接口的实现类
 * 
 * @author 
 *
 */
@Service
public class TbUserServiceImpl implements TbUserService {
	private final Logger LOG = LogManager.getLogger(this.getClass());

	@Autowired
	private TbUserDao tbUserDao;
	
	// TODO 当你看到这个方法时你应该创建一个工具类做通用的方法,定义自己的返回格式化
	private static final int C200 = 200;
	private static final int C412 = 412;
	public String resultFormat(int code, Object data) {
		JSONObject result = new JSONObject();
		result.put("code", code);
		if (data != null) {
			result.put("data", data);
		}
		return result.toJSONString();
	}

	@Override
	public String find(TbUser value) {
		//TODO这里可以做通过Assist做添加查询
		List<TbUser> result = tbUserDao.selectTbUser(null);
		if (LOG.isDebugEnabled()) {
			LOG.debug("执行获取TbUser数据集-->结果:", result);
		}
		return resultFormat(C200, result);
	}
	@Override
	public String findOne(Integer id) {
		if (id == null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("执行通过TbUser的id获得TbUser对象-->失败:id不能为空");
			}
			return resultFormat(C412, null);
		}
		TbUser result = tbUserDao.selectTbUserById(id);
		if (LOG.isDebugEnabled()) {
			LOG.debug("执行通过TbUser的id获得TbUser对象-->结果:", result);
		}
		return resultFormat(C200, result);
	}

	@Override
	public String saveNotNull(TbUser value) {
		if (value == null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("执行将TbUser中属性值不为null的数据保存到数据库-->失败:对象不能为空");
			}
			return resultFormat(C412, null);
		}
		int result = tbUserDao.insertNotNullTbUser(value);
		if (LOG.isDebugEnabled()) {
			LOG.debug("执行将TbUser中属性值不为null的数据保存到数据库-->结果:", result);
		}
		return resultFormat(C200, result);
	}
	@Override
	public String updateNotNullById(TbUser value) {
		if (value == null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("执行通过TbUser的id更新TbUser中属性不为null的数据-->失败:对象为null");
			}
			return resultFormat(C412, null);
		}
		int result = tbUserDao.updateNotNullTbUserById(value);
		if (LOG.isDebugEnabled()) {
			LOG.debug("执行通过TbUser的id更新TbUser中属性不为null的数据-->结果:", result);
		}
		return resultFormat(C200, result);
	}

	@Override
	public String deleteById(Integer id) {
		if (id == null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("执行通过TbUser的id删除TbUser-->失败:id不能为空");
			}
			return resultFormat(C412, null);
		}
		int result = tbUserDao.deleteTbUserById(id);
		if (LOG.isDebugEnabled()) {
			LOG.debug("执行通过TbUser的id删除TbUser-->结果:", result);
		}
		return resultFormat(C200, result);
	}

	@Override
	public TbUser selectTbUser(String name) {
		TbUser tbUsers = new TbUser();
		tbUsers.setName(name);
	  TbUser tbUser =  tbUserDao.selectTbUserObjSingle(tbUsers);
		return tbUser;
	}


}
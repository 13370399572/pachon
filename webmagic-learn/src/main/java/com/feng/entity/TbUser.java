package com.feng.entity;

import com.alibaba.fastjson.JSONObject;

/**
 * tb_user实体类
 * 
 * @author 
 *
 */
public class TbUser {
	/***/
	private Integer id; 
	/***/
	private String name; 
	/***/
	private String passwd; 
	/***/
	private String address; 
	/***/
	private String level; 
	/***/
	private String phone; 
	/***/
	private String email; 
	/***/
	private String salt; 
	/***/
	private Integer valid; 
	/***/
	private Integer deptId; 
	/***/
	private String createdUser; 
	/***/
	private String updateUser; 
	/**
	 * 实例化
	 */
	public TbUser() {
		super();
	}
	/**
	 * 实例化
	 * 
	 * @param obj
	 */
	public TbUser(JSONObject obj) {
		this();
		if (obj.get("id") instanceof Number) {
			this.setId(((Number) obj.get("id")).intValue());
		}
		if (obj.get("name") instanceof String) {
			this.setName((String) obj.get("name"));
		}
		if (obj.get("passwd") instanceof String) {
			this.setPasswd((String) obj.get("passwd"));
		}
		if (obj.get("address") instanceof String) {
			this.setAddress((String) obj.get("address"));
		}
		if (obj.get("level") instanceof String) {
			this.setLevel((String) obj.get("level"));
		}
		if (obj.get("phone") instanceof String) {
			this.setPhone((String) obj.get("phone"));
		}
		if (obj.get("email") instanceof String) {
			this.setEmail((String) obj.get("email"));
		}
		if (obj.get("salt") instanceof String) {
			this.setSalt((String) obj.get("salt"));
		}
		if (obj.get("valid") instanceof Number) {
			this.setValid(((Number) obj.get("valid")).intValue());
		}
		if (obj.get("deptId") instanceof Number) {
			this.setDeptId(((Number) obj.get("deptId")).intValue());
		}
		if (obj.get("createdUser") instanceof String) {
			this.setCreatedUser((String) obj.get("createdUser"));
		}
		if (obj.get("updateUser") instanceof String) {
			this.setUpdateUser((String) obj.get("updateUser"));
		}
	}
	
	/**
	 * 将当前对象转换为JsonObject
	 * 
	 * @return
	 */
	public JSONObject toJson() {
		JSONObject result = new JSONObject();
		if (this.getId() != null) {
			result.put("id",this.getId());
		}
		if (this.getName() != null) {
			result.put("name",this.getName());
		}
		if (this.getPasswd() != null) {
			result.put("passwd",this.getPasswd());
		}
		if (this.getAddress() != null) {
			result.put("address",this.getAddress());
		}
		if (this.getLevel() != null) {
			result.put("level",this.getLevel());
		}
		if (this.getPhone() != null) {
			result.put("phone",this.getPhone());
		}
		if (this.getEmail() != null) {
			result.put("email",this.getEmail());
		}
		if (this.getSalt() != null) {
			result.put("salt",this.getSalt());
		}
		if (this.getValid() != null) {
			result.put("valid",this.getValid());
		}
		if (this.getDeptId() != null) {
			result.put("deptId",this.getDeptId());
		}
		if (this.getCreatedUser() != null) {
			result.put("createdUser",this.getCreatedUser());
		}
		if (this.getUpdateUser() != null) {
			result.put("updateUser",this.getUpdateUser());
		}
		return result;
	}
	
	
	/**
	 * 获取id
	 * 
	 * @return
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置id
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * 获取name
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 获取passwd
	 * 
	 * @return
	 */
	public String getPasswd() {
		return passwd;
	}

	/**
	 * 设置passwd
	 * 
	 * @param passwd
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	/**
	 * 获取address
	 * 
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 设置address
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * 获取level
	 * 
	 * @return
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * 设置level
	 * 
	 * @param level
	 */
	public void setLevel(String level) {
		this.level = level;
	}
	
	/**
	 * 获取phone
	 * 
	 * @return
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * 设置phone
	 * 
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * 获取email
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 设置email
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * 获取salt
	 * 
	 * @return
	 */
	public String getSalt() {
		return salt;
	}

	/**
	 * 设置salt
	 * 
	 * @param salt
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	/**
	 * 获取valid
	 * 
	 * @return
	 */
	public Integer getValid() {
		return valid;
	}

	/**
	 * 设置valid
	 * 
	 * @param valid
	 */
	public void setValid(Integer valid) {
		this.valid = valid;
	}
	
	/**
	 * 获取deptId
	 * 
	 * @return
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * 设置deptId
	 * 
	 * @param deptId
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	
	/**
	 * 获取createdUser
	 * 
	 * @return
	 */
	public String getCreatedUser() {
		return createdUser;
	}

	/**
	 * 设置createdUser
	 * 
	 * @param createdUser
	 */
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	
	/**
	 * 获取updateUser
	 * 
	 * @return
	 */
	public String getUpdateUser() {
		return updateUser;
	}

	/**
	 * 设置updateUser
	 * 
	 * @param updateUser
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	@Override
	public String toString() {
		return "TbUser [id=" + id + " , name=" + name + " , passwd=" + passwd + " , address=" + address + " , level=" + level + " , phone=" + phone + " , email=" + email + " , salt=" + salt + " , valid=" + valid + " , deptId=" + deptId + " , createdUser=" + createdUser + " , updateUser=" + updateUser + "  ]";
	
	}
	
	
}

package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 自愿者
 *
 * @author 
 * @email
 */
@TableName("ziyuanzhe")
public class ZiyuanzheEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZiyuanzheEntity() {

	}

	public ZiyuanzheEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 账户
     */
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @TableField(value = "password")

    private String password;


    /**
     * 自愿者姓名
     */
    @TableField(value = "ziyuanzhe_name")

    private String ziyuanzheName;


    /**
     * 头像
     */
    @TableField(value = "ziyuanzhe_photo")

    private String ziyuanzhePhoto;


    /**
     * 手机号
     */
    @TableField(value = "ziyuanzhe_phone")

    private String ziyuanzhePhone;


    /**
     * 电子邮箱
     */
    @TableField(value = "ziyuanzhe_email")

    private String ziyuanzheEmail;


    /**
     * 性别
     */
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 假删
     */
    @TableField(value = "ziyuanzhe_delete")

    private Integer ziyuanzheDelete;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }
    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }
    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：自愿者姓名
	 */
    public String getZiyuanzheName() {
        return ziyuanzheName;
    }
    /**
	 * 获取：自愿者姓名
	 */

    public void setZiyuanzheName(String ziyuanzheName) {
        this.ziyuanzheName = ziyuanzheName;
    }
    /**
	 * 设置：头像
	 */
    public String getZiyuanzhePhoto() {
        return ziyuanzhePhoto;
    }
    /**
	 * 获取：头像
	 */

    public void setZiyuanzhePhoto(String ziyuanzhePhoto) {
        this.ziyuanzhePhoto = ziyuanzhePhoto;
    }
    /**
	 * 设置：手机号
	 */
    public String getZiyuanzhePhone() {
        return ziyuanzhePhone;
    }
    /**
	 * 获取：手机号
	 */

    public void setZiyuanzhePhone(String ziyuanzhePhone) {
        this.ziyuanzhePhone = ziyuanzhePhone;
    }
    /**
	 * 设置：电子邮箱
	 */
    public String getZiyuanzheEmail() {
        return ziyuanzheEmail;
    }
    /**
	 * 获取：电子邮箱
	 */

    public void setZiyuanzheEmail(String ziyuanzheEmail) {
        this.ziyuanzheEmail = ziyuanzheEmail;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }
    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：假删
	 */
    public Integer getZiyuanzheDelete() {
        return ziyuanzheDelete;
    }
    /**
	 * 获取：假删
	 */

    public void setZiyuanzheDelete(Integer ziyuanzheDelete) {
        this.ziyuanzheDelete = ziyuanzheDelete;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Ziyuanzhe{" +
            "id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", ziyuanzheName=" + ziyuanzheName +
            ", ziyuanzhePhoto=" + ziyuanzhePhoto +
            ", ziyuanzhePhone=" + ziyuanzhePhone +
            ", ziyuanzheEmail=" + ziyuanzheEmail +
            ", sexTypes=" + sexTypes +
            ", ziyuanzheDelete=" + ziyuanzheDelete +
            ", createTime=" + createTime +
        "}";
    }
}

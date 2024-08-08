package com.entity.vo;

import com.entity.ZiyuanzheEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 自愿者
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("ziyuanzhe")
public class ZiyuanzheVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "create_time")
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

}

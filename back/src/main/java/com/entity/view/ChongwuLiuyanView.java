package com.entity.view;

import com.entity.ChongwuLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 宠物留言
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("chongwu_liuyan")
public class ChongwuLiuyanView extends ChongwuLiuyanEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 chongwu
			/**
			* 宠物名称
			*/
			private String chongwuName;
			/**
			* 宠物照片
			*/
			private String chongwuPhoto;
			/**
			* 宠物类型
			*/
			private Integer chongwuTypes;
				/**
				* 宠物类型的值
				*/
				private String chongwuValue;
			/**
			* 宠物介绍
			*/
			private String chongwuContent;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 头像
			*/
			private String yonghuPhoto;
			/**
			* 手机号
			*/
			private String yonghuPhone;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;
			/**
			* 假删
			*/
			private Integer yonghuDelete;

	public ChongwuLiuyanView() {

	}

	public ChongwuLiuyanView(ChongwuLiuyanEntity chongwuLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, chongwuLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}







				//级联表的get和set chongwu

					/**
					* 获取： 宠物名称
					*/
					public String getChongwuName() {
						return chongwuName;
					}
					/**
					* 设置： 宠物名称
					*/
					public void setChongwuName(String chongwuName) {
						this.chongwuName = chongwuName;
					}

					/**
					* 获取： 宠物照片
					*/
					public String getChongwuPhoto() {
						return chongwuPhoto;
					}
					/**
					* 设置： 宠物照片
					*/
					public void setChongwuPhoto(String chongwuPhoto) {
						this.chongwuPhoto = chongwuPhoto;
					}

					/**
					* 获取： 宠物类型
					*/
					public Integer getChongwuTypes() {
						return chongwuTypes;
					}
					/**
					* 设置： 宠物类型
					*/
					public void setChongwuTypes(Integer chongwuTypes) {
						this.chongwuTypes = chongwuTypes;
					}


						/**
						* 获取： 宠物类型的值
						*/
						public String getChongwuValue() {
							return chongwuValue;
						}
						/**
						* 设置： 宠物类型的值
						*/
						public void setChongwuValue(String chongwuValue) {
							this.chongwuValue = chongwuValue;
						}

					/**
					* 获取： 宠物介绍
					*/
					public String getChongwuContent() {
						return chongwuContent;
					}
					/**
					* 设置： 宠物介绍
					*/
					public void setChongwuContent(String chongwuContent) {
						this.chongwuContent = chongwuContent;
					}




























				//级联表的get和set yonghu

					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}

					/**
					* 获取： 假删
					*/
					public Integer getYonghuDelete() {
						return yonghuDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setYonghuDelete(Integer yonghuDelete) {
						this.yonghuDelete = yonghuDelete;
					}






}

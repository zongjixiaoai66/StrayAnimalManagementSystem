package com.entity.view;

import com.entity.ChongwulingyangshenheEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 宠物领养审核
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("chongwulingyangshenhe")
public class ChongwulingyangshenheView extends ChongwulingyangshenheEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 申请状态的值
		*/
		private String chongwulingyangshenheYesnoValue;



		//级联表 chongwulingyang
			/**
			* 标题
			*/
			private String chongwulingyangName;
			/**
			* 宠物类型
			*/
			private Integer chongwuTypes;
				/**
				* 宠物类型的值
				*/
				private String chongwuValue;
			/**
			* 宠物图片
			*/
			private String chongwulingyangPhoto;
			/**
			* 是否被认领
			*/
			private Integer jieshuTypes;
				/**
				* 是否被认领的值
				*/
				private String jieshuValue;
			/**
			* 宠物详情
			*/
			private String chongwulingyangContent;

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

	public ChongwulingyangshenheView() {

	}

	public ChongwulingyangshenheView(ChongwulingyangshenheEntity chongwulingyangshenheEntity) {
		try {
			BeanUtils.copyProperties(this, chongwulingyangshenheEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 申请状态的值
			*/
			public String getChongwulingyangshenheYesnoValue() {
				return chongwulingyangshenheYesnoValue;
			}
			/**
			* 设置： 申请状态的值
			*/
			public void setChongwulingyangshenheYesnoValue(String chongwulingyangshenheYesnoValue) {
				this.chongwulingyangshenheYesnoValue = chongwulingyangshenheYesnoValue;
			}
















				//级联表的get和set chongwulingyang

					/**
					* 获取： 标题
					*/
					public String getChongwulingyangName() {
						return chongwulingyangName;
					}
					/**
					* 设置： 标题
					*/
					public void setChongwulingyangName(String chongwulingyangName) {
						this.chongwulingyangName = chongwulingyangName;
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
					* 获取： 宠物图片
					*/
					public String getChongwulingyangPhoto() {
						return chongwulingyangPhoto;
					}
					/**
					* 设置： 宠物图片
					*/
					public void setChongwulingyangPhoto(String chongwulingyangPhoto) {
						this.chongwulingyangPhoto = chongwulingyangPhoto;
					}

					/**
					* 获取： 是否被认领
					*/
					public Integer getJieshuTypes() {
						return jieshuTypes;
					}
					/**
					* 设置： 是否被认领
					*/
					public void setJieshuTypes(Integer jieshuTypes) {
						this.jieshuTypes = jieshuTypes;
					}


						/**
						* 获取： 是否被认领的值
						*/
						public String getJieshuValue() {
							return jieshuValue;
						}
						/**
						* 设置： 是否被认领的值
						*/
						public void setJieshuValue(String jieshuValue) {
							this.jieshuValue = jieshuValue;
						}

					/**
					* 获取： 宠物详情
					*/
					public String getChongwulingyangContent() {
						return chongwulingyangContent;
					}
					/**
					* 设置： 宠物详情
					*/
					public void setChongwulingyangContent(String chongwulingyangContent) {
						this.chongwulingyangContent = chongwulingyangContent;
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

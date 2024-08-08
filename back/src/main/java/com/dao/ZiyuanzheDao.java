package com.dao;

import com.entity.ZiyuanzheEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZiyuanzheView;

/**
 * 自愿者 Dao 接口
 *
 * @author 
 */
public interface ZiyuanzheDao extends BaseMapper<ZiyuanzheEntity> {

   List<ZiyuanzheView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

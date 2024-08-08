package com.dao;

import com.entity.ChongwujiyangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChongwujiyangView;

/**
 * 宠物寄养 Dao 接口
 *
 * @author 
 */
public interface ChongwujiyangDao extends BaseMapper<ChongwujiyangEntity> {

   List<ChongwujiyangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

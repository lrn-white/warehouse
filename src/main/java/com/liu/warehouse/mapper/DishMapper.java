package com.liu.warehouse.mapper;

import com.liu.warehouse.model.Dish;
import com.liu.warehouse.model.Material;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 刘仁楠
 * @date 2018/5/8 14:37
 */
@Mapper
public interface DishMapper {

    /**
     * 获取菜品列表
     *
     * @author 刘仁楠
     * @date 2018/5/7 10:22
     */
    @Select("SELECT * FROM dish")
    List<Dish> getAllDish();

    @Select("SELECT * FROM ")
    List<Material> getMaterialsByDishID(Integer dishID);
}

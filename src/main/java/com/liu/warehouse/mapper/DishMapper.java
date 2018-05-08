package com.liu.warehouse.mapper;

import com.liu.warehouse.model.Dish;
import com.liu.warehouse.model.DishAndMaterial;
import com.liu.warehouse.model.Material;
import org.apache.ibatis.annotations.Insert;
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

    /**
     * 通过dishID获取原材料
     *
     * @author 刘仁楠
     * @date 2018/5/8 15:35
     */
    @Select("SELECT * FROM dishandmaterial WHERE dishID = #{arg1}")
    List<DishAndMaterial> getMaterialsByDishID(Integer dishID);

    /**
     * 添加菜品的原材料
     *
     * @author 刘仁楠
     * @date 2018/5/8 16:48
     */
    @Insert("INSERT INTO dishandmaterial (dishID, materialName, amount) VALUES (#{dishID}, #{materialName}, #{amount})")
    void dishAddMaterial(DishAndMaterial dishAndMaterial);
}

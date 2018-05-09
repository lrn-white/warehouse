package com.liu.warehouse.mapper;

import com.liu.warehouse.model.Dish;
import com.liu.warehouse.model.DishAndMaterial;
import com.liu.warehouse.model.Material;
import org.apache.ibatis.annotations.*;

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

    /**
     * 根据materialID删除菜品的原材料
     *
     * @author 刘仁楠
     * @date 2018/5/8 16:48
     */
    @Delete("DELETE FROM dishandmaterial WHERE materialName = #{arg1}")
    void deleteDishByMaterialName(String materialName);

    /**
     * 根据materialName修改菜品原材料的amount
     *
     * @author 刘仁楠
     * @date 2018/5/9 9:49
     */
    @Update("UPDATE dishandmaterial SET amount = #{amount} WHERE materialName = #{materialName} AND dishID = #{dishID}")
    void updateDishMaterialByMaterialName(DishAndMaterial dishAndMaterial);

    /**
     * 通过materialName获得material信息
     *
     * @author 刘仁楠
     * @date 2018/5/9 9:53
     */
    @Select("SELECT * FROM dishandmaterial WHERE materialName = #{arg1}")
    DishAndMaterial getMaterialbyMaterialname(String materialName);

    /**
     * 根据materialName获取materialPrice
     *
     * @author 刘仁楠
     * @date 2018/5/9 10:13
     */
    @Select("SELECT materialPrice FROM material WHERE materialName = #{arg1}")
    double getMaterialPriceByMaterialName(String materialName);

    /**
     * 根据dishID修改总价
     *
     * @author 刘仁楠
     * @date 2018/5/9 10:26
     */
    @Update("UPDATE dish SET totalPrice = #{totalPrice} WHERE dishID = #{dishID}")
    void updateDishTotalPrice(Dish dish);

    /**
     * 添加菜名
     *
     * @author 刘仁楠
     * @date 2018/5/9 14:30
     */
    @Insert("INSERT INTO dish (dishName) VALUES (#{arg1})")
    void addDishName(String dishName);

    /**
     * 根据dishID删除菜名
     *
     * @author 刘仁楠
     * @date 2018/5/9 14:34
     */
    @Delete("DELETE FROM dish WHERE dishID = #{arg1}")
    void deleteDishByDishID(Integer dishID);
}

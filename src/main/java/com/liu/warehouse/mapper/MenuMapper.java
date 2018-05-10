package com.liu.warehouse.mapper;

import com.liu.warehouse.model.DishAndMenu;
import com.liu.warehouse.model.Menu;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 刘仁楠
 * @date 2018/5/9 15:14
 */
@Mapper
public interface MenuMapper {

    /**
     * 添加菜单
     *
     * @author 刘仁楠
     * @date 2018/5/9 16:11
     */
    @Insert("INSERT INTO menu (menuName) VALUES (#{arg1})")
    void addMenu(String menuName);

    /**
     * 获取所有的菜单
     *
     * @author 刘仁楠
     * @date 2018/5/9 16:16
     */
    @Select("SELECT * FROM menu")
    List<Menu> getAllMenu();

    /**
     * 根据menuID删除menu
     *
     * @author 刘仁楠
     * @date 2018/5/9 16:43
     */
    @Delete("DELETE FROM menu WHERE menuID = #{arg1}")
    void deleteMenuByMenuID(Integer menuID);

    /**
     * 根据menuID获得菜单菜品
     *
     * @author 刘仁楠
     * @date 2018/5/9 16:52
     */
    @Select("SELECT * FROM dishandmenu WHERE menuID = #{arg1}")
    List<DishAndMenu> getDishByMenuID(Integer menuID);

    /**
     * 根据DishName修改TotalPrice
     *
     * @author 刘仁楠
     * @date 2018/5/9 17:01
     */
    @Update("UPDATE dishandmenu SET totalPrice = #{totalPrice} WHERE dishName = #{dishName}")
    void updateTotalPriceByDishName(DishAndMenu dishAndMenu);

    /**
     * 根据dishID获得dishName
     *
     * @author 刘仁楠
     * @date 2018/5/9 17:06
     */
    @Select("SELECT dishName FROM dish WHERE dishID = #{arg1}")
    String getDishNameByDishID(Integer dishID);

    /**
     * 根据menuID修改totalMenuPrice
     *
     * @author 刘仁楠
     * @date 2018/5/9 17:22
     */
    @Update("UPDATE menu SET totalMenuPrice = #{totalMenuPrice} WHERE menuID = #{menuID}")
    void updateTotalMenuPriceByMenuID(Menu menu);

    /**
     * 添加菜单中的菜品
     * @author 刘仁楠
     * @date 2018/5/10 9:00
     */
    @Insert("INSERT INTO dishandmenu (menuID, dishName, totalPrice) VALUES (#{menuID}, #{dishName}, #{totalPrice}) ")
    void addMenuDish(DishAndMenu dishAndMenu);

    /**
     * 根据dishName获取totalPrice
     * @author 刘仁楠
     * @date 2018/5/10 9:25
     */
    @Select("SELECT totalPrice FROM dish WHERE dishName = #{arg1}")
    Double getTotalPriceByDishName(String dishName);

    /**
     * 根据menuID和dishName删除菜单中的菜品
     * @author 刘仁楠
     * @date 2018/5/10 9:55
     */
    @Delete("DELETE FROM dishandmenu WHERE menuID = #{menuID} AND dishName = #{dishName}")
    void deleteDishbyMenuIDAndDishName(DishAndMenu dishAndMenu);

    /**
     * 根据dishName获取dishID
     * @author 刘仁楠
     * @date 2018/5/10 10:23
     */
    @Select("SELECT dishID FROM dish WHERE dishName = #{arg1}")
    Integer getDishIDByDishName(String dishName);

    /**
     * 从库存中减去菜单消耗的原材料
     * @author 刘仁楠
     * @date 2018/5/10 14:18
     */
    @Update("UPDATE material SET materialStock = materialStock - #{arg1} WHERE materialName = #{arg0}")
    void reduceConsumption(String materialName, Integer amount);
}

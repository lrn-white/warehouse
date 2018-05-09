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
     * @author 刘仁楠
     * @date 2018/5/9 16:11
     */
    @Insert("INSERT INTO menu (menuName) VALUES (#{arg1})")
    void addMenu(String menuName);

    /**
     * 获取所有的菜单
     * @author 刘仁楠
     * @date 2018/5/9 16:16
     */
    @Select("SELECT * FROM menu")
    List<Menu> getAllMenu();

    /**
     * 根据menuID删除menu
     * @author 刘仁楠
     * @date 2018/5/9 16:43
     */
    @Delete("DELETE FROM menu WHERE menuID = #{arg1}")
    void deleteMenuByMenuID(Integer menuID);

    /**
     * 根据menuID获得菜单菜品
     * @author 刘仁楠
     * @date 2018/5/9 16:52
     */
    @Select("SELECT * FROM dishandmenu WHERE menuID = #{arg1}")
    List<DishAndMenu> getDishByMenuID(Integer menuID);

    /**
     * 根据DishName修改TotalPrice
     * @author 刘仁楠
     * @date 2018/5/9 17:01
     */
    @Update("UPDATE dishandmenu SET totalPrice = #{totalPrice} WHERE dishName = #{dishName}")
    void updateTotalPriceByDishName(DishAndMenu dishAndMenu);

    /**
     * 根据dishID获得dishName
     * @author 刘仁楠
     * @date 2018/5/9 17:06
     */
    @Select("SELECT dishName FROM dish WHERE dishID = #{arg1}")
    String getDishNameByDishID(Integer dishID);

    /**
     * 根据menuID修改totalMenuPrice
     * @author 刘仁楠
     * @date 2018/5/9 17:22
     */
    @Update("UPDATE menu SET totalMenuPrice = #{totalMenuPrice} WHERE menuID = #{menuID}")
    void updateTotalMenuPriceByMenuID(Menu menu);
}

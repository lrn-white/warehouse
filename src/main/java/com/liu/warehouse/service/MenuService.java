package com.liu.warehouse.service;

import com.liu.warehouse.mapper.MenuMapper;
import com.liu.warehouse.model.DishAndMenu;
import com.liu.warehouse.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 刘仁楠
 * @date 2018/5/9 15:14
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 添加菜单
     * @author 刘仁楠
     * @date 2018/5/9 16:11
     */
    public void addMenu(String menuName){
        menuMapper.addMenu(menuName);
    }

    /**
     * 获取所有的菜单
     * @author 刘仁楠
     * @date 2018/5/9 16:16
     */
    public List<Menu> getAllMenu(){
        return menuMapper.getAllMenu();
    }

    /**
     * 根据menuID删除menu
     * @author 刘仁楠
     * @date 2018/5/9 16:43
     */
    public void deleteMenuByMenuID(Integer menuID){
        menuMapper.deleteMenuByMenuID(menuID);
    }

    /**
     * 根据menuID获得菜单菜品
     * @author 刘仁楠
     * @date 2018/5/9 16:52
     */
    public List<DishAndMenu> getDishByMenuID(Integer menuID){
        return menuMapper.getDishByMenuID(menuID);
    }

    /**
     * 计算菜单总价
     * @author 刘仁楠
     * @date 2018/5/9 17:19
     */
    public void countMenu(Integer menuID){
        double totalMenuPrice = 0;
        List<DishAndMenu> dishAndMenus = menuMapper.getDishByMenuID(menuID);
        for (DishAndMenu dishAndMenu:dishAndMenus) {
            double totalPrice = dishAndMenu.getTotalPrice();
            totalMenuPrice = totalPrice + totalMenuPrice;
        }

        Menu menu = new Menu();
        menu.setMenuID(menuID);
        menu.setTotalMenuPrice(totalMenuPrice);
        menuMapper.updateTotalMenuPriceByMenuID(menu);
    }
}

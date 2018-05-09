package com.liu.warehouse.controller;

import com.liu.warehouse.model.DishAndMenu;
import com.liu.warehouse.model.Menu;
import com.liu.warehouse.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 刘仁楠
 * @date 2018/5/9 15:14
 */
@RequestMapping("/menu")
@RestController
public class MenuController {

    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    private MenuService menuService;

    /**
     * 添加菜单
     * @author 刘仁楠
     * @date 2018/5/9 16:11
     */
    @RequestMapping("/addMenu")
    public void addMenu(String menuName){
        menuService.addMenu(menuName);
    }

    /**
     * 获取所有的菜单
     * @author 刘仁楠
     * @date 2018/5/9 16:16
     */
    @RequestMapping("/getAllMenu")
    public List<Menu> getAllMenu(){
        return menuService.getAllMenu();
    }

    /**
     * 根据menuID删除menu
     * @author 刘仁楠
     * @date 2018/5/9 16:43
     */
    @RequestMapping("/deleteMenuByMenuID")
    public void deleteMenuByMenuID(Integer menuID){
        menuService.deleteMenuByMenuID(menuID);
    }

    /**
     * 根据menuID获得菜单菜品
     * @author 刘仁楠
     * @date 2018/5/9 16:52
     */
    @RequestMapping("/getDishByMenuID")
    public List<DishAndMenu> getDishByMenuID(Integer menuID){
        return menuService.getDishByMenuID(menuID);
    }
}

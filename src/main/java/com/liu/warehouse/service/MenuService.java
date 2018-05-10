package com.liu.warehouse.service;

import com.liu.warehouse.mapper.DishMapper;
import com.liu.warehouse.mapper.MenuMapper;
import com.liu.warehouse.model.DishAndMaterial;
import com.liu.warehouse.model.DishAndMenu;
import com.liu.warehouse.model.Menu;
import com.liu.warehouse.model.MenuExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Autowired
    private DishMapper dishMapper;

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

    /**
     * 添加菜单中的菜品
     * @author 刘仁楠
     * @date 2018/5/10 9:22
     */
    public void addMenuDish(String dishName, Integer menuID){
        Double totalPrice = menuMapper.getTotalPriceByDishName(dishName);
        DishAndMenu dishAndMenu = new DishAndMenu();
        dishAndMenu.setDishName(dishName);
        dishAndMenu.setTotalPrice(totalPrice);
        dishAndMenu.setMenuID(menuID);
        menuMapper.addMenuDish(dishAndMenu);
        countMenu(menuID);
    }


    /**
     * 根据menuID和dishName删除菜单中的菜品
     * @author 刘仁楠
     * @date 2018/5/10 9:55
     */
    public void deleteDishbyMenuIDAndDishName(String dishName, Integer menuID){
        DishAndMenu dishAndMenu = new DishAndMenu();
        dishAndMenu.setMenuID(menuID);
        dishAndMenu.setDishName(dishName);
        menuMapper.deleteDishbyMenuIDAndDishName(dishAndMenu);
        countMenu(menuID);
    }

    /**
     * 根据menuID获取菜单详情
     * @author 刘仁楠
     * @date 2018/5/10 10:17
     */
    public List<MenuExcel> getMenuDetailByMenuID(Integer menuID){
        List<DishAndMenu> dishAndMenus = menuMapper.getDishByMenuID(menuID);

        List<MenuExcel> menuExcels = new ArrayList<>();
        for (DishAndMenu dishAndMenu: dishAndMenus) {
            String dishName = dishAndMenu.getDishName();
            Integer dishID = menuMapper.getDishIDByDishName(dishName);
            List<DishAndMaterial> dishAndMaterials = dishMapper.getMaterialsByDishID(dishID);

            double totalPrice = dishAndMenu.getTotalPrice();
            for (DishAndMaterial dishAndMaterial: dishAndMaterials) {
                int amount = dishAndMaterial.getAmount();
                String materialName = dishAndMaterial.getMaterialName();

                MenuExcel menuExcel = new MenuExcel();
                menuExcel.setAmount(amount);
                menuExcel.setMaterialName(materialName);
                menuExcel.setDishName(dishName);
                menuExcel.setTotalPrice(totalPrice);

                menuExcels.add(menuExcel);
            }
        }
        return menuExcels;
    }

    /**
     * 从库存中减去菜单消耗的原材料
     * @author 刘仁楠
     * @date 2018/5/10 14:18
     */
    public void reduceConsumption(List<MenuExcel> menuExcels){
        for (MenuExcel menuExcel: menuExcels) {
            int amount = menuExcel.getAmount();
            String materialName = menuExcel.getMaterialName();
            menuMapper.reduceConsumption(materialName,amount);
        }
    }
}

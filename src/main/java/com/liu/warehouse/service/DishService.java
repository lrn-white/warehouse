package com.liu.warehouse.service;

import com.liu.warehouse.mapper.DishMapper;
import com.liu.warehouse.mapper.MenuMapper;
import com.liu.warehouse.model.Dish;
import com.liu.warehouse.model.DishAndMaterial;
import com.liu.warehouse.model.DishAndMenu;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 刘仁楠
 * @date 2018/5/7 14:49
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class DishService {

    @Autowired
    private DishMapper dishMapper;

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 获取菜品列表
     *
     * @author 刘仁楠
     * @date 2018/5/7 10:20
     */
    public List<Dish> getAllDish() {
        return dishMapper.getAllDish();
    }

    /**
     * 通过dishID获取原材料
     *
     * @author 刘仁楠
     * @date 2018/5/8 15:35
     */
    public List<DishAndMaterial> getMaterialsByDishID(Integer dishID) {
        return dishMapper.getMaterialsByDishID(dishID);
    }

    /**
     * 添加菜品的原材料
     *
     * @author 刘仁楠
     * @date 2018/5/8 16:48
     */
    public void dishAddMaterial(DishAndMaterial dishAndMaterial) {
        dishMapper.dishAddMaterial(dishAndMaterial);
        Integer dishId = dishAndMaterial.getDishID();
        countPrice(dishId);
    }

    /**
     * 根据materialName删除菜品的原材料
     *
     * @author 刘仁楠
     * @date 2018/5/8 16:48
     */
    public void deleteDishByMaterialName(String materialName,Integer dishID) {
        dishMapper.deleteDishByMaterialName(materialName);
        countPrice(dishID);
    }

    /**
     * 根据materialName修改菜品原材料的amount
     *
     * @author 刘仁楠
     * @date 2018/5/9 9:49
     */
    public void updateDishMaterialByMaterialName(DishAndMaterial dishAndMaterial) {
        dishMapper.updateDishMaterialByMaterialName(dishAndMaterial);
        Integer dishId = dishAndMaterial.getDishID();
        countPrice(dishId);
    }

    /**
     * 通过materialName获得material信息
     *
     * @author 刘仁楠
     * @date 2018/5/9 9:53
     */
    public DishAndMaterial getMaterialbyMaterialname(String materialName) {
        return dishMapper.getMaterialbyMaterialname(materialName);
    }

    /**
     * 计算菜品原材料总价
     *
     * @author 刘仁楠
     * @date 2018/5/9 10:13
     */
    public void countPrice(Integer dishID) {
        double totalPrice = 0;
        List<DishAndMaterial> dishAndMaterials = dishMapper.getMaterialsByDishID(dishID);
        for (DishAndMaterial dishAndMaterial : dishAndMaterials) {
            String materilaname = dishAndMaterial.getMaterialName();
            double materialPrice = dishMapper.getMaterialPriceByMaterialName(materilaname);
            int amount = dishAndMaterial.getAmount();
            totalPrice = amount * materialPrice / 1000 + totalPrice;
        }
        Dish dish = new Dish();
        dish.setDishID(dishID);
        dish.setTotalPrice(totalPrice);
        dishMapper.updateDishTotalPrice(dish);

        DishAndMenu dishAndMenu = new DishAndMenu();
        dishAndMenu.setTotalPrice(totalPrice);
        String dishName = menuMapper.getDishNameByDishID(dishID);
        dishAndMenu.setDishName(dishName);
        menuMapper.updateTotalPriceByDishName(dishAndMenu);
    }

    /**
     * 添加菜名
     * @author 刘仁楠
     * @date 2018/5/9 14:30
     */
    public void addDishName(String dishName){
        dishMapper.addDishName(dishName);
    }

    /**
     * 根据dishID删除菜名
     *
     * @author 刘仁楠
     * @date 2018/5/9 14:34
     */
    public void deleteDishByDishID(Integer dishID){
        dishMapper.deleteDishByDishID(dishID);
    }
}

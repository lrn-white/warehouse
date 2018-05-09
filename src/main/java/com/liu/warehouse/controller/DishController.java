package com.liu.warehouse.controller;

import com.liu.warehouse.model.Dish;
import com.liu.warehouse.model.DishAndMaterial;
import com.liu.warehouse.service.DishService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author 刘仁楠
 * @date 2018/5/7 10:04
 */
@RestController
@RequestMapping("/dish")
public class DishController {

    private static final Logger logger = LoggerFactory.getLogger(DishController.class);

    @Autowired
    private DishService dishService;

    /**
     * 获取菜品列表
     *
     * @author 刘仁楠
     * @date 2018/5/7 10:17
     */
    @RequestMapping(value = "/getAllDish")
    public List<Dish> getAllDish() {
        return dishService.getAllDish();
    }

    /**
     * 通过dishID获取原材料
     *
     * @author 刘仁楠
     * @date 2018/5/8 15:35
     */
    @RequestMapping("/getMaterialsByDishID")
    public List<DishAndMaterial> getMaterialsByDishID(Integer dishID) {
        return dishService.getMaterialsByDishID(dishID);
    }

    /**
     * 添加菜品的原材料
     *
     * @author 刘仁楠
     * @date 2018/5/8 16:48
     */
    @RequestMapping("/dishAddMaterial")
    public void dishAddMaterial(DishAndMaterial dishAndMaterial) {
        dishService.dishAddMaterial(dishAndMaterial);
    }

    /**
     * 根据materialID删除菜品的原材料
     *
     * @author 刘仁楠
     * @date 2018/5/8 16:48
     */
    @RequestMapping("/deleteDishByMaterialName")
    public void deleteDishByMaterialName(String materialName, Integer dishID) {
        dishService.deleteDishByMaterialName(materialName, dishID);
    }

    /**
     * 根据materialName修改菜品原材料的amount
     *
     * @author 刘仁楠
     * @date 2018/5/9 9:49
     */
    @RequestMapping("/updateDishMaterialByMaterialName")
    public void updateDishMaterialByMaterialName(DishAndMaterial dishAndMaterial) {
        dishService.updateDishMaterialByMaterialName(dishAndMaterial);
    }

    /**
     * 通过materialName获得material信息
     *
     * @author 刘仁楠
     * @date 2018/5/9 9:53
     */
    @RequestMapping("/getMaterialbyMaterialname")
    public DishAndMaterial getMaterialbyMaterialname(String materialName) {
        return dishService.getMaterialbyMaterialname(materialName);
    }

    /**
     * 添加菜名
     * @author 刘仁楠
     * @date 2018/5/9 14:30
     */
    @RequestMapping("/addDishName")
    public void addDishName(String dishName){
        dishService.addDishName(dishName);
    }

    /**
     * 根据dishID删除菜名
     *
     * @author 刘仁楠
     * @date 2018/5/9 14:34
     */
    @RequestMapping("/deleteDishByDishID")
    public void deleteDishByDishID(Integer dishID){
        dishService.deleteDishByDishID(dishID);
    }
}

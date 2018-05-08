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
}

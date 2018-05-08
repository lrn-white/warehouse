package com.liu.warehouse.service;

import com.liu.warehouse.mapper.DishMapper;
import com.liu.warehouse.model.Dish;
import com.liu.warehouse.model.DishAndMaterial;
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
    }

    /**
     * 根据materialID删除菜品的原材料
     *
     * @author 刘仁楠
     * @date 2018/5/8 16:48
     */
    public void deleteDishByMaterialName(String materialName){
        dishMapper.deleteDishByMaterialName(materialName);
    }
}

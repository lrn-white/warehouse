package com.liu.warehouse.service;

import com.liu.warehouse.mapper.DishMapper;
import com.liu.warehouse.model.Dish;
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
}

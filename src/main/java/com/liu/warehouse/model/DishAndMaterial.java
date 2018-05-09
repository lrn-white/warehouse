package com.liu.warehouse.model;

import lombok.Data;

/**
 * @author 刘仁楠
 * @date 2018/5/8 15:36
 */
@Data
public class DishAndMaterial {
    private Integer dishID;

    private Integer materialID;

    private Integer amount;

    private String materialName;
}

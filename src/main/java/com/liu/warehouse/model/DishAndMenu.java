package com.liu.warehouse.model;

import lombok.Data;

/**
 * @author 刘仁楠
 * @date 2018/5/9 16:50
 */
@Data
public class DishAndMenu {
    private Integer dishID;

    private Integer menuID;

    private String dishName;

    private double totalPrice;
}

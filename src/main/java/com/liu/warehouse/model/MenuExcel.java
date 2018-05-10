package com.liu.warehouse.model;

import lombok.Data;

import java.util.List;

/**
 * @author 刘仁楠
 * @date 2018/5/10 10:14
 */
@Data
public class MenuExcel {
    private String dishName;

    private double totalPrice;

    private Integer amount;

    private String materialName;
}

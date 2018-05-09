package com.liu.warehouse.model;

import lombok.Data;

/**
 * @author 刘仁楠
 * @date 2018/5/7 9:57
 */
@Data
public class Material {
    private Integer materialID;

    private String materialName;

    private double materialPrice;
    /**
     * 库存
     */
    private Integer materialStock;
}

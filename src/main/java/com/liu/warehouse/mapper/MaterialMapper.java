package com.liu.warehouse.mapper;

import com.liu.warehouse.model.Material;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 刘仁楠
 * @date 2018/5/7 10:20
 */
@Mapper
public interface MaterialMapper {
    /**
     * 获取原材料列表
     *
     * @param null
     * @return
     * @author 刘仁楠
     * @date 2018/5/7 10:22
     */
    @Select("SELECT * FROM material")
    List<Material> getAllMaterial();

    /**
     * 新增原材料
     *
     * @param null
     * @return
     * @author 刘仁楠
     * @date 2018/5/8 11:36
     */
    @Insert("INSERT INTO material (materialName, materialPrice, materialStock) " +
            "VALUES (#{materialName}, #{materialPrice}, #{materialStock})")
    void addMaterial(Material material);

    /**
     * 根据材料id删除原材料
     *
     * @param null
     * @return
     * @author 刘仁楠
     * @date 2018/5/8 13:37
     */
    @Delete("DELETE FROM material WHERE materialID = #{arg1}")
    void deleteMaterialById(Integer materialID);

    /**
     * 修改原材料信息
     *
     * @param null
     * @return
     * @author 刘仁楠
     * @date 2018/5/8 13:40
     */
    @Update("UPDATE material SET materialPrice = #{materialPrice} ,materialStock = #{materialStock} " +
            "WHERE materialName = #{materialName}")
    void updatematerial(Material material);

    /**
     * 根据materialID获取原材料信息
     *
     * @author 刘仁楠
     * @date 2018/5/8 13:59
     */
    @Select({"SELECT * FROM material where materialID = #{arg1}"})
    Material getMaterialById(Integer materialID);
}

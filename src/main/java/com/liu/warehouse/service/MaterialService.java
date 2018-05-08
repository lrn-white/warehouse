package com.liu.warehouse.service;

import com.liu.warehouse.mapper.MaterialMapper;
import com.liu.warehouse.model.Material;
import com.liu.warehouse.msg.MsgTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author 刘仁楠
 * @date 2018/5/7 10:18
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class MaterialService {

    @Autowired
    private MaterialMapper materialMapper;

    /**
     * 获取原材料列表
     *
     * @param null
     * @return
     * @author 刘仁楠
     * @date 2018/5/7 10:20
     */
    public Map<String, Object> getAllMaterial(Material material) {
        List<Material> materials = materialMapper.getAllMaterial();
        return MsgTemplate.successMsg(materials);
    }
    /**
     * 新增原材料
     *
     * @param null
     * @return
     * @author 刘仁楠
     * @date 2018/5/8 11:36
     */
    public void addMaterial(Material material){
        materialMapper.addMaterial(material);
    }

    /**
     * 根据材料id删除原材料
     *
     * @param null
     * @return
     * @author 刘仁楠
     * @date 2018/5/8 13:37
     */
    public void deleteMaterialById(Integer materialID){
        materialMapper.deleteMaterialById(materialID);
    }

    /**
     * 修改原材料信息
     *
     * @param null
     * @return
     * @author 刘仁楠
     * @date 2018/5/8 13:40
     */
    public void updatematerial(Material material){
        materialMapper.updatematerial(material);
    }

    /**
     * 根据materialID获取原材料信息
     *
     * @author 刘仁楠
     * @date 2018/5/8 13:59
     */
    public Material getMaterialById(Integer materialID){
        return materialMapper.getMaterialById(materialID);
    }
}

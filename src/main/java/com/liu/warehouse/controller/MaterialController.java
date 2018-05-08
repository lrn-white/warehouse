package com.liu.warehouse.controller;

import com.liu.warehouse.model.Material;
import com.liu.warehouse.msg.MsgEnum;
import com.liu.warehouse.msg.MsgTemplate;
import com.liu.warehouse.service.MaterialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author 刘仁楠
 * @date 2018/5/7 10:15
 */
@RestController
@RequestMapping("/material")
public class MaterialController {

    private static final Logger logger = LoggerFactory.getLogger(MaterialController.class);

    @Autowired
    private MaterialService materialSerivce;

    /**
     * 获取原材料列表
     *
     * @return
     * @author 刘仁楠
     * @date 2018/5/7 10:17
     */
    @RequestMapping("/getAllMaterial")
    public Map<String, Object> getAllmaterial() {
        try {
            Material material = new Material();
            return materialSerivce.getAllMaterial(material);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return MsgTemplate.failureMsg(MsgEnum.OPS_FAILURE);
        }
    }

    /**
     * 新增原材料
     *
     * @return
     * @author 刘仁楠
     * @date 2018/5/8 11:36
     */
    @RequestMapping("/addMaterial")
    public void addMaterial(Material material) {
        materialSerivce.addMaterial(material);
    }

    /**
     * 根据材料id删除原材料
     *
     * @return
     * @author 刘仁楠
     * @date 2018/5/8 13:37
     */
    @RequestMapping("/deleteMaterialById")
    public void deleteMaterialById(Integer materialID) {
        materialSerivce.deleteMaterialById(materialID);
    }

    /**
     * 修改原材料信息
     *
     * @return
     * @author 刘仁楠
     * @date 2018/5/8 13:40
     */
    @RequestMapping("/updatematerial")
    public void updatematerial(Material material) {
        materialSerivce.updatematerial(material);
    }

    /**
     * 根据materialID获取原材料信息
     *
     * @author 刘仁楠
     * @date 2018/5/8 13:59
     */
    @RequestMapping("/getMaterialById")
    public Material getMaterialById(Integer materialID) {
        return materialSerivce.getMaterialById(materialID);
    }
}

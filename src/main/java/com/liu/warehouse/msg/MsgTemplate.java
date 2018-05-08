package com.liu.warehouse.msg;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 刘仁楠
 * @date 2018/4/27 16:03
 */
public class MsgTemplate {

    private static final Logger logger = LoggerFactory.getLogger(MsgTemplate.class);

    /**
     * 成功输出
     *
     * @return
     */
    public static Map<String, Object> successMsg() {
        return successMsg(null);
    }

    /**
     * 成功输出
     *
     * @param data 输出数据
     * @return
     */
    public static Map<String, Object> successMsg(Object data) {
        return customMsg(100000, "", data);
    }

    /**
     * Custom map.
     *

     * @param msgCode the enums code
     * @param message the message
     * @param data    the data
     * @return the map
     */
    private static Map<String, Object> customMsg(int msgCode, String message, Object data) {
        Map<String, Object> result = new HashMap<String, Object>();

        result.put("code", msgCode);
        result.put("msg", message);
        result.put("data", data);
        try {
            ObjectMapper mapper = new ObjectMapper();
            logger.info("返回输出：", mapper.writeValueAsString(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 成功输出
     *
     * @param message MsgInterface接口类型
     * @param data    输出数据
     * @return
     */
    public static Map<String, Object> successMsg(MsgInterface message, Object data) {
        return customMsg( message.getCode(), message.getMsg(), data);
    }

    /**
     * 错误输出
     *
     * @param message MsgInterface接口类型
     * @param data    输出数据
     * @return
     */
    public static Map<String, Object> failureMsg(MsgInterface message, Object data) {
        return customMsg( message.getCode(), message.getMsg(), data);
    }

    /**
     * 错误输出
     *
     * @param message MsgInterface接口类型
     * @return
     */
    public static Map<String, Object> failureMsg(MsgInterface message) {
        return customMsg( message.getCode(), message.getMsg(), null);
    }



}

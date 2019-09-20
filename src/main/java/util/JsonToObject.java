package util;

import com.mysql.jdbc.Util;
import net.sf.json.JSONObject;

/**
 * @ClassName JsonToObject
 * @Description TODO
 * @Auther tuantuan
 * @Date 2019/9/19 9:33
 * @Version 1.0
 * @Attention Copyright (C)，2004-2019，BDILab，XiDian University
 **/
public class JsonToObject {
    public Object jsonToObject(String json){
        JSONObject jsonObject = JSONObject.fromObject(json);
        return JSONObject.toBean(jsonObject, Util.class);
    }
}

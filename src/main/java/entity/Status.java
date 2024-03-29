package entity;


import java.util.Date;

/**
 * @ClassName Status
 * @Description TODO
 * @Auther tuantuan
 * @Date 2019/9/10 17:23
 * @Version 1.0
 * @Attention Copyright (C)，2004-2019，BDILab，XiDian University
 **/
public class Status extends Message {

    /**
     * 令牌
     */
    private String TOKEN = null;
    /**
     * 设备Guid
     */
    private String GUID = null;
    /**
     * 时间
     */
    private long TIME = -1;
    /**
     *开关门状态（0：开门，1：关门）
     */
    private int DOOR_STATUS = -1;

    public String getTOKEN() {
        return TOKEN;
    }

    public String getGUID() {
        return GUID;
    }

    public long getTIME() {
        return TIME;
    }

    public int getDOOR_STATUS() {
        return DOOR_STATUS;
    }

    public void setTOKEN(String TOKEN) {
        this.TOKEN = TOKEN;
    }

    public void setGUID(String GUID) {
        this.GUID = GUID;
    }

    public void setTIME(long TIME) {
        this.TIME = TIME;
    }

    public void setDOOR_STATUS(int DOOR_STATUS) {
        this.DOOR_STATUS = DOOR_STATUS;
    }


}

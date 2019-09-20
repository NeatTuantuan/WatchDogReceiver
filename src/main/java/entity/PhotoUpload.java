package entity;

import java.util.Date;

/**
 * @ClassName PhotoUpload
 * @Description TODO
 * @Auther tuantuan
 * @Date 2019/9/10 17:30
 * @Version 1.0
 * @Attention Copyright (C)，2004-2019，BDILab，XiDian University
 **/
public class PhotoUpload extends Message {
    /**
     * 令牌
     */
    private String TOKEN = null;
    /**
     * 设备Guid
     */
    private String GUID = null;
    /**
     *抓拍时间
     */
    private long PHOTO_TIME = -1;
    /**
     *门禁端比对人员类型（0:住户，1:陌生人）
     */
    private int USER_TYPE = -1;
    /**
     *抓拍照片
     */
    private byte[] PHOTO_IMG ;

    public String getTOKEN() {
        return TOKEN;
    }

    public String getGUID() {
        return GUID;
    }

    public long getPHOTO_TIME() {
        return PHOTO_TIME;
    }

    public int getUSER_TYPE() {
        return USER_TYPE;
    }

    public byte[] getPHOTO_IMG() {
        return PHOTO_IMG;
    }

    public void setTOKEN(String TOKEN) {
        this.TOKEN = TOKEN;
    }

    public void setGUID(String GUID) {
        this.GUID = GUID;
    }

    public void setPHOTO_TIME(long PHOTO_TIME) {
        this.PHOTO_TIME = PHOTO_TIME;
    }

    public void setUSER_TYPE(int USER_TYPE) {
        this.USER_TYPE = USER_TYPE;
    }

    public void setPHOTO_IMG(byte[] PHOTO_IMG) {
        this.PHOTO_IMG = PHOTO_IMG;
    }

}

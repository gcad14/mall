package com.gc.bdzb.enums;

/**
 * @author Administrator
 */

public enum SBLXEnum {
    ZBYQ("主变压器","0301","台"),
    MX("母线","0311","条"),
    DLQHGIS("断路器含GIS","0305,0321","台，间隔"),
    DKQ("电抗器","0312","台"),
    GLKG("隔离开关","0306","组"),
    DLHGQ("电流互感器","0313","台"),
    DYHGQ("电压互感器","0314","台"),
    BLQ("避雷器","0318","台");
    private String name;
    private String lxbm;
    private String dw;

    SBLXEnum() {
    }

    SBLXEnum(String name, String lxbm, String dw) {
        this.name = name;
        this.lxbm = lxbm;
        this.dw = dw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLxbm() {
        return lxbm;
    }

    public void setLxbm(String lxbm) {
        this.lxbm = lxbm;
    }

    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw;
    }
}

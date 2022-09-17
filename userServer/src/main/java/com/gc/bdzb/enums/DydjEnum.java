package com.gc.bdzb.enums;

public enum DydjEnum {
    JL35KV("交流35kV","25"),
    Jl110KV("交流110kV","32"),
    JL220KV("交流220kV","33"),
    JL500KV("交流500kV","35"),
    JL1000KV("交流1000kV","37");

    private String name;
    private String value;

    DydjEnum() {
    }

    DydjEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

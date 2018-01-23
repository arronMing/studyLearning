package com.kpmg.data.export.constant;

public enum SoftwareCompanyEnum {

    ORACLE("ORACLE甲骨文", 1),
    SAP("SAP", 2),
    UFIDA("用友", 3),
    KINGDEE("金蝶", 4);




    SoftwareCompanyEnum(String name, int code) {
        this.name = name;
        this.code = code;
    }

    //名称
    private String name;

    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

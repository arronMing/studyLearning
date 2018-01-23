package com.kpmg.data.export.constant;

public enum SoftVersionEnum {

    ORACLE("ORACLE甲骨文", "ORACLE EBS", 1),
    SAP("SAP", "SAP R3", 2),
    UFIDA_NC("用友", "NC", 3),
    UFIDA_U8("用友", "U8", 4),
    KINGDEE_EAS("金蝶", "EAS", 5),
    KINGDEE_K3("金蝶", "K3", 6);


    SoftVersionEnum(String name, String version, int code) {
        this.name = name;
        this.version = version;
        this.code = code;
    }

    //名称
    private String name;
    //版本
    private String version;

    private int code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}

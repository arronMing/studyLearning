package com.kpmg.data.export.constant;

public enum DataBaseTypeEnum {

    ORACLE("ORACLE database", "oracle.jdbc.driver.OracleDriver"),
    //String url = "jdbc:oracle:" + "thin:@127.0.0.1:1521:XE";// 127.0.0.1是本机地址，XE是精简版Oracle的默认数据库名
    SQLSERVER("Microsoft SQL Server", "com.microsoft.sqlserver.jdbc.SQLServerDriver"),
    //String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=QQhrlgzysyWeb;user=sa;password=123";//sa身份连接
    IBM("IBM BD2", "com.ibm.db2.jcc.DB2Driver"),
    SAP("SAP SYBASE", "com.sybase.jdbc3.jdbc.SybDriver");
    // String url = "jdbc:sybase:Tds:192.168.2.103:5000/ext"; // 连接的数据库是ext


    private String name;

    private String driver;

    DataBaseTypeEnum(String name, String driver) {
        this.name = name;
        this.driver = driver;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
}

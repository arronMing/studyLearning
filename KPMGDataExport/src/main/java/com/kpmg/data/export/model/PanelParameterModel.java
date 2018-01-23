package com.kpmg.data.export.model;

public class PanelParameterModel {

    //软件厂商
    private String softwareVendor;
    //软件版本
    private String softwareVersion;
    //数据库类型
    private String databaseType;
    //数据库连接地址
    private String databaseUrl;
    //连接名称
    private String connectName;
    //用户名
    private String username;
    //密码
    private String password;
    //帐套
    private String setOfBook;
    //导出类型
    private String[] exportType;
    //导出形式
    private String exportMode;
    //开始时间
    private String startTime;
    //结束时间
    private String endTime;

    public String getSoftwareVendor() {
        return softwareVendor;
    }

    public void setSoftwareVendor(String softwareVendor) {
        this.softwareVendor = softwareVendor;
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public void setSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }

    public String getDatabaseType() {
        return databaseType;
    }

    public void setDatabaseType(String databaseType) {
        this.databaseType = databaseType;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public void setDatabaseUrl(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

    public String getConnectName() {
        return connectName;
    }

    public void setConnectName(String connectName) {
        this.connectName = connectName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSetOfBook() {
        return setOfBook;
    }

    public void setSetOfBook(String setOfBook) {
        this.setOfBook = setOfBook;
    }

    public String[] getExportType() {
        return exportType;
    }

    public void setExportType(String[] exportType) {
        this.exportType = exportType;
    }

    public String getExportMode() {
        return exportMode;
    }

    public void setExportMode(String exportMode) {
        this.exportMode = exportMode;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}

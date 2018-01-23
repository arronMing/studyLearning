package com.kpmg.data.export.utils;

import com.kpmg.data.export.constant.DataBaseTypeEnum;

public class DataConvertUtil {


    /**
     * 根据数据库类型获取驱动
     *
     * @param databaseType
     * @return
     */
    public static String getDataBaseDriver(String databaseType) {

        for (DataBaseTypeEnum data : DataBaseTypeEnum.values()) {

            if (databaseType.equals(data.getName())) {
                return data.getDriver();
            }

        }
        return "";
    }

    /**
     * 组装成实际连接的的url
     *
     * @param url
     * @return
     */
    public static String getRealUrl(String databaseType, String url) {

        String realUrl = "";
        if (databaseType.equals("ORACLE database")) {
            realUrl = "jdbc:oracle:thin:@" + url + ":orcl";
        }
        return realUrl;
    }


}

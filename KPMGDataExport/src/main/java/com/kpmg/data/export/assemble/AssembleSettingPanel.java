package com.kpmg.data.export.assemble;

import com.kpmg.data.export.component.FlowLayoutPanel;
import com.kpmg.data.export.component.GridBagLayoutPanel;
import com.kpmg.data.export.constant.Constants;
import com.kpmg.data.export.constant.DataBaseTypeEnum;
import com.kpmg.data.export.constant.SoftVersionEnum;
import com.kpmg.data.export.constant.SoftwareCompanyEnum;

import javax.swing.*;
import java.awt.*;

public class AssembleSettingPanel implements PanelCreate {

    //切换面板中的基础设置面板
    private GridBagLayoutPanel settingPanel;

    private GridBagConstraints gridBagConstraints;

    //向panel添加元素的时候递增的Y轴
    private int i = 0;

    //软件厂商组装pannel
    private AssembleLableComboboxPanel assemblePanelManufacturer;
    //软件版本面板拼装器
    private AssembleLableComboboxPanel assembleSoftVersion;
    //数据库类型拼装器
    private AssembleLableComboboxPanel assembleDatabaseType;
    //数据库连接地址拼装器
    private AssembleLableTextfieldPanel assembleDataBaseAddress;
    //连接名称panel 拼装器
    private AssembleLableTextfieldPanel assembleConnectionName;
    //用户名panel拼装器
    private AssembleLableTextfieldPanel assembleUsername;
    //密码拼装器
    private AssembleLableTextfieldPanel assemblePassword;
    //测试按钮拼装器
    private AssembleLinkTestPanel assembleLinkTestPanel;

    public AssembleSettingPanel() {
        settingPanel = new GridBagLayoutPanel();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 0;
        gridBagConstraints.gridx = 0; // 0行0列

        assemblePanelManufacturer = new AssembleLableComboboxPanel(Constants.SOFTWARE_VENDOR);
        assembleSoftVersion = new AssembleLableComboboxPanel(Constants.SOFTWARE_VERSION);
        assembleDatabaseType = new AssembleLableComboboxPanel(Constants.DATABASE_TYPE);
        assembleDataBaseAddress = new AssembleLableTextfieldPanel(Constants.DATABASE_ADDRESS);
        assembleConnectionName = new AssembleLableTextfieldPanel(Constants.CONNECTION_NAME);
        assembleUsername = new AssembleLableTextfieldPanel(Constants.USERNAME);
        assemblePassword = new AssembleLableTextfieldPanel(Constants.PASSWORD);
        assembleLinkTestPanel = new AssembleLinkTestPanel(Constants.LINK_TEST);
    }


    /**
     * 向面板中添加元素
     *
     * @param component
     */
    private void addPanelItem(Component component) {
        gridBagConstraints.gridy = i;
        i++;
        settingPanel.add(component, gridBagConstraints);
    }

    /**
     * 向软件厂商的下拉列表中添加元素
     */
    private void addSoftwareItem() {

        for (SoftwareCompanyEnum softwareCompanyEnum : SoftwareCompanyEnum.values()) {
            assemblePanelManufacturer.addItem(softwareCompanyEnum.getName());
        }

    }


    /**
     * 软件厂商下拉监听
     */
    private void addSoftwareListener() {
        assemblePanelManufacturer.addJComboBoxListener(assembleSoftVersion);
    }

    /**
     * 向软件版本的下拉列表中添加元素
     */
    private void addSoftwareVersionItem() {

        assembleSoftVersion.addItem(SoftVersionEnum.ORACLE.getVersion());
    }

    /**
     * 向数据库类型下拉列表中添加元素
     */
    private void addDatabaseTypeItem() {

        for (DataBaseTypeEnum dataBaseTypeEnum : DataBaseTypeEnum.values()) {
            assembleDatabaseType.addItem(dataBaseTypeEnum.getName());
        }

    }

    @Override
    public JPanel createPanel() {
        //软件厂商面板
        FlowLayoutPanel panelManufacturerPanel = assemblePanelManufacturer.createPanel();
        addPanelItem(panelManufacturerPanel);
        addSoftwareItem();
        addSoftwareListener();
        //软件版本面板
        FlowLayoutPanel softVersionPanel = assembleSoftVersion.createPanel();
        addPanelItem(softVersionPanel);
        addSoftwareVersionItem();
        //数据库类型面板
        FlowLayoutPanel databaseTypePanel = assembleDatabaseType.createPanel();
        addPanelItem(databaseTypePanel);
        addDatabaseTypeItem();
        //数据库链接地址面板
        FlowLayoutPanel databaseAddress = assembleDataBaseAddress.createPanel();
        addPanelItem(databaseAddress);
        //连接名称面板
        FlowLayoutPanel connectionNamePanel = assembleConnectionName.createPanel();
        addPanelItem(connectionNamePanel);
        //用户名面板
        FlowLayoutPanel usernamePanel = assembleUsername.createPanel();
        addPanelItem(usernamePanel);
        //密码面板
        FlowLayoutPanel passwordPanel = assemblePassword.createPanel();
        addPanelItem(passwordPanel);
        //测试连接面板
        FlowLayoutPanel linkTextPanel = (FlowLayoutPanel) assembleLinkTestPanel.createPanel();
        assembleLinkTestPanel.addButtonListener(this);
        addPanelItem(linkTextPanel);
        return settingPanel;
    }

    public AssembleLableComboboxPanel getAssemblePanelManufacturer() {
        return assemblePanelManufacturer;
    }

    public AssembleLableComboboxPanel getAssembleSoftVersion() {
        return assembleSoftVersion;
    }

    public AssembleLableComboboxPanel getAssembleDatabaseType() {
        return assembleDatabaseType;
    }

    public AssembleLableTextfieldPanel getAssembleDataBaseAddress() {
        return assembleDataBaseAddress;
    }

    public AssembleLableTextfieldPanel getAssembleConnectionName() {
        return assembleConnectionName;
    }

    public AssembleLableTextfieldPanel getAssembleUsername() {
        return assembleUsername;
    }

    public AssembleLableTextfieldPanel getAssemblePassword() {
        return assemblePassword;
    }
}

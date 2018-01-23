package com.kpmg.data.export.assemble;

import com.kpmg.data.export.component.FlowLayoutPanel;
import com.kpmg.data.export.constant.SoftVersionEnum;
import com.kpmg.data.export.constant.SoftwareCompanyEnum;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AssembleLableComboboxPanel implements PanelCreate {

    //当前面板
    private FlowLayoutPanel panel;
    //标题
    private Label label;
    // 下拉选择器
    private JComboBox jComboBox;

    public AssembleLableComboboxPanel(String name) {

        panel = new FlowLayoutPanel();
        label = new Label(name);
        jComboBox = new JComboBox();
        jComboBox.setPreferredSize(new Dimension(200, 25));
    }

    /**
     * 创建面板
     *
     * @return
     */
    public FlowLayoutPanel createPanel() {

        panel.add(label);
        panel.add(jComboBox);
        return panel;

    }

    /**
     * 向下拉框中添加元素
     */
    public void addItem(String name) {
        jComboBox.addItem(name);
    }

    /**
     * 下拉监听
     *
     * @param assembleSoftVersion
     */
    public void addJComboBoxListener(final AssembleLableComboboxPanel assembleSoftVersion) {
        jComboBox.addItemListener(new ItemListener() {

            JComboBox softwareVersion = assembleSoftVersion.getjComboBox();

            @Override
            public void itemStateChanged(ItemEvent e) {
                String selected = String.valueOf(e.getItem());
                if (selected.equals(SoftwareCompanyEnum.ORACLE.getName())) {
                    softwareVersion.removeAllItems();
                    softwareVersion.addItem(SoftVersionEnum.ORACLE.getVersion());

                } else if (selected.equals(SoftwareCompanyEnum.SAP.getName())) {
                    softwareVersion.removeAllItems();
                    softwareVersion.addItem(SoftVersionEnum.SAP.getVersion());

                } else if (selected.equals(SoftwareCompanyEnum.UFIDA.getName())) {
                    softwareVersion.removeAllItems();
                    softwareVersion.addItem(SoftVersionEnum.UFIDA_NC.getVersion());
                    softwareVersion.addItem(SoftVersionEnum.UFIDA_U8.getVersion());

                } else if (selected.equals(SoftwareCompanyEnum.KINGDEE.getName())) {
                    softwareVersion.removeAllItems();
                    softwareVersion.addItem(SoftVersionEnum.KINGDEE_EAS.getVersion());
                    softwareVersion.addItem(SoftVersionEnum.KINGDEE_K3.getVersion());

                }
            }
        });

    }

    public JComboBox getjComboBox() {
        return jComboBox;
    }


}

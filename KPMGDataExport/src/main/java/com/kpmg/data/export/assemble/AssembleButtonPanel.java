package com.kpmg.data.export.assemble;

import com.kpmg.data.export.component.CustomButton;
import com.kpmg.data.export.component.GridBagLayoutPanel;
import com.kpmg.data.export.constant.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AssembleButtonPanel implements PanelCreate {

    //左侧两个按钮的面板
    private GridBagLayoutPanel buttonPanel;
    //左侧基础设置菜单按钮
    private CustomButton settingButton;
    //左侧数据导出菜单按钮
    private CustomButton dataExportButton;


    public AssembleButtonPanel() {
        buttonPanel = new GridBagLayoutPanel();
        settingButton = new CustomButton(Constants.SETTING_BUTTON_CONTENT);
        dataExportButton = new CustomButton(Constants.DATA_BUTTON_CONTENT);
    }


    @Override
    public JPanel createPanel() {
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0; // 0行0列
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0;
        c.weighty = 0;
        buttonPanel.add(settingButton, c);


        c.gridx = 0; // 0行0列
        c.gridy = 1;
        buttonPanel.add(dataExportButton, c);

        return buttonPanel;
    }

    /**
     * 绑定监听事件
     */
    public void bindButtonListener(final JPanel panel) {

        settingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) (panel.getLayout());
                cardLayout.show(panel, Constants.CARD_PANEL_SETTING);
            }
        });

        dataExportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) (panel.getLayout());
                cardLayout.show(panel, Constants.CARD_PANEL_EXPORT);
            }
        });

    }
}

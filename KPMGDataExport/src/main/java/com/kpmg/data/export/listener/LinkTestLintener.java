package com.kpmg.data.export.listener;

import com.kpmg.data.export.assemble.AssembleSettingPanel;
import com.kpmg.data.export.constant.Constants;
import com.kpmg.data.export.jdbc.DatabaseTemplate;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LinkTestLintener implements ActionListener {

    private AssembleSettingPanel assembleSettingPanel;

    private JLabel label;

    public LinkTestLintener(AssembleSettingPanel assembleSettingPanel, JLabel label) {
        this.assembleSettingPanel = assembleSettingPanel;
        this.label = label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String driver = (String) assembleSettingPanel.getAssembleDatabaseType().getjComboBox().getSelectedItem();
        String username = assembleSettingPanel.getAssembleUsername().getTextField().getText();
        String password = assembleSettingPanel.getAssemblePassword().getTextField().getText();
        String url = assembleSettingPanel.getAssembleDataBaseAddress().getTextField().getText();
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password) || StringUtils.isBlank(url)) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, Constants.INFO_NOT_EMPTY, "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
        } else {

            boolean result = DatabaseTemplate.testLink(driver, url, username, password);
            if (result) {
                //连接成功
                label.setText(Constants.LINK_SUCEESS);
            } else {
                //连接失败
                label.setText(Constants.LINK_ERROR);
            }

        }


    }
}

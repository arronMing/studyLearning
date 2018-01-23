package com.kpmg.data.export.assemble;

import com.kpmg.data.export.component.GridBagLayoutPanel;

import javax.swing.*;
import java.awt.*;

public class AssembleSeparatePanel implements PanelCreate {

    //标题
    private JLabel title;
    //分隔符
    private JLabel separate;
    //面板
    private GridBagLayoutPanel panel;

    private GridBagConstraints gridBagConstraints;
    //放入面板中组件的位置
    private int i = 0;

    public AssembleSeparatePanel(String titleName) {

        title = new JLabel(titleName);
        title.setFont(new   java.awt.Font("Dialog",   1,   15));
        separate = new JLabel("————————————————————————————————————————————");
        panel = new GridBagLayoutPanel();

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0; // 0行0列
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 0;

    }

    @Override
    public JPanel createPanel() {
        addPanelItem(title);
        addPanelItem(separate);

        return panel;
    }

    private void addPanelItem(Component item) {
        gridBagConstraints.gridx = 0; // 0行0列
        gridBagConstraints.gridy = i;
        panel.add(item, gridBagConstraints);
        i++;
    }
}

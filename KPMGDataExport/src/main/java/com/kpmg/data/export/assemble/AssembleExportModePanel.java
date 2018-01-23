package com.kpmg.data.export.assemble;

import com.kpmg.data.export.component.FlowLayoutPanel;
import com.kpmg.data.export.constant.Constants;

import javax.swing.*;

public class AssembleExportModePanel implements PanelCreate {

    //当前面板
    private FlowLayoutPanel panel;
    //单选
    private JCheckBox one;
    private JCheckBox two;

    public AssembleExportModePanel() {

        panel = new FlowLayoutPanel();
        one = new JCheckBox(Constants.EXPORT_MODE_ONE, true);
        two = new JCheckBox(Constants.EXPORT_MODE_TWO);
    }

    @Override
    public JPanel createPanel() {
        panel.add(one);
        panel.add(two);
        return panel;
    }
}

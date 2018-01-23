package com.kpmg.data.export.assemble;

import com.kpmg.data.export.component.FlowLayoutPanel;
import com.kpmg.data.export.constant.Constants;

import javax.swing.*;

public class AssembleRadioPanel implements PanelCreate {

    //当前面板
    private FlowLayoutPanel panel;
    //单选
    private JRadioButton one;
    private JRadioButton two;
    private JRadioButton three;
    private ButtonGroup buttonGroup;

    public AssembleRadioPanel() {

        panel = new FlowLayoutPanel();
        one = new JRadioButton(Constants.BOOKS_ONE, true);
        two = new JRadioButton(Constants.BOOKS_TWO);
        three = new JRadioButton(Constants.BOOKS_THREE);
        buttonGroup = new ButtonGroup();
        buttonGroup.add(one);
        buttonGroup.add(two);
        buttonGroup.add(three);
    }

    @Override
    public JPanel createPanel() {
        panel.add(one);
        panel.add(two);
        panel.add(three);
        return panel;
    }
}

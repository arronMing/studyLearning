package com.kpmg.data.export.assemble;

import com.kpmg.data.export.component.FlowLayoutPanel;

import javax.swing.*;
import java.awt.*;

public class AssembleLableTextAreaPanle implements PanelCreate {

    //面板
    private FlowLayoutPanel panel;
    //单选
    private JRadioButton full;
    private JRadioButton select;
    //文本域
    private JTextArea textArea;

    private ButtonGroup buttonGroup;
    private JScrollPane jScrollPane;
    //提示文字
    private JLabel tipslabel;


    public AssembleLableTextAreaPanle() {

        panel = new FlowLayoutPanel();
        full = new JRadioButton("所有帐套", true);
        select = new JRadioButton("可选帐套");
        textArea = new JTextArea(10, 18);

        textArea.setLineWrap(true);
        //滚动条
        jScrollPane = new JScrollPane(textArea);


        buttonGroup = new ButtonGroup();
        buttonGroup.add(full);
        buttonGroup.add(select);

        tipslabel = new JLabel("输入的帐套请用\",\"分隔");


    }


    @Override
    public JPanel createPanel() {

        panel.add(full);
        panel.add(select);
        panel.add(jScrollPane);
        panel.add(tipslabel);
        return panel;
    }

    public JRadioButton getSelect() {
        return select;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public JRadioButton getFull() {
        return full;
    }

    public ButtonGroup getButtonGroup() {
        return buttonGroup;
    }
}

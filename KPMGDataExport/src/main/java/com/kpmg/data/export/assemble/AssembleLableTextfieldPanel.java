package com.kpmg.data.export.assemble;

import com.kpmg.data.export.component.FlowLayoutPanel;

import javax.swing.*;
import java.awt.*;

public class AssembleLableTextfieldPanel implements PanelCreate {

    //当前面板
    private FlowLayoutPanel panel;
    //标题
    private Label label;
    //文本框
    private JTextField textField;

    public AssembleLableTextfieldPanel(String name) {

        panel = new FlowLayoutPanel();
        label = new Label(name);
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(200, 25));

    }

    /**
     * 创建面板
     *
     * @return
     */
    public FlowLayoutPanel createPanel() {

        panel.add(label);
        panel.add(textField);
        return panel;

    }

    public JTextField getTextField() {
        return textField;
    }
}

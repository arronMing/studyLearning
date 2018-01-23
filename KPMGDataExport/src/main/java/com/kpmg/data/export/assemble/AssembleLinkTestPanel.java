package com.kpmg.data.export.assemble;

import com.kpmg.data.export.component.FlowLayoutPanel;
import com.kpmg.data.export.listener.LinkTestLintener;

import javax.swing.*;

public class AssembleLinkTestPanel implements PanelCreate {


    //面板
    private FlowLayoutPanel panel;

    private JButton button;

    private JLabel label;

    public AssembleLinkTestPanel(String name) {

        panel = new FlowLayoutPanel();
        button = new JButton(name);
        label = new JLabel();
    }

    @Override
    public JPanel createPanel() {
        panel.add(button);
        panel.add(label);
        return panel;
    }

    public void addButtonListener(AssembleSettingPanel assembleSettingPanel) {


        button.addActionListener(new LinkTestLintener(assembleSettingPanel, label));
    }

}

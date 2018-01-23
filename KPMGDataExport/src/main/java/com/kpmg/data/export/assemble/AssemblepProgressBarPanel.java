package com.kpmg.data.export.assemble;

import com.kpmg.data.export.component.FlowLayoutPanel;
import com.kpmg.data.export.constant.Constants;

import javax.swing.*;

public class AssemblepProgressBarPanel implements PanelCreate {


    //当前面板
    private FlowLayoutPanel panel;
    //标题
    private JLabel title;
    //当前数目
    private JLabel num;
    //总数目
    private JLabel total;
    //分隔符
    private JLabel separate;

    public AssemblepProgressBarPanel() {

        panel = new FlowLayoutPanel();
        panel.setVisible(false);
        title = new JLabel(Constants.PROCESS_TEXT);
        num = new JLabel("0");
        total = new JLabel("0");
        separate = new JLabel("/");

    }

    @Override
    public JPanel createPanel() {

        panel.add(title);
        panel.add(num);
        panel.add(separate);
        panel.add(total);
        return panel;
    }

    public JLabel getNum() {
        return num;
    }

    public JLabel getTotal() {
        return total;
    }

    public FlowLayoutPanel getPanel() {
        return panel;
    }
}

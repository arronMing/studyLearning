package com.kpmg.data.export.assemble;

import com.kpmg.data.export.component.FlowLayoutPanel;
import com.kpmg.data.export.constant.DataConstant;

import javax.swing.*;
import java.awt.*;

public class AssembleRangeDatePanel implements PanelCreate {

    //当前面板
    private FlowLayoutPanel panel;
    //标题
    private Label labelFitst;
    private Label labelSecond;
    private Label labelThird;
    private Label labelForth;
    private Label labelFifth;
    private Label labelSixth;
    //开始年
    private JComboBox jComboBoxFromYear;
    //开始月
    private JComboBox jComboBoxFromMonth;
    //结束年
    private JComboBox jComboBoxToYear;
    //结束月
    private JComboBox jComboBoxToMonth;


    public AssembleRangeDatePanel() {

        panel = new FlowLayoutPanel();
        labelFitst = new Label("从");
        labelSecond = new Label("年");
        labelThird = new Label("月");
        labelForth = new Label("到");
        labelFifth = new Label("年");
        labelSixth = new Label("月");
        jComboBoxFromYear = new JComboBox();
        jComboBoxFromMonth = new JComboBox();
        jComboBoxToYear = new JComboBox();
        jComboBoxToMonth = new JComboBox();
        intiData();
    }

    private void intiData() {

        for (String year : DataConstant.YEARS_DATA) {
            jComboBoxFromYear.addItem(year);
            jComboBoxToYear.addItem(year);
        }

        for (String month : DataConstant.MONTH_DATA) {
            jComboBoxFromMonth.addItem(month);
            jComboBoxToMonth.addItem(month);
        }

    }

    @Override
    public JPanel createPanel() {

        panel.add(labelFitst);
        panel.add(jComboBoxFromYear);
        panel.add(labelSecond);
        panel.add(jComboBoxFromMonth);
        panel.add(labelThird);
        panel.add(labelForth);
        panel.add(jComboBoxToYear);
        panel.add(labelFifth);
        panel.add(jComboBoxToMonth);
        panel.add(labelSixth);
        return panel;
    }

    public JComboBox getjComboBoxFromYear() {
        return jComboBoxFromYear;
    }

    public JComboBox getjComboBoxFromMonth() {
        return jComboBoxFromMonth;
    }

    public JComboBox getjComboBoxToYear() {
        return jComboBoxToYear;
    }

    public JComboBox getjComboBoxToMonth() {
        return jComboBoxToMonth;
    }
}

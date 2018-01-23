package com.kpmg.data.export.assemble;

import com.kpmg.data.export.component.FlowLayoutPanel;
import com.kpmg.data.export.component.GridBagLayoutPanel;
import com.kpmg.data.export.constant.Constants;
import com.kpmg.data.export.factory.SeparatePanelFactory;

import javax.swing.*;
import java.awt.*;

public class AssembleExportPanel implements PanelCreate {

    //切换面板中的数据导出面板
    private GridBagLayoutPanel exportPanel;
    private GridBagConstraints gridBagConstraints;

    //向panel添加元素的时候递增的Y轴
    private int i = 0;

    //帐套拼装panel
    private AssembleLableTextAreaPanle assembleLSetOfBooksPanel;
    //年份月份拼装panel
    private AssembleRangeDatePanel assembleLYearMonthPanel;
    //导出按钮拼装panel
    private AssembleLableButtonPanel assembleExportButtonPanel;
    //帐套导出形式拼装面板
    private AssembleRadioPanel assembleRadioPanel;
    //帐套导出类型
    private AssembleExportModePanel assembleExportModePanel;
    //进度条拼装模板
    private AssemblepProgressBarPanel assemblepProgressBarPanel;


    public AssembleExportPanel() {

        exportPanel = new GridBagLayoutPanel();
        assembleLSetOfBooksPanel = new AssembleLableTextAreaPanle();
        assembleLYearMonthPanel = new AssembleRangeDatePanel();
        assembleExportButtonPanel = new AssembleLableButtonPanel("", Constants.EXPORT, Constants.UPLOAD);
        assembleRadioPanel = new AssembleRadioPanel();
        assembleExportModePanel = new AssembleExportModePanel();
        assemblepProgressBarPanel = new AssemblepProgressBarPanel();

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 0;
        gridBagConstraints.gridx = 0; // 0行0列
    }


    @Override
    public JPanel createPanel() {

        //帐套标题
        GridBagLayoutPanel booksTitle = SeparatePanelFactory.createSeparatePanel(Constants.BOOKS_TITLE);
        addPanelItem(booksTitle);

        //帐套面板
        FlowLayoutPanel setOfBooksPanel = (FlowLayoutPanel) assembleLSetOfBooksPanel.createPanel();
        addPanelItem(setOfBooksPanel);


        //年份标题
        GridBagLayoutPanel yearsTitle = SeparatePanelFactory.createSeparatePanel(Constants.RANGE_DATE_TITLE);
        addPanelItem(yearsTitle);


        //年份月份面板
        FlowLayoutPanel yearPanel = (FlowLayoutPanel) assembleLYearMonthPanel.createPanel();
        addPanelItem(yearPanel);


        // 帐套导出类型标题createSeparatePanel
        GridBagLayoutPanel exportTypeTitlePanel = SeparatePanelFactory.createSeparatePanel(Constants.EXPORT_MODE);
        addPanelItem(exportTypeTitlePanel);

        //帐套导出形式panel
        FlowLayoutPanel exportModePanel = (FlowLayoutPanel) assembleExportModePanel.createPanel();
        addPanelItem(exportModePanel);


        // 帐套导出形式标题
        GridBagLayoutPanel exportTypePanel = SeparatePanelFactory.createSeparatePanel(Constants.EXPORT_TYPE);
        addPanelItem(exportTypePanel);

        //帐套导出形式面板
        FlowLayoutPanel bookTypePanel = (FlowLayoutPanel) assembleRadioPanel.createPanel();
        addPanelItem(bookTypePanel);

        //分隔面板
        GridBagLayoutPanel separateTitle = SeparatePanelFactory.createSeparatePanel("");
        addPanelItem(separateTitle);


        //导出面板
        FlowLayoutPanel exportButtonPanel = (FlowLayoutPanel) assembleExportButtonPanel.createPanel();
        addPanelItem(exportButtonPanel);

        //分隔面板
        GridBagLayoutPanel separateTitle1 = SeparatePanelFactory.createSeparatePanel("");
        addPanelItem(separateTitle1);

        //进度条面板
        FlowLayoutPanel processPanel = (FlowLayoutPanel) assemblepProgressBarPanel.createPanel();
        addPanelItem(processPanel);

        return exportPanel;
    }

    /**
     * 向面板中添加元素
     *
     * @param component
     */
    private void addPanelItem(Component component) {
        gridBagConstraints.gridy = i;
        i++;
        exportPanel.add(component, gridBagConstraints);
    }

    /**
     * 绑定导出按钮的监听事件
     *
     * @param assembleSettingPanel
     */
    public void bindButtonListener(AssembleSettingPanel assembleSettingPanel) {

        assembleExportButtonPanel.bindButtonListener(assembleSettingPanel, this);


    }

    public AssembleLableTextAreaPanle getAssembleLSetOfBooksPanel() {
        return assembleLSetOfBooksPanel;
    }

    public AssembleRangeDatePanel getAssembleLYearMonthPanel() {
        return assembleLYearMonthPanel;
    }

    public AssembleLableButtonPanel getAssembleExportButtonPanel() {
        return assembleExportButtonPanel;
    }

    public AssemblepProgressBarPanel getAssemblepProgressBarPanel() {
        return assemblepProgressBarPanel;
    }
}

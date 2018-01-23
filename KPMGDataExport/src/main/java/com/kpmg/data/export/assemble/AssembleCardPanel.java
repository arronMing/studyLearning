package com.kpmg.data.export.assemble;

import com.kpmg.data.export.component.CardLayoutPanel;
import com.kpmg.data.export.component.GridBagLayoutPanel;
import com.kpmg.data.export.constant.Constants;

import javax.swing.*;

public class AssembleCardPanel implements PanelCreate {

    //右侧能够切换界面的面板
    private CardLayoutPanel cardPanel;

    //切换面板中的基础设置面板组装类
    private AssembleSettingPanel assembleSettingPanel;

    //切换面板中的数据导出面板组装类
    private AssembleExportPanel assembleExportPanel;

    public AssembleCardPanel() {

        cardPanel = new CardLayoutPanel();
        assembleSettingPanel = new AssembleSettingPanel();
        assembleExportPanel = new AssembleExportPanel();
    }


    @Override
    public JPanel createPanel() {
        GridBagLayoutPanel settingPanel = (GridBagLayoutPanel) assembleSettingPanel.createPanel();
        GridBagLayoutPanel exportPanel = (GridBagLayoutPanel) assembleExportPanel.createPanel();

        cardPanel.add(settingPanel, Constants.CARD_PANEL_SETTING);
        cardPanel.add(exportPanel, Constants.CARD_PANEL_EXPORT);
        return cardPanel;
    }

    /**
     * 绑定导出按钮的监听事件
     */
    public void bindButtonListener() {
        assembleExportPanel.bindButtonListener(assembleSettingPanel);
    }
}

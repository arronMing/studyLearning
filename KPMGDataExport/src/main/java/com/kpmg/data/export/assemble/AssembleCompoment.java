package com.kpmg.data.export.assemble;

import com.kpmg.data.export.component.CardLayoutPanel;
import com.kpmg.data.export.component.CustomFrame;
import com.kpmg.data.export.component.FlowLayoutPanel;
import com.kpmg.data.export.component.GridBagLayoutPanel;

public class AssembleCompoment {


    private static CustomFrame mainFrame = new CustomFrame();


    public AssembleCompoment() {
        assembleButtonPanel = new AssembleButtonPanel();
        assembleCardPanel = new AssembleCardPanel();
    }

    //最外层的主面板
    private FlowLayoutPanel mainPanel;
    //按钮面板拼装类
    private AssembleButtonPanel assembleButtonPanel;
    //切换的面板拼装类
    private AssembleCardPanel assembleCardPanel;

    /**
     * 拼装组件
     */
    public void assemble() {

        //创建主panel
        mainPanel = new FlowLayoutPanel();
        mainFrame.add(mainPanel);

        //创建按钮面板
        GridBagLayoutPanel buttonPanel = (GridBagLayoutPanel) assembleButtonPanel.createPanel();
        mainPanel.add(buttonPanel);

        //创建能切换的面板
        CardLayoutPanel cardLayoutPanel = (CardLayoutPanel) assembleCardPanel.createPanel();
        mainPanel.add(cardLayoutPanel);

        //绑定按钮面板中按钮的监听事件
        assembleButtonPanel.bindButtonListener(cardLayoutPanel);
        //绑定导出按钮监听事件
        assembleCardPanel.bindButtonListener();

        //显示界面
        mainFrame.visible();
    }

}

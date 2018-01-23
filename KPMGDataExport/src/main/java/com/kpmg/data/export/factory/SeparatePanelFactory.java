package com.kpmg.data.export.factory;

import com.kpmg.data.export.assemble.AssembleSeparatePanel;
import com.kpmg.data.export.component.GridBagLayoutPanel;

public class SeparatePanelFactory {

    public static GridBagLayoutPanel createSeparatePanel(String title) {

        AssembleSeparatePanel assembleSeparatePanel = new AssembleSeparatePanel(title);
        return (GridBagLayoutPanel) assembleSeparatePanel.createPanel();


    }


}

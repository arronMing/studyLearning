package com.kpmg.data.export.assemble;

import com.kpmg.data.export.component.CustomButton;
import com.kpmg.data.export.component.FlowLayoutPanel;
import com.kpmg.data.export.task.DownDataTask;
import com.kpmg.data.export.utils.FileChooseUtil;
import com.kpmg.data.export.utils.FileWriteUtil;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class AssembleLableButtonPanel implements PanelCreate {


    //当前面板
    private FlowLayoutPanel panel;
    //标题
    private Label label;
    //导出按钮
    private CustomButton button;
    //上传按钮
    private CustomButton upload;

    public AssembleLableButtonPanel(String lableName, String buttonName, String uploadName) {
        panel = new FlowLayoutPanel();
        label = new Label(lableName);
        button = new CustomButton(buttonName);
        upload = new CustomButton(uploadName);
    }

    @Override
    public JPanel createPanel() {

        panel.add(label);
        panel.add(button);
        panel.add(upload);
        return panel;
    }

    /**
     * 绑定button监听事件
     *
     * @param assembleSettingPanel
     * @param assembleExportPanel
     */
    public void bindButtonListener(final AssembleSettingPanel assembleSettingPanel, final AssembleExportPanel assembleExportPanel) {

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doAction(assembleSettingPanel, assembleExportPanel);
            }
        });
    }

    /**
     * 处理按钮被点击之后的操作
     *
     * @param assembleSettingPanel
     * @param assembleExportPanel
     */
    private void doAction(AssembleSettingPanel assembleSettingPanel, AssembleExportPanel assembleExportPanel) {

//        //软件厂商
//        String software = (String) assembleSettingPanel.getAssemblePanelManufacturer().getjComboBox().getSelectedItem();
//        //软件版本
//        String softwareVersion = (String) assembleSettingPanel.getAssembleSoftVersion().getjComboBox().getSelectedItem();
//        //数据库类型
//        String databaseType = (String) assembleSettingPanel.getAssembleDatabaseType().getjComboBox().getSelectedItem();
//        //数据库链接地址
//        String databaseAddress = assembleSettingPanel.getAssembleDataBaseAddress().getTextField().getText();
//        //连接名称
//        String connectionName = assembleSettingPanel.getAssembleConnectionName().getTextField().getText();
//        //用户名
//        String username = assembleSettingPanel.getAssembleUsername().getTextField().getText();
//        //密码
//        String password = assembleSettingPanel.getAssemblePassword().getTextField().getText();
//        //帐套
//        JRadioButton full = assembleExportPanel.getAssembleLSetOfBooksPanel().getFull();
//        JRadioButton select = assembleExportPanel.getAssembleLSetOfBooksPanel().getSelect();
//        if (full.isSelected()) {
//
//        } else {
//            JTextArea textArea = assembleExportPanel.getAssembleLSetOfBooksPanel().getTextArea();
//            String content = textArea.getText();
//        }
//
//        //年份
//        String fromYear = (String) assembleExportPanel.getAssembleLYearMonthPanel().getjComboBoxFromYear().getSelectedItem();
//        String fromMonth = (String) assembleExportPanel.getAssembleLYearMonthPanel().getjComboBoxFromMonth().getSelectedItem();
//        String toYear = (String) assembleExportPanel.getAssembleLYearMonthPanel().getjComboBoxToYear().getSelectedItem();
//        String toMonth = (String) assembleExportPanel.getAssembleLYearMonthPanel().getjComboBoxToMonth().getSelectedItem();

//        System.out.println("++++" + software);

        //获取打开文件夹路径
        String path = FileChooseUtil.getChoicePath();
        if (StringUtils.isBlank(path)) {
            return;
        }
        //设置进度条进度
        JPanel processPanel = assembleExportPanel.getAssemblepProgressBarPanel().getPanel();
        JLabel processNumLable = assembleExportPanel.getAssemblepProgressBarPanel().getNum();
        JLabel processTotalLable = assembleExportPanel.getAssemblepProgressBarPanel().getTotal();

        //创建文件
        FileWriteUtil fileWriteUtil = new FileWriteUtil();
        fileWriteUtil.writeContent("11111.csv", path, new ArrayList<String>());

        processPanel.setVisible(true);
        //新创建线程执行进度条任务
//        CountDownLatch countDownLatch = new CountDownLatch(5);
        DownDataTask task = new DownDataTask(processPanel, processNumLable, processTotalLable, path);
        task.start();


    }

    public String getProjectPath() {


        java.net.URL url = this.getClass().getProtectionDomain().getCodeSource().getLocation();

        String filePath = null;

        try {

            filePath = java.net.URLDecoder.decode(url.getPath(), "utf-8");

        } catch (Exception e) {

            e.printStackTrace();

        }

        if (filePath.endsWith(".jar"))

            filePath = filePath.substring(0, filePath.lastIndexOf("/") + 1);

        java.io.File file = new java.io.File(filePath);

        filePath = file.getAbsolutePath();

        return filePath;

    }

    /**
     * 获取复选框组中被选中的内容
     *
     * @param checkBoxes
     * @return
     */
    private List<String> getCheckboxSelectItem(JCheckBox[] checkBoxes) {

        List list = new ArrayList();
        for (JCheckBox box : checkBoxes) {
            if (box.isSelected()) {
                list.add(box.getText());
            }
        }
        return list;

    }
}

package com.kpmg.data.export.task;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class DownDataTask extends Thread {


    private JPanel processPanel;
    private JLabel processNumLable;
    private JLabel processTotalLable;
    //打开文件夹目录
    private String path;

    public DownDataTask(JPanel processPanel, JLabel processNumLable, JLabel processTotalLable, String path) {
        this.processPanel = processPanel;
        this.processNumLable = processNumLable;
        this.processTotalLable = processTotalLable;
        this.path = path;
    }

    @Override
    public void run() {
        try {
            processTotalLable.setText("5");
            for (int i = 0; i < 5; i++) {
                Thread.sleep(2000);
                processNumLable.setText(String.valueOf((i + 1)));
            }
            processPanel.setVisible(false);
            Desktop.getDesktop().open(new File(path));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package gui.listener;

import gui.panel.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBarListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainPanel mainPanel = MainPanel.instance;
        // 获取点击的按钮。
        JButton b = (JButton) e.getSource();
        if (b == mainPanel.bSpend) {
            mainPanel.workingPanel.show(SpendPanel.instance);
        }
        if (b == mainPanel.bBackup) {
            mainPanel.workingPanel.show(BackupPanel.instance);
        }
        if (b == mainPanel.bCategory) {
            mainPanel.workingPanel.show(CategoryPanel.instance);
        }
        if (b == mainPanel.bConfig) {
            mainPanel.workingPanel.show(ConfigPanel.instance);
        }
        if (b == mainPanel.bRecord) {
            mainPanel.workingPanel.show(RecordPanel.instance);
        }
        if (b == mainPanel.bReport) {
            mainPanel.workingPanel.show(ReportPanel.instance);
        }
        if (b == mainPanel.bRecover) {
            mainPanel.workingPanel.show(RecoverPanel.instance);
        }
    }
}

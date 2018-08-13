package gui.listener;

import gui.panel.ConfigPanel;
import service.ConfigService;
import util.GUIUitl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ConfigListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        ConfigPanel p = ConfigPanel.instance;
        if (!GUIUitl.checkNumber(p.tfBudget, "Budget of this Month"))
            return;

        String mysqlPath = p.tfMysqlPath.getText();
        if (0 != mysqlPath.length()) {
            File file = new File(mysqlPath, "/out/mysql");
            if (!file.exists()) {
                JOptionPane.showMessageDialog(p, "mysql路径不正确");
                p.tfMysqlPath.grabFocus();
                return;
            }
        }

        // 更新数据库
        ConfigService cs = new ConfigService();
        cs.update(ConfigService.budget, p.tfBudget.getText());
        cs.update(ConfigService.mysqlPath, p.tfMysqlPath.getText());
        JOptionPane.showMessageDialog(p, "Configuration Modified");
    }
}

package gui.panel;

import util.ColorUtil;
import util.GUIUitl;

import javax.swing.*;

public class BackupPanel extends JPanel {
    static {
        GUIUitl.useLNF();
    }

    public static BackupPanel instance = new BackupPanel();

    private BackupPanel() {
        JButton bbackup = new JButton("Backup");
        GUIUitl.setColor(ColorUtil.blueColor, bbackup);
        this.add(bbackup);
    }

    public static void main(String[] args) {
        GUIUitl.showPanel(BackupPanel.instance);
    }
}

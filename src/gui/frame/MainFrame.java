package gui.frame;

import gui.panel.MainPanel;

import javax.swing.*;

public class MainFrame extends JFrame {
    public static MainFrame instance = new MainFrame();

    private MainFrame() {
        this.setSize(500, 450);
        this.setLocationRelativeTo(null);
        this.setTitle("账本");
        // 不可改变大小
        this.setResizable(false);
        this.setContentPane(MainPanel.instance);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        instance.setVisible(true);
    }
}

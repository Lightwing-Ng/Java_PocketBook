package gui.panel;

import util.ColorUtil;
import util.GUIUitl;

import javax.swing.*;

public class RecoverPanel extends JPanel {
    static {
        GUIUitl.useLNF();
    }

    public static RecoverPanel instance = new RecoverPanel();

    private RecoverPanel() {
        JButton brecover = new JButton("Recover");
        GUIUitl.setColor(ColorUtil.blueColor, brecover);
        this.add(brecover);
    }

    public static void main(String[] args) {
        GUIUitl.showPanel(RecoverPanel.instance);
    }
}

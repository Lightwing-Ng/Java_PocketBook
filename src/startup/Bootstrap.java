package startup;

import gui.frame.MainFrame;
import gui.panel.MainPanel;
import gui.panel.SpendPanel;
import util.GUIUitl;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class Bootstrap {
    public static void main(String[] args) {
        GUIUitl.useLNF();
        try {
            // 线程：耗时任务放在一个工作线程中，界面刷新放在EDT（事件派发线程)中
            SwingUtilities.invokeAndWait(() -> {
                MainFrame.instance.setVisible(true);
                MainPanel.instance.workingPanel.show(SpendPanel.instance);
            });
        } catch (InterruptedException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

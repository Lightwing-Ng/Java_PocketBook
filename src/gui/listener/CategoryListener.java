package gui.listener;

import entity.Category;
import gui.panel.CategoryPanel;
import service.CategoryService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CategoryListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        CategoryPanel p = CategoryPanel.instance;
        JButton b = (JButton) e.getSource();
        if (b == p.bAdd) {
            // 弹出输入对话框
            String name = JOptionPane.showInputDialog(null);
            if (0 == name.length()) {
                JOptionPane.showMessageDialog(p, "Empty Category Name is not Allowed!");
                return;
            }
            new CategoryService().add(name);
            JOptionPane.showMessageDialog(p, "Adding Successfully!");
        }
        if (b == p.bEdit) {
            Category c = p.getSelectedCategory();
            if (c == null)
                return;

            int id = c.id;
            String name = JOptionPane.showInputDialog("Modify Category", c.name);
            if (0 == name.length()) {
                JOptionPane.showMessageDialog(p, "Empty Category Name is not Allowed!");
                return;
            }
            new CategoryService().update(id, name);
            JOptionPane.showMessageDialog(p, "Modified Successfully!");
        }

        if (b == p.bDelete) {
            Category c = p.getSelectedCategory();
            int cid = c.id;
            if (c.recordNumber != 0) {
                JOptionPane.showMessageDialog(p, "Some record exists under this Category.");
                return;
            }
            if (JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(
                    p, "Are you sure to delete it?"))
                return;

            new CategoryService().delete(cid);
            JOptionPane.showMessageDialog(p, "Deleted Successfully!");
        }
    }
}

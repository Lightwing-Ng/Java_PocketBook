package gui.panel;

import gui.model.CategoryComboxModel;
import org.jdesktop.swingx.JXDatePicker;
import util.ColorUtil;
import util.GUIUitl;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class RecordPanel extends JPanel {
    static {
        GUIUitl.useLNF();
    }

    public static RecordPanel instance = new RecordPanel();

    private RecordPanel() {
        JLabel lSpend = new JLabel("Cost($)");
        JLabel lCategory = new JLabel("Category");
        JLabel lComment = new JLabel("Remarks");
        JLabel lDate = new JLabel("Date");
        GUIUitl.setColor(ColorUtil.grayColor, lSpend, lCategory, lComment, lDate);
        JButton bSubmit = new JButton("New");
        GUIUitl.setColor(ColorUtil.blueColor, bSubmit);

        JPanel pinput = new JPanel();
        JPanel psubmit = new JPanel();
        // 组件之间水平和垂直方向间隔
        int gap = 40;
        pinput.setLayout(new GridLayout(4, 2, gap, gap));
        pinput.add(lSpend);
        JTextField tf = new JTextField("0");
        pinput.add(tf);
        pinput.add(lCategory);
        CategoryComboxModel cbModel = new CategoryComboxModel();
        JComboBox<String> cbCategory = new JComboBox<>(cbModel);
        pinput.add(cbCategory);
        pinput.add(lComment);
        JTextField tfComment = new JTextField();
        pinput.add(tfComment);
        pinput.add(lDate);
        JXDatePicker datepick = new JXDatePicker(new Date());
        pinput.add(datepick);

        psubmit.add(bSubmit);
        // 布局方式
        this.setLayout(new BorderLayout());
        this.add(pinput, BorderLayout.NORTH);
        this.add(psubmit, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        GUIUitl.showPanel(RecordPanel.instance);
    }
}

package gui.panel;

import util.CircleProgressBar;
import util.ColorUtil;
import util.GUIUitl;

import javax.swing.*;
import java.awt.*;

public class SpendPanel extends JPanel {
    static {
        GUIUitl.useLNF();
    }

    public static SpendPanel instance = new SpendPanel();
    private JLabel lMonthSpend = new JLabel("This Month");
    private JLabel lTodaySpend = new JLabel("Today");
    private JLabel lAvgSpendPerDay = new JLabel("Average");
    private JLabel lMonthLeft = new JLabel("Remain");
    private JLabel lDayAvgAvailable = new JLabel("Average");
    private JLabel lMonthLeftDay = new JLabel("To End of this Month");
    private JLabel vMonthSpend = new JLabel("$18,350");
    private JLabel vTodaySpend = new JLabel("$25");
    private JLabel vAvgSpendPerDay = new JLabel("$120");
    private JLabel vMonthAvailable = new JLabel("%2,084");
    private JLabel vDayAvgAvailable = new JLabel("$389");
    private JLabel vMonthLeftDay = new JLabel("15 Days");
    private CircleProgressBar bar;

    private SpendPanel() {
        this.setLayout(new BorderLayout());
        bar = new CircleProgressBar();
        bar.setBackgroundColor(Color.BLUE);

        GUIUitl.setColor(ColorUtil.grayColor, lMonthSpend, lTodaySpend, lAvgSpendPerDay, lMonthLeft, lDayAvgAvailable,
                lMonthLeftDay, vAvgSpendPerDay, vMonthAvailable, vDayAvgAvailable, vMonthLeftDay);
        GUIUitl.setColor(Color.BLUE, vMonthSpend, vTodaySpend);
        vMonthSpend.setFont(new Font("微软雅黑", Font.BOLD, 23));
        vTodaySpend.setFont(new Font("微软雅黑", Font.BOLD, 23));

        this.add(center(), BorderLayout.CENTER);
        this.add(south(), BorderLayout.SOUTH);
    }

    private JPanel center() {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(west(), BorderLayout.WEST);
        p.add(center2(), BorderLayout.CENTER);
        return p;
    }

    private JComponent center2() {
        return bar;
    }

    private JComponent west() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(4, 1));
        p.add(lMonthSpend);
        p.add(vMonthSpend);
        p.add(lTodaySpend);
        p.add(vTodaySpend);
        return p;
    }

    private JComponent south() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2, 4));

        p.add(lAvgSpendPerDay);
        p.add(lMonthLeft);
        p.add(lDayAvgAvailable);
        p.add(lMonthLeftDay);
        p.add(vAvgSpendPerDay);
        p.add(vMonthAvailable);
        p.add(vDayAvgAvailable);
        p.add(vMonthLeftDay);
        return p;
    }

    public static void main(String[] args) {
        GUIUitl.showPanel(SpendPanel.instance);
    }

}

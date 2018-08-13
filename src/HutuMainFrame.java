import javax.swing.*;
import java.awt.*;

public class HutuMainFrame {
    public static void main(String[] args) {
        JFrame f = new JFrame("账本");
        f.setResizable(false);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setSize(500, 450);
        f.setLayout(new BorderLayout());

        JToolBar tb = new JToolBar();
        JButton bSpend = new JButton("消费一览");
        JButton bRecord = new JButton("记一笔");
        JButton bCategory = new JButton("消费分类");
        JButton bReport = new JButton("月消费报告");
        JButton bConfig = new JButton("设置");
        JButton bBackup = new JButton("备份");
        JButton bRecover = new JButton("还原");

        tb.add(bSpend);
        tb.add(bRecord);
        tb.add(bCategory);
        tb.add(bReport);
        tb.add(bConfig);
        tb.add(bBackup);
        tb.add(bRecover);
        f.add(tb, BorderLayout.NORTH);
        f.add(new JPanel(), BorderLayout.CENTER);
        f.setVisible(true);

        bSpend.addActionListener(e -> {
        });
        bRecord.addActionListener(e -> {
        });
        bCategory.addActionListener(e -> {
        });
        bReport.addActionListener(e -> {
        });
        bConfig.addActionListener(e -> {
        });
        bBackup.addActionListener(e -> {
        });
        bRecover.addActionListener(e -> {
        });
    }
}

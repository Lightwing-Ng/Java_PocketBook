package gui.model;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.ArrayList;
import java.util.List;

public class CategoryComboxModel implements ComboBoxModel<String> {
    private List<String> cs = new ArrayList<>();
    // 保存选中
    private String c;

    public CategoryComboxModel() {
        cs.add("餐饮");
        cs.add("交通");
        cs.add("话费");
        cs.add("住宿");
        c = cs.get(0);
    }

    @Override
    public Object getSelectedItem() {
        return c;
    }

    @Override
    public int getSize() {
        return cs.size();
    }

    @Override
    public String getElementAt(int index) {
        return cs.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        c = (String) anItem;
    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }
}

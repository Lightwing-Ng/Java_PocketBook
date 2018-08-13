package service;

import dao.CategoryDAO;
import dao.RecordDAO;
import entity.Category;
import entity.Record;

import java.util.List;

public class CategoryService {
    private CategoryDAO categoryDAO = new CategoryDAO();
    private RecordDAO recordDAO = new RecordDAO();

    /**
     * 得到所有的分类
     *
     * @return
     */
    public List<Category> list() {
        List<Category> cs = categoryDAO.list();
        for (Category c : cs) {
            List<Record> rs = recordDAO.list(c.id);
            c.recordNumber = rs.size();
        }
        // 根据消费记录次数倒序排列。
        cs.sort((o1, o2) -> o2.recordNumber - o1.recordNumber);
        return cs;
    }

    /**
     * 添加
     *
     * @param name
     */
    public void add(String name) {
        Category category = new Category();
        category.setName(name);
        categoryDAO.add(category);
    }

    public void update(int id, String name) {
        Category category = new Category();
        category.setName(name);
        category.setId(id);
        categoryDAO.update(category);
    }

    public void delete(int id) {
        categoryDAO.delete(id);
    }
}

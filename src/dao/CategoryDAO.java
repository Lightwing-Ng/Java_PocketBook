package dao;

import entity.Category;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    /**
     * 返回数据条数
     *
     * @return
     */
    public int getTotal() {
        int total = 0;
        try (Connection conn = DBUtil.getConnection();
             Statement s = conn.createStatement()) {
            String sql = "SELECT count(*) FROM `category`";
            ResultSet rs = s.executeQuery(sql);

            while (rs.next())
                total = rs.getInt(1);
            System.out.println("total:" + total);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    /**
     * 插入数据
     *
     * @param category
     */
    public void add(Category category) {
        String sql = "INSERT INTO `category` VALUES(NULL, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, category.name);
            ps.execute();
            // 获取自增主键
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next())
                category.id = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新记录
     *
     * @param category
     */
    public void update(Category category) {
        String sql = "UPDATE category SET name = ? WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, category.name);
            ps.setInt(2, category.id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除
     *
     * @param id
     */
    public void delete(int id) {
        try (Connection conn = DBUtil.getConnection();
             Statement s = conn.createStatement()) {
            String sql = "DELETE FROM category WHERE id = " + id;
            s.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据id得到数据
     *
     * @param id
     * @return
     */
    public Category get(int id) {
        Category category = null;
        try (Connection conn = DBUtil.getConnection();
             Statement s = conn.createStatement()) {
            String sql = "SELECT * FROM category WHERE id = " + id;
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                category = new Category();
                category.id = id;
                category.name = rs.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    /**
     * 返回所有数据
     *
     * @return
     */
    public List<Category> list() {
        return list(Short.MAX_VALUE);
    }

    /**
     * 分页查询
     *
     * @param count
     * @return
     */
    private List<Category> list(int count) {
        List<Category> list = new ArrayList<>();
        String sql = "SELECT * FROM category ORDER BY id DESC LIMIT ?, ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, 0);
            ps.setInt(2, count);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.id = rs.getInt("id");
                category.name = rs.getString("name");
                list.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

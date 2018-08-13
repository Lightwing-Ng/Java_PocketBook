package dao;

import entity.Record;
import util.DBUtil;
import util.DateUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecordDAO {
    /**
     * 返回数据条数
     *
     * @return
     */
    public int getTotal() {
        int total = 0;
        try (Connection conn = DBUtil.getConnection();
             Statement s = conn.createStatement()) {
            String sql = "SELECT count(*) FROM `record`";
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                total = rs.getInt(1);
            }
            System.out.println("total:" + total);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    /**
     * 插入数据
     *
     * @param record
     */
    public void add(Record record) {
        String sql = "INSERT INTO `config` VALUES(NULL, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, record.spend);
            ps.setInt(2, record.cid);
            ps.setString(3, record.comment);
            // date类型转换
            ps.setDate(4, DateUtil.util2sql(record.date));
            ps.execute();
            // 获取自增主键
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next())
                record.id = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新记录
     *
     * @param record
     */
    public void update(Record record) {
        String sql = "UPDATE config SET `spend` = ?, cid = ?, comment = ?, date = ? WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, record.spend);
            ps.setInt(2, record.cid);
            ps.setString(3, record.comment);
            ps.setDate(4, DateUtil.util2sql(record.date));
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
            String sql = "DELETE FROM record WHERE id = " + id;
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
    public Record get(int id) {
        Record record = null;
        try (Connection conn = DBUtil.getConnection();
             Statement s = conn.createStatement()) {
            String sql = "SELECT * FROM record WHERE id = " + id;
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                record = new Record();
                record.id = id;
                record.spend = rs.getInt("spend");
                record.cid = rs.getInt("cid");
                record.comment = rs.getString("comment");
                record.date = rs.getDate("date");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return record;
    }

    /**
     * 返回所有数据
     *
     * @return
     */
    public List<Record> list() {
        return list(0, Short.MAX_VALUE);
    }

    /**
     * 分页查询
     *
     * @param start
     * @param count
     * @return
     */
    private List<Record> list(int start, int count) {
        List<Record> list = new ArrayList<>();
        String sql = "SELECT * FROM record ORDER BY id DESC LIMIT ?, ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, start);
            ps.setInt(2, count);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Record record = new Record();
                record.id = rs.getInt("id");
                record.spend = rs.getInt("spend");
                record.cid = rs.getInt("cid");
                record.comment = rs.getString("comment");
                record.date = rs.getDate("date");
                list.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 根据分类cid返回消费记录数据
     *
     * @return
     */
    public List<Record> list(int cid) {
        List<Record> list = new ArrayList<>();
        String sql = "SELECT * FROM `record` WHERE cid = ?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, cid);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Record record = new Record();
                record.id = rs.getInt("id");
                record.spend = rs.getInt("spend");
                record.cid = cid;
                record.comment = rs.getString("comment");
                record.date = rs.getDate("date");
                list.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 返回指定日期的记录
     *
     * @param date
     * @return
     */
    private List<Record> list(Date date) {
        List<Record> list = new ArrayList<>();
        String sql = "SELECT * FROM record WHERE date = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, DateUtil.util2sql(date));

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Record record = new Record();
                record.id = rs.getInt("id");
                record.spend = rs.getInt("spend");
                record.cid = rs.getInt("cid");
                record.comment = rs.getString("comment");
                record.date = rs.getDate("date");
                list.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 返回当天的记录
     *
     * @return
     */
    public List<Record> listToday() {
        return list(DateUtil.today());
    }

    /**
     * 返回这个月的记录
     *
     * @return
     */
    public List<Record> listThisMonth() {
        return list(DateUtil.monthBegin(), DateUtil.monthEnd());
    }

    /**
     * 返回某个时间段的记录
     *
     * @param start
     * @param end
     * @return
     */
    private List<Record> list(Date start, Date end) {
        List<Record> list = new ArrayList<>();
        String sql = "SELECT * FROM record WHERE date >= ?, DATE <= ?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, DateUtil.util2sql(start));
            ps.setDate(2, DateUtil.util2sql(end));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Record record = new Record();
                record.id = rs.getInt("id");
                record.spend = rs.getInt("spend");
                record.cid = rs.getInt("cid");
                record.comment = rs.getString("comment");
                record.date = rs.getDate("date");
                list.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

package vn.example.demo1.util;

import com.mysql.cj.util.StringUtils;
import vn.example.demo1.dto.UserDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {
    static String DB_INFO = "jdbc:mysql://localhost:3306/2202";
    static String USER_NAME = "root";
    static String PASS = "20102010";

    public static void create(String sql) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_INFO, USER_NAME, PASS);
        Statement sqlFile = conn.createStatement();
        try {

            System.out.println("SQL:" + sql);
            sqlFile.executeUpdate(sql);


        } finally {
            sqlFile.close();
            conn.close();
        }
    }

    public static List<UserDto> danhSachUser(String key, int page, int perpage) throws SQLException {
        List<UserDto> userDtoList = new ArrayList<>();
        Connection conn = DriverManager.getConnection(DB_INFO, USER_NAME, PASS);
        Statement sqlFile = conn.createStatement();
        try {


            StringBuilder sql = new StringBuilder("SElECT u.* FROM USER u where 1=1 ");
            if (!StringUtils.isNullOrEmpty(key))
                sql.append(" u.USER_NAME LIKE '%")
                        .append(key).append(" %' OR u.FULL_NAME LIKE '%")
                        .append(key).append("%'");

            sql.append(" limit ").append(perpage).append(" offset ").append((page - 1) * perpage);
            ResultSet resultSet = sqlFile.executeQuery(sql.toString());
            while (resultSet != null && resultSet.next()) {
                Long id = resultSet.getLong(1);
                String userName = resultSet.getString(2);
                String fullName = resultSet.getString(4);
                String email = resultSet.getString(5);
                String phone = resultSet.getString(6);
                Integer gender = resultSet.getInt(7);
                Integer status = resultSet.getInt(8);
                String role = resultSet.getString(9);

                userDtoList.add(new UserDto(id,userName,null,fullName,null,email,phone,gender,status,role));
            }
        } finally {
            sqlFile.close();
            conn.close();
        }
        return userDtoList;
    }


    public static UserDto detail(Long id) throws SQLException {
        List<UserDto> userDtoList = new ArrayList<>();
        Connection conn = DriverManager.getConnection(DB_INFO, USER_NAME, PASS);
        Statement sqlFile = conn.createStatement();
        try {


            StringBuilder sql = new StringBuilder("SElECT u.* FROM USER u where id= ");
            sql.append(id);
            ResultSet resultSet = sqlFile.executeQuery(sql.toString());
            while (resultSet != null && resultSet.next()) {

                String userName = resultSet.getString(2);
                String fullName = resultSet.getString(4);
                String email = resultSet.getString(5);
                String phone = resultSet.getString(6);
                Integer gender = resultSet.getInt(7);
                Integer status = resultSet.getInt(8);
                String role = resultSet.getString(9);

                userDtoList.add(new UserDto(id,userName,null,fullName,null,email,phone,gender,status,role));
            }
        } finally {
            sqlFile.close();
            conn.close();
        }
        return userDtoList.get(0);
    }


    public static Long countUser(String key) throws SQLException {
        List<UserDto> userDtoList = new ArrayList<>();
        Connection conn = DriverManager.getConnection(DB_INFO, USER_NAME, PASS);
        Statement sqlFile = conn.createStatement();
        try {


            StringBuilder sql = new StringBuilder("SElECT COUNT(u.id) FROM USER u where 1=1 ");
            if (!StringUtils.isNullOrEmpty(key))
                sql.append(" u.USER_NAME LIKE '%")
                        .append(key).append(" %' OR u.FULL_NAME LIKE '%")
                        .append(key).append("%'");


            ResultSet resultSet = sqlFile.executeQuery(sql.toString());
            while (resultSet != null && resultSet.next()) {
                Long count = resultSet.getLong(1);
                return count;
            }
        } finally {
            sqlFile.close();
            conn.close();
        }
        return 0L;
    }

}

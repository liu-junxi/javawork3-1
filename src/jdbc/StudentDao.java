package jdbc;

import javabean.Student;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class StudentDao {
    public static int insert(Student student) throws IOException, ClassNotFoundException, SQLException {
        //1.读取配置文件中的4个基本信息
        InputStream is = StudentDao.class.getClassLoader().getResourceAsStream("jdbc.properties");

        Properties pros = new Properties();
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");
//        System.out.println(driverClass);

        //2.加载驱动
        Class.forName(driverClass);

        //3.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);

        //4.完成插入
        String sql ="insert into student (id,name,sex)value(?,?,?)";
        PreparedStatement p =conn.prepareStatement(sql);
        p.setInt(1, student.getId());
        p.setString(2,student.getName());
        p.setString(3,student.getSex());

        int rs = p.executeUpdate();

        return rs;
    }
}

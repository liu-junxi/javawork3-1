import javabean.Student;
import jdbc.StudentDao;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

public class TestJDBC {
    @Test
    public void testInsert() throws SQLException, IOException, ClassNotFoundException {
        StudentDao studentDao = new StudentDao();
        Student student1 = new Student();
        student1.setId(3);
        student1.setName("丽丝可");
        student1.setSex("女");

        int res= studentDao.insert(student1);

        if(res>=1){
            System.out.println("插入成功");
        }else {
            System.out.println("插入失败");
        }
    }
}

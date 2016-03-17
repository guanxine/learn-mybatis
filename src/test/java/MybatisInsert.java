import cn.gx.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by guan_x on 2016/3/17.
 */
public class MybatisInsert {

    @Test
    public void before(){

    }
    public static void main(String args[]) throws IOException {



        //Create a new student object
        Student student = new Student("Mohammad","It", 80, 984803322, "Mohammad@gmail.com" );

        //Insert student data
        session.insert("Student.insert", student);
        System.out.println("record inserted successfully");
        session.commit();
        session.close();

    }
}

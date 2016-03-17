import cn.gx.Student;
import mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Created by guan_x on 2016/3/17.
 */
public class MybatisCURDByAnnotations {

    private SqlSession session;
    private StudentMapper studentMapper;
    @Before
    public void before() throws IOException {
        Reader reader = Resources.getResourceAsReader("SqlMapConfigAnnotations.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        session = sqlSessionFactory.openSession();
        studentMapper=session.getMapper(StudentMapper.class);
    }

    @Test
    public void testInsert(){

        //Create a new student object
        Student student = new Student("gx","It", 80, 984803322, "Mohammad@gmail.com" );

        //Insert student data
        studentMapper.insert(student);
        System.out.println("record inserted successfully");
        session.commit();
        session.close();
    }

    @Test
    public void testSelectAll(){
        List<Student> student =studentMapper.getAll();

        student.forEach(st->System.out.println(st.toString()));

        System.out.println("Records Read Successfully ");
        session.commit();
        session.close();
    }

    @Test
    public void testGetById(){
        Student s = studentMapper.getById(3);
        System.out.println(s.toString());
        System.out.println("Records Read Successfully ");
        session.commit();
        session.close();
    }

    @Test
    public void testUpdate(){
        //select a particular student using id
        Student student = studentMapper.getById(1);
        System.out.println("Current details of the student are" );
        System.out.println(student.toString());

        //Set new values to the mail and phone number of the student
        student.setEmail("sfsdf@yahoo.com");
        student.setPhone(90000000);


        //Update the student record
        studentMapper.update(student);
        System.out.println("Record updated successfully");
        session.commit();
        //session.close();

        //verifying the record
        Student std = studentMapper.getById(1);
        System.out.println("Details of the student after update operation" );
        System.out.println(std.toString());
        session.commit();
        session.close();


    }

    @Test
    public void deleteByID(){


        System.out.println("====================delete======");
        studentMapper.delete(4);
        session.commit();
        session.commit();
    }
}

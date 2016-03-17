import cn.gx.Student;
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
public class MybatisCURDByXML {

    private SqlSession session;
    @Before
    public void before() throws IOException {
        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        session = sqlSessionFactory.openSession();
    }

    @Test
    public void testInsert(){

        //Create a new student object
        Student student = new Student("guanxin","It", 80, 984803322, "Mohammad@gmail.com" );

        //Insert student data
        session.insert("Student.insert", student);
        System.out.println("record inserted successfully");
        session.commit();
        session.close();
    }

    @Test
    public void testSelectAll(){
        List<Student> student = session.selectList("Student.getAll");

        student.forEach(st->System.out.println(st.toString()));

        System.out.println("Records Read Successfully ");
        session.commit();
        session.close();
    }

    @Test
    public void testGetById(){
        Student s = session.selectOne("Student.getById",2);
        System.out.println(s.toString());
        System.out.println("Records Read Successfully ");
        session.commit();
        session.close();
    }

    @Test
    public void testUpdate(){
        //select a particular student using id
        Student student = (Student) session.selectOne("Student.getById", 1);
        System.out.println("Current details of the student are" );
        System.out.println(student.toString());

        //Set new values to the mail and phone number of the student
        student.setEmail("sunyu@yahoo.com");
        student.setPhone(90000000);


        //Update the student record
        session.update("Student.update",student);
        System.out.println("Record updated successfully");
        session.commit();
        //session.close();

        //verifying the record
        Student std = (Student) session.selectOne("Student.getById", 1);
        System.out.println("Details of the student after update operation" );
        System.out.println(std.toString());
        session.commit();
        session.close();


    }

    @Test
    public void deleteByID(){
        //Delete operation
        List<Student> student = session.selectList("Student.getAll");
        student.forEach(st -> System.out.println(st.toString()));

        System.out.println("====================delete======");
        session.delete("Student.deleteById", 2);
        session.commit();
        student = session.selectList("Student.getAll");
        student.forEach(st -> System.out.println(st.toString()));

        session.close();
        System.out.println("Record deleted successfully");
    }

    @Test
    public void callById(){

        //select a particular student  by  id


        Student s = (Student) session.selectOne("Student.callById", 3);
        System.out.println(s.toString());
    }

    @Test
    public void getStudentByName(){
        Student stud = new Student();
        stud.setName("baijuan");
        Student student = session.selectOne("Student.getStudentByName", stud);

        System.out.println(student.toString());
    }
}

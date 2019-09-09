import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.example.BlogMapper;
import org.mybatis.example.bean.Blog;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by guanxine on 18-12-29.
 */
public class Demo {

    private final SqlSessionFactory sqlSessionFactory;

    public Demo() throws IOException {
        String resource = "org/mybatis/example/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }

    public Blog getByOld(int id) {
        SqlSession sqlSession =
                this.sqlSessionFactory.openSession();

        try {
            Blog o = (Blog)sqlSession.selectOne("org.mybatis.example.BlogMapper.selectBlog", id);
            return o;
        }
        finally {
            sqlSession.close();
        }
    }

    public Blog get(int id) {
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        try {
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            return mapper.select(id);
        }
        finally {
            sqlSession.close();
        }
    }

    public static void main(String[] args) throws IOException {
        Demo demo = new Demo();
        Blog byOld = demo.getByOld(1);
        System.out.println(byOld);

        Blog blog = demo.get(1);
        System.out.println(blog);
    }
}

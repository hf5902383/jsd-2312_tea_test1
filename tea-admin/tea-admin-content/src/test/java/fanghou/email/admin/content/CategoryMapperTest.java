package fanghou.email.admin.content;

import fanghou.email.admin.content.dao.mapper.CategoryMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


@SpringBootTest
public class CategoryMapperTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private CategoryMapper categoryMapper;



    @Test
    public void testSQLConnection(){
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(connection);

    }

    @Test
    public void testCategoryMapper(){
        Integer count = categoryMapper.countCategoryByName("ad");
        System.out.println(count);
    }

}

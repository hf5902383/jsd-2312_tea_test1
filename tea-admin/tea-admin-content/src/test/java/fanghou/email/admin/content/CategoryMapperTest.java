package fanghou.email.admin.content;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import fanghou.email.admin.content.dao.mapper.CategoryMapper;
import fanghou.email.admin.content.pojo.po.CategoryPO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import javax.sql.DataSource;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    //老方法mapper添加数据
    @Test
    public void testCategoryMapper(){
        Integer count = categoryMapper.countCategoryByName("ad");
        System.out.println(count);
    }

    @Test
    public void testCategoryMapperPlusC(){
        CategoryPO categoryPO = new CategoryPO();
        categoryPO.setName("sdgundom2");
        categoryMapper.insert(categoryPO);

    }

    @Test
    public void testCategoryMapperPlusR(){
        CategoryPO categoryPO = categoryMapper.selectById(1);
        System.out.println("id = " + categoryPO);
        System.out.println("----------------------");

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("name","sdgundom");
        List list = categoryMapper.selectList(wrapper);
        System.out.println(list);
        System.out.println("----------------------");


        Map<String, Object> wrapperMap = new HashMap<>();
        wrapperMap.put("name","sdgundom2");
        List<CategoryPO> categoryPOS = categoryMapper.selectByMap(wrapperMap);
        System.out.println(categoryPOS);
        System.out.println("----------------------");

        QueryWrapper wrapper1 = new QueryWrapper();
        wrapper1.eq("name","sdgundom");
        Integer integer = categoryMapper.selectCount(wrapper1);
        System.out.println(integer);


    }

    @Test
    public void testCategoryMapperPlusU(){
        CategoryPO categoryPO = new CategoryPO();
        categoryPO.setName("sdgundom-setbyName");
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("name","sdgundom");
        int update = categoryMapper.update(categoryPO, updateWrapper);
        System.out.println(update);
        System.out.println("_______________");

        CategoryPO categoryUpdateIdPO = new CategoryPO();
        categoryUpdateIdPO.setId(1L);
        categoryUpdateIdPO.setName("SD gundom123");
        int i = categoryMapper.updateById(categoryUpdateIdPO);
        System.out.println(i);
    }

    @Test
    public void testCategoryMapperPlusD(){
        CategoryPO categoryPO = categoryMapper.selectById(1);
        System.out.println("id = " + categoryPO);

    }

    @Test
    public void testReflection() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = Class.forName("fanghou.email.admin.content.pojo.po.CategoryPO");
        //类名
        String name = aClass.getName();
        System.out.println("aClass.getName()" +name);

        //Constructors
        Constructor<?>[] constructors = aClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("aClass.getConstructors()" + constructor);
        }

        //FieldNames
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("aClass.getDeclaredFields()"+ declaredField);
        }


        Object o = aClass.newInstance();

        Method setName = aClass.getDeclaredMethod("setName", String.class);
        setName.invoke(o,"gg");

        Method getName = aClass.getDeclaredMethod("getName");
        Object invoke = getName.invoke(o);
        System.out.println(invoke);

    }

}

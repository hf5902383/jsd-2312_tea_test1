package fanghou.email.admin.content.service.impl;

import fanghou.email.admin.content.dao.repository.ICategoryRepository;
import fanghou.email.admin.content.pojo.param.CategoryAddParam;
import fanghou.email.admin.content.pojo.po.CategoryPO;
import fanghou.email.admin.content.service.ICategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public void add(CategoryAddParam categoryAddParam) {
        String name = categoryAddParam.getName();

        //使用plus实现：避免耦合；封装到Repository中
//        QueryWrapper queryWrapper = new QueryWrapper();
//        queryWrapper.eq("name",name);
//        Integer count = categoryMapper.selectCount(queryWrapper);

        Integer count = categoryRepository.countCategoryByName(name);

        //使用mybatis实现：
        //Integer count = categoryMapper.countCategoryByName(name);

        //todo how to boolean equal
        if (count == 0){
            //todo save in database
            CategoryPO categoryPO = new CategoryPO();
            BeanUtils.copyProperties(categoryAddParam, categoryPO);
            categoryRepository.save(categoryPO);
            //避免耦合封装到categoryRepository中
//            categoryMapper.insert(categoryPO);
            //使用Mapper实现业务，用MybatisPlus 实现
            //categoryMapper.save(categoryPO);
        }else{
            //todo return exception
            throw new RuntimeException("Category already Exists");
        }
    }
}

package fanghou.email.admin.content.service.impl;

import fanghou.email.admin.content.dao.mapper.CategoryMapper;
import fanghou.email.admin.content.pojo.param.CategoryAddParam;
import fanghou.email.admin.content.pojo.po.CategoryPO;
import fanghou.email.admin.content.service.ICategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public void add(CategoryAddParam categoryAddParam) {
        String name = categoryAddParam.getName();
        Integer count = categoryMapper.countCategoryByName(name);

        if (count == 0){
            //todo save in database
            CategoryPO categoryPO = new CategoryPO();
            categoryMapper.save(categoryPO);
        }else{
            throw new RuntimeException("Category already Exists");
        }
    }
}

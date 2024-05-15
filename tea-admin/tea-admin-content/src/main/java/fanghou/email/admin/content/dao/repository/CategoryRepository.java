package fanghou.email.admin.content.dao.repository;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import fanghou.email.admin.content.dao.mapper.CategoryMapper;
import fanghou.email.admin.content.pojo.po.CategoryPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class CategoryRepository implements ICategoryRepository{

    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public Integer countCategoryByName(String name) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name",name);
        Integer integer = categoryMapper.selectCount(queryWrapper);
        return integer;
    }

    @Override
    public void save(CategoryPO categoryPO) {
        categoryMapper.insert(categoryPO);
    }
}

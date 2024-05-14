package fanghou.email.admin.content.dao.mapper;

import fanghou.email.admin.content.pojo.po.CategoryPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper {
    Integer countCategoryByName(String name);

    void save(CategoryPO categoryPO);
}

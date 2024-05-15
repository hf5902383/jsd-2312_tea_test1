package fanghou.email.admin.content.dao.mapper;

import fanghou.email.admin.content.pojo.po.CategoryPO;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Mapper
public interface CategoryMapper extends BaseMapper<CategoryPO>{
    Integer countCategoryByName(String name);

    //void save(CategoryPO categoryPO);
}

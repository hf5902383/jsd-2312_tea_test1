package fanghou.email.admin.content.dao.repository;


import fanghou.email.admin.content.pojo.po.CategoryPO;

public interface ICategoryRepository {
    Integer countCategoryByName(String name);

    void save(CategoryPO categoryPO);

    CategoryPO getCategoryById(Long categoryId);
}

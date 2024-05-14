package fanghou.email.service;

import fanghou.email.pojo.vo.ArticleVO;
import fanghou.email.pojo.vo.CategoryItemVO;

import java.util.List;

public interface IArticleService {
    List<CategoryItemVO> listArticleByCategoryId(Long categoryId);

    ArticleVO getArticleById(Long articleId);
}

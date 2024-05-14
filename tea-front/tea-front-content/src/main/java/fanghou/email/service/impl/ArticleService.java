package fanghou.email.service.impl;

import fanghou.email.pojo.vo.ArticleVO;
import fanghou.email.pojo.vo.CategoryItemVO;
import fanghou.email.service.IArticleService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ArticleService implements IArticleService {

    @Override
    public List<CategoryItemVO> listArticleByCategoryId(Long categoryId) {
        return null;
    }

    @Override
    public ArticleVO getArticleById(Long articleId) {
        return null;
    }
}

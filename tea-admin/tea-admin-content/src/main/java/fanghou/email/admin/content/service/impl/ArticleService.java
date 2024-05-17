package fanghou.email.admin.content.service.impl;

import fanghou.email.admin.content.dao.repository.IArticleRepository;
import fanghou.email.admin.content.dao.repository.ICategoryRepository;
import fanghou.email.admin.content.pojo.param.ArticleAddParam;
import fanghou.email.admin.content.pojo.po.ArticleDetailPO;
import fanghou.email.admin.content.pojo.po.ArticlePO;
import fanghou.email.admin.content.pojo.po.CategoryPO;
import fanghou.email.admin.content.service.IArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ArticleService implements IArticleService {

    @Autowired
    private IArticleRepository articleRepository;

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public void add(ArticleAddParam articleAddParam) {
    }

    @Override
    public void countArticleByTitle(ArticleAddParam articleAddParam) {
        String title = articleAddParam.getTitle();
        Integer countTitle = articleRepository.countArticleByTitle(title);
        System.out.println("Count = " + countTitle);

        if (countTitle ==0){
            //标题不为重复；判断类别是否存在：
            Long categoryId = articleAddParam.getCategoryId();
            CategoryPO categoryPO = categoryRepository.getCategoryById(categoryId);

            if (categoryPO == null){
                throw new RuntimeException("文章类别发送失败");
            }else{
                Integer enable = categoryPO.getEnable();
                if (enable == 1){
                    //todo 文章类别启用
                    ArticlePO articlePO = new ArticlePO();
                    BeanUtils.copyProperties(articlePO,articleAddParam);
                    Integer countArticle = articleRepository.save(articlePO);

                    if (countArticle != 1){
                        throw new RuntimeException("文章发布异常");
                    }

                    ArticleDetailPO articleDetailPO = new ArticleDetailPO();
                    articleDetailPO.setArticleId(articlePO.getId());
                    articleDetailPO.setDetail(articleAddParam.getDetail());
                    Integer saveDetailCount = articleRepository.saveDetail(articleDetailPO);

                    if (saveDetailCount != 1){
                        throw new RuntimeException("文章详情发布异常");
                    }


                }else{
                    throw new RuntimeException("文章类别未启用");
                }
            }

        }
    }
}

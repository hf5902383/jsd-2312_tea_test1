package fanghou.email.admin.content.dao.repository;

import fanghou.email.admin.content.pojo.po.ArticleDetailPO;
import fanghou.email.admin.content.pojo.po.ArticlePO;

public interface IArticleRepository {

    Integer countArticleByTitle(String title);

    Integer save(ArticlePO articlePO);

    Integer saveDetail(ArticleDetailPO articleDetailPO);
}

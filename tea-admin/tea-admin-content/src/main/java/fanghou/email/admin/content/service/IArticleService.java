package fanghou.email.admin.content.service;

import fanghou.email.admin.content.pojo.param.ArticleAddParam;

public interface IArticleService {
    void add(ArticleAddParam articleAddParam);

    void countArticleByTitle(ArticleAddParam articleAddParam);
}

package fanghou.email.admin.content.dao.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import fanghou.email.admin.content.dao.mapper.ArticleDetailMapper;
import fanghou.email.admin.content.dao.mapper.ArticleMapper;
import fanghou.email.admin.content.pojo.po.ArticleDetailPO;
import fanghou.email.admin.content.pojo.po.ArticlePO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleRepository implements IArticleRepository{
    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ArticleDetailMapper articleDetailMapper;

    @Override
    public Integer countArticleByTitle(String title) {

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("title", title);
        Integer count = articleMapper.selectCount(queryWrapper);
        return count;
    }

    @Override
    public Integer save(ArticlePO articlePO) {
        int insert = articleMapper.insert(articlePO);
        return insert;
    }

    @Override
    public Integer saveDetail(ArticleDetailPO articleDetailPO) {
        int insert = articleDetailMapper.insert(articleDetailPO);
        return insert;
    }
}



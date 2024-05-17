package fanghou.email.admin.content.controller;

import fanghou.email.admin.content.pojo.param.ArticleAddParam;
import fanghou.email.admin.content.service.IArticleService;
import fanghou.email.web.Enums.ServiceCodeEnum;
import fanghou.email.web.JsonResult;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * /article
 * 文章接口
 *
 * add 方法 (CategoryAddParam: name）
 */
@RequestMapping("/article")
@RestController
@Slf4j
@Api(tags = "文章接口")
@Validated
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    /**
     * 验证：
     * 1.类别id
     * 2.文章标题 必须
     * 3.内容 必须
     * 增加文章业务逻辑：
     * 1. 管理员文章不能重复：
     * 2. 判断类别id是否存在； 必须传
     * 3.判断类别id是否存在，如不存在报错
     * 4. 保存文章。
     * @param articleAddParam
     * @return
     */

    @PostMapping("/add")
    public JsonResult add(@Validated @RequestBody ArticleAddParam articleAddParam){

        //1.判断文章不能重复：
        articleService.countArticleByTitle(articleAddParam);

        articleService.add(articleAddParam);
        return JsonResult.success();
    }


}

package fanghou.email.admin.content.controller;

import fanghou.email.admin.content.pojo.param.ArticleAddParam;
import fanghou.email.admin.content.service.IArticleService;
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

    @PostMapping("/add")
    public JsonResult add(@Validated @RequestBody ArticleAddParam articleAddParam){
        articleService.add(articleAddParam);
        return JsonResult.success();
    }
}

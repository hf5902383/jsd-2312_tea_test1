package fanghou.email.controller;

import fanghou.email.pojo.vo.ArticleVO;
import fanghou.email.pojo.vo.CategoryItemVO;
import fanghou.email.service.IArticleService;
import fanghou.email.web.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/article")
@Validated
@Api(tags = "文章接口")

public class ArticleController {

    @Autowired
    private IArticleService articleService;

    /**
     * 功能：通过类别ID 查询文章列表；list
     * 地址：/list/{categoryId}
     *
     * Type类型： Long Name：categoryId
     *
     * 方法名称：listArticleByCategoryId
     *
     * @return JsonResult
     * */
    @ApiOperation("文章列表")
    @GetMapping("/list/{categoryId}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "categoryId",value = "类别类型",required = true, dataType = "Long")
    })
    public JsonResult listArticleByCategoryId(@PathVariable("categoryId") Long categoryId){
        log.info("show categoryId",categoryId);
        List<CategoryItemVO> list =articleService.listArticleByCategoryId(categoryId);
        return JsonResult.success(list);
    }



    /**
     * 功能：通过文章ID 查询详细文章；具体
     * 地址：/list
     *
     * Type类型： Long Name：articleId
     *
     * 方法名称：getArticleById
     * @return JsonResult
     * */
    @GetMapping("/list")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "articleId", value = "文章类型", required = true,dataType = "Long")
    })
    @ApiOperation("具体文章")
    public JsonResult getArticleById(@RequestParam() Long articleId){
        log.info("show articleId",articleId);
        ArticleVO articleVO = articleService.getArticleById(articleId);
        return JsonResult.success(articleVO);
    }


}

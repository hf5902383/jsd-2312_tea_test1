package fanghou.email.controller;

import fanghou.email.pojo.vo.CategoryItemVO;
import fanghou.email.service.ICategoryService;
import fanghou.email.web.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/categories")
@Validated
@Api(tags = "类别接口")
public class CategoryController {
    @Autowired
    @Resource
    private ICategoryService categoryService;


    @ApiOperation("类别列表")
    @GetMapping("/list")
    public JsonResult list(){
        List<CategoryItemVO> list = categoryService.list();
        return JsonResult.success(list);
    }

}

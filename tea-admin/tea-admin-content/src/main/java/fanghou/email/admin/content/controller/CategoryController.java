package fanghou.email.admin.content.controller;

import fanghou.email.admin.content.pojo.param.CategoryAddParam;
import fanghou.email.admin.content.service.ICategoryService;
import fanghou.email.web.JsonResult;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("类别接口")
@Slf4j
@RequestMapping("/categories")
@RestController
@Validated
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;


    @PostMapping("/add")
    public JsonResult add(@Validated @RequestBody CategoryAddParam categoryAddParam){
        categoryService.add(categoryAddParam);
        return JsonResult.success();
    }

}

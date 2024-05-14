package fanghou.email.admin.content.pojo.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ArticleAddParam implements Serializable {

    //创建时间 需要前端传么?不需要
    //文章id 不需要 数据库自增
    //作者id 不是业务必须
    //文章类型 不是业务必须

    @ApiModelProperty("类别id")
    Long categoryId;

    @ApiModelProperty("文章标题")
    String title;

    @ApiModelProperty("文章图片")
    String imgUrl;

    @ApiModelProperty("文章详情")
    String detail;


}


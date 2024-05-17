package fanghou.email.admin.content.pojo.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ArticleAddParam implements Serializable {

    //创建时间 需要前端传么?不需要
    //文章id 不需要 数据库自增
    //作者id 不是业务必须
    //文章类型 不是业务必须

    @ApiModelProperty("类别id")
    @NotNull(message = "类别Id不能为空")
    Long categoryId;

    @ApiModelProperty("文章标题")
    @NotEmpty(message = "文章标题不能为空")
    String title;

    @ApiModelProperty("文章详情")
    @Size(min = 1, max = 500, message = "文章详情不能多余500个字且不能为空")
    String detail;


}


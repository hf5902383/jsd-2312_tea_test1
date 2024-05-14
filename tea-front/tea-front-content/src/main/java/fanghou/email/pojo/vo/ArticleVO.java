package fanghou.email.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ArticleVO implements Serializable {
    @ApiModelProperty("文章ID")
    private Long articleId;
    @ApiModelProperty("文章标题")
    private String articleTitle;
    @ApiModelProperty("文章图片")
    private String imgUrl;
    @ApiModelProperty("文章内容")
    private String articleContent;
}

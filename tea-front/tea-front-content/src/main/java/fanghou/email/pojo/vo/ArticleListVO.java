package fanghou.email.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ArticleListVO implements Serializable {
    @ApiModelProperty("类别ID")
    private Long categoryId;
    @ApiModelProperty("文章标题")
    private String articleTitle;
    @ApiModelProperty("文章图片")
    private String imgUrl;
    @ApiModelProperty("文章摘要")
    private String articleDigest;

}

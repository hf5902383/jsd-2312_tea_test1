package fanghou.email.admin.content.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("content_article_detail")
public class ArticleDetailPO implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long articleId;

    private String detail;

}

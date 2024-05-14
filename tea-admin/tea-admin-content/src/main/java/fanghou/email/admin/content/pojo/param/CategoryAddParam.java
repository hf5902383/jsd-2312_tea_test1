package fanghou.email.admin.content.pojo.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class CategoryAddParam implements Serializable {

    @ApiModelProperty("类别名称")
    @NotNull(message = "category cannot be empty")
    @Size(min = 1, max = 4, message = "category cannot be too long")
    private String name;





}

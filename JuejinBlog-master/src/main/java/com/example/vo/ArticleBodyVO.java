package com.example.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("文章体（视图）")
public class ArticleBodyVO {
    @ApiModelProperty("文章内容")
    private String content;
}

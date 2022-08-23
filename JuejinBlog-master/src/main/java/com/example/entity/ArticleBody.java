package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("文章体")
public class ArticleBody {
    @ApiModelProperty("文章体主键")
    @TableId(type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("文章内容md格式")
    private String content;

    @ApiModelProperty("文章内容html格式")
    private String contentHtml;

    @ApiModelProperty("文章主键id")
    private Long articleId;
}

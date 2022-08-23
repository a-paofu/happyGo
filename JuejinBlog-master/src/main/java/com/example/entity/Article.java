package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("文章")
public class Article {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("文章标题")
    private String title;

    @ApiModelProperty("文章概要")
    private String summary;

    @ApiModelProperty("文章体的主键id")
    private Long bodyId;
}

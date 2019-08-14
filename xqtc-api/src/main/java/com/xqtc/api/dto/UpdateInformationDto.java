package com.xqtc.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author zhangw
 * @since 2019-07-23
 */
@Data
public class UpdateInformationDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 资讯id
     */
    @ApiModelProperty(value = "资讯id  必传", required = true, example = "0")
    @NotNull(message = "资讯id不能为空")
    private Integer informationId;

    /**
     * 作者
     */
    @ApiModelProperty(value = "作者", example = "光头强")
    private String author;

    /**
     * 资讯描述
     */
    @ApiModelProperty(value = "资讯描述", example = "描述")
    private String informationDesc;

    /**
     * 资讯类型(0:行业资讯 1:公司资讯)
     */
    @ApiModelProperty(value = "资讯类型(0:行业资讯 1:公司资讯  )", example = "0")
    private Integer informationType;

    /**
     * 标题
     */
    @ApiModelProperty(value = "标题 ", example = "标题")
    private String title;

    /**
     * 资讯内容
     */
    @ApiModelProperty(value = "资讯内容", example = "资讯内容")
    private String content;

    /**
     * 资讯配图地址
     */
    @ApiModelProperty(value = "资讯配图地址", example = "资讯配图地址")
    private String pictureUrl;

    /**
     * 资讯状态(0:未发布 1:已发布 )
     */
    @ApiModelProperty(value = "资讯状态(0:未发布 1:已发布 )", example = "1")
    private Integer informationState;


    /**
     * 是否删除 0正常 1删除
     */
    @ApiModelProperty(value = "是否删除 0正常 1删除", example = "1")
    private Integer isDeleted;

}

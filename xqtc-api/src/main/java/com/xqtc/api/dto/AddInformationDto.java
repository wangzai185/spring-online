package com.xqtc.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
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
@RequiredArgsConstructor
public class AddInformationDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 资讯id
     */
    private Integer informationId;

    /**
     * 作者
     */
    @ApiModelProperty(value = "作者", required = false, example = "光头强")
    private String author;

    /**
     * 资讯描述
     */
    @ApiModelProperty(value = "资讯描述", required = false, example = "描述")
    private String informationDesc;

    /**
     * 资讯类型(0:行业资讯 1:公司资讯)
     */
    @ApiModelProperty(value = "资讯类型(0:行业资讯 1:公司资讯  必传)", required = true, example = "0")
    @NotNull(message = "资讯类型不能为空")
    private Integer informationType;

    /**
     * 标题
     */
    @ApiModelProperty(value = "标题 必传", required = true, example = "标题")
    @NotBlank(message = "标题为空")
    private String title;

    /**
     * 资讯内容
     */
    @ApiModelProperty(value = "资讯内容 必传", required = true, example = "资讯内容")
    @NotBlank(message = "资讯内容")
    private String content;

    /**
     * 资讯配图地址
     */
    @ApiModelProperty(value = "资讯配图地址 必传", required = true, example = "资讯配图地址")
    @NotBlank(message = "资讯配图地址")
    private String pictureUrl;

    /**
     * 资讯状态(0:未发布 1:已发布 )
     */
    private Integer informationState;


    /**
     * 是否删除 0正常 1删除
     */
    private Integer isDeleted;






}

package com.xqtc.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhangw
 * @since 2019-07-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@RequiredArgsConstructor
public class JhkjInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 资讯id
     */
    @TableId(value = "information_id", type = IdType.AUTO)
    private Integer informationId;

    /**
     * 作者
     */
    private String author;

    /**
     * 资讯描述
     */
    private String informationDesc;

    /**
     * 资讯类型(0:行业资讯 1:公司资讯)
     */
    private Integer informationType;

    /**
     * 标题
     */
    private String title;

    /**
     * 资讯内容
     */
    private String content;

    /**
     * 资讯配图地址
     */
    private String pictureUrl;

    /**
     * 资讯状态(0:未发布 1:已发布 )
     */
    private Integer informationState;

    /**
     * 发布日期
     */
    private Date publishTime;

    /**
     * 是否删除 0正常 1删除
     */
    private Integer isDeleted;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;


}

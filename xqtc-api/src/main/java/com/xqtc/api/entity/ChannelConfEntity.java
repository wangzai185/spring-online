package com.xqtc.api.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhangw
 * @since 2019-07-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("channel_conf")
public class ChannelConfEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "cc_id", type = IdType.AUTO)
    private Integer ccId;

    private String channelName;

    private Integer costType;

    private Integer chargeType;

    private Integer payType;

    private Integer salesStart;

    private Integer salesEnd;

    private Integer salesIncrement;

    private String url;

    @TableField("secKey")
    private String secKey;

    private String banner;

    private Long createTime;

    private Long updateTime;

    private String creator;

    private String updator;

    private String remark;

    private Integer status;


}

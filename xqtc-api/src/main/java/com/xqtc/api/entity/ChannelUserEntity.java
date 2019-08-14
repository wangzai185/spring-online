package com.xqtc.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * channel_user
 * @author 
 */
@Data
@TableName("channel_user")
public class ChannelUserEntity implements Serializable {

    @TableId("cu_id")
    private Long cuId;

    private Integer channelId;

    private String openId;

    private Long unniId;

    private String phone;

    private Long xcoId;

    private Integer state;

    private Long createTime;

    private Long updateTime;

    private String creator;

    private String updator;

    private String remark;

    private static final long serialVersionUID = 1L;
}
package com.xqtc.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *    合作方信息
 * </p>
 *
 * @author zhangw
 * @since 2019-07-14
 */
@Data
@TableName("xqtc_business")
public class BusinessEntity  implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "business_id", type = IdType.AUTO)
    private Integer businessId;

    /**
     * 商家名称
     */
    private String businessName;

    /**
     * 公钥
     */
    private String accessKey;

    /**
     * 秘钥
     */
    private String secretKey;

    /**
     * 备注
     */
    private String businessRemarks;

    /**
     * 状态 1 启用 2 禁用
     */
    private Boolean businessState;

    /**
     * 修改时间
     */
    private LocalDateTime modifyTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 是否删除 0正常 1删除
     */
    private Boolean isDeleted;


}

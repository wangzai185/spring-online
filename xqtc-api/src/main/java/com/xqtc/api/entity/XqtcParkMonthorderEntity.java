package com.xqtc.api.entity;

import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2019-07-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class XqtcParkMonthorderEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("parkId")
    private Long parkId;

    @TableField("monthOrder")
    private Integer monthOrder;


}

package org.hmsystem.server.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 新建实体类用于单据流转中的药品详情传送
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "Medicine对象", description = "")
public class Medicine {
    @ApiModelProperty(value = "药品编号")
    private Integer medicineNum;
    @ApiModelProperty(value = "药品价格")
    private Float medicinePrice;
    @ApiModelProperty(value = "存储数量")
    private Integer storageNumber;
    @ApiModelProperty(value = "药品名")
    private String medicineName;
}

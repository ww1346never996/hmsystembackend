package org.hmsystem.server.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;



/**
 * 新建实体类用于警戒库存
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "AlarmStorage对象", description = "")
public class AlarmStorage {
    @ApiModelProperty(value = "药品编号")
    private int medicineNum;
    @ApiModelProperty(value = "药品名称")
    private String medicineName;
    @ApiModelProperty(value = "库存状态")
    private boolean storageState;
    @ApiModelProperty(value = "警戒库存量")
    private int AlarmStorageNum;
}

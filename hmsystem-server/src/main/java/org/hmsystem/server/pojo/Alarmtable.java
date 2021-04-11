package org.hmsystem.server.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author ww1346
 * @since 2021-03-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "Alarmtable对象", description = "")
public class Alarmtable implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "药品编号")
    private Integer medicinenum;

    @ApiModelProperty(value = "警戒库存")
    private Integer alarmstoragenum;


}

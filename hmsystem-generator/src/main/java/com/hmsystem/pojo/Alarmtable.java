package com.hmsystem.pojo;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
@ApiModel(value="Alarmtable对象", description="")
public class Alarmtable implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer medicinenum;

    private Integer alarmstoragenum;


}

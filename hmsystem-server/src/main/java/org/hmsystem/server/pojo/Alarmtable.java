package org.hmsystem.server.pojo;

import io.swagger.annotations.ApiModel;
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

    private Integer medicinenum;

    private Integer alarmstoragenum;


}

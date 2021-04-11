package org.hmsystem.server.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
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
@ApiModel(value="Docinfotable对象", description="")
public class Docinfotable implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "单据详情编号")
    private Integer docinfonum;

    @ApiModelProperty(value = "单据编号")
    private Integer docnum;

    @ApiModelProperty(value = "药品编号")
    private Integer medicinenum;

    @ApiModelProperty(value = "药品数量")
    private Integer medicinenumber;


}

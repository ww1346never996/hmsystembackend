package org.hmsystem.server.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@ApiModel(value = "Medicinetable对象", description = "")
public class Medicinetable implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "药品编号")
    private Integer medicinenum;

    @ApiModelProperty(value = "药品名")
    private String medicinename;

    @ApiModelProperty(value = "制造商名")
    private String manufacturername;

    @ApiModelProperty(value = "入库日期")
    private LocalDateTime storagedate;

    @ApiModelProperty(value = "进货价格")
    private Float purchaseprice;

    @ApiModelProperty(value = "库存容量")
    private Integer storagenum;
}

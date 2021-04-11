package org.hmsystem.server.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@ApiModel(value = "Documenttable对象", description = "")
public class Documenttable implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "单据编号")
    private Integer docnum;

    @ApiModelProperty(value = "单据标识")
    private Integer docid;

    @ApiModelProperty(value = "单据状态")
    private Integer docstate;

    @ApiModelProperty(value = "单据创建人")
    private String doccreator;

    @ApiModelProperty(value = "单据创建时间")
    private LocalDateTime doccreatedate;


}

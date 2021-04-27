package org.hmsystem.server.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "Rationinfotable对象", description = "")
public class Rationinfotable implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "配给详情编号")
    private Integer rationinfonum;

    @ApiModelProperty(value = "部门编号")
    private Integer departmentnum;

    @ApiModelProperty(value = "药品编号")
    private Integer medicinenum;

    @ApiModelProperty(value = "配给数量")
    private Integer medicinenumber;

}

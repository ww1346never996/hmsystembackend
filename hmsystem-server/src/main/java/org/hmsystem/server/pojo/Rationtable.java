package org.hmsystem.server.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "Rationtable对象", description = "")
public class Rationtable implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "部门编号")
    private Integer departmentnum;

    @ApiModelProperty(value = "部门名")
    private String departmentname;


}

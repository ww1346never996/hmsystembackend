package org.hmsystem.server.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "Ration对象", description = "")
public class Ration {
    @ApiModelProperty("部门编号")
    Integer departmentNum;
    @ApiModelProperty("部门名称")
    String departmentName;
    @ApiModelProperty("采购列表")
    List<Medicine> medicineList;
}

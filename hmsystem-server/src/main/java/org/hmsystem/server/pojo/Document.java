package org.hmsystem.server.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * 新建实体类用于单据流转
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "Document对象", description = "")
public class Document {
    @ApiModelProperty(value = "文档编号")
    private int docNum;
    @ApiModelProperty(value = "文档分类")
    private int docId;
    @ApiModelProperty(value = "文档状态")
    private int docState;
    @ApiModelProperty(value = "文档创建者")
    private String docCreator;
    @ApiModelProperty(value = "文档创建时间")
    private LocalDateTime docCreateTime;
    @ApiModelProperty(value = "药品详情列表")
    private List<Medicinetable> medicineList;

}

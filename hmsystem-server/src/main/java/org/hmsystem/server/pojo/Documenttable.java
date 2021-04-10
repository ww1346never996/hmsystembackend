package org.hmsystem.server.pojo;

import io.swagger.annotations.ApiModel;
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

    private Integer docnum;

    private Integer docid;

    private Integer docstate;

    private String doccreator;

    private LocalDateTime doccreatedate;


}

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
@ApiModel(value="Manufacturetable对象", description="")
public class Manufacturetable implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer manufacturenum;

    private String manufacturername;


}

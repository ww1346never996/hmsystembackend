package org.hmsystem.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "User对象", description = "")
public class User {
    @ApiModelProperty(value = "id")
    private String username;
    @ApiModelProperty(value = "密码")
    private String userpassword;
    @ApiModelProperty(value = "权限组")
    private Integer useridentity;
    @ApiModelProperty(value = "注册时间")
    private LocalDateTime createdate;
    @ApiModelProperty(value = "用户名")
    private String name;
    @ApiModelProperty(value = "头像")
    private String avatar;

}

package org.hmsystem.server.controller;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.hmsystem.server.pojo.Manufacturetable;
import org.hmsystem.server.pojo.RespBean;
import org.hmsystem.server.service.IManufacturetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ww1346
 * @since 2021-03-29
 */
@RestController
@RequestMapping("/manufacturetable")
public class ManufacturetableController {

    @Autowired
    IManufacturetableService manufacturetableService;

    @ApiOperation(value = "获取制造商信息列表")
    @GetMapping("/manufactureInfo")
    public List<Manufacturetable> getAllList(){
        return manufacturetableService.getManufactureInfo();
    }

    @ApiOperation(value = "添加制造商信息")
    @PostMapping("/insertManufactureInfo")
    public RespBean addManufactureInfo(@RequestBody Manufacturetable manufacturetable){
        if (manufacturetableService.addManufacture(manufacturetable)){
            return RespBean.success("添加成功");
        }else {
            return RespBean.error("添加失败");
        }
    }

    @ApiOperation(value = "删除制造商信息")
    @PostMapping("/deleteManufactureInfo")
    public RespBean deleteManufactureInfo(@RequestParam("manufacturenum") int manufactureNum){
        if (manufactureNum!=0){
            if (manufacturetableService.deleteManufacture(manufactureNum)){
                return RespBean.success("删除成功");
            }else{
                return RespBean.error("删除失败，请检查数据库");
            }
        }else {
            return RespBean.error("未选中正确的项目");
        }
    }

    @ApiOperation(value = "修改制造商信息")
    @PostMapping("/changeManufactureInfo")
    public RespBean changeManufactureInfo(@RequestBody Manufacturetable manufacturetable){
        if (manufacturetableService.changeManufacture(manufacturetable)){
            return RespBean.success("修改成功");
        }else {
            return RespBean.error("修改失败");
        }
    }
}

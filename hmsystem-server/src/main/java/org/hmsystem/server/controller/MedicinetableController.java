package org.hmsystem.server.controller;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.hmsystem.server.pojo.Manufacturetable;
import org.hmsystem.server.pojo.Medicinetable;
import org.hmsystem.server.pojo.RespBean;
import org.hmsystem.server.service.IMedicinetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
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
@RequestMapping("/medicinetable")
public class MedicinetableController {

    @Autowired
    IMedicinetableService medicinetableService;

    @ApiOperation(value = "获取药品信息列表")
    @GetMapping("/medicineInfo")
    public List<Medicinetable> getAllList(){
        return medicinetableService.getMedicineInfo();
    }

    @ApiOperation(value = "添加药品信息")
    @PostMapping("/addMedicine")
    public RespBean addMedicineInfo(@RequestBody Medicinetable medicinetable){
        if (medicinetable!=null){
            medicinetable.setStoragedate(LocalDateTime.now());
            medicinetable.setMedicinenum(null);
            if (medicinetableService.addMedicineInfo(medicinetable)){
                return RespBean.success("添加成功");
            }else {
                return RespBean.error("添加失败");
            }
        }else {
            return RespBean.error("未正确输入");
        }
    }

    @ApiOperation(value = "删除药品信息")
    @PostMapping("/deleteMedicine")
    public RespBean deleteMedicineInfo(@RequestParam("medicinenum") int medicineNum){
        if (medicineNum!=0){
            if (medicinetableService.deleteMedicineInfo(medicineNum)){
                return RespBean.success("删除成功");
            }else {
                return RespBean.error("删除失败");
            }
        }else {
            return RespBean.error("未能正确选中要删除的药品");
        }
    }

    @ApiOperation(value = "更改药品信息")
    @PostMapping("/changeMedicine")
    public RespBean changeMedicineInfo(@RequestBody Medicinetable medicinetable){
        if (medicinetable!=null){
            medicinetable.setStoragedate(LocalDateTime.now());
            if (medicinetableService.changeMedicineInfo(medicinetable)){
                return RespBean.success("修改成功");
            }else {
                return RespBean.error("修改失败");
            }
        }else {
            return RespBean.error("输入不正确");
        }
    }
}

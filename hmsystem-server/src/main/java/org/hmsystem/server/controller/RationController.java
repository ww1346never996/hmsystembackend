package org.hmsystem.server.controller;

import com.baomidou.mybatisplus.extension.api.R;
import io.swagger.annotations.ApiOperation;
import org.hmsystem.server.pojo.*;
import org.hmsystem.server.service.IMedicinetableService;
import org.hmsystem.server.service.IRationinfotableService;
import org.hmsystem.server.service.IRationtableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ration")
public class RationController {

    @Autowired
    IRationtableService rationtableService;
    @Autowired
    IRationinfotableService rationinfotableService;
    @Autowired
    IMedicinetableService medicinetableService;

    @ApiOperation("获取部门配给计划")
    @GetMapping("/getRationList")
    public List<Ration> getRationList() {
        List<Ration> rationList = new ArrayList<>();
        List<Rationtable> rationtableList = rationtableService.getAllList();
        List<Rationinfotable> rationinfotableList = rationinfotableService.getRationInfo();
        List<Medicinetable> medicines = medicinetableService.getMedicineInfo();
        for (int i = 0; i < rationtableList.size(); i++) {
            Ration ration = new Ration();
            List<Medicine> medicineList = new ArrayList<>();
            int rationNum = rationtableList.get(i).getDepartmentnum();
            ration.setDepartmentName(rationtableList.get(i).getDepartmentname());
            ration.setDepartmentNum(rationNum);
            for (int j = 0; j < rationinfotableList.size(); j++) {
                if (rationinfotableList.get(j).getDepartmentnum() == rationNum) {
                    int medicineNum = rationinfotableList.get(j).getMedicinenum();
                    int medicineNumber = rationinfotableList.get(j).getMedicinenumber();
                    for (int k = 0; k < medicines.size(); k++) {
                        if (medicineNum == medicines.get(k).getMedicinenum()) {
                            Medicine medicine = new Medicine();
                            medicine.setMedicineNum(medicineNum);
                            medicine.setMedicineName(medicines.get(k).getMedicinename());
                            medicine.setStorageNumber(medicineNumber);
                            medicine.setMedicinePrice(medicines.get(k).getPurchaseprice());
                            medicineList.add(medicine);
                        }
                    }
                }
            }
            ration.setMedicineList(medicineList);
            rationList.add(ration);
        }
        return rationList;
    }

    @ApiOperation("修改部门配给计划")
    @PostMapping("/changeRation")
    public RespBean changeRation(@RequestBody Ration ration) {
        if (ration != null) {
            Rationtable rationtable = new Rationtable();
            Rationinfotable rationinfotable = new Rationinfotable();
            rationtable.setDepartmentname(ration.getDepartmentName());
            rationtable.setDepartmentnum(ration.getDepartmentNum());
            List<Medicine> medicineList = ration.getMedicineList();
            boolean flag = rationtableService.changeRation(rationtable);
            for (int i = 0; i < medicineList.size(); i++) {
                rationinfotable.setDepartmentnum(ration.getDepartmentNum());
                rationinfotable.setRationinfonum(null);
                rationinfotable.setMedicinenum(medicineList.get(i).getMedicineNum());
                rationinfotable.setMedicinenumber(medicineList.get(i).getStorageNumber());
                if (flag) {
                    flag = rationinfotableService.changeRationInfo(rationinfotable);
                } else {
                    return RespBean.error("修改失败");
                }
            }
            if (flag){
                return RespBean.success("修改成功");
            }
        }
        return RespBean.error("请求参数无效");
    }

    @ApiOperation("添加配给计划")
    @PostMapping("/addRation")
    public RespBean addRation(@RequestBody Ration ration) {
        if (ration != null) {
            Rationtable rationtable = new Rationtable();
            Rationinfotable rationinfotable = new Rationinfotable();
            rationtable.setDepartmentname(ration.getDepartmentName());
            rationtable.setDepartmentnum(ration.getDepartmentNum());
            List<Medicine> medicineList = ration.getMedicineList();
            boolean flag = rationtableService.addRation(rationtable);
            for (int i = 0; i < medicineList.size(); i++) {
                rationinfotable.setDepartmentnum(ration.getDepartmentNum());
                rationinfotable.setRationinfonum(null);
                rationinfotable.setMedicinenum(medicineList.get(i).getMedicineNum());
                rationinfotable.setMedicinenumber(medicineList.get(i).getStorageNumber());
                if (flag) {
                    flag = rationinfotableService.addRationInfo(rationinfotable);
                } else {
                    return RespBean.error("添加失败");
                }
            }
            if (flag){
                return RespBean.success("添加成功");
            }
        }
        return RespBean.error("请求参数无效");
    }

    @ApiOperation("删除配给信息")
    @PostMapping("/deleteRation")
    public RespBean deleteRation(@RequestBody Ration ration) {
        if (ration != null) {
            int departmentNum = ration.getDepartmentNum();
            if (rationtableService.deleteRation(departmentNum)
                    && rationinfotableService.deleteRationInfo(departmentNum)) {
                return RespBean.success("删除成功");
            }
        }
        return RespBean.error("请求参数无效");
    }
}

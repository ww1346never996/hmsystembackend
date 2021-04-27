package org.hmsystem.server.controller;


import com.fasterxml.jackson.databind.annotation.JsonAppend;
import io.swagger.annotations.ApiOperation;
import org.hmsystem.server.utils.JwtTokenUtil;
import org.hmsystem.server.pojo.*;
import org.hmsystem.server.service.IAlarmtableService;
import org.hmsystem.server.service.IDocinfotableService;
import org.hmsystem.server.service.IDocumenttableService;
import org.hmsystem.server.service.IMedicinetableService;
import org.hmsystem.server.utils.OrderNumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ww1346
 * @since 2021-03-29
 */
@RestController
@RequestMapping("/alarmtable")
public class AlarmtableController {

    @Autowired
    IAlarmtableService alarmtableService;
    @Autowired
    IDocumenttableService documenttableService;
    @Autowired
    IDocinfotableService docinfotableService;
    @Autowired
    IMedicinetableService medicinetableService;
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Autowired
    OrderNumUtils orderNumUtils;

    @ApiOperation(value = "获取警戒库存列表")
    @GetMapping("/alarmInfo")
    public List<AlarmStorage> getAllList() {
        List<Alarmtable> alarmtableList = alarmtableService.getAlarmList();
        List<Medicinetable> medicineList = medicinetableService.getMedicineInfo();
        List<AlarmStorage> result = new ArrayList<>();
        //判断存储数据是否正确及调用是否正常
        if (alarmtableList.size() == medicineList.size() && !alarmtableList.isEmpty()) {
            for (int i = 0; i < alarmtableList.size(); i++) {
                //获取警戒库存对象
                AlarmStorage alarmStorage = new AlarmStorage();
                int medicineNum = alarmtableList.get(i).getMedicinenum();
                int storageNum = 0;
                int alarmStorageNum = alarmtableList.get(i).getAlarmstoragenum();
                alarmStorage.setMedicineNum(medicineNum);
                alarmStorage.setAlarmStorageNum(alarmStorageNum);
                alarmStorage.setMedicineName(medicineList.get(i).getMedicinename());
                storageNum = medicineList.get(i).getStoragenum();
                if (storageNum <= alarmStorageNum) {
                    alarmStorage.setStorageState(false);
                } else {
                    alarmStorage.setStorageState(true);
                }
                //添加至警戒库存列表
                result.add(alarmStorage);
            }
            return result;
        } else {
            return null;
        }
    }

    @ApiOperation(value = "修改警戒库存")
    @PostMapping("/changeAlarmStorage")
    public RespBean changeAlarmStorage(@RequestBody Alarmtable alarmtable) {
        if (alarmtable != null) {
            if (alarmtableService.changeAlarmInfo(alarmtable)) {
                return RespBean.success("修改成功");
            } else {
                return RespBean.error("修改失败");
            }
        } else {
            return RespBean.error("未正确输入");
        }
    }

    @ApiOperation(value = "生成订货单")
    @PostMapping("/generateOrderDoc")
    public RespBean generateOrderDoc(@RequestParam("token") String token) {
        List<AlarmStorage> alarmStorageList = getAllList();
        List<Documenttable> documenttableList = documenttableService.getDocList();
        Documenttable documenttable = new Documenttable();
        int docNum = orderNumUtils.getOrderNum();
        documenttable.setDoccreatedate(LocalDateTime.now());
        documenttable.setDoccreator(jwtTokenUtil.getUserNameFromToken(token));
        //1代表订货单
        documenttable.setDocid(1);
        //状态1为待确认
        documenttable.setDocstate(1);
        documenttable.setDocnum(docNum);
        boolean needToAdd = false;
        for (int i = 0; i < alarmStorageList.size(); i++) {
            if (!alarmStorageList.get(i).isStorageState()){
                needToAdd = true;
                Docinfotable docinfotable = new Docinfotable();
                docinfotable.setDocinfonum(null);
                docinfotable.setDocnum(docNum);
                docinfotable.setMedicinenum(alarmStorageList.get(i).getMedicineNum());
                //采购量为2倍的警戒库存
                docinfotable.setMedicinenumber(alarmStorageList.get(i).getAlarmStorageNum()*2);
                docinfotableService.createDocInfo(docinfotable);
            }
        }
        if (needToAdd){
            if (documenttableService.createDoc(documenttable)){
                return RespBean.success("添加成功");
            }else {
                return RespBean.error("添加失败");
            }
        }else {
            return RespBean.error("未知错误，请检查后端程序");
        }
    }


}

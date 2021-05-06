package org.hmsystem.server.controller;


import io.swagger.annotations.ApiOperation;
import org.hmsystem.server.utils.JwtTokenUtil;
import org.hmsystem.server.pojo.*;
import org.hmsystem.server.service.IDocinfotableService;
import org.hmsystem.server.service.IDocumenttableService;
import org.hmsystem.server.service.IMedicinetableService;
import org.hmsystem.server.utils.OrderNumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
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
@RequestMapping("/documenttable")
public class DocumenttableController {

    @Autowired
    IMedicinetableService medicinetableService;
    @Autowired
    IDocinfotableService docinfotableService;
    @Autowired
    IDocumenttableService documenttableService;
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Autowired
    OrderNumUtils orderNumUtils;

    @ApiOperation(value = "获取单据列表")
    @GetMapping("/documentInfo")
    public List<Document> getAllList() {
        List<Document> result = new ArrayList<>();
        List<Documenttable> documenttables = documenttableService.getDocList();
        List<Docinfotable> docinfotables = docinfotableService.getDocInfoList();
        List<Medicinetable> medicinetables = medicinetableService.getMedicineInfo();
        for (int i = 0; i < documenttables.size(); i++) {
            Document document = new Document();
            List<Medicine> medicineList = new ArrayList<>();
            Documenttable documenttable = documenttables.get(i);
            int docNum = documenttable.getDocnum();
            document.setDocNum(docNum);
            document.setDocId(documenttable.getDocid());
            document.setDocCreateTime(documenttable.getDoccreatedate());
            document.setDocCreator(documenttable.getDoccreator());
            document.setDocState(documenttable.getDocstate());
            //获取药品详情列表
            for (int j = 0; j < docinfotables.size(); j++) {
                if (docinfotables.get(j).getDocnum() == docNum) {
                    int index = docinfotables.get(j).getMedicinenum();
                    Medicinetable medicinetable = medicinetables.get(index - 1);
                    Medicine medicine = new Medicine();
                    medicine.setMedicineNum(medicinetable.getMedicinenum());
                    medicine.setStorageNumber(docinfotables.get(j).getMedicinenumber());
                    medicine.setMedicinePrice(medicinetable.getPurchaseprice());
                    medicine.setMedicineName(medicinetable.getMedicinename());
                    medicineList.add(medicine);
                }
            }
            document.setMedicineList(medicineList);
            result.add(document);
        }
        return result;
    }

    @ApiOperation(value = "生成单据")
    @PostMapping("/addDocument")
    public RespBean createDocument(@RequestBody Document document) {
        if (document != null) {
            int docNum = orderNumUtils.getOrderNum();
            Documenttable documenttable = new Documenttable();
            documenttable.setDocnum(docNum);
            documenttable.setDocstate(document.getDocState());
            documenttable.setDocid(document.getDocId());
            documenttable.setDoccreator(document.getDocCreator());
            documenttable.setDoccreatedate(LocalDateTime.now());
            List<Medicine> medicineList = document.getMedicineList();
            //存入document信息
            if (documenttableService.createDoc(documenttable)) {
                boolean flag = false;
                //获取单据编号
                for (int i = 0; i < medicineList.size(); i++) {
                    Docinfotable docinfotable = new Docinfotable();
                    docinfotable.setDocnum(docNum);
                    docinfotable.setMedicinenum(medicineList.get(i).getMedicineNum());
                    docinfotable.setMedicinenumber(medicineList.get(i).getStorageNumber());
                    docinfotable.setDocinfonum(null);
                    flag = docinfotableService.createDocInfo(docinfotable);
                }
                if (flag) {
                    return RespBean.success("创建成功");
                }
                return RespBean.error("添加单据详情失败");
            }
            return RespBean.error("创建单据失败");
        }
        return RespBean.error("传入值不正确");
    }

    @ApiOperation(value = "变更单据状态")
    @PostMapping("/changeDocState")
    public RespBean changeDocState(@RequestParam("docNum") int docNum, @RequestParam("docState") int docState) {
        if (docNum != 0 && docState != 0) {
            if (documenttableService.changeDocState(docNum, docState)) {
                return RespBean.success("修改成功");
            }
            return RespBean.error("修改失败");
        }
        return RespBean.error("传入值不正确");
    }

    @ApiOperation(value = "删除单据")
    @PostMapping("/deleteDocument")
    public RespBean deleteDoc(@RequestParam("docNum") int docNum) {
        if (documenttableService.deleteDoc(docNum)&&docinfotableService.deleteDocInfo(docNum)) {
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @ApiOperation(value = "修改单据信息")
    @PostMapping("/changeDocument")
    public RespBean changeDocument(@RequestBody Document document) {
        if (document != null) {
            Documenttable documenttable = new Documenttable();
            int docNum = document.getDocNum();
            documenttable.setDocnum(docNum);
            documenttable.setDocstate(document.getDocState());
            documenttable.setDoccreatedate(LocalDateTime.now());
            documenttable.setDoccreator(document.getDocCreator());
            documenttable.setDocid(document.getDocId());
            if (documenttableService.changeDoc(documenttable)) {
                List<Medicine> medicineList = document.getMedicineList();
                Boolean flag = false;
                List<Docinfotable> docinfotables = docinfotableService.getDocInfoList();
                for (int i = 0; i < medicineList.size(); i++) {
                    Boolean found = false;
                    Docinfotable docinfotable = new Docinfotable();
                    for (int j = 0; j < docinfotables.size(); j++) {
                        if (docinfotables.get(j).getDocnum() == docNum) {
                            if (docinfotables.get(j).getMedicinenum().equals(medicineList.get(i).getMedicineNum())) {
                                docinfotable.setDocinfonum(docinfotables.get(j).getDocinfonum());
                                docinfotable.setDocnum(docNum);
                                docinfotable.setMedicinenumber(medicineList.get(i).getStorageNumber());
                                docinfotable.setMedicinenum(medicineList.get(i).getMedicineNum());
                                flag = docinfotableService.changeDocInfo(docinfotable);
                                found = true;
                                break;
                            }
                        }
                    }
                    if (!found) {
                        docinfotable.setDocinfonum(null);
                        docinfotable.setDocnum(docNum);
                        docinfotable.setMedicinenumber(medicineList.get(i).getStorageNumber());
                        docinfotable.setMedicinenum(medicineList.get(i).getMedicineNum());
                        flag = docinfotableService.createDocInfo(docinfotable);
                    }
                }
                if (flag) {
                    return RespBean.success("修改成功");
                }
                return RespBean.error("修改详情失败");
            }
            return RespBean.error("修改失败");
        }
        return RespBean.error("传入值为空");
    }

    @ApiOperation("获取入库单列表")
    @GetMapping("/getStorageIn")
    public List<Document> getStorageIn() {
        List<Document> allDocuments = getAllList();
        List<Document> inOrders = new ArrayList();
        for (int i = 0; i < allDocuments.size(); i++) {
            if (allDocuments.get(i).getDocId() == 2) {
                inOrders.add(allDocuments.get(i));
            }
        }
        return inOrders;
    }

    @ApiOperation("获取出库单列表")
    @GetMapping("/getStorageOut")
    public List<Document> getStorageOut() {
        List<Document> allDocuments = getAllList();
        List<Document> outOrders = new ArrayList();
        for (int i = 0; i < allDocuments.size(); i++) {
            if (allDocuments.get(i).getDocId() == 3) {
                outOrders.add(allDocuments.get(i));
            }
        }
        return outOrders;
    }

    @ApiOperation("获取采购单列表")
    @GetMapping("/getOrder")
    public List<Document> getOrder() {
        List<Document> allDocuments = getAllList();
        List<Document> orders = new ArrayList();
        for (int i = 0; i < allDocuments.size(); i++) {
            if (allDocuments.get(i).getDocId() == 1) {
                orders.add(allDocuments.get(i));
            }
        }
        return orders;
    }

    @ApiOperation("完成入库单")
    @PostMapping("/inDone")
    public RespBean inDone(@RequestParam("docnum") int docnum) {
        boolean flag = false;
        if (docnum != 0) {
            List<Document> documentList = getAllList();
            Document document = new Document();
            for (int i = 0; i < documentList.size(); i++) {
                if (documentList.get(i).getDocNum() == docnum) {
                    document = documentList.get(i);
                    break;
                }
            }
            List<Medicine> medicineList = document.getMedicineList();
            List<Medicinetable> medicinetableList = medicinetableService.getMedicineInfo();
            Documenttable documenttable = new Documenttable();
            documenttable.setDocid(document.getDocId());
            documenttable.setDoccreator(document.getDocCreator());
            documenttable.setDoccreatedate(document.getDocCreateTime());
            documenttable.setDocstate(2);
            documenttable.setDocnum(document.getDocNum());
            flag = documenttableService.changeDoc(documenttable);
            for (int i = 0; i < medicineList.size(); i++) {
                Medicine medicine = medicineList.get(i);
                for (int j = 0; j < medicinetableList.size(); j++) {
                    if (medicine.getMedicineNum().equals(medicinetableList.get(j).getMedicinenum())) {
                        Medicinetable medicinetable = medicinetableList.get(j);
                        medicinetable.setStoragedate(LocalDateTime.now());
                        medicinetable.setStoragenum(medicine.getStorageNumber() + medicinetableList.get(j).getStoragenum());
                        flag = medicinetableService.changeMedicineInfo(medicinetable);
                    }
                }
            }
        }
        if (flag) {
            return RespBean.success("入库操作完成");
        }
        return RespBean.error("未知错误");
    }

    @ApiOperation("完成出库单")
    @PostMapping("/outDone")
    public RespBean outDone(@RequestParam("docnum") int docnum) {
        boolean flag = false;
        if (docnum != 0) {
            List<Document> documentList = getAllList();
            Document document = new Document();
            for (int i = 0; i < documentList.size(); i++) {
                if (documentList.get(i).getDocNum() == docnum) {
                    document = documentList.get(i);
                    break;
                }
            }
            List<Medicine> medicineList = document.getMedicineList();
            List<Medicinetable> medicinetableList = medicinetableService.getMedicineInfo();
            Documenttable documenttable = new Documenttable();
            documenttable.setDocid(document.getDocId());
            documenttable.setDoccreator(document.getDocCreator());
            documenttable.setDoccreatedate(document.getDocCreateTime());
            documenttable.setDocstate(2);
            documenttable.setDocnum(document.getDocNum());
            flag = documenttableService.changeDoc(documenttable);
            for (int i = 0; i < medicineList.size(); i++) {
                Medicine medicine = medicineList.get(i);
                for (int j = 0; j < medicinetableList.size(); j++) {
                    if (medicine.getMedicineNum().equals(medicinetableList.get(j).getMedicinenum())) {
                        Medicinetable medicinetable = medicinetableList.get(j);
                        medicinetable.setStoragedate(LocalDateTime.now());
                        medicinetable.setStoragenum(medicinetableList.get(j).getStoragenum() - medicine.getStorageNumber());
                        flag = medicinetableService.changeMedicineInfo(medicinetable);
                    }
                }
            }
        }
        if (flag) {
            return RespBean.success("入库操作完成");
        }
        return RespBean.error("未知错误");
    }

    @ApiOperation("获取已完成采购单列表")
    @GetMapping("/getOrderDone")
    public List<Document> getOrderDone() {
        List<Document> allDocuments = getAllList();
        List<Document> orders = new ArrayList();
        for (int i = 0; i < allDocuments.size(); i++) {
            if (allDocuments.get(i).getDocId() == 1 && allDocuments.get(i).getDocState() == 2) {
                orders.add(allDocuments.get(i));
            }
        }
        return orders;
    }

    @ApiOperation("通过配给计划生成出库单")
    @PostMapping("/generateOut")
    public RespBean generateOut(@RequestBody httpRation2Out httpRation2Out) {
        if (httpRation2Out != null) {
            Ration ration = httpRation2Out.getRation();
            String user = httpRation2Out.getUser();
            List<Medicine> medicineList = ration.getMedicineList();
            int docNum = orderNumUtils.getOrderNum();
            Documenttable documenttable = new Documenttable();
            documenttable.setDocnum(docNum);
            documenttable.setDocstate(1);
            documenttable.setDoccreatedate(LocalDateTime.now());
            documenttable.setDoccreator(user);
            documenttable.setDocid(3);
            boolean flag = documenttableService.createDoc(documenttable);
            for (int i = 0; i < medicineList.size(); i++) {
                Docinfotable docinfotable = new Docinfotable();
                docinfotable.setDocnum(docNum);
                docinfotable.setDocinfonum(null);
                docinfotable.setMedicinenum(medicineList.get(i).getMedicineNum());
                docinfotable.setMedicinenumber(medicineList.get(i).getStorageNumber());
                if (flag){
                    flag = docinfotableService.createDocInfo(docinfotable);
                }else {
                    return RespBean.error("生成出库单失败");
                }
            }
            if (flag){
                return RespBean.success("生成出库单成功");
            }
        }
        return RespBean.error("请求参数不能为空");
    }
}

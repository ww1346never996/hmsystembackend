package org.hmsystem.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.hmsystem.server.pojo.Rationinfotable;

import java.util.List;

public interface IRationinfotableService extends IService<Rationinfotable> {

    /**
     *
     * 获取需求计划的详情列表
     */
    List<Rationinfotable> getRationInfo();

    /**
     * 添加需求计划详情
     */
    boolean addRationInfo(Rationinfotable rationinfotable);

    /**
     * 删除需求计划详情
     */
    boolean deleteRationInfo(int departmentNum);

    /**
     * 修改需求计划详情
     */
    boolean changeRationInfo(Rationinfotable rationinfotable);
}

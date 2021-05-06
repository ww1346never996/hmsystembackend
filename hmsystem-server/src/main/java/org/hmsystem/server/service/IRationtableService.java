package org.hmsystem.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.hmsystem.server.pojo.Rationtable;

import java.util.List;

public interface IRationtableService extends IService<Rationtable> {

    /**
     * 查询科室需求计划
     */
    List<Rationtable> getAllList();

    /**
     * 添加科室需求计划
     */
    boolean addRation(Rationtable rationtable);

    /**
     * 删除科室需求计划
     */
    boolean deleteRation(int rationNum);

    /**
     * 修改科室需求计划
     */
    boolean changeRation(Rationtable rationtable);
}

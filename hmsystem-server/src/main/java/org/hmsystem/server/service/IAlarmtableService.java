package org.hmsystem.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.hmsystem.server.pojo.Alarmtable;
import org.hmsystem.server.pojo.Medicinetable;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ww1346
 * @since 2021-03-29
 */
public interface IAlarmtableService extends IService<Alarmtable> {
    /**
     * 查询库存预警信息
     */
    List<Alarmtable> getAlarmList();

    /**
     * 删除库存预警信息
     */
    boolean deleteAlarmInfo(int medicineNum);

    /**
     * 修改库存预警信息
     */
    boolean changeAlarmInfo(Alarmtable alarmtable);

    /**
     * 添加库存预警信息
     */
    boolean addAlarmInfo(Alarmtable alarmtable);
}

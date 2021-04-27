package org.hmsystem.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.hmsystem.server.mapper.AlarmtableMapper;
import org.hmsystem.server.pojo.Alarmtable;
import org.hmsystem.server.service.IAlarmtableService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ww1346
 * @since 2021-03-29
 */
@Service
public class AlarmtableServiceImpl extends ServiceImpl<AlarmtableMapper, Alarmtable> implements IAlarmtableService {

    @Override
    public List<Alarmtable> getAlarmList() {
        return list();
    }

    @Override
    public boolean deleteAlarmInfo(int medicineNum) {
        return remove(new QueryWrapper<Alarmtable>().eq("medicinenum",medicineNum));
    }

    @Override
    public boolean changeAlarmInfo(Alarmtable alarmtable) {
        return update(alarmtable,new QueryWrapper<Alarmtable>().eq("medicinenum",alarmtable.getMedicinenum()));
    }

    @Override
    public boolean addAlarmInfo(Alarmtable alarmtable) {
        return save(alarmtable);
    }
}

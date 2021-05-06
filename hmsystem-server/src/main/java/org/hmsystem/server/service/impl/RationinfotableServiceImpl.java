package org.hmsystem.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.hmsystem.server.mapper.RationinfotableMapper;
import org.hmsystem.server.pojo.Rationinfotable;
import org.hmsystem.server.service.IRationinfotableService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RationinfotableServiceImpl extends ServiceImpl<RationinfotableMapper, Rationinfotable> implements IRationinfotableService{

    @Override
    public List<Rationinfotable> getRationInfo() {
        return list();
    }

    @Override
    public boolean addRationInfo(Rationinfotable rationinfotable) {
        return save(rationinfotable);
    }

    @Override
    public boolean deleteRationInfo(int departmentNum) {
        return remove(new QueryWrapper<Rationinfotable>().eq("departmentnum", departmentNum));
    }

    @Override
    public boolean changeRationInfo(Rationinfotable rationinfotable) {
        return update(rationinfotable, new QueryWrapper<Rationinfotable>()
                .eq("departmentnum", rationinfotable.getDepartmentnum())
                .eq("medicinenum",rationinfotable.getMedicinenum()));
    }
}

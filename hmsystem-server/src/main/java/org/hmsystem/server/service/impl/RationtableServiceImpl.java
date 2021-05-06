package org.hmsystem.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.hmsystem.server.mapper.RationtableMapper;
import org.hmsystem.server.pojo.Rationtable;
import org.hmsystem.server.service.IRationtableService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RationtableServiceImpl extends ServiceImpl<RationtableMapper, Rationtable> implements IRationtableService {

    @Override
    public List<Rationtable> getAllList() {
        return list();
    }

    @Override
    public boolean addRation(Rationtable rationtable) {
        return save(rationtable);
    }

    @Override
    public boolean deleteRation(int rationNum) {
        return remove(new QueryWrapper<Rationtable>().eq("departmentnum", rationNum));
    }

    @Override
    public boolean changeRation(Rationtable rationtable) {
        return update(rationtable, new QueryWrapper<Rationtable>().eq("departmentnum", rationtable.getDepartmentnum()));
    }
}

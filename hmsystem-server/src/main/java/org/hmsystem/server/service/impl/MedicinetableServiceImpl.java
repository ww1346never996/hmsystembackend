package org.hmsystem.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.hmsystem.server.mapper.MedicinetableMapper;
import org.hmsystem.server.pojo.Medicinetable;
import org.hmsystem.server.service.IMedicinetableService;
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
public class MedicinetableServiceImpl extends ServiceImpl<MedicinetableMapper, Medicinetable> implements IMedicinetableService {

    @Override
    public List<Medicinetable> getMedicineInfo() {
        return list();
    }

    @Override
    public boolean deleteMedicineInfo(int medicineNum) {
        return remove(new QueryWrapper<Medicinetable>().eq("medicinenum", medicineNum));
    }

    @Override
    public boolean changeMedicineInfo(Medicinetable medicinetable) {
        return update(medicinetable,new QueryWrapper<Medicinetable>().eq("medicinenum",medicinetable.getMedicinenum()));
    }

    @Override
    public boolean addMedicineInfo(Medicinetable medicinetable) {
        return save(medicinetable);
    }
}

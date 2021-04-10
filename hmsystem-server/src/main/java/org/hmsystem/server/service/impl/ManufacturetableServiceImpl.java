package org.hmsystem.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.hmsystem.server.mapper.ManufacturetableMapper;
import org.hmsystem.server.pojo.Manufacturetable;
import org.hmsystem.server.service.IManufacturetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class ManufacturetableServiceImpl extends ServiceImpl<ManufacturetableMapper, Manufacturetable> implements IManufacturetableService {

    @Autowired
    ManufacturetableMapper manufacturetableMapper;


    @Override
    public List<Manufacturetable> getManufactureInfo() {
        /**
         * //查询账户状态是否被禁用
         * if (auth != 0){
         *             return list();
         *         }
         *         return null;
         */
        return list();
    }

    @Override
    public boolean deleteManufacture(int manufactureNum) {
        return remove(new QueryWrapper<Manufacturetable>().eq("manufacturenum", manufactureNum));
    }

    @Override
    public boolean changeManufacture(Manufacturetable manufacturetable) {
        return update(manufacturetable, new QueryWrapper<Manufacturetable>().eq("manufacturenum",manufacturetable.getManufacturenum()));
    }

    @Override
    public boolean addManufacture(Manufacturetable manufacturetable) {
        return save(manufacturetable);
    }
}

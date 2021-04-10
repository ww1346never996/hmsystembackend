package org.hmsystem.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.hmsystem.server.mapper.DocumenttableMapper;
import org.hmsystem.server.pojo.Document;
import org.hmsystem.server.pojo.Documenttable;
import org.hmsystem.server.service.IDocumenttableService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ww1346
 * @since 2021-03-29
 */
@Service
public class DocumenttableServiceImpl extends ServiceImpl<DocumenttableMapper, Documenttable> implements IDocumenttableService {

    @Override
    public List<Documenttable> getDocList() {
        return list();
    }

    @Override
    public boolean createDoc(Documenttable documenttable) {
        return save(documenttable);
    }

    @Override
    public boolean deleteDoc(int documentNum) {
        return remove(new QueryWrapper<Documenttable>().eq("docnum", documentNum));
    }

    @Override
    public boolean changeDoc(Documenttable documenttable) {
        return update(documenttable, new QueryWrapper<Documenttable>().eq("docnum", documenttable.getDocnum()));
    }
}

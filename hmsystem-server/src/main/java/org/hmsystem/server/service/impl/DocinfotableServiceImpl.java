package org.hmsystem.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.hmsystem.server.mapper.DocinfotableMapper;
import org.hmsystem.server.pojo.Docinfotable;
import org.hmsystem.server.service.IDocinfotableService;
import org.springframework.stereotype.Service;

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
public class DocinfotableServiceImpl extends ServiceImpl<DocinfotableMapper, Docinfotable> implements IDocinfotableService {

    @Override
    public List<Docinfotable> getDocInfoList() {
        return list();
    }

    @Override
    public boolean createDocInfo(Docinfotable docinfotable) {
        return save(docinfotable);
    }

    @Override
    public boolean deleteDocInfo(int docInfoNum) {
        return remove(new QueryWrapper<Docinfotable>().eq("docinfonum", docInfoNum));
    }

    @Override
    public boolean changeDocInfo(Docinfotable docinfotable) {
        return update(docinfotable, new QueryWrapper<Docinfotable>().eq("docinfonum", docinfotable.getDocinfonum()));
    }
}

package org.hmsystem.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.hmsystem.server.pojo.Document;
import org.hmsystem.server.pojo.Documenttable;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author ww1346
 * @since 2021-03-29
 */
public interface IDocumenttableService extends IService<Documenttable> {
    /**
     * 查询单据信息
     */
    List<Documenttable> getDocList();

    /**
     * 新建单据
     */
    boolean createDoc(Documenttable documenttable);

    /**
     * 删除单据
     */
    boolean deleteDoc(int documentNum);

    /**
     * 修改单据信息
     */
    boolean changeDoc(Documenttable documenttable);
}

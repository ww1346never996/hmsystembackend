package org.hmsystem.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.hmsystem.server.pojo.Docinfotable;
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
public interface IDocinfotableService extends IService<Docinfotable> {
    /**
     * 查询单据详情信息
     */
    List<Docinfotable> getDocInfoList();

    /**
     * 新建单据详情信息
     */
    boolean createDocInfo(Docinfotable docinfotable);

    /**
     * 删除单据详情信息
     */
    boolean deleteDocInfo(int docInfoNum);

    /**
     * 修改单据详情信息
     */
    boolean changeDocInfo(Docinfotable docinfotable);

}

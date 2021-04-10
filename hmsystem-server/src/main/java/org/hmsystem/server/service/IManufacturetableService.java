package org.hmsystem.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.hmsystem.server.pojo.Manufacturetable;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author ww1346
 * @since 2021-03-29
 */
public interface IManufacturetableService extends IService<Manufacturetable> {
    /**
     * 查询制造商信息
     */
    List<Manufacturetable> getManufactureInfo();

    /**
     * 删除制造商信息
     */
    boolean deleteManufacture(int manufactureNum);

    /**
     * 修改制造商信息
     */
    boolean changeManufacture(Manufacturetable manufacturetable);

    /**
     * 添加制造商信息
     */
    boolean addManufacture(Manufacturetable manufacturetable);
}

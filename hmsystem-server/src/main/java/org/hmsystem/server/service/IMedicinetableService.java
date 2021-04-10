package org.hmsystem.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.hmsystem.server.pojo.Manufacturetable;
import org.hmsystem.server.pojo.Medicinetable;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ww1346
 * @since 2021-03-29
 */
public interface IMedicinetableService extends IService<Medicinetable> {
    /**
     * 查询药品信息
     */
    List<Medicinetable> getMedicineInfo();

    /**
     * 删除药品信息
     */
    boolean deleteMedicineInfo(int medicineNum);

    /**
     * 修改药品信息
     */
    boolean changeMedicineInfo(Medicinetable medicinetable);

    /**
     * 添加药品信息
     */
    boolean addMedicineInfo(Medicinetable medicinetable);

}

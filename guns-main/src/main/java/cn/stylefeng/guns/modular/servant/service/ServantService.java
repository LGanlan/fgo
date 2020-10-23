package cn.stylefeng.guns.modular.servant.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.servant.entity.Servant;
import cn.stylefeng.guns.modular.servant.model.params.ServantParam;
import cn.stylefeng.guns.modular.servant.model.result.ServantResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Ganlan
 * @since 2020-10-23
 */
public interface ServantService extends IService<Servant> {

    /**
     * 新增
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    void add(ServantParam param);

    /**
     * 删除
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    void delete(ServantParam param);

    /**
     * 更新
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    void update(ServantParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    ServantResult findBySpec(ServantParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    List<ServantResult> findListBySpec(ServantParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
     LayuiPageInfo findPageBySpec(ServantParam param);

}

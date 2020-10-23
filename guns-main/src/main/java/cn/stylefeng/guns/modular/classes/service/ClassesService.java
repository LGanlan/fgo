package cn.stylefeng.guns.modular.classes.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.classes.entity.Classes;
import cn.stylefeng.guns.modular.classes.model.params.ClassesParam;
import cn.stylefeng.guns.modular.classes.model.result.ClassesResult;
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
public interface ClassesService extends IService<Classes> {

    /**
     * 新增
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    void add(ClassesParam param);

    /**
     * 删除
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    void delete(ClassesParam param);

    /**
     * 更新
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    void update(ClassesParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    ClassesResult findBySpec(ClassesParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    List<ClassesResult> findListBySpec(ClassesParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
     LayuiPageInfo findPageBySpec(ClassesParam param);

}
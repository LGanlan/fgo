package cn.stylefeng.guns.modular.grade.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.grade.entity.Grade;
import cn.stylefeng.guns.modular.grade.model.params.GradeParam;
import cn.stylefeng.guns.modular.grade.model.result.GradeResult;
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
public interface GradeService extends IService<Grade> {

    /**
     * 新增
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    void add(GradeParam param);

    /**
     * 删除
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    void delete(GradeParam param);

    /**
     * 更新
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    void update(GradeParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    GradeResult findBySpec(GradeParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    List<GradeResult> findListBySpec(GradeParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
     LayuiPageInfo findPageBySpec(GradeParam param);

}

package cn.stylefeng.guns.modular.grade.mapper;

import cn.stylefeng.guns.modular.grade.entity.Grade;
import cn.stylefeng.guns.modular.grade.model.params.GradeParam;
import cn.stylefeng.guns.modular.grade.model.result.GradeResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Ganlan
 * @since 2020-10-23
 */
public interface GradeMapper extends BaseMapper<Grade> {

    /**
     * 获取列表
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    List<GradeResult> customList(@Param("paramCondition") GradeParam paramCondition);

    /**
     * 获取map列表
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") GradeParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    Page<GradeResult> customPageList(@Param("page") Page page, @Param("paramCondition") GradeParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") GradeParam paramCondition);

}

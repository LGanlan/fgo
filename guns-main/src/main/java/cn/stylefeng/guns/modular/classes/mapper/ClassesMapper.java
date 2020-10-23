package cn.stylefeng.guns.modular.classes.mapper;

import cn.stylefeng.guns.modular.classes.entity.Classes;
import cn.stylefeng.guns.modular.classes.model.params.ClassesParam;
import cn.stylefeng.guns.modular.classes.model.result.ClassesResult;
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
public interface ClassesMapper extends BaseMapper<Classes> {

    /**
     * 获取列表
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    List<ClassesResult> customList(@Param("paramCondition") ClassesParam paramCondition);

    /**
     * 获取map列表
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") ClassesParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    Page<ClassesResult> customPageList(@Param("page") Page page, @Param("paramCondition") ClassesParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") ClassesParam paramCondition);

}
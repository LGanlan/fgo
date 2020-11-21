package cn.stylefeng.guns.modular.servant.mapper;

import cn.stylefeng.guns.modular.servant.entity.Servant;
import cn.stylefeng.guns.modular.servant.model.params.ServantParam;
import cn.stylefeng.guns.modular.servant.model.result.ServantResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Ganlan
 * @since 2020-10-23
 */
public interface ServantMapper extends BaseMapper<Servant> {

    /**
     * 获取列表
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    List<ServantResult> customList(@Param("paramCondition") ServantParam paramCondition);

    /**
     * 获取map列表
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") ServantParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    Page<ServantResult> customPageList(@Param("page") Page page, @Param("paramCondition") ServantParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") ServantParam paramCondition);

    /**
     * 通过class获取从者列表
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    List<ServantResult> getServantByClass(@Param("classes") String classes);

}

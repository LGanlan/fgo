package cn.stylefeng.guns.modular.servant.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author Ganlan
 * @since 2020-10-23
 */
@Data
public class ServantParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    /**
     * 主键id
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 职阶id
     */
    private Long classId;

    /**
     * 评分id
     */
    private Long gradeId;

    /**
     * 是否拥有（0 无 1 有）
     */
    private Integer isHas;

    /**
     * 修改时间
     */
    private Date updateDate;

    /**
     * 评分
     */
    private String score;

    @Override
    public String checkParam() {
        return null;
    }

}

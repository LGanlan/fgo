package cn.stylefeng.guns.modular.grade.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author Ganlan
 * @since 2020-10-23
 */
@Data
public class GradeParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    /**
     * 主键id
     */
    private Long id;

    /**
     * 评分
     */
    private String grade;

    @Override
    public String checkParam() {
        return null;
    }

}

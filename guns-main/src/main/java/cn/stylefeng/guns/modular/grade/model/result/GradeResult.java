package cn.stylefeng.guns.modular.grade.model.result;

import lombok.Data;
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
public class GradeResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 主键id
     */
    private Long id;

    /**
     * 评分
     */
    private String grade;

    /**
     * 排序
     */
    private Integer sort;
}

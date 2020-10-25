package cn.stylefeng.guns.modular.servant.model.result;

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
public class ServantResult implements Serializable {

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
    private String classes;

    /**
     * 评分id
     */
    private Long gradeId;
    private String grade;

    /**
     * 是否拥有（0 无 1 有）
     */
    private Integer isHas;

}

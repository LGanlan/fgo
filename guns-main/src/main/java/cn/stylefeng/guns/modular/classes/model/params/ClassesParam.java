package cn.stylefeng.guns.modular.classes.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Ganlan
 * @since 2020-10-23
 */
@Data
public class ClassesParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    /**
     * 主键id
     */
    private Long id;

    /**
     * 职介
     */
    private String classes;

    @Override
    public String checkParam() {
        return null;
    }

}
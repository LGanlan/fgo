package cn.stylefeng.guns.modular.classes.model.result;

import lombok.Data;
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
public class ClassesResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 主键id
     */
    private Long id;

    /**
     * 职介
     */
    private String classes;

}
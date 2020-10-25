package cn.stylefeng.guns.modular.grade.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author Ganlan
 * @since 2020-10-23
 */
@TableName("grade")
public class Grade implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    /**
     * 评分
     */
    @TableField("grade")
    private String grade;

    /**
     * 排序
     */
    @TableField("sort")
    private Integer sort;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", grade='" + grade + '\'' +
                ", sort=" + sort +
                '}';
    }
}
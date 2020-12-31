package cn.stylefeng.guns.modular.servant.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author Ganlan
 * @since 2020-10-23
 */
@TableName("servant")
public class Servant implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    /**
     * 姓名
     */
    @TableField("name")
    private String name;

    /**
     * 职阶id
     */
    @TableField("class_id")
    private Long classId;

    /**
     * 评分id
     */
    @TableField("grade_id")
    private Long gradeId;

    /**
     * 是否拥有（0 无 1 有）
     */
    @TableField("is_has")
    private Integer isHas;

    /**
     * 修改时间
     */
    @TableField(value = "update_date", fill = FieldFill.INSERT)
    private Date updateDate;

    /**
     * 评分
     */
    @TableField("score")
    private BigDecimal score;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public Integer getIsHas() {
        return isHas;
    }

    public void setIsHas(Integer isHas) {
        this.isHas = isHas;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Servant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classId=" + classId +
                ", gradeId=" + gradeId +
                ", isHas=" + isHas +
                ", updateDate=" + updateDate +
                ", score='" + score + '\'' +
                '}';
    }
}

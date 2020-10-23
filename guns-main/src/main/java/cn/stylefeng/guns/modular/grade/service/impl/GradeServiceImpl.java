package cn.stylefeng.guns.modular.grade.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.grade.entity.Grade;
import cn.stylefeng.guns.modular.grade.mapper.GradeMapper;
import cn.stylefeng.guns.modular.grade.model.params.GradeParam;
import cn.stylefeng.guns.modular.grade.model.result.GradeResult;
import  cn.stylefeng.guns.modular.grade.service.GradeService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Ganlan
 * @since 2020-10-23
 */
@Service
public class GradeServiceImpl extends ServiceImpl<GradeMapper, Grade> implements GradeService {

    @Override
    public void add(GradeParam param){
        Grade entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(GradeParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(GradeParam param){
        Grade oldEntity = getOldEntity(param);
        Grade newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public GradeResult findBySpec(GradeParam param){
        return null;
    }

    @Override
    public List<GradeResult> findListBySpec(GradeParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(GradeParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(GradeParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Grade getOldEntity(GradeParam param) {
        return this.getById(getKey(param));
    }

    private Grade getEntity(GradeParam param) {
        Grade entity = new Grade();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}

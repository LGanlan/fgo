package cn.stylefeng.guns.modular.classes.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.classes.entity.Classes;
import cn.stylefeng.guns.modular.classes.mapper.ClassesMapper;
import cn.stylefeng.guns.modular.classes.model.params.ClassesParam;
import cn.stylefeng.guns.modular.classes.model.result.ClassesResult;
import  cn.stylefeng.guns.modular.classes.service.ClassesService;
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
public class ClassesServiceImpl extends ServiceImpl<ClassesMapper, Classes> implements ClassesService {

    @Override
    public void add(ClassesParam param){
        Classes entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(ClassesParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(ClassesParam param){
        Classes oldEntity = getOldEntity(param);
        Classes newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public ClassesResult findBySpec(ClassesParam param){
        return null;
    }

    @Override
    public List<ClassesResult> findListBySpec(ClassesParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(ClassesParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(ClassesParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Classes getOldEntity(ClassesParam param) {
        return this.getById(getKey(param));
    }

    private Classes getEntity(ClassesParam param) {
        Classes entity = new Classes();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
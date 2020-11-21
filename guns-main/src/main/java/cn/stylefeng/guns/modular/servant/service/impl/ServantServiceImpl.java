package cn.stylefeng.guns.modular.servant.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.servant.entity.Servant;
import cn.stylefeng.guns.modular.servant.mapper.ServantMapper;
import cn.stylefeng.guns.modular.servant.model.params.ServantParam;
import cn.stylefeng.guns.modular.servant.model.result.ServantResult;
import  cn.stylefeng.guns.modular.servant.service.ServantService;
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
public class ServantServiceImpl extends ServiceImpl<ServantMapper, Servant> implements ServantService {

    @Override
    public void add(ServantParam param){
        Servant entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(ServantParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(ServantParam param){
        Servant oldEntity = getOldEntity(param);
        Servant newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public ServantResult findBySpec(ServantParam param){
        return null;
    }

    @Override
    public List<ServantResult> findListBySpec(ServantParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(ServantParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    @Override
    public List<ServantResult> getServantByClass(String classes) {
        return this.baseMapper.getServantByClass(classes);
    }

    private Serializable getKey(ServantParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Servant getOldEntity(ServantParam param) {
        return this.getById(getKey(param));
    }

    private Servant getEntity(ServantParam param) {
        Servant entity = new Servant();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}

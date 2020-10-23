package cn.stylefeng.guns.modular.servant.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.servant.entity.Servant;
import cn.stylefeng.guns.modular.servant.model.params.ServantParam;
import cn.stylefeng.guns.modular.servant.service.ServantService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 控制器
 *
 * @author Ganlan
 * @Date 2020-10-23 15:38:56
 */
@Controller
@RequestMapping("/servant")
public class ServantController extends BaseController {

    private String PREFIX = "/servant";

    @Autowired
    private ServantService servantService;

    /**
     * 跳转到主页面
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/servant.html";
    }

    /**
     * 新增页面
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/servant_add.html";
    }

    /**
     * 编辑页面
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/servant_edit.html";
    }

    /**
     * 新增接口
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(ServantParam servantParam) {
        this.servantService.add(servantParam);
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    @RequestMapping("/editItem")
    @ResponseBody
    public ResponseData editItem(ServantParam servantParam) {
        this.servantService.update(servantParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData delete(ServantParam servantParam) {
        this.servantService.delete(servantParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    @RequestMapping("/detail")
    @ResponseBody
    public ResponseData detail(ServantParam servantParam) {
        Servant detail = this.servantService.getById(servantParam.getId());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(ServantParam servantParam) {
        return this.servantService.findPageBySpec(servantParam);
    }

}



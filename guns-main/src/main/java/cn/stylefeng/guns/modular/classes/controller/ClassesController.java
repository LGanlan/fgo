package cn.stylefeng.guns.modular.classes.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.classes.entity.Classes;
import cn.stylefeng.guns.modular.classes.model.params.ClassesParam;
import cn.stylefeng.guns.modular.classes.service.ClassesService;
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
@RequestMapping("/classes")
public class ClassesController extends BaseController {

    private String PREFIX = "/classes";

    @Autowired
    private ClassesService classesService;

    /**
     * 跳转到主页面
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/classes.html";
    }

    /**
     * 新增页面
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/classes_add.html";
    }

    /**
     * 编辑页面
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/classes_edit.html";
    }

    /**
     * 新增接口
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(ClassesParam classesParam) {
        this.classesService.add(classesParam);
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
    public ResponseData editItem(ClassesParam classesParam) {
        this.classesService.update(classesParam);
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
    public ResponseData delete(ClassesParam classesParam) {
        this.classesService.delete(classesParam);
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
    public ResponseData detail(ClassesParam classesParam) {
        Classes detail = this.classesService.getById(classesParam.getId());
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
    public LayuiPageInfo list(ClassesParam classesParam) {
        return this.classesService.findPageBySpec(classesParam);
    }

}



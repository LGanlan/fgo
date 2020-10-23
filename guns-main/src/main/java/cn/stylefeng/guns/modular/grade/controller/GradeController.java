package cn.stylefeng.guns.modular.grade.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.grade.entity.Grade;
import cn.stylefeng.guns.modular.grade.model.params.GradeParam;
import cn.stylefeng.guns.modular.grade.service.GradeService;
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
@RequestMapping("/grade")
public class GradeController extends BaseController {

    private String PREFIX = "/grade";

    @Autowired
    private GradeService gradeService;

    /**
     * 跳转到主页面
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/grade.html";
    }

    /**
     * 新增页面
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/grade_add.html";
    }

    /**
     * 编辑页面
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/grade_edit.html";
    }

    /**
     * 新增接口
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(GradeParam gradeParam) {
        this.gradeService.add(gradeParam);
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
    public ResponseData editItem(GradeParam gradeParam) {
        this.gradeService.update(gradeParam);
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
    public ResponseData delete(GradeParam gradeParam) {
        this.gradeService.delete(gradeParam);
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
    public ResponseData detail(GradeParam gradeParam) {
        Grade detail = this.gradeService.getById(gradeParam.getId());
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
    public LayuiPageInfo list(GradeParam gradeParam) {
        return this.gradeService.findPageBySpec(gradeParam);
    }

}
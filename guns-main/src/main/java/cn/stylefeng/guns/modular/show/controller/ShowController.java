package cn.stylefeng.guns.modular.show.controller;

import cn.stylefeng.guns.modular.servant.model.result.ServantResult;
import cn.stylefeng.guns.modular.servant.service.ServantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/show")
public class ShowController {

    private String PREFIX = "/website";

    @Autowired
    private ServantService servantService;

    /**
     * 跳转到主页面
     *
     * @author Ganlan
     * @Date 2020-10-23
     */
    @RequestMapping("")
    public String index(@RequestParam(value = "classes", required = false) String classes, Model model) {
        List<ServantResult> servantList = servantService.getServantByClass(classes);
        if (classes == null) {
            classes = "All";
        }
        model.addAttribute("servantList", servantList);
        model.addAttribute("classes", classes);
        return PREFIX + "/show.html";
    }

}
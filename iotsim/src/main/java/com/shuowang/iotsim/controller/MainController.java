package com.shuowang.iotsim.controller;

import com.shuowang.iotsim.backend.ControlCenter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    static ControlCenter CC = new ControlCenter();
    @RequestMapping("/home")
    @ResponseBody
    public ModelAndView show()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        modelAndView.addObject("name","User");
        return modelAndView;

    }

    @RequestMapping(value = "start_iotdev")
    public void start(@RequestParam("dev_num") int devnum) throws Exception {
        CC.start(devnum);

    }

//    @RequestMapping(value = "add_load_balancer")
//    public void addLoadBalancer(){
//        CC.addLoadBalancer();
//    }
}

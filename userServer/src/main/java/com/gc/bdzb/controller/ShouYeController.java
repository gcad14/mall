package com.gc.bdzb.controller;

import com.gc.bdzb.service.ShouyeService;
import com.gc.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Map;

//变电指标
@RequestMapping("/bdzb")
@RestController
public class ShouYeController {
    @Autowired
    private ShouyeService shouyeService;

    @GetMapping("/getGztyl")
    public ResponseData getGztyl(String date){
        List<Map<String,Object>> list = shouyeService.getGztyl(date);
        return ResponseData.success(list);
    }
}

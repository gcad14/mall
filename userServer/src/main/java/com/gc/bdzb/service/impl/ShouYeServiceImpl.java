package com.gc.bdzb.service.impl;

import com.gc.bdzb.service.ShouyeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ShouYeServiceImpl implements ShouyeService {
    @Override
    public List<Map<String, Object>> getGztyl(String date) {
        //根据设备编码查询设备数量(查询投运日期小于=查询的日期)
        //查询数据库中录入的个设备跳闸数据
        //循环计算进行相加
        return null;
    }
}

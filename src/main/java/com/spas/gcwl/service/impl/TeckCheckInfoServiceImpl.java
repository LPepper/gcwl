package com.spas.gcwl.service.impl;


import com.spas.gcwl.dao.TeckCheckInfoMapper;
import com.spas.gcwl.entity.TechCheckInfo;
import com.spas.gcwl.service.TeckCheckInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeckCheckInfoServiceImpl implements TeckCheckInfoService {
    @Autowired
    TeckCheckInfoMapper teckCheckInfoMapper;

    @Override
    public int addTeckCheckInfo(TechCheckInfo techCheckInfo) {
        return this.teckCheckInfoMapper.addTeckCheckInfo(techCheckInfo);
    }

    @Override
    public List<TechCheckInfo> findByCarNumAndType(String number, Integer type) {
        return this.teckCheckInfoMapper.findByCarNumAndType(number,type);
    }
}

package com.spas.gcwl.service.impl;

import com.spas.gcwl.dao.ECheckInfoMapper;
import com.spas.gcwl.entity.ECheckInfo;
import com.spas.gcwl.service.ECheckInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ECheckInfoServiceImpl implements ECheckInfoService {
    @Autowired
    ECheckInfoMapper eCheckInfoMapper;

    @Override
    public int addECheckInfo(ECheckInfo eCheckInfo) {
        return this.eCheckInfoMapper.addECheckInfo(eCheckInfo);
    }

    @Override
    public List<ECheckInfo> findByCarNumAndType(String number, Integer type) {
        return this.eCheckInfoMapper.findByCarNumAndType(number,type);
    }
}

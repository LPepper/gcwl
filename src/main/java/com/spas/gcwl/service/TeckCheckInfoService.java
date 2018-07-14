package com.spas.gcwl.service;

import com.spas.gcwl.entity.TechCheckInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeckCheckInfoService {

    int addTeckCheckInfo(TechCheckInfo techCheckInfo);
    List<TechCheckInfo> findByCarNumAndType(String number, String type);

}

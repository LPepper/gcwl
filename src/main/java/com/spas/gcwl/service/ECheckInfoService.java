package com.spas.gcwl.service;

import com.spas.gcwl.entity.ECheckInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ECheckInfoService {

    int addECheckInfo(ECheckInfo eCheckInfo);
    List<ECheckInfo> findByCarNumAndType( String number, String type);

}

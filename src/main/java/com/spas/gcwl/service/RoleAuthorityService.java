package com.spas.gcwl.service;

import com.spas.gcwl.entity.RoleAuthority;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleAuthorityService {
    int addRoleAuthority(RoleAuthority roleAuthority);
    List<Integer> findAuthorityByRoleId(Integer Role_id );
    int deleteColums(RoleAuthority roleAuthority);
    int deleteByRoleId( Integer Role_id);


}

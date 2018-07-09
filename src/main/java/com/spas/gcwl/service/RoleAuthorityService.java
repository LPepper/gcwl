package com.spas.gcwl.service;

import com.spas.gcwl.entity.RoleAuthority;
import org.apache.ibatis.annotations.Param;

public interface RoleAuthorityService {
    int addRoleAuthority(RoleAuthority roleAuthority);
    Integer findAuthorityByRoleId( Integer Role_id );
    int deleteColums(RoleAuthority roleAuthority);


}

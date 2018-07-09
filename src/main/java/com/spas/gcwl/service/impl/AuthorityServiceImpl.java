package com.spas.gcwl.service.impl;

import com.spas.gcwl.dao.AuthorityMapper;
import com.spas.gcwl.entity.Authority;
import com.spas.gcwl.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    AuthorityMapper authorityMapper;

    @Override
    public String findAuthorityById(Integer id) {
        return this.authorityMapper.findAuthorityById(id);
    }

    @Override
    public int addAuthroity(Authority authority) {
        return this.authorityMapper.addAuthority(authority);
    }

    @Override
    public List<Authority> findAllAuthority() {
        return authorityMapper.findAllAuthority();
    }
}

package com.spas.gcwl.service;

import com.spas.gcwl.entity.Authority;

import java.util.List;

public interface AuthorityService {
    String findAuthorityById(Integer id);
    int addAuthroity(Authority authority);
    List<Authority> findAllAuthority();
}

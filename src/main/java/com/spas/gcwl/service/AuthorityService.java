package com.spas.gcwl.service;

import com.spas.gcwl.entity.Authority;

public interface AuthorityService {
    String findAuthorityById(Integer id);
    int addAuthroity(Authority authority);
}

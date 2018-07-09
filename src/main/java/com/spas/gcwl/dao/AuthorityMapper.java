package com.spas.gcwl.dao;

import com.spas.gcwl.entity.Authority;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface AuthorityMapper {
    @Select("select Authority_tag from Authority where id=#{id}")
    String findAuthorityById(Integer id);

    @Select("select * from Authority")
    List<Authority> findAllAuthority();

    @Insert("insert into Authority(id, authority_tag) values(#{id},#{authority_tag})")
    int addAuthority(Authority authority);
    //modificaion
}

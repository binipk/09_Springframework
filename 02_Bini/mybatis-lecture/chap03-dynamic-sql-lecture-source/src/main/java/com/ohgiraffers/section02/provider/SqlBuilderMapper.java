package com.ohgiraffers.section02.provider;

import com.ohgiraffers.common.MenuDTO;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SelectBuilder;

import java.util.List;

public interface SqlBuilderMapper {

    @SelectProvider(type = SelectBuilder.class, method = "selectAllMenu")
    List<MenuDTO> selectAllMenu();



}

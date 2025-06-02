package com.ohgiraffers.practice.common;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Template {

    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSession() {
        if (sqlSessionFactory == null) {
            String resource = "config/mybatis-config.xml";
            try (InputStream inputStream = Resources.getResourceAsStream(resource)) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException("MyBatis 설정 파일을 로드하는 중 오류 발생", e);
            }
        }
        return sqlSessionFactory.openSession(false); // AutoCommit = false
    }
}

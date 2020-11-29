package com.europa.mybatis;

import com.europa.mybatis.entity.User;
import com.europa.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MybatisMain {

    public static void main(String[] args) {
        SqlSession session = getSession(getSessionFactory());
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectUser(1L);
        System.out.println(user.toString());
    }

    public static SqlSession getSession(SqlSessionFactory sessionFactory) {
        return sessionFactory.openSession();
    }

    public static SqlSessionFactory getSessionFactory() {
        String source = "mybatis-config.xml";
        InputStream inputStream = null;
        Properties prop = null;
        try {
            prop = Resources.getResourceAsProperties("application.properties");
            inputStream = Resources.getResourceAsStream(source);
        } catch (IOException e) {
            System.out.println("获取sqlSession失败" + e.getMessage());
        }
        return new SqlSessionFactoryBuilder().build(inputStream, prop);
    }
}

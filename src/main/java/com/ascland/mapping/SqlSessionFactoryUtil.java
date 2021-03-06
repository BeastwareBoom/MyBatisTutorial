package com.ascland.mapping;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * SqlSessionFactory全局工具类
 */
public class SqlSessionFactoryUtil {

    //全局单例对象
    private static SqlSessionFactory sqlSessionFactory;

    //类线程锁
    private static final Class CLASS_LOCK = SqlSessionFactoryUtil.class;

    /**
     * 私有化构造器
     */
    private SqlSessionFactoryUtil() {
    }

    /**
     * 初始化SqlSessionFactory
     */
    private static void initSqlSessionFactory() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = org.apache.ibatis.io.Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            Logger.getLogger(SqlSessionFactoryUtil.class.getName()).log(Level.SEVERE, null, e);
        }

        //提高效率
        if (sqlSessionFactory == null) {
            synchronized (CLASS_LOCK) {
                if (sqlSessionFactory == null) {
                    sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                }
            }
        }
    }

    /**
     * 获取SqlSession
     *
     * @return
     */
    public static SqlSession openSqlSession() {
        if (sqlSessionFactory == null) {
            initSqlSessionFactory();
        }

        return sqlSessionFactory.openSession();
    }
}

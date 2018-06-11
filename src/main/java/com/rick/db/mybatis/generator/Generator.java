/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: Generator
 * Author:   ywang7
 * Date:     2018/6/6 15:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rick.db.mybatis.generator;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author ywang7
 * @create 2018/6/6
 * @since 1.0.0
 */
public class Generator {

    private static SqlSessionFactory sqlSessionFactory;

    public static void generatorCode() throws  Exception{

        List<String> warnings=new ArrayList<String>();
        boolean overwrite=true;
        InputStream inputStream=Generator.class.getResourceAsStream("/generator/generatorConfig.xml");
        ConfigurationParser cp =new ConfigurationParser(warnings);
        org.mybatis.generator.config.Configuration config = cp.parseConfiguration(inputStream);
        inputStream.close();
        DefaultShellCallback callback=new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator=new MyBatisGenerator(config,callback,warnings);
        myBatisGenerator.generate(null);
        for(String warning:warnings){
            System.out.println(warning);
        }
    }

    public static void main(String[] args) throws  Exception{
    }


}

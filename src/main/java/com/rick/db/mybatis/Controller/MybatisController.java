/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: MybatisController
 * Author:   ywang7
 * Date:     2018/6/6 10:59
 * Description: mybatis controller test
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rick.db.mybatis.Controller;

import com.rick.db.mybatis.Utils.ResultBody;
import com.rick.db.mybatis.mapper.SysRoleMapper;
import com.rick.db.mybatis.mapper.SysUserMapper;
import com.rick.db.mybatis.model.SysRole;
import com.rick.db.mybatis.model.SysUser;
import com.rick.db.mybatis.type.Enabled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈mybatis controller test〉
 *
 * @author ywang7
 * @create 2018/6/6
 * @since 1.0.0
 */
@RestController
public class MybatisController {

//    private SqlSessionFactory sqlSessionFactory;

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String hello(){
        return "hello,mybatis test!  swagger url: http://localhost:8080/swagger-ui.html#/";
    }

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    private final Logger LOGGER = LoggerFactory.getLogger(MybatisController.class);
    @RequestMapping(value="/bootBatisTest1",method = RequestMethod.GET)
    public ResultBody bootBatisTest1(){
        LOGGER.info("this is a test");
        return new ResultBody(sysUserMapper.selectAll());
    }

    @RequestMapping(value="/bootBatisTest2",method = RequestMethod.GET)
    public ResultBody bootBatisTest2(){
            SysUser sysUser=sysUserMapper.selectByPrimaryKey(1L);
            sysUser.setUserName("admin_test");
            int result=sysUserMapper.updateByPrimaryKey(sysUser);
            return new ResultBody(result);
    }

    @RequestMapping(value="/bootBatisTest3",method = RequestMethod.GET)
    public ResultBody bootBatisTest3(){
            SysUser sysUser=new SysUser();
            sysUser.setUserName("test1");
            sysUser.setId(1002L);
            sysUser.setUserEmail("test1@mybatis.com");
            sysUser.setUserInfo("test info");
            sysUser.setHeadImg(new byte[]{1,2,3});
            sysUser.setCreateTime(new Date());
            int result=sysUserMapper.insert(sysUser);
            return new ResultBody(sysUser.getId() + "," +  result);
    }

    @RequestMapping(value="/bootBatisTest4",method = RequestMethod.GET)
    public ResultBody bootBastisTest4(){
        return new ResultBody(sysUserMapper.deleteByPrimaryKey(1001L));
    }

    @RequestMapping(value="/bootBatisTest5",method = RequestMethod.GET)
    public ResultBody bootBastisTest5(){
        return new ResultBody(sysUserMapper.selectRoleByUserIdAndRoleEnabled(1L,1));
    }

    @RequestMapping(value="/bootBatisTest6",method = RequestMethod.GET)
    public ResultBody bootBastisTest6(){
        return new ResultBody(sysUserMapper.selectByIdZhuJie(1L));
    }

    @RequestMapping(value="/bootBatisTest7",method = RequestMethod.GET)
    public ResultBody bootBastisTest7(){
        return new ResultBody(sysUserMapper.selectByIdZhujie1(1L));
    }

    @RequestMapping(value="/bootBatisTest8",method = RequestMethod.GET)
    public ResultBody bootBastisTest8(){
        return new ResultBody(sysUserMapper.selectByIdZhujie2(1L));
    }

    @RequestMapping(value="/bootBatisTest9",method = RequestMethod.GET)
    public ResultBody bootBastisTest9(){
        SysUser sysUser=new SysUser();
        sysUser.setUserName("test1");
        sysUser.setId(1002L);
        sysUser.setUserEmail("test1@mybatis.com");
        sysUser.setUserInfo("test info");
        sysUser.setHeadImg(new byte[]{1,2,3});
        sysUser.setCreateTime(new Date());
        int result=sysUserMapper.insertZhujie1(sysUser);
        return new ResultBody(sysUser.getId() + "," +  result);
    }

    @RequestMapping(value="/bootBatisTest10",method = RequestMethod.GET)
    public ResultBody bootBatisTest10(){
        SysUser sysUser=sysUserMapper.selectByPrimaryKey(1L);
        sysUser.setUserName("admin_test111111");
        int result=sysUserMapper.updateZhujie1(sysUser);
        return new ResultBody(result);
    }

    @RequestMapping(value="/bootBatisTest11",method = RequestMethod.GET)
    public ResultBody bootBastisTest11(){
        return new ResultBody(sysUserMapper.selectByUser("admin",""));
    }

    @RequestMapping(value="/bootBatisTest12",method = RequestMethod.GET)
    public ResultBody bootBastisTest12(){
        return new ResultBody(sysUserMapper.selectByIdOrUserName(1L,""));
    }

    @RequestMapping(value="/bootBatisTest13",method = RequestMethod.GET)
    public ResultBody bootBastisTest13(){
        List<Long> idList = new ArrayList<Long>();
        idList.add(1L);
        idList.add(1002L);
        return new ResultBody(sysUserMapper.selectByIdList(idList));
    }

    @RequestMapping(value="/bootBatisTest14",method = RequestMethod.GET)
    public ResultBody bootBatisTest14(){
        List<SysUser> userList = new ArrayList<SysUser>();
        for(int i = 0; i < 2; i++){
            SysUser user = new SysUser();
            user.setUserName("test" + i);
            user.setUserPassword("123456");
            user.setUserEmail("test@mybatis.tk");
            userList.add(user);
        }
        //将新建的对象批量插入数据库中，特别注意，这里的返回值 result 是执行的 SQL 影响的行数
        return new ResultBody(sysUserMapper.insertList(userList));
    }

    @RequestMapping(value="/bootBatisTest15",method = RequestMethod.GET)
    public ResultBody bootBatisTest15(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", 1L);
        map.put("user_email", "test@mybatis.tk");
        map.put("user_password", "12345678");
        //更新数据
        return new ResultBody(sysUserMapper.updateByMap(map));
    }

    @RequestMapping(value="/bootBatisTest16",method = RequestMethod.GET)
    public ResultBody bootBatisTest16(){
        return new ResultBody(sysUserMapper.selectAllUserAndRoles());
    }

    @RequestMapping(value="/bootBatisTest17",method = RequestMethod.GET)
    public ResultBody bootBatisTest17(){
        SysUser sysUser=new SysUser();
        sysUser.setId(1L);
        sysUserMapper.selectUserById(sysUser);
        return new ResultBody(sysUser);
    }

    @RequestMapping(value="/bootBatisTest18",method = RequestMethod.GET)
    public ResultBody bootBatisTest18(){
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userName", "test");
        params.put("offset", 0);
        params.put("limit", 10);
        List<SysUser> userList = sysUserMapper.selectUserPage(params);
        return new ResultBody(userList);
    }

    @RequestMapping(value="/bootBatisTest19",method = RequestMethod.GET)
    public ResultBody bootBatisTest19(){
        SysRole sysRole=sysRoleMapper.selectByPrimaryKey(2);
        sysRole.setEnabled(Enabled.disabled);
        return new ResultBody(sysRoleMapper.updateByPrimaryKey(sysRole));
    }



//    @RequestMapping(value="/mybatis1",method = RequestMethod.GET)
//    public ResultBody mybatisTest1(){
//        LogFactory.useLog4JLogging();
////        init();
//        SqlSession sqlSession=sqlSessionFactory.openSession();
//        try{
//            List<Country> countryList=sqlSession.selectList("selectAll");
//            for(Country country :countryList){
//                System.out.printf("%-4d%4s%4s\n",country.getId(), country.getCountrycode(), country.getCountryname());
//            }
//            return new ResultBody(countryList);
//        }
//        catch (Exception ex){
//            ex.printStackTrace();
//        }
//        finally {
//            sqlSession.close();
//        }
//        return null;
//    }

    /**
     * test select object
     * @return
     */
//    @RequestMapping(value="/mybatis2",method = RequestMethod.GET)
//    public ResultBody mybatisTest2(){
////        init();
//        SqlSession sqlSession=sqlSessionFactory.openSession();
//        try{
//            SysUserMapper sysUserMapper= sqlSession.getMapper(SysUserMapper.class);
//            SysUser sysUser=sysUserMapper.selectById(1L);
//            return new ResultBody(sysUser);
//        }
//        finally {
//            sqlSession.close();
//        }
//    }

    /**
     * test get list object
     * @return
     */
//    @RequestMapping(value="/mybatis3",method = RequestMethod.GET)
//    public ResultBody mybatisTest3(){
//        LogFactory.useLog4JLogging();
////        init();
//        SqlSession sqlSession=sqlSessionFactory.openSession();
//        try{
//            SysUserMapper sysUserMapper= sqlSession.getMapper(SysUserMapper.class);
//            List<SysRole> sysRoles=sysUserMapper.selectRoleByUserId(1L);
//            return new ResultBody(sysRoles);
//        }
//        finally {
//            sqlSession.close();
//        }
//    }

    /**
     * test insert object
     * @return
     */
//    @RequestMapping(value="/mybatis4",method = RequestMethod.GET)
//    public ResultBody mybatisTest4(){
////        init();
//        SqlSession sqlSession=sqlSessionFactory.openSession();
//        try{
//            SysUserMapper sysUserMapper= sqlSession.getMapper(SysUserMapper.class);
//            SysUser sysUser=new SysUser();
//            sysUser.setUserName("test1");
//            sysUser.setId(1002L);
//            sysUser.setUserEmail("test1@mybatis.com");
//            sysUser.setUserInfo("test info");
//            sysUser.setHeadImg(new byte[]{1,2,3});
//            sysUser.setCreateTime(new Date());
//            int result=sysUserMapper.insert(sysUser);
//            return new ResultBody(result);
//        }
//        finally {
//           // sqlSession.rollback();
//            sqlSession.close();
//        }
//    }

    /**
     * test update object
     * @return
     */
//    @RequestMapping(value="/mybatis5",method = RequestMethod.GET)
//
//    public ResultBody mybatisTest5(){
////        init();
//        SqlSession sqlSession=sqlSessionFactory.openSession();
//        try{
//            SysUserMapper sysUserMapper= sqlSession.getMapper(SysUserMapper.class);
//            SysUser sysUser=sysUserMapper.selectByPrimaryKey(1L);
//            sysUser.setUserName("admin_test");
//            int result=sysUserMapper.updateByPrimaryKey(sysUser);
//            return new ResultBody(result);
//        }
//        finally {
//            // sqlSession.rollback();
//            sqlSession.close();
//        }
//    }


//    public void init(){
//        try{
//            Reader reader= Resources.getResourceAsReader("mybatis-config.xml");
//            sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}

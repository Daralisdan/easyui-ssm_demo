package com.daralisdan.test;//package com.daralisdan.test;
//
//import com.daralisdan.bean.Deparment;
//import com.daralisdan.bean.Employee;
//import com.daralisdan.dao.DeparmentMapper;
//import com.daralisdan.dao.EmployeeMapper;
//import org.apache.ibatis.session.SqlSession;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.UUID;
//
///**
// *
// * Description：测试dao层的工作 <br>
// * @author yaodan  <br>
// * date 2019年7月31日 下午11:52:12 <br>
// *
// * 推荐spring的项目可以用spring的单元测试，可以自动注入我们需要的组件
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
//public class MapperTest {
//  /**
//   *
//   * Description：测试部门的mapper <br>
//   * 测试DeparmentMapper
//   * author：yaodan  <br>
//   */
//  @Autowired
//  DeparmentMapper deparmentMapper;
//
//  @Autowired
//  EmployeeMapper employeeMapper;
//
//  @Autowired
//  SqlSession sqlsession;
//
//  @Test
//  public void testCrud() {
//    /**
//    * 这是原生的测试
//    */
//    // 1.创建springIOC容器
//    // 传入配置文件的位置路径
//    // ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
//    // 2.从容器中获取mapper
//    // DeparmentMapper bean = ioc.getBean(DeparmentMapper.class);
//
//
//    /**
//     * spring的单元测试
//     * 1.导入springTest模块的jar
//     * 2.使用@ContextConfiguration指定spring配置文件的位置
//     * 3.@RunWith指定哪个单元测试来运行
//     * 4.直接使用autowired注解要使用的组件
//     * 5.注解 @Autowired
//     * DeparmentMapper DeparmentMapper;
//     */
//    System.out.println(deparmentMapper);
//    /**
//     * 1.插入几个部门
//     * 1.1引入查询方法，然后在实体类中增加有参构造器，必须添加无参构造器
//     */
//    deparmentMapper.insertSelective(new Deparment(null, "ABC"));
//    deparmentMapper.insertSelective(new Deparment(null, "测试部"));
//    deparmentMapper.insertSelective(new Deparment(null, "人力资源部"));
//    System.out.println("插入成功");
//    /**
//     * 2.生成员工数据
//     * 2.1添加注解，
//     * 2.2生成有参，无参构造器，步骤同上
//     */
//    // employeeMapper.insert(new Employee(null, "xiaogauis", "F", "xiaogauis@qq.com", 1));
//    // 批量插入多个员工，批量，使用可以执行批量的sqlSession
//    // for () {
//    // employeeMapper.insert(new Employee(null, , "F", "xiaogauis@qq.com", 1));
//    // }
//
//    /**
//     * 1.在IOC容器中 ，配置一个可以执行批量的sqlSession
//     * 2.自动注入一个SQLSession
//     */
//    EmployeeMapper mapper = sqlsession.getMapper(EmployeeMapper.class);
//    for (int i = 0; i < 1000; i++) {
//      // 因为UUID太长了就截取0到5条
//      String uid = UUID.randomUUID().toString().substring(0, 5) + i;
//      mapper.insertSelective(new Employee(null, uid, "M", uid + "@com", 1));
//    }
//    System.out.println("批量完成");
//  }
//}

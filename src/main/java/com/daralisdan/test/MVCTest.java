package com.daralisdan.test;//package com.daralisdan.test;
//
//import com.daralisdan.bean.Employee;
//import com.github.pagehelper.PageInfo;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mock.web.MockHttpServletRequest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import java.util.List;
//
///**
// *
// * Description：使用spring测试模块提供的测试请求功能，测试crud请求正确 <br>
// * @author yaodan  <br>
// * date 2019年8月2日 下午3:28:07 <br>
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//
//// 5.该注解用于获取到WebApplicationContext
//@WebAppConfiguration
//// spring配置文件的路径，springmvc配置文件的路径
//@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:springmvc.xml"})
//public class MVCTest {
//  // 测试请求
//  // 4.传入springmvc的ioc
//  @Autowired // 自动装配，只能装配ioc容器里面的
//  WebApplicationContext context;
//
//  // 1.虚拟mvc请求，获取到处理结果
//  MockMvc mockMvc;
//
//  // 2.初始化请求mockmvc
//  @Before // 6.每次用之前都要初始化一下该方法
//  public void initMockMvc() {
//    // 3.需要创建出来才能用
//    mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
//  }
//
//  // 7.编写测试分页测试方法
//  @Test
//  public void testPage() throws Exception {
//    // 7.1模拟请求并且拿到返回值
//    MvcResult result =
//        mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn", "5")).andReturn();
//    // 7.2请求成功之后，请求域中会有pageInfo,我们可以取出pageInfo进行验证
//    MockHttpServletRequest request = result.getRequest();
//    PageInfo pi = (PageInfo) request.getAttribute("pageInfo");
//    System.out.println("当前页码：" + pi.getPageNum());
//    System.out.println("总页码：" + pi.getPages());
//    System.out.println("总记录数：" + pi.getTotal());
//    System.out.println("在页面需要连续显示的页码");
//    int[] nums = pi.getNavigatepageNums();
//    for (int i : nums) {
//      System.out.print(" " + i);
//    }
//    // 获取员工数据
//    List<Employee> list = pi.getList();
//    for (Employee employee : list) {
//      System.out.println("ID:" + employee.getEmpId() + "===>Name:" + employee.getEmpName());
//    }
//  }
//}

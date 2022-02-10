package com.jt.controller;

import com.jt.pojo.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 1.Servlet-request 对象/response对象
 * 2.Servlet中如何取值?
 * URL:http://localhost:8080/user/findUser?id=100&name=tomact
 */


@RestController //=@Controller + @ResponseBody 类中的方法返回的数据都是JSON
@RequestMapping("/user") //定义公共的前缀
public class UserController {
    @RequestMapping("/user/findUser")
    public String findUser(HttpServletRequest request,
                           HttpServletResponse response){
        String id = request.getParameter("id");
        int intid = Integer.parseInt(id);
        String name = request.getParameter("name");
        return intid+":"+name;
    }

    /**
     * URL:http://localhost:8080/user/findUser2?id=100&name=tomact
     * 规则:SpringMVC中的参数名称,必须与传递参数名称一致
     * 原理:SpringMVC在内部将Servlet的取值的方式包装,用户只需要填参数
     * 就可以获取数据
     * @return
     */
    @RequestMapping("/findUser2")
    public String findUser2(Integer id,String name){
        return id+":"+name;
    }

    /**
     * URL:http://localhost:8080/user/getUser?id=1001&name=王麻子&age=18
     * 返回值:User对象
     * 知识点:
     *      当遇到多个参数时,可以使用对象封装,
     *      要求多个属性必须和参数名称一致,同时必须有set/get方法
     *      SpringMVC会自动将参数赋值给属性
     */
    @RequestMapping("/getUser")
    public User getUser(User user){
        return user;
    }

    /**
     * RestFul结构: 动态接受参数
     * URL:http://localhost:8080/user/restFul/1/张三/24
     * 难点:从URL中获取参数
     * 返回值:User对象
     * 语法:
     *     1.服务器参数接受时,变量使用{XX}进行包裹并位置固定
     *     2.利用@PathVariable注解,动态获取路径中的数据,
     *       要求名称必须匹配
     */
    @RequestMapping(value = "/restFul/{id}/{name}/{age}",method = RequestMethod.GET)
//    @GetMapping("")
//    @PostMapping
    public User restFul(@PathVariable Integer id,
                        @PathVariable String  name,
                        @PathVariable Integer age){
        User user = new User();
        user.setName(name);
        user.setId(id);
        user.setAge(age);
        return user;
    }

    /**
     * RestFul对象接受
     *       如果对象的属性与{key}相同,则可以使用对象接受,
     * 用途:restFul结构,常用于更新操作
     * @param user
     * @return
     */
    @RequestMapping("/restFul2/{id}/{name}/{age}")
    public User restFul2(User user){
        return user;
    }

    /**
     * URL地址:http://localhost:8080/user/saveHobby?hobby=篮球,排球,乒乓球
     * @param hobby
     * @return
     */
    @GetMapping("/saveHobby")
    public String[] saveHobby(String[] hobby){
//        String[] split = hobby.split(",");
        //将字符串转化为数组,可以方便后续业务调用
//        return split;
        return hobby;
    }
}

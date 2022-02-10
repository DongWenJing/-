package com.jt.controller;

import com.jt.pojo.Function11;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Controller
@RequestMapping("/game")
public class GameController {
    //1.入门测试
    @GetMapping("/start")
    public String testGeam(){
        return "游戏开始咯~";
    }
    //2.对象的形式  返回的数据是JSON串
    @GetMapping("/useGame")
    public Function11 useGame(){
        Function11 function = new Function11();
        function.setId(001);
        function.setName("卡布达");
        function.setPattern("手动变形");
        return function;
    }
    //3.使用对象接受参数
    //此方式,可以在地址栏输入与调用类属性名相同名赋值
    //URL:http://localhost:8080/game/forGame?id=2&name=大黄蜂&pattern=燃油
    @GetMapping("/forGame")
    public Function11 forGame(Function11 function11){
        return function11;
    }
    //4.RestFul的结构对象传参
    //RestFul请求: http://localhost:8080/game/restFul/3/蜻蜓队长/大米饭
    @GetMapping("/restFul/{id}/{name}/{pattern}")
    public Function11 restFul(Function11 function11){
        return function11;
    }

}

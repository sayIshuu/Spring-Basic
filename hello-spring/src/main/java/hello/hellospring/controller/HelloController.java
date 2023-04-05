package hello.hellospring.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");  // 모델에다가 data = "hello!!"라고 넣어놓은것.
        return "hello"; //get어노테이션에 의하여 resources 밑의 templates 밑에서 hello라는 이름의 파일을 찾는다.
    }
}

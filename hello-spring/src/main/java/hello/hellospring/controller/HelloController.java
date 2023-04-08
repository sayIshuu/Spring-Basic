package hello.hellospring.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
//컨트롤러 사용 예제
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");  // 모델에다가 data = "hello!!"라고 넣어놓은것.
        return "hello"; //get어노테이션에 의하여 resources 밑의 templates 밑에서 hello라는 이름의 파일을 찾는다.
    }

//mvc방식 예제
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

//템플릿엔진 안쓰고, @ResponseBody를 통해 뷰를 사용하지 않고 그대로 내려가는 방식
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

//API 예제 @ResponseBody로 객체를 반환하면 json방식으로 전달함.
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name")String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

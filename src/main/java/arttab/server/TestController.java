package arttab.server;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Slf4j
@Controller
public class TestController {
    @GetMapping("/")
    public String index() {
        log.info("Call index.html");
        return "index";
    }
    @GetMapping("/layout-test")
    public String layoutTest() {
        log.info("Call test.html");
        return "test";
    }
}

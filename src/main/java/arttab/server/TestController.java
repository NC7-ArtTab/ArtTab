package arttab.server;


import arttab.server.service.DefaultArtService;
import arttab.server.vo.Art;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Slf4j
@Controller
public class TestController {
    @GetMapping("/")
    public String index() {
        log.info("Call index.html");
        return "list";
    }
    @GetMapping("/layout-test")
    public String layoutTest() {
        log.info("Call test.html");
        return "test";
    }


}

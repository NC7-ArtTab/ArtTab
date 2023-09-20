// MyBidController.java
package arttab.server.controller;

import arttab.server.service.MyBidService;
import arttab.server.vo.Bid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyBidController {
    private final MyBidService myBidService;

    @Autowired
    public MyBidController(MyBidService myBidService) {
        this.myBidService = myBidService;
    }

    @GetMapping("/mybid")
    public String showMyBidPage(@RequestParam(value = "memNo", defaultValue = "1") int memNo, Model model) {
        model.addAttribute("getMyBidList", myBidService.getMyBidList(memNo));
        return "mybid"; // mybid.html 템플릿을 사용
    }
}

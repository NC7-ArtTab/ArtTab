package arttab.server.controller;

import arttab.server.service.MyPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyPayController {
    private final MyPayService myPayService;

    @Autowired
    public MyPayController(MyPayService myPayService) {
        this.myPayService = myPayService;
    }

    @GetMapping("/mypay")
    public String showMyPayPage(@RequestParam(value = "memNo", defaultValue = "1") int memNo, Model model) {
        // memNo를 기반으로 구매 현황 정보를 가져와서 모델에 추가
        model.addAttribute("purchaseHistory", myPayService.getPurchaseHistory(memNo));
        return "mypay"; // mypay.html 템플릿을 사용
    }
}

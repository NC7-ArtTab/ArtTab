package arttab.server.controller;

import arttab.server.service.MyBidService;
import arttab.server.vo.MyBid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mypage")
public class MyBidController {

    private final MyBidService myBidService;

    @Autowired
    public MyBidController(MyBidService myBidService) {
        this.myBidService = myBidService;
    }

    @GetMapping("/mybid")
    public List<MyBid> findByMemNo(Model model) {
        int memNo = 1; // 예시로 멤버 번호를 지정, 로그인한 정보를 가져와야 합니다.

        try {
            List<MyBid> myBids = myBidService.findByMemNo(memNo);
            model.addAttribute("myBids", myBids);
            return myBids;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

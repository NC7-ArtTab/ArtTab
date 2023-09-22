package arttab.server.controller;


import arttab.server.service.ArtService;
import arttab.server.vo.Art;
import arttab.server.vo.Bid;
import arttab.server.vo.MailSender;
import arttab.server.vo.PageNation;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Slf4j
@Controller
@RequestMapping("/art")
@RequiredArgsConstructor
public class ArtController {
    private final ArtService artService;
    private final MailSender mailSender;


    @GetMapping("detail")
    public String detail(
            @RequestParam(name="artNo") int artNo,
            Model model) throws Exception {


        Art art = artService.get(artNo);

        List<Bid> list = art.getArtBids();

        if (art != null) {
            model.addAttribute("art", art);
            model.addAttribute("list", list);
        }
        return "art/detail";
    }


    @GetMapping("list")
    public String list(Model model,
                       @RequestParam(name = "pageNo", defaultValue = "1") int pageNo,
                       @RequestParam(name = "artStatus", defaultValue = "") String artStatus,
                       @RequestParam(name = "artCategory", defaultValue = "") String artCategory) throws Exception {

        try {
            Art art = new Art();
            art.setArtCategory(artCategory);
            art.setArtStatus(artStatus);

            List<Art> artList = artService.list(art); // artCategory와 artStatus를 담아 넘김

            if (artList != null && artList.size() > 0) { // 조회된 전체 경매작품이 0 개 이상이면
                PageNation pageNation = new PageNation(pageNo);
                List<Art> subList = pageNation.toSubList(artList, pageNo);  // 현재 요청된 페이지에 보여줄 게시글만 subList로 추출

                int totalPages = pageNation.setGetTotalPages(artList.size());
                int startPage = pageNation.setGetStartPage(pageNo);
                pageNation.setGetEndPage(startPage, totalPages);

                model.addAttribute("pageNation", pageNation);
                model.addAttribute("list", subList);
            }
            model.addAttribute("artCategory", art.getArtCategory());
            model.addAttribute("artStatus", art.getArtStatus());
            return "art/list";

        } catch (Exception e) {
            throw e;
        }
    }

    @PostMapping("/update")
    @ResponseBody
    public void update(HttpServletResponse response, @RequestParam(name = "artNo") int artNo) throws Exception {
        try {
            int bidMaxPirce = 0;
            Art art = artService.get(artNo);  // 경매작품 데이터 한번 더

            if (art.getArtBids() != null && art.getArtBids().size() > 0) { // 해당 경매작품의 입찰기록이 1개 이상 존재하면
                bidMaxPirce = art.getArtBids().get(0).getBidPrice(); // 가격을 최신화
            }

            if (!"P".equals(art.getArtStatus())) { // 작품의 상태가 이미 취소인 상태이면 에러페이지로 이동
                throw new Exception();
            }


            if ("P".equals(art.getArtStatus()) && bidMaxPirce == 0) { // 진행중인 경매건이면서 아무도 입찰을 안했으면
                art.setArtStatus("F"); // 그냥 종료로 변경
                artService.update(art);
            } else if ("P".equals(art.getArtStatus()) && bidMaxPirce > 0) { // 진행중인 경매건이면서 현재 입찰가(최고입찰가)가 있으면
                art.setArtStatus("Y"); // 낙찰 처리
                artService.update(art);

                // 최고 입찰자의 메일로 낙찰 메일 전송<수정해야함!!!>
                mailSender.sendMail(art, "itkw87@naver.com");

                System.out.println(mailSender.toString());
            }

            Gson gson = new Gson();
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("artTitle", art.getArtTitle());
            response.setContentType("application/json; charset=UTF-8");
            response.getWriter().print(gson.toJson(data));

        } catch (Exception e) {
            throw e;
        }
    }

    @PostMapping("/realTimeInfo")
    @ResponseBody
    public void realTimeInfo(HttpServletResponse response, @RequestParam(name = "artNo") int artNo) throws Exception {
        try {
            Art art = artService.get(artNo);

            Map<String, Object> data = new HashMap<String, Object>();

            data.put("art", art);
            Gson gson = new Gson();

            response.setContentType("application/json; charset=UTF-8");
            response.getWriter().print(gson.toJson(data));
        } catch (Exception e) {
            throw e;
        }
    }
}
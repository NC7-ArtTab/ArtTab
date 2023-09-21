package arttab.server.controller;

import arttab.server.dao.FAQDao;
import arttab.server.service.FAQService;
import arttab.server.vo.FAQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FAQController {
    private final FAQService faqService;

    @Autowired
    public FAQController(FAQService faqService) {
        this.faqService = faqService;
    }

    @GetMapping("/faq")
    public String showFAQPage(Model model) {
        List<FAQ> faqList = faqService.getAllFAQs();
        model.addAttribute("faq-list", faqList);
        return "faq";
    }

    @GetMapping("/api/faq")
    @ResponseBody
    public List<FAQ> getFAQList() {
        return faqService.getAllFAQs();
    }
}

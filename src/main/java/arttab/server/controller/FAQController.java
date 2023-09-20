package arttab.server.controller;

import arttab.server.service.FAQService;
import arttab.server.vo.FAQ;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class FAQController {

    private final FAQService faqService;

    public FAQController(FAQService faqService) {
        this.faqService = faqService;
    }

    @GetMapping("/faq/list") // FAQ 목록
    public String faqList(Model model) {
        List<FAQ> faqs = faqService.getAllFAQs();
        model.addAttribute("faqs", faqs);
        return "faq/list";
    }

    @GetMapping("/faq/view/{faqId}")
    public String viewFAQ(@PathVariable Long faqId, Model model) {
        // faqId를 사용하여 해당 FAQ의 내용을 불러옴
        FAQ faq = faqService.getFAQById(faqId);
        model.addAttribute("faq", faq);
        return "faq/view";
    }
}

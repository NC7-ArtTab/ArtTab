package arttab.server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalControllerAdvice {
  @ExceptionHandler(Exception.class)
  public Object exceptionHandler(Exception e, HttpServletRequest request) {
    if (isAjaxRequest(request)) {
      // 실패 응답 생성
      Map<String, String> errorResponse = new HashMap<>();
      errorResponse.put("error", e.getMessage());

      // 실패 응답과 HTTP 상태 코드를 반환
      return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST); // 상태코드 400으로 응답
    } else {
      ModelAndView mv = new ModelAndView();
      mv.addObject("exception", e);
      mv.addObject("message", e.getMessage());
      mv.setViewName("error");
      return mv;
    }
  }

  private boolean isAjaxRequest(HttpServletRequest request) {
    return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
  }
}

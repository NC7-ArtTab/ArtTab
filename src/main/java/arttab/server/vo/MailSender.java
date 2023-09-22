package arttab.server.vo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;


@Getter
@Setter
@ToString
@Slf4j
@RequiredArgsConstructor
@Component
public class MailSender {
  private final SenderProperties senderProperties;

  public void sendMail(Art art, String recipient) {
     // SMTP 서버 정보 설정
    // TLSv1.2 추가하여 신뢰성 확보
    Properties prop = new Properties();
    prop.put("mail.smtp.host", "smtp.gmail.com");
    prop.put("mail.smtp.port", 465);
    prop.put("mail.smtp.auth", "true");
    prop.put("mail.smtp.ssl.enable", "true");
    prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
    prop.put("mail.smtp.ssl.protocols", "TLSv1.2");

    Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(senderProperties.getUser(), senderProperties.getPassword());
      }
    });

    try {
      MimeMessage message = new MimeMessage(session);

      // 발신자 정보
      message.setFrom(new InternetAddress(senderProperties.getUser(), "ArtTab"));

      // 수신자 메일주소
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

      // 메일 제목
      message.setSubject("경매에 낙찰되셨습니다."); //메일 제목을 입력

      // 메일 내용
      // HTML 문자열을 빌드하기 위한 StringBuilder 생성
      StringBuilder htmlContent = new StringBuilder();
      htmlContent.append("<html><body style='font-family: Arial, sans-serif;'>");
      htmlContent.append("<div style='border: 10px solid gold; text-align: center; padding: 20px; width: 600px; margin: 0 auto;'>");
      htmlContent.append("<div style='color: #333; font-size: 24px;'>경매작품을 낙찰 받으셨습니다!</div>");
      htmlContent.append("<div style='font-size: 18px; margin-top: 20px;'>");
      htmlContent.append("<p>" + art.getArtTitle() + " 이(가)<span style='color: #ff0000; font-weight: bold;'>" + art.getArtBids().get(0).getBidPrice() + "</span>(원)에 낙찰되었습니다.</p>");
      htmlContent.append("<p>해당 낙찰건에 대한 자세한 정보는 아래 링크를 확인해주세요!</p>");
      htmlContent.append("<div style='border: 10px double gold; padding: 10px; display: inline-block;'>"); // 이중액자 테두리 스타일
      htmlContent.append("<a href='http://localhost:8080'>ArtTab 방문하기</a>");
      htmlContent.append("<br>"); // 줄 바꿈
      htmlContent.append("<img src='https://i.namu.wiki/i/50YwMBj6uGsRxdbGd2LBLp1WyLqntJ7u6XI4NgNoSRQTnZiRTbc_c7CEuYShyBhZyhAonB8bVDIO18gRO3jx3Q.jpg' alt='작품 이미지' style='max-width: 100%;'>");
      htmlContent.append("</div>");
      htmlContent.append("</div>");
      htmlContent.append("</div>");
      htmlContent.append("</body></html>");

      // 이메일 메시지에 HTML 내용 설정
      message.setContent(htmlContent.toString(), "text/html; charset=utf-8");

      // 전송
      Transport.send(message);
      System.out.println("메일 전송 완료");
    } catch (AddressException e) {
      e.printStackTrace();
    } catch (MessagingException e) {
      e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }
}

package ssy.mail;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import lombok.Data;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-04-20 18:10
 */
@Data
public class MailTest {

  //----------邮件--------
  //"javax.mail:javax.mail-api:1.6.2",
  //"com.sun.mail:javax.mail:1.6.2",
  //----------邮件--------

  private String to;

  private String from;

  private String smtpServer;

  private String userName;

  private String password;

  private String subject;

  private String content;

  private List<String> list = new ArrayList<>();


  public void sendMail() {
    Properties properties = System.getProperties();
    properties.put("mail.smtp.host", smtpServer);
    properties.put("mail.smtp.auth", "true");

    Session session = Session.getDefaultInstance(properties, new Authenticator() {
      @Override
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(userName, password);
      }
    });

    try {
      //5.	MimeMessage，代表一个真正的邮件
      MimeMessage message = new MimeMessage(session);
      message.setFrom(new InternetAddress(from));
      InternetAddress[] address = {new InternetAddress(to)};
      message.setRecipients(RecipientType.TO, address);
      message.setSubject(subject);
      message.setText(content);

      //邮件体
      Multipart mp = new MimeMultipart();
      MimeBodyPart mbp = new MimeBodyPart();
      mbp.setText(content);
      mp.addBodyPart(mbp);

      //处理附件
      for (String fileName : list) {
        MimeBodyPart mbpFile = new MimeBodyPart();
        FileDataSource fileDataSource = new FileDataSource(fileName);
        mbpFile.setDataHandler(new DataHandler(fileDataSource));

        mbpFile.setFileName(new File(fileName).getName());
        mp.addBodyPart(mbpFile);
      }

      message.setContent(mp);
      message.setSentDate(new Date());

      Transport.send(message);
    } catch (MessagingException e) {
      e.printStackTrace();
    }
  }


  public static void main(String[] args) {
    MailTest mail = new MailTest();
    mail.setSmtpServer("smtp.163.com");
    mail.setUserName("chenjitang56");
    mail.setPassword("cjt2016");
    mail.setTo("15359329600@163.com");
    mail.setTo("282903282@qq.com");
    mail.setFrom("chenjitang56@163.com");
    mail.setSubject("这是java发送的mail标题2");
    mail.setContent("这是邮件测试内容...!!");

    mail.getList().add("c:/temp/666.doc");
    mail.getList().add("c:/temp/12320.xls");

    mail.sendMail();
  }


}

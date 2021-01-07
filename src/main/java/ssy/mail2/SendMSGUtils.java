package ssy.mail2;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import java.util.Properties;

/**
 * 发送邮件
 * 
 * @author heshui fan
 *
 */

public class SendMSGUtils {


  private String mailUser = "282903282@qq.com";

  private String mailPassword = "aefcfwkgdrezbifh";

  /** 配置默认的邮箱地址*/
  private String receiErrorMssgMail = "jimmy723@qq.com";

  /**
   * 发送邮件
   * 
   * @param receiMail 接受者邮件地址，可以是集合。多个用 英文逗号隔开
   * @param conent 邮件内容
   * @param title 邮件标题
   */
  public void sendQQEMail(String receiMail, String conent, String title) {
    try {
      String[] receiMailStr = receiMail.split(",");
      Properties props = new Properties();
      // 表示SMTP发送邮件，需要进行身份验证
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.host", "smtp.qq.com");
      // 发件人的账号
      props.put("mail.user", mailUser);
      // 访问SMTP服务时需要提供的密码
      props.put("mail.password", mailPassword); // 不是qq的真正密码，而是授权码。在邮箱-设置-账户-找到发送密码的地方
      // props.put("mail.debug", "true");// 设置是否显示debug信息 true 会在控制台显示相关信息
      props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
      props.put("mail.smtp.port", 587); // 端口号 465 有问题
      props.put("mail.smtp.socketFactory.port", 587); // 端口号 465 有问题
      Authenticator authenticator = new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
          // 用户名、密码
          return new PasswordAuthentication(mailUser, mailPassword);
        }
      };
      // 使用环境属性和授权信息，创建邮件会话
      Session mailSession = Session.getInstance(props, authenticator);
      // 创建邮件消息
      MimeMessage message = new MimeMessage(mailSession);
      // 设置发件人
      InternetAddress form = new InternetAddress(mailUser);
      InternetAddress[] tos = new InternetAddress[receiMailStr.length];
      message.setFrom(form);
      for (int i = 0; i < receiMailStr.length; i++) {
        // 设置收件人
        InternetAddress to = new InternetAddress(receiMailStr[i]);
        tos[i] = to;
        // // 设置抄送
        // InternetAddress cc = new
        // InternetAddress("luo_aaaaa@yeah.net");
        // message.setRecipient(RecipientType.CC, cc);
      }
      // 设置收件人
      message.setRecipients(RecipientType.TO, tos);
      // 设置邮件标题
      message.setSubject(title);
      // 设置邮件的内容体
      message.setContent(conent, "text/html;charset=UTF-8");
      // 发送邮件
      Transport.send(message);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
 
  /**
   * 发送给默认系统邮箱的邮件信息
   * 
   * @param conent 邮件内容
   * @param title 邮件标题
   */
  public void sendDefalutEMail(String conent, String title) {
    this.sendQQEMail(receiErrorMssgMail, conent, title);
  }

  public static void main(String[] args) {
    SendMSGUtils t = new SendMSGUtils();
    t.sendQQEMail("282903282@qq.com", "吉米测试666666", "案件测试标题");

  }
}

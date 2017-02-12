package com.geekidentity.mail;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.geekidentity.util.PropertiesUtils;

public class JavaMailUtil {
    public static String EmailAccount = PropertiesUtils.getValue("mail.account");
    public static String EmailPassword = PropertiesUtils.getValue("mail.password");
    public static String EmailSMTPHost = PropertiesUtils.getValue("mail.host");
    public static String ReceiveAccount = PropertiesUtils.getValue("mail.host");

	public static void sendMail(String content) throws Exception {
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.host", EmailSMTPHost);        // 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.auth", "true");            // 请求认证，参数名称与具体实现有关

        // 2. 根据配置创建会话对象, 用于和邮件服务器交互
        Session session = Session.getDefaultInstance(props);
        session.setDebug(true); 
     // 3. 创建一封邮件
        MimeMessage message = createMimeMessage(session);
		message.setFrom(new InternetAddress("houfachao1994@163.com", "USER_AA", "UTF-8"));
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress("geekidentity@163.com", "侯法超", "UTF-8"));
		// 4. 根据 Session 获取邮件传输对象
        Transport transport = session.getTransport();
        // 5. 使用 邮箱账号 和 密码 连接邮件服务器
        // 这里认证的邮箱必须与 message 中的发件人邮箱一致，否则报错
        transport.connect(EmailAccount, EmailPassword);

        // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
        transport.sendMessage(message, message.getAllRecipients());

        // 7. 关闭连接
        transport.close();
	}
	
	/**
     * 创建一封只包含文本的简单邮件
     *
     * @param session 和服务器交互的会话
     * @return
	 * @throws MessagingException 
	 * @throws UnsupportedEncodingException 
     * @throws Exception
     */
    public static MimeMessage createMimeMessage(Session session) throws UnsupportedEncodingException, MessagingException {
        // 1. 创建一封邮件
        MimeMessage message = new MimeMessage(session);

        // 2. From: 发件人
        message.setFrom(new InternetAddress(EmailAccount, "侯法超", "UTF-8"));

        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(ReceiveAccount, "XX用户", "UTF-8"));

        // 4. Subject: 邮件主题
        message.setSubject("打折钜惠", "UTF-8");

        // 5. Content: 邮件正文（可以使用html标签）
        message.setContent("XX用户你好, 今天全场5折, 快来抢购, 错过今天再等一年。。。", "text/html;charset=UTF-8");

        // 6. 设置发件时间
        message.setSentDate(new Date());

        // 7. 保存设置
        message.saveChanges();

        return message;
    }
}

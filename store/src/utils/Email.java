package utils;


import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


import model.User;
public class Email extends Thread{

			String emailUser = "2832353697@qq.com";
			String emailPwd = "qtqtbnwmnltpdcei";
			String emailHost = "smtp.qq.com";
			private User user;
			
			public Email(User user) {
		        this.user = user;
		    }
			public void run() {
		        Transport ts = null;
		        try {
			//获取系统环境信息
			Properties props = System.getProperties();
			//设置邮件服务器
			props.setProperty("mail.smtp.host", emailHost); 
			//设置密码认证
			props.setProperty("mail.smtp.auth", "true");
			//设置传输协议
			props.setProperty("mail.transport.protocol", "smtp");
			
            
			//创建session对象
            Session session = Session.getDefaultInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(emailUser,emailPwd);
                }
            });
			//设置输出日志
			session.setDebug(true);
 
			//获取邮件发送管道
			ts=session.getTransport();
			//连接管道
			ts.connect(emailHost, emailUser, emailPwd);
			
			//邮件发送对象
			MimeMessage message = new MimeMessage(session);
			//设置发件人
			message.setFrom(new InternetAddress(emailUser));
			//设置邮件主题
			message.setSubject("注册信息");
			
			message.setRecipient(Message.RecipientType.TO,new InternetAddress(user.getEmail()));//收件人
            String info = "注册成功!你的账号信息为:用户名: " + user.getUsername() + "   密码: " + user.getPassword();
            message.setContent("<h1 style='color: red'>" + info + "</h1>","text/html;charset=UTF-8");//邮件内容
            message.saveChanges();//保存设置
			//发送邮件
			ts.sendMessage(message,message.getAllRecipients());
		
			
	
		} 
		catch (MessagingException e) {
			e.printStackTrace();
		} finally {
	            //关闭连接
	            try {
	                ts.close();
	            } catch (MessagingException e) {
	                e.printStackTrace();
	            }
	        }
	
			}
			
}

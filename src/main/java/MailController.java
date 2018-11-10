import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class MailController {

  //  private String host = "smtp.gmail.com"; //for gmail
    private String host = "smtp-mail.outlook.com"; //for outllok

    private String user = "mti.tareq.test@outlook.com";
    private String pass = "tareq82737";
    private String to = "mti.tareq3@gmail.com";
    private String from = "mti.tareq.test@outlook.com";
    private String subject = "This is a test Sub";
    private String messageText = "Your Is Test Email :";
    private boolean sessionDebug = false;

    public void send(){
        try {

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587"); //this port 587 for both gmail and outlook
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

            Session mailSession = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(user, pass);
                }
            });
            mailSession.setDebug(sessionDebug);

            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setText(messageText);

            Transport transport = mailSession.getTransport("smtp");
            transport.connect(host, user, pass);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            System.out.println("message send successfully");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public MailController(String to, String subject, String messageText) {
        this.to = to;
        this.subject = subject;
        this.messageText = messageText;
    }
}

//Note: Go To This Link : "https://www.google.com/settings/security/lesssecureapps"
// and Make "TURN ON" then ur application runs For Sure.

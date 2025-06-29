package utils;

import jakarta.mail.*;
import jakarta.mail.search.FlagTerm;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailReader {

    public static String getResetLink(String host, String user, String password) throws Exception {
        Properties properties = new Properties();
        properties.put("mail.store.protocol", "imaps");

        Session session = Session.getInstance(properties);
        Store store = session.getStore("imaps");
        store.connect(host, user, password);

        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);

        Message[] messages = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));
        for (int i = messages.length - 1; i >= 0; i--) {
            Message message = messages[i];
            String subject = message.getSubject();

            if (subject != null && subject.contains("Password Reset")) {
                Object content = message.getContent();
                String body;
                if (content instanceof String) {
                    body = (String) content;
                } else if (content instanceof Multipart) {
                    Multipart multipart = (Multipart) content;
                    StringBuilder result = new StringBuilder();
                    for (int j = 0; j < multipart.getCount(); j++) {
                        BodyPart part = multipart.getBodyPart(j);
                        result.append(part.getContent().toString());
                    }
                    body = result.toString();
                } else {
                    continue;
                }

                Matcher matcher = Pattern.compile("https://app\\.novacrm\\.ca/[^\"]+").matcher(body);
                if (matcher.find()) {
                    return matcher.group(0);
                }

            }
        }

        throw new Exception("Reset link not found in email");
    }
}
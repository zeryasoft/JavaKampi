package eTicaret.core.servis;

import java.util.Random;

public class VerificationMailSender implements MailSender{
    @Override
    public String send(String mail) {
        Random rand = new Random();
        String code = String.valueOf(rand.nextInt(1000));
        System.out.println("Merhabalar, " + mail +"mail Onay kodunuz: " + code);
        return code;
    }
}

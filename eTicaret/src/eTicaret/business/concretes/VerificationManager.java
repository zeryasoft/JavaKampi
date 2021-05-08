package eTicaret.business.concretes;

import java.util.Scanner;

import eTicaret.business.abstracts.VerificationService;
import eTicaret.core.servis.MailSender;

public class VerificationManager implements VerificationService {
	
    private MailSender mailSender;
    public VerificationManager(MailSender mailSender){
        this.mailSender = mailSender;
    }
    
    @Override
    public boolean verificate(String mail) {
        String code = "";
        try{
            Thread.sleep(1000);
            code = mailSender.send(mail);
        }catch (Exception e){
            System.out.println("HATA!!!");
        }
        Scanner scan = new Scanner(System.in);
        System.out.print("Lütfen gelen kodu giriniz: ");
        String enteredCode = scan.nextLine();
        if(!code.equals(enteredCode)){
            return false;
        }
        System.out.println("Mailiniz Aktifleþti");
        return true;
    }
}
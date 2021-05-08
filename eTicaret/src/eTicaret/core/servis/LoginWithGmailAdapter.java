package eTicaret.core.servis;

import eTicaret.microService.Google.LoginWithGmail;

public class LoginWithGmailAdapter implements LoginWithGmailService {
    @Override
    public boolean login(String mail, String password) {
        LoginWithGmail loginWithGmail = new LoginWithGmail();
        return loginWithGmail.login(mail,password);
    }
}

package SupportClasses;

import Service.DecryptService;
import Service.EncryptService;

public class Runner {
    public void run(String[] arguments){
        EncryptService encryptService = new EncryptService();
        DecryptService decryptService = new DecryptService();
        if(arguments[0].equals(Constants.ENCRYPT_MODE)){
            encryptService.encrypt(arguments[1], arguments[2]);
        }
        else if(arguments[0].equals(Constants.DECRYPT_MODE)){
            decryptService.decrypt(arguments[1], arguments[2]);
        }

    }
}

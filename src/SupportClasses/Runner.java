package SupportClasses;

import Service.DecryptService;
import Service.EncryptService;

import java.io.File;

public class Runner {
    public void run(String[] arguments){
        final String MODE = arguments[0];
        final String FilePath = arguments[1];
        final String KEY = arguments[2];

        EncryptService encryptService = new EncryptService();
        DecryptService decryptService = new DecryptService();
        if(MODE.equals(Constants.ENCRYPT_MODE)){
            encryptService.encrypt(FilePath, KEY);
        }
        else if(MODE.equals(Constants.DECRYPT_MODE)){
            decryptService.decrypt(FilePath, KEY);
        }

    }
}

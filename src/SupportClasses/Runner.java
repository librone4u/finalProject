package SupportClasses;

import Service.DecryptService;
import Service.EncryptService;

import java.io.File;

public class Runner {
    public void run(String[] arguments){
        final String MODE = arguments[Constants.MODE_INDEX];
        final String FilePath = arguments[Constants.FILE_PATH_INDEX];
        final String KEY = arguments[Constants.KEY_INDEX];

        EncryptService encryptService = new EncryptService();
        DecryptService decryptService = new DecryptService();

        Validator.ValidateInputData(arguments);

        if(MODE.equals(Constants.ENCRYPT_MODE)){
            encryptService.encrypt(FilePath, KEY);
        }
        else if(MODE.equals(Constants.DECRYPT_MODE)){
            decryptService.decrypt(FilePath, KEY);
        }

    }
}

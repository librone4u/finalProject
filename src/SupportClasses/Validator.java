package SupportClasses;
import Exception.InvalidArgumentException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Calendar;

public class Validator {
    public static void ValidateInputData(String[] args){
        ValidateLengthOfArguments(args);
        ValidateCommand(args[Constants.MODE_INDEX]);
        ValidateFilePath(args[Constants.FILE_PATH_INDEX]);
    }
    private static void ValidateLengthOfArguments(String[] args){
        if(args.length > 2){
            throw new InvalidArgumentException("There can not be more than 3 arguments \njava -jar myApp.jar command filePath key");
        }
        else if(args.length < 2){
            throw new InvalidArgumentException("There can not be less than 3 arguments \njava -jar myApp.jar command filePath key");
        }
    }
    private static void ValidateCommand(String mode){
        if(!mode.equals(Constants.ENCRYPT_MODE) && !mode.equals(Constants.DECRYPT_MODE)){
            throw new InvalidArgumentException("Command is not exist \n Please choose: ENCRYPT/DECRYPT");
        }
    }
    private static void ValidateFilePath(String FilePath){
        if(FilePath.isBlank()){
            throw new InvalidArgumentException("File is empty");
        }
        if(!Files.exists(Path.of(FilePath))){
            throw new InvalidArgumentException("File not founded");
        }
    }
}

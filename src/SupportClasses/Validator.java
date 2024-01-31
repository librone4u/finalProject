package SupportClasses;
import Exception.InvalidArgumentException;

import java.nio.file.Files;
import java.nio.file.Path;

public class Validator {
    public static void validateInputData(String[] args){
        validateLengthOfArguments(args);
        validateCommand(args[Constants.MODE_INDEX]);
        validateFilePath(args[Constants.FILE_PATH_INDEX]);
    }
    private static void validateLengthOfArguments(String[] args){
        if(args.length > 3){
            throw new InvalidArgumentException("There can not be more than 3 arguments \njava -jar myApp.jar command filePath key");
        }
        else if(args.length < 2){
            throw new InvalidArgumentException("There can not be less than 3 arguments \njava -jar myApp.jar command filePath key");
        }
    }
    private static void validateCommand(String mode){
        if(!mode.equals(Constants.ENCRYPT_MODE) && !mode.equals(Constants.DECRYPT_MODE)){
            throw new InvalidArgumentException("Command is not exist \n Please choose: ENCRYPT/DECRYPT");
        }
    }
    private static void validateFilePath(String FilePath){
        if(FilePath.isBlank()){
            throw new InvalidArgumentException("File is empty");
        }
        if(!Files.exists(Path.of(FilePath))){
            throw new InvalidArgumentException("File not founded");
        }
    }
}

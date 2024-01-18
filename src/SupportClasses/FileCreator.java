package SupportClasses;

import java.io.File;
import java.io.IOException;

public class FileCreator {
    public File createNewFile(File file, Enum mode){
        String currentFileName = file.getName();
        int dotIndex = currentFileName.lastIndexOf(".");
        int openParenIndex = currentFileName.lastIndexOf("(");

        if(openParenIndex != -1){
            currentFileName = currentFileName.substring(0 , openParenIndex) + currentFileName.substring(dotIndex);
            dotIndex = currentFileName.lastIndexOf(".");
        }

        final String absolutePath = file.getAbsolutePath();
        String nameForNewFiles = null;

        if(dotIndex != -1){
            nameForNewFiles = currentFileName.substring(0, dotIndex) + "(" + mode + ")" + currentFileName.substring(dotIndex);
        }
        File newFile = new File(absolutePath.substring(0, absolutePath.lastIndexOf(File.separator) + 1) + nameForNewFiles);
        try {
            newFile.createNewFile();
        } catch (Exception e) {
            System.out.println("Path is wrong");;
        }
        return newFile;
    }
}

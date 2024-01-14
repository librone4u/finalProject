package SupportClasses;

import java.io.File;
import java.io.IOException;

public class CreateNewFile {
    public File createNewFile(File file, Enum mode){
        final String currentFileName = file.getName();
        final String absolutePath = file.getAbsolutePath();
        final String absolutePathOfNewFile = null;
        String nameForNewFiles = null;

        int dotIndex = currentFileName.lastIndexOf(".");

        if(dotIndex != -1){
            nameForNewFiles = currentFileName.substring(0, dotIndex) + "(" + mode + ")" + currentFileName.substring(dotIndex);
        }
        File newFile = new File(absolutePath.substring(0, absolutePath.lastIndexOf(File.separator) + 1) + nameForNewFiles);
        try {
            newFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return newFile;
    }
}

package Service;

import SupportClasses.FileCreator;
import SupportClasses.Mode;
import Transformer.TextTransformer;

import java.io.*;

public class EncryptService {
    private TextTransformer textTransformer = new TextTransformer();
    private FileCreator fileCreator = new FileCreator();

    public void encrypt(String filePath, String key){
        File currentFilePath = new File(filePath);
        final File inputStream = currentFilePath;
        File encryptedFile = fileCreator.createNewFile(currentFilePath, Mode.ENCRYPT);
        final File outputStream = encryptedFile;

        try(BufferedReader reader = new BufferedReader(new FileReader(inputStream));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputStream))){

        String line;
        while((line = reader.readLine()) != null){
            String text = textTransformer.moveLetterOnRightPosition(Integer.parseInt(key), line);
            writer.write(text);
            writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("File not found");;
        }
    }

}

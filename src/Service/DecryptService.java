package Service;

import SupportClasses.FileCreator;
import SupportClasses.Mode;
import Transformer.TextTransformer;

import java.io.*;

public class DecryptService {
    TextTransformer textTransformer = new TextTransformer();
    FileCreator fileCreator = new FileCreator();

    public void decrypt(String filePath , String key){
        File currentFilePath = new File(filePath);
        final File inputStream = currentFilePath;
        File decryptedFile = fileCreator.createNewFile(currentFilePath, Mode.DECRYPT);
        final File outputStream = decryptedFile;

        try(BufferedReader reader = new BufferedReader(new FileReader(inputStream));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputStream))) {

            String line;
            while((line = reader.readLine()) != null){
                String text = textTransformer.moveLetterOnLeftPosition(Integer.parseInt(key), line);
                writer.write(text);
                writer.newLine();
            }
        } catch (Exception e) {
            System.out.println("File not found");
        }
    }
}

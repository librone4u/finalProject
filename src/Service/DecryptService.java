package Service;

import SupportClasses.CreateNewFile;
import SupportClasses.Mode;
import Transformer.TextTransformer;

import java.io.*;

public class DecryptService {
    TextTransformer textTransformer = new TextTransformer();
    CreateNewFile createNewFile = new CreateNewFile();

    public void decrypt(File file , int key){
        final File inputStream = file;
        File decryptedFile = createNewFile.createNewFile(file, Mode.DECRYPT);
        final File outputStream = decryptedFile;

        try(BufferedReader reader = new BufferedReader(new FileReader(inputStream));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputStream))) {

            String line;
            while((line = reader.readLine()) != null){
                String text = textTransformer.moveLetterOnLeftPosition(key, line);
                writer.write(text);
                writer.newLine();
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

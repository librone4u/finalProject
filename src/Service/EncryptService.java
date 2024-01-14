package Service;

import SupportClasses.CreateNewFile;
import SupportClasses.Mode;
import Transformer.TextTransformer;

import java.io.*;

public class EncryptService {
    private TextTransformer textTransformer = new TextTransformer();
    private CreateNewFile createNewFile = new CreateNewFile();
    public void encrypt(File file, int key){
        final File inputStream = file;
        File encryptedFile = createNewFile.createNewFile(file, Mode.ENCRYPT);
        final File outputStream = encryptedFile;

        try(BufferedReader reader = new BufferedReader(new FileReader(inputStream));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputStream))){

        String line;
        while((line = reader.readLine()) != null){
            String text = textTransformer.moveLetterOnRightPosition(key, line);
            writer.write(text);
            writer.newLine();
        }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args){
        String filePath = "C:\\Users\\user\\Downloads\\Java-Advanced-Streams-Files-and-Directories-Resources\\Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        try(FileInputStream fis = new FileInputStream(filePath)){
            StringBuilder binaryOutput = new StringBuilder();

            int byteData;
            while((byteData = fis.read()) != -1){
                if(binaryOutput.length() > 0){
                    binaryOutput.append(",");
                }
                binaryOutput.append(String.format("%s ", Integer.toBinaryString(byteData & 0xFF)).replace(' ', '0'));
            }
            System.out.println(binaryOutput.toString());
        }catch(IOException e){
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}

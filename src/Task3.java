import java.io.*;

public class Task3
{
    public static void main(String[] args) throws IOException  {

        int a;
        try(FileInputStream fis = new FileInputStream("Paragraph-example.txt");
            FileOutputStream fos = new FileOutputStream("copyParagraph-example.txt"))
        {
            do {
                a = fis.read();
                if ((char) a == ' ') a = '-'; //replace space with - (dash)
                if (a != -1) fos.write(a);
            }
            while (a != -1);
            System.out.println("Copied successfully");
        }
        catch (FileNotFoundException e){
            System.out.println("The file is not found");
        }
        catch (IOException e){
            System.out.println("Error");
        }
    }
}

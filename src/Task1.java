import java.io.*;

public class Task1
{
    public static void main(String[] args) throws IOException
    {
        FileInputStream file;
        int a;

        try{
            file = new FileInputStream("Test.txt");
        }catch (FileNotFoundException e)
        {
            System.out.println("File not Found");
            return;
        }

        try {
            do{
                a=file.read();
                if(a!=-1)System.out.print((char)a);
            }while (a!=-1);
        }catch (IOException e)
        {
            System.out.println("Error reading file");
        }finally {
            file.close();
            System.out.println("\nClosing file");
        }
    }
}

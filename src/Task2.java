import java.io.*;
public class Task2
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

            try(FileInputStream fis = new FileInputStream("Test.txt")) {
                do{
                    a=fis.read();
                    if(a!=-1) System.out.print((char)a);
                }while (a!=-1);
            }catch (IOException e)
            {
                System.out.println("Error reading file");
            }finally {
                System.out.println("\nClosing file");
            }
        }
}



import java.io.*;
import java.util.*;

public class Task4 {
    public static void main(String[] args) throws IOException{
        DataManagement data = new DataManagement();
        data.readData();
        data.writeDataToFile();
        data.readDataFromFile();
    }
}


class DataManagement {
    private static String name;
    public static List<String> names = new ArrayList<>();

    static void readData() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count=0;
        System.out.println("Type 'end' when finish");
        while (count==0)
        {
            System.out.println("Enter Full Name : ");
            name = br.readLine();
            if(name.equals("end")) {
                count=1;
                break;
            }
            names.add(name);
        }
    }

    static void writeDataToFile() throws IOException {
        try (FileWriter fw = new FileWriter("Name-List.txt"))
        {
            //fw.write(String.valueOf(names));
            for(int i=0;i<names.size();i++)
            {
                fw.write(names.get(i));
                fw.write("\n");
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File is not found");
        }
        catch(IOException e){
            System.out.println("Error");
        }
    }

    static void readDataFromFile() {
        int a;
        FileInputStream file;
        try{
            file = new FileInputStream("Name-List.txt");
        }catch (FileNotFoundException e)
        {
            System.out.println("File not Found");
            return;
        }
        try(FileInputStream fis = new FileInputStream("Name-List.txt")) {
            System.out.println("-------------------------------");
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
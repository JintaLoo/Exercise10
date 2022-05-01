import java.io.*;
import java.net.URL;

public class Task5 {
    public static void main(String[] args) throws IOException {

        URL url = new URL("https://ewib.nbp.pl/plewibnra?dokNazwa=plewibnra.txt");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the first three digit of your bank account = ");
        String accountNumber = bf.readLine();

        try(BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream())))
        {
            String line;
            System.out.println("Reading the line");

            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\t+");
                String bankNumber = words[0].trim();
                String bankName = words[1].trim();
                if (bankNumber.equals(accountNumber)){
                    System.out.println("-------------------------------------");
                    System.out.println("Bank number : " + bankNumber + " \nBank : " + bankName);
                    break;
                }
            }
        }
        catch(IOException e){
            System.out.println("Error");
        }

    }
}
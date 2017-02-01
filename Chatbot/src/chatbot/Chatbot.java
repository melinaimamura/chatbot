package chatbot;
import java.util.Scanner;
public class Chatbot {
    public static void main(String[] args) {
     Scanner reader = new Scanner(System.in);
     Magpie_Class chat = new Magpie_Class();
     System.out.println(chat.greeting());
     while(true)
     {
        String ans1 = reader.nextLine();
        String resp = chat.getResponse(ans1);
        System.out.println(resp);
        if(resp.equals("Bye!"))
            break;
     }
          
    }
    
}

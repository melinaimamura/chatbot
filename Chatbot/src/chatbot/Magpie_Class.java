package chatbot;
import java.util.Random;
public class Magpie_Class {
    public String greeting()
    {
        String hello = "Hello, let's talk!";
        return hello;
    }
    public String getResponse(String x)
    {
        String answer = x;
        String responseNo = "Ouch.";
        if((findKeyword(answer, "bye", 0) == 0) || answer.contains("goodbye"))
        {
            return "Bye!";
        }
        else if((findKeyword(answer, "hi", 0) == 0) ||
                (findKeyword(answer, "hello", 0) == 0))
        {
            return "What did you do today?";
        }
        else if(findKeyword(answer, "i want", 0) == 0 )
        {
            int word = answer.indexOf("want ") + 5; 
            return "Would you really be happy if you had " + 
                    answer.substring(word) + "?";
        }
        else if(findKeyword(answer, "i like", 0) == 0)
        {
            int word = answer.indexOf("like ") + 5;
            return "Why do you like " + answer.substring(word) + "?";
        }
        else if(findKeyword(answer, "cat", 0) == 0 ||
                findKeyword(answer, "dog", 0) == 0)
        {
            return "Tell me more about your pets.";
        }
        else if(findKeyword(answer, "mother", 0) == 0 || 
                findKeyword(answer, "father", 0) == 0 || 
                findKeyword(answer, "brother", 0) == 0 || 
                findKeyword(answer, "sister", 0) == 0)
        {
            return "Tell me more about your family.";      
        }  
        else if(findKeyword(answer, "Mr. Imamura", 0) == 0 ||
                findKeyword(answer, "Mr. I", 0) == 0)
        {
            return "He's a great teacher!";
        }
        else if(findKeyword(answer, "no", 0) == 0)
        {
            return responseNo;
        }
        else if(answer.contains(" "))
        {
            String trimmed = answer.trim();
            int length = trimmed.length();
            if(length == 0)
                return "Say something please.";
            else
                return getRandomResponse(x);
        }  
        else 
            return getRandomResponse(x);
    }
    private String getRandomResponse(String y)
    {
        String [] list = new String [8];
        Random generator = new Random();
        int choose = generator.nextInt(8);
        list [0] = "Boring.";
        list [1] = "That's so cool!";
        list [2] = "Nice!";
        list [3] = "I don't care.";
        list [4] = "Tell me more!";
        list [5] = "That's great.";
        list [6] = "You're weird.";
        list [7] = "Interesting...";
        return list [choose];
    }
    private int findKeyword(String statement, String goal, int startPos)
    {
        String phrase = statement.trim().toLowerCase();
        goal = goal.toLowerCase();
        int psn = phrase.indexOf(goal, startPos);
        while(psn >= 0)
        {
            String before = " ", after = " ";
            if(psn > 0)
            {
                before = phrase.substring(psn - 1, psn);
            }
            if (psn + goal.length() < phrase.length())
            {
                after = phrase.substring(psn + goal.length(),
                        psn + goal.length() + 1);
            }
            if(((before.compareTo("a") < 0 ) || (before.compareTo("z") > 0)) 
                    && ((after.compareTo("a") < 0) || 
                    (after.compareTo("z") > 0)))
            {
                return psn;
            }
            psn = phrase.indexOf(goal, psn +1);
        }
        return -1;
    }
}

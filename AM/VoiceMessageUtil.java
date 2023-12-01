import java.util.Date;
public class VoiceMessageUtil{

    public String greeting(){
        return "hello you";
    }

    public String greeting(String name){
        return "hello " + name;
    }

    public String greeting(String age, int count){
        return "your age is " + age;
    }

    public void getCurrentDate(){
        Date today = new Date();
        System.out.println("hello, the current date is: "+ today);
    }

    public void getCurrentDate(String test){
        Date today = new Date();
        System.out.println("goodbye, the current date is: "+ today);
    }
}
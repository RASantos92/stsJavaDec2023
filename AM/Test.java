public class Test{
    public static void main(String[] args){
        VoiceMessageUtil util = new VoiceMessageUtil();
        System.out.println(util.greeting());
        System.out.println(util.greeting("Mayank"));
        System.out.println(util.greeting("test", 1));
        util.getCurrentDate();

    }
}
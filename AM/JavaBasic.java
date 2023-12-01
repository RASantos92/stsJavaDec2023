public class JavaBasic{
    // entry point method
    // The JRE needs to call on the programs main method for the program to run.
    // public because this method needs to be callable outside the class.
    // static methods can be called without having to create an instance of the class to call it.
    // JRE by default will call on your class.main(args) 
    public static void main(String[] arg){
        System.out.println("Hello world");
        String firstName = "Abel";
        String lastName = "Frisk";
        int age = 26;
        boolean isStudent = true;
        double weight = 165.5;
        char grade = 'A';
        System.out.println(firstName + " " + lastName + "\n" + age 
        + "\n" + isStudent + "\n" + weight + "\n"+ grade);
        System.out.println(Integer.MAX_VALUE);


        // if(weight < 100) {
        //     System.out.println("you really need to eat more");
        // }else {
        //     System.out.println("your okay");
        // }


        System.out.println(weight < 100 ? "you really need to eat more" : "your okay");



        String name = "Kennedy Vandel";
        System.out.println(name.length());

        String fullName = firstName.concat(lastName);
        System.out.println(fullName);

        String greeting = String.format("Hi %s, you are %d years old", fullName, age );
        System.out.println(greeting);
        System.out.printf("Hi %s, you are %d years old \n", fullName, age);


        String firstName1 = "Alonzo";
        String firstName2 = new String("Alonzo");
        String firstName3 = "Alonzo";

        System.out.println(firstName1 == firstName3); // True
        System.out.println(firstName1 == firstName2); // false

        System.out.println(firstName1.equals(firstName2)); // true
    }
}

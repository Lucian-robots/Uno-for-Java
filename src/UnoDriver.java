import java.util.ArrayList;
// quick test for arrayList .add function. I need to see order of .add thing to make sure discard pile will work. 


public class UnoDriver {
    public static void main(String[]args) {
        ArrayList<String> test = new ArrayList<>();
        test.add("Hello");
        test.add("Greetings");

        System.out.println(test.get(test.size()-1));

        System.out.println(test);
    }
} 
import com.company.ShuntingYard;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
   //USE SPACES!!!!!!!!!!!
    //DO NOT PUT A SPACE AT THE END
    public static void main(String[]args){
        ShuntingYard shunt = new ShuntingYard();

        System.out.println(shunt.infixToPostfix("1 + 1 + 3"));
        System.out.println(shunt.evaluatePostfix("1 1 + 3 +"));

    }
}
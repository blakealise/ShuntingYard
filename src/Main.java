import com.company.ShuntingYard;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
   //USE SPACES!!!!!!!!!!!
    public static void main(String[]args){
        ShuntingYard shunty = new ShuntingYard();


        System.out.println(shunty.infixToPostfix("1 + 1 + 3"));

    }
}
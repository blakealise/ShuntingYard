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

        List<String> tokens = shunty.tokenize("11 + * -5 / 9 + 1 ");

        System.out.println(shunty.infixToPostfix("1 + 1 + 3"));
                    // 1 1 3 * +

        /*
               1 + 1 * 3
               [1,+,1,+,3]
         */

//        Queue<String> tester = new LinkedList<>();
//        for(int i = 0; i< 6; i++){
//            tester.add("" + i);
//        }
//
//        System.out.println(tester);
//
//        for(String x : tokens){
//            System.out.println(x);
//        }
    }
}
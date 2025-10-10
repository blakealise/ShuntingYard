package com.company;


import java.util.*;


    /**
     * Implementation of Dijkstra's Shunting Yard Algorithm
     * Converts infix expressions to postfix (Reverse Polish Notation)
     *
     * Example: "3 + 4 * 2" becomes "3 4 2 * +"
     *
     * Algorithm Overview:
     * 1. Read tokens from left to right
     * 2. If operand (number), add to output
     * 3. If operator, pop operators from stack based on precedence rules
     * 4. If '(', push to stack
     * 5. If ')', pop until matching '(' is found
     * 6. At end, pop remaining operators to output
     */
    public class ShuntingYard {

        String[] numbers = {"0","1","2","3","4","5","6","7","8","9"};
        List<String> arrNum = Arrays.asList(numbers);
        /**
         * Converts an infix expression to postfix notation
         *
         * @param infix The infix expression as a string (e.g., "3 + 4 * 2")
         * @return The postfix expression as a string (e.g., "3 4 2 * +")
         *
         * Hint: Use a Stack for operators and a Queue or List for output
         * Consider how to handle:
         * - Operands (numbers)
         * - Operators (+, -, *, /)
         * - Parentheses
         */
        public String infixToPostfix(String infix) {
            // TODO: Implement the shunting yard algorithm
            // You'll need:
            // - A stack to hold operators temporarily
            // - An output queue or list for the result
            // - Logic to tokenize the input string
            // - Logic to handle operator precedence
            Stack<String> operations = new Stack();
            Queue<String> output = new LinkedList<>();
            List<String> arr = tokenize(infix);
            for(int i = 0; i<arr.size();i++){
                String temp = arr.get(i);
                System.out.println("temp is : " + temp);
                if(isOperator(temp.charAt(0)) == true) {
                    System.out.println("Verified that " + temp + " is an operator");
                    int prec = getPrecedence(temp);
                    if (prec == 1) {
                        if (operations.isEmpty() == true) {
                            operations.add(arr.get(i));
                        }
                        else operations.add(temp);
                    }
                    if (prec == 2) {
                        if (operations.isEmpty() == true) {
                            operations.add(arr.get(i));
                        }
                        else {
                            while (!operations.peek().equals(')')) {
                                output.add(operations.pop());
                            }
                            operations.pop();
                        }
                    }
                    if (prec == 3) {
                        if (operations.isEmpty() == true) {
                            operations.add(arr.get(i));
                        }
                        else operations.add(temp);
                    }
                    if (prec == 4) {
                        System.out.println(temp + " has a precedence of 4");
                        System.out.println("The stack currently has a size of : " + operations.size());
                        if (operations.isEmpty() == true) {
                            operations.add(arr.get(i));
                        }
                        else{
                            String opTemp = operations.peek();
                            if (getPrecedence(opTemp) <= 4) {
                                System.out.println("I'm popping from stack");
//                                output.add(temp);
                                output.add(operations.pop());
                            }
                            operations.add(temp);
                        }

                    }

                    if (prec == 5) {
                        if (operations.isEmpty() == true) {
                            operations.add(arr.get(i));
                        } else {
                            String opTemp = operations.peek();
                            if (getPrecedence(opTemp) >= 5) {
                                System.out.println("adding to queue");
                                output.add(operations.pop());
                            }
                            System.out.println("adding + to stack");
                            operations.add(arr.get(i));
                        }
                    } else if (isNumber(temp)) {
                        output.add(temp);
                    }
                }
            }

            while(operations.isEmpty() == false){
                output.add(operations.pop());
            }

            String outputString = "";
            for(int i = 0; i< output.size(); i++){

                outputString += output.peek();
                output.remove();

            }
            return outputString;
        }


        /**
         * Determines the precedence of an operator
         * Higher number = higher precedence
         *
         * @param operator The operator character
         * @return The precedence level (higher is more important)
         *
         * Hint: Multiplication and division have higher precedence than addition and subtraction
         * Standard precedence: *, / = 2; +, - = 1
         */


        private int getPrecedence(String operator) {
            // TODO: Return appropriate precedence values
            int current = 0;
            if(operator.length()!= 1){
                //throw
            }
            if(operator.equals("(")){
                 current = 1;
            }
            if(operator.equals(")")){
                current = 2;
            }
            if(operator.equals("^")){
                current = 3;
            }
            if(operator.equals("*") || operator.equals("/")){
                current = 4;
            }
            if(operator.equals("+") || operator.equals("-")){
                current = 5;
            }
            return current;
        }


        /**
         * Checks if a character is an operator
         *
         * @param c The character to check
         * @return true if the character is an operator (+, -, *, /)
         *
         * Hint: Compare against the four basic operators
         */
        private boolean isOperator(char c) {
            // TODO: Check if c is one of: +, -, *, /, ^
            if (c == '(' || c== ')' || c == '^' || c == '*' || c == '/' || c == '+' || c == '-'){
                return true;
            }

            return false;
        }


        /**
         * Checks if a string is a number (operand)
         *
         * @param token The string to check
         * @return true if the string represents a valid number
         *
         * Hint: You can use try-catch with parsing, or check character by character
         */
        private boolean isNumber(String token) {
            // TODO: Determine if the token is a valid number
            // Consider: integers, decimals, negative numbers
           // String numbers = "-.0123456789";
            int deCount = 0;
            int negCount = 0;

            for(int i = 0; i < token.length(); i++){
                if (arrNum.contains(token.charAt(i))) return true;

                if (token.charAt(i) == '-'){
                    if(negCount == 0) negCount++;
                    else return false;
                }
                if(token.charAt(i) == '.' ){
                    if(deCount == 0) deCount++;
                    else return false;
                }
                else return false;
            }
            return false;
        }


        /**
         * Evaluates a postfix expression and returns the result
         *
         * @param postfix The postfix expression to evaluate
         * @return The numerical result of the expression
         *
         * Hint: Use a stack to store operands
         * When you encounter an operator:
         * 1. Pop two operands
         * 2. Apply the operator
         * 3. Push the result back
         */
        public double evaluatePostfix(String postfix) {
            // TODO: Implement postfix evaluation
            // Algorithm:
            // - For each token:
            //   - If number: push to stack
            //   - If operator: pop two values, compute, push result
            // - Final stack value is the answer


            return 0.0;
        }


        /**
         * Tokenizes an expression string into individual tokens
         *
         * @param expression The expression to tokenize
         * @return A list of tokens (numbers and operators)
         *
         * Hint: Split by spaces, or iterate character by character
         * Consider multi-digit numbers
         */
        public List<String> tokenize(String expression) {
            // TODO: Break the expression into tokens
            // Example: "3 + 4 * 2" -> ["3", "+", "4", "*", "2"]
            ArrayList<String> arr = new ArrayList<String>();
            while(expression.contains(" ")){
                String temp = expression.substring(0,expression.indexOf(" "));
                arr.add(temp);
                expression = expression.substring(expression.indexOf(" ") +1);
            }
            arr.add(expression);
            return arr;
        }


    }

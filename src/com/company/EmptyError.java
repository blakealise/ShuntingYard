
package com.company;

public class EmptyError extends RuntimeException {
    public EmptyError(){
        super("Empty Error");
    }
    public EmptyError(String message){
        super(message);
    }
}

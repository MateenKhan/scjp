package Exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Basic implements Person {
    public static void main(String[] args) {

        System.out.println("asdf");
    }

    //    must not declare any checked exceptions that are broader than the exceptions declared in the interface method
//    Below will give error
//    @Override
//    public void talk() throws Exception {
//
//    }

//    narrorwer exceptions are ok :)
    @Override
    public void talk() throws FileNotFoundException {


    }

}

interface Person {
    void talk() throws IOException;
}

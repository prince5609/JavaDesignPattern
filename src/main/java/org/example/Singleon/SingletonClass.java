package org.example.Singleon;

public class SingletonClass {
    public static void main(String[] args){
        Abc obj1 = Abc.getInstance();   // Client can call object only once
    }
}

class Abc{
    static Abc obj = new Abc();   // make obj inside class only
    private Abc(){     // make a private constructor so that client couldn't make other object.

    }

    public static Abc getInstance(){
        return obj;                   // everything will be returned from here.
    }
}

package ru.itis.javalab;

public class Component {
    private int privateField;
    public int publicFiled;
    public final static String staticField = "FINAL";

    public Component() {
        this.privateField = 10;
        this.publicFiled = 10;
    }

    public Component(int privateField, int publicFiled) {
        this.privateField = privateField;
        this.publicFiled = publicFiled;
    }

    public int getPrivateField() {
        return privateField;
    }

    public int getPublicFiled() {
        return publicFiled;
    }

    public void publicMethod(){
        System.out.println(privateField + " " + publicFiled);
    }

    private boolean privateMethod(){
        return this.privateField == this.publicFiled;
    }

    public int getSumOfFields(int a){
        return a + this.privateField + this.publicFiled;
    }

    public static int methodWithArgs(int a, int b, int c){
        return a + b + c;
    }
}

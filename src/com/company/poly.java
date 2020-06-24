package com.company;

public class poly {
    public static void main(String[] arg){
        A1[] obj = new A1[3];
        try {
            obj[1] = new b1(2);
            System.out.println(obj[1].getI());
            obj[2] = new c1(3);
            System.out.println(obj[2].getI());
            obj[0] = new A1(23);
            System.out.println(obj[0].getI());
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
class A1{
    private int i;
    public A1(int i) throws Exception {
        this.setI(i);
    }
    private void setI(int i) throws Exception{
        if(i > 0 && i < 9){
            this.i = i;
        }
        else{
            throw new Exception("Number should be between 1 to 8");
        }
    }
    public String getI(){
        return this.i + "";
    }
}
class b1 extends A1{
    public b1(int i) throws Exception {
        super(i);
    }
    public String getI() {
       return "I called by b" + super.getI();
    }
}
class c1 extends A1{
    public c1(int i) throws Exception {
        super(i);
    }
    public String getI() {
        return "I called by c" + super.getI();
    }
    public String getI(int i) {
        return "I called by c" + super.getI();
    }
}
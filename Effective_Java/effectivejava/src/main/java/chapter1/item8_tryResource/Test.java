package chapter1.item8_tryResource;

public class Test {


  static String a = "";
  static String b = new String();


  public static void main(String[] args) {
    System.out.println(a==b);
    System.out.println(a.equals(b));

    System.out.println("a.getClass() = " + a.getClass());
    
    String valueOf = String.valueOf(a);

    System.out.println(a==valueOf);
  }

}

class Singleton {
 private static Singleton instance;
 private Singleton() {}
 public static Singleton getInstance() {
 if (instance == null) {
    instance = new Singleton();
 }
 return instance;
 }
 public void display() {
 System.out.println("Singleton Instance Created");
 }
}
public class sepm7 {
 public static void main(String[] args) {
 Singleton obj = Singleton.getInstance();
 obj.display();
 }
}

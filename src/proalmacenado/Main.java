
package proalmacenado;

public class Main {
    
    public static void main(String[] args) {
        
        database db = new database();

        String r = db.procedure("John Winston Lennon", 1999);
        System.out.println(r);

        r = db.procedure("James Paul McCartney", 1990);
        System.out.println(r);

        r = db.procedure("Ned Flanders", 1994);
        System.out.println(r);
    }
}

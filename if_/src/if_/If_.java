/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package if_;
import java.util.Scanner;
/**
 *
 * @author Rey
 */
public class If_ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado =new Scanner(System.in);
        int edad=0;
        System.out.println("Escribe tu edad");
        edad=teclado.nextInt();
        if(edad>=80){
            System.out.println("Usted Pertenece a la 3a edad");
        }
        if(edad<=79 && edad>=60){
            System.out.println("Usted ha alcanzado la esperanza de vida");
        }
        if(edad<=59 && edad>=50){
            System.out.println("Usted es un adulto mayor");
        }
        if(edad<=49 && edad>=40){
            System.out.println("Usted es un adulto maduro");
        }
        if(edad<=39 && edad>=30){
            System.out.println("Usted es un adulto");
        }
        if(edad<=29 && edad>=20){
            System.out.println("Usted es un adulto joven");
        }
        if(edad<=19 && edad>=12){
            System.out.println("Usted es un adolescente");
        }
        if(edad<=11 && edad>=8){
            System.out.println("Usted es un infante");
        }
    }
}

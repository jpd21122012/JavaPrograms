package clase;                                           //NOMBRE DEL PAQUETE ( CLASE)

/**
 *
 * PAOLO MEDINA
 */
import java.util.*;
public class Clase {
public static void main(String[] args) {                 //CLASE PRINCIPAL(main)
    int op=1;
    Suma A=new Suma();                                  //Se declara o inicializa la Clase "Suma"
    Resta B=new Resta();                                //Se declara o inicializa la Clase "Resta"
    Multiplicacion C=new Multiplicacion();
    Division D=new Division();
    System.out.println("");
    System.out.println("Opcion 1 => SUMA (4+5)");//IMPRIMIMOS  LA OPCION "SUMA"
    System.out.println("Opcion 2 => RESTA (6+8)");//IMPRIMIMOS LA OPCION "RESTA"
    System.out.println("Opcion 3 => MULTIPLICACION (10+3)");//IMPRIMIMOS LA OPCION"MULTIPLICACION"
    System.out.println("Opcion 4 => DIVISION (12+6)");// IMPRIMIMOS LA OPCION "DIVISION"
        int opcion;
        Scanner l=new Scanner(System.in);
        System.out.print("--Escoge una opcion: ");//IMPRIMIMOS LA LINEA DE OPCION
        opcion=l.nextInt();
        switch(opcion){
            case 1:
            A.suma(4,5);
            System.out.println("Resultado suma: "+A.suma(4,5));//IMPRIMIMOS  LA OPERACION"SUMA"
                break;
            case 2:
                B.resta(2,3);
                 System.out.println("Resultado resta: "+B.resta(6,8));// IMPRIMIMOS LA OPERACION "RESTA"
                
                break;
            case 3:
                C.multiplicacion(10,3);
                System.out.println("Resultado multiplicacion: "+C.multiplicacion(10,3));// IMPRIMIMOS LA OPERACION"MULTIPLICACION"
                break;
            case 4:
                D.division(12,6);
                 System.out.println("Resultado division: "+D.division(12,6));//IMPRMIMIOS LA OPERACION"DIVISION"
                break;
        }

}
    

while (op==1);

}
}
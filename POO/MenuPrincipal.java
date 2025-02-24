package POO;

import java.util.Scanner;

public class MenuPrincipal {

    public static int MostrarMenuPrincipal() {
        Scanner sc = new Scanner(System.in);

        System.out.println("===============================");
        System.out.println("         MENU PRINCIPAL        ");
        System.out.println("===============================");
        System.out.println("1. Administrar hospitales");
        System.out.println("2. Administrar empleados");
        System.out.println("3. Administrar pacientes");
        System.out.println("4. Administrar grupos medicos");
        System.out.println("5. Administrar ambulancias");
        System.out.println("6. Salir");

        return sc.nextInt();
    }
}

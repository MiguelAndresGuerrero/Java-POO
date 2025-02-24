package POO;

import java.sql.*;
import java.util.Scanner;

public class JavaPoo {
    private static Statement stmt;
    private static Connection Conect;

    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/sih?serverTimezone=UTC";
        String user = "root";
        String password = "0098";
        try {
            Conect = DriverManager.getConnection(url, user, password);
            stmt = Conect.createStatement();
            System.out.println("Conexion exitosa");
            mostrarMenu();
        } catch (Exception e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
    }

    public static void mostrarMenu() {
        int opcion;
        do {
            opcion = MenuPrincipal.MostrarMenuPrincipal();
            switch (opcion) {
                case 1:
                    mostrarHospitales();
                    break;
                case 2:
                    mostrarEmpleados();
                    break;
                case 3:
                    mostrarPacientes();
                    break;
                case 4:
                    mostrarGrupos();
                    break;
                case 5:
                    System.out.println("Vuelve pronto");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 5);
    }

    public static void mostrarHospitales() {
        String consulta = "SELECT * FROM Hospital";
        try {
            ResultSet rs = stmt.executeQuery(consulta);
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("ID") + ", Nombre: " + rs.getString("Nombre_Hospital") + ", Capacidad: " + rs.getInt("Capacidad"));
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar hospitales: " + e.getMessage());
        }
    }

    public static void mostrarEmpleados() {
        String consulta = "SELECT * FROM Empleados";
        try {
            ResultSet rs = stmt.executeQuery(consulta);
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("ID") + ", Nombre: " + rs.getString("Nombres") + " " + rs.getString("Apellidos") + ", Cargo: " + rs.getString("Cargo") + ", Salario: " + rs.getDouble("Salario"));
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar empleados: " + e.getMessage());
        }
    }

    public static void mostrarPacientes() {
        String consulta = "SELECT * FROM Pacientes";
        try {
            ResultSet rs = stmt.executeQuery(consulta);
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("ID") + ", Nombre: " + rs.getString("Nombres") + " " + rs.getString("Apellidos") + ", Edad: " + rs.getInt("Edad") + ", Ingreso: " + rs.getDate("Fecha_Ingreso"));
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar pacientes: " + e.getMessage());
        }
    }

    public static void mostrarGrupos() {
        String consulta = "SELECT * FROM Grupos";
        try {
            ResultSet rs = stmt.executeQuery(consulta);
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("ID") + ", Numero de Grupo: " + rs.getInt("Numero_grupo") + ", Lider: " + rs.getInt("Coordinador"));
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar grupos medicos: " + e.getMessage());
        }
    }
}
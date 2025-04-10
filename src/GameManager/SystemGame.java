package GameManager;

import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class SystemGame {
    private Map<User> userList;
    private Adapter adapter;
    private String adminCode = "admin";
    public static System getInstanceOfSystemGame() {
        if (instance == null) {
            instance = new System();
        }
        return instance;
    }
    public User  getUserWithOutCode(String userName, String password){
        for (User user : userList.values()) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                System.out.println("Recuerda que tu codigo es: "+user.getCodigo());
                return user;
            }
        }
        return null;
        }
    public User getUser(String userCode) {
        return userList.get(userCode);
    }
    public String newPlayer(String userName, String password) {
        Credentials c = new Credentials(userName, password);
        if (credentials.isValid()) {
            String userCode = credentials.getUserCode();
            userList.put(userCode, new Player(userName, password));
            return userCode;
        } else {
            return "-1";
        }
    }
    public void showStartScreen(){
        limpiarConsola();
        System.out.println("Bienvenido al juego. Que quieres hacer?");
        System.out.println("1-. Iniciar sesión");
        System.out.println("2-. Crear un nuevo usuario");
        System.out.println("3-. Crear un nuevo admin");
        System.out.println("4-. Salir del juego");
        Scanner scanner = new Scanner(System.in);
        int option = 16;
        while (option < 1 || option > 4) {
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    showLoginScreen();
                    break;
                case 2:
                    showNewUserScreen();
                    break;
                case 3:
                    showNewAdminScreen();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
        }
        }
    }
    public void showLoginScreen(){
        limpiarConsola();
        System.out.println("Escribe tu código de usuario (si no te acuerdas escribe -1): ");
        Scanner scanner = new Scanner(System.in);
        String userCode = scanner.nextLine();
        if (userCode == "-1"){
            System.out.println("Escribe tu nombre de usuario");
            String userName = scanner.nextLine();
            System.out.println("Escribe tu contraseña");
            String password = scanner.nextLine();
            User user = getUserWithOutCode(userName, password);
            if (user != null) {
                System.out.println("Pulsa enter para continuar");
                scanner.nextLine();
                
            } else {
                System.out.println("Usuario no válido.");
                showLoginScreen();
            }
            }
        } 
        else {
            User user = getUser(userCode);
            if (user != null) {
                
                
            } else {
                System.out.println("Código de usuario no válido.");
                showLoginScreen();
            }
        }
    
        
        
    }
    public void showNewUserScreen(){
        limpiarConsola();
        System.out.println("Escribe el nombre de usuario que quieras usar:")
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();
        System.out.println("Escribe la contraseña que quieras usar:");
        String password = scanner.nextLine();
        String validation = newPlayer(userName, password);
        if (validation == "-1"){
            System.out.println("Hay algun fallo en la contraseña o el nombre. Prueba otro");

        } else {
            System.out.println("Usuario creado con éxito. Tu código de usuario es: " + validation);
        }
    }
    public void showNewAdminScreen(){
        limpiarConsola();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escribe la contraseña de admin");
        String adminPassword = scanner.nextLine();
        if (adminPassword.equals(adminCode)) {
            System.out.println("Escribe el nombre de usuario que quieras usar:")            
            String userName = scanner.nextLine();
            System.out.println("Escribe la contraseña que quieras usar:");
            String password = scanner.nextLine();
            String validation = newAdmin(userName, password);
            if (validation == "-1"){
                System.out.println("Hay algun fallo en la contraseña o el nombre. Prueba otro");

            } else {
                System.out.println("Usuario creado con éxito. Tu código de usuario es: " + validation);
            }
        } else {
            System.out.println("Contraseña incorrecta. No tienes permisos para crear un nuevo admin.");
            showStartScreen();
    }
            
        }
    }
    public static void limpiarConsola() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

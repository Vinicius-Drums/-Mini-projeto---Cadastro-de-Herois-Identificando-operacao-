//  ConsoleLog.java
package br.senai.devtubaraosc.heroi.utils;

// Classe para exibir mensagens formatadas no console
public class ConsoleLog {
    // Método para exibir mensagem de informação
    public static void info(String message) {
        System.out.println(message);
    }

    // Método para exibir mensagem de sucesso
    public static void success(String message) {
        System.out.println(ConsoleColors.GREEN + message + ConsoleColors.RESET);
    }

    // Método para exibir mensagem de aviso
    public static void warning(String message) {
        System.out.println(ConsoleColors.YELLOW + message + ConsoleColors.RESET);
    }

    // Método para exibir mensagem de erro
    public static void error(String message) {
        System.out.println(ConsoleColors.RED + message + ConsoleColors.RESET);
    }
}

// Pacote para a classe HeroiCli
package br.senai.devtubaraosc.heroi;

// Importações necessárias
import br.senai.devtubaraosc.heroi.enuns.Operacao;
import br.senai.devtubaraosc.heroi.model.Heroi;
import br.senai.devtubaraosc.heroi.utils.ConsoleColors;
import br.senai.devtubaraosc.heroi.utils.ConsoleLog;

import java.util.Scanner;

// Classe responsável pela lógica de interação com o usuário
public class HeroiCli {
    // Scanner para entrada de dados do usuário
    private Scanner scanner;

    // Construtor da classe
    public HeroiCli() {
        this.scanner = new Scanner(System.in);
    }

    // Método para exibir o menu da aplicação
    public void exibirMenu() {
        ConsoleLog.info("");
        ConsoleLog.info(ConsoleColors.BLUE + "===== MENU =====" + ConsoleColors.RESET);
        ConsoleLog.info("");
        ConsoleLog.info(ConsoleColors.BLUE + "1. Adicionar Herói" + ConsoleColors.RESET);
        ConsoleLog.info("");
        ConsoleLog.info(ConsoleColors.BLUE + "2. Listar Heróis" + ConsoleColors.RESET);
        ConsoleLog.info("");
        ConsoleLog.info(ConsoleColors.BLUE + "3. Sair" + ConsoleColors.RESET);
        ConsoleLog.info("");
        ConsoleLog.info(ConsoleColors.BLUE + "Escolha uma opção: " + ConsoleColors.RESET);
        ConsoleLog.info("");
    }

    // Método para solicitar e retornar a operação escolhida pelo usuário
    public Operacao solicitarOperacao() {
        String opcao = scanner.nextLine();
        try {
            int valor = Integer.parseInt(opcao);
            return Operacao.values()[valor - 1];
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            return Operacao.SAIR; // Se a entrada não for válida, sair do programa
        }
    }

    // Método principal para execução do programa
    public void executar() {
        Heroi[] heroisCadastrados = new Heroi[5]; // Capacidade para 5 heróis
        int indice = 0; // Índice para controle dos heróis cadastrados

        try {
            while (true) {
                exibirMenu(); // Exibe o menu

                // Ler a opção do usuário
                Operacao operacao = solicitarOperacao();

                // Realizar a ação correspondente à operação escolhida
                switch (operacao) {
                    case ADICIONAR:
                        // Adicionar um novo herói
                        adicionarHeroi(heroisCadastrados, indice);
                        indice++; // Incrementa o índice
                        break;
                    case LISTAR:
                        // Listar todos os heróis cadastrados
                        listarHerois(heroisCadastrados, indice);
                        break;
                    case SAIR:
                        // Sair do sistema
                        ConsoleLog.warning("Saindo do sistema...");
                        return; // Encerra o método executar()
                }
            }
        } finally {
            // Fecha o scanner ao sair do loop principal
            scanner.close();
        }
    }

    // Método para adicionar um novo herói ao array de heróis cadastrados
    private void adicionarHeroi(Heroi[] heroisCadastrados, int indice) {
        if (indice >= heroisCadastrados.length) {
            ConsoleLog.error("Limite de heróis alcançado.");
            return;
        }

        ConsoleLog.info("");
        ConsoleLog.info("Nome do Herói: ");
        String nome = scanner.nextLine();

        String superpoder;
        do {
            ConsoleLog.info("Superpoder do Herói: ");
            superpoder = scanner.nextLine().trim(); // Remover espaços em branco no início e no final
            if (superpoder.isEmpty()) {
                ConsoleLog.error("Por favor, insira um superpoder válido.");
            }
        } while (superpoder.isEmpty());

        int idade;
        try {
            ConsoleLog.info("Idade do Herói: ");
            idade = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            ConsoleLog.error("Por favor, insira uma idade válida.");
            return;
        }

        heroisCadastrados[indice] = new Heroi(nome, superpoder, idade);
        ConsoleLog.success("");
        ConsoleLog.success("Herói adicionado com sucesso!");
        ConsoleLog.success("");
    }

    // Método para listar todos os heróis cadastrados
    private void listarHerois(Heroi[] heroisCadastrados, int indice) {
        if (indice == 0) {
            ConsoleLog.warning("Nenhum herói cadastrado.");
            return;
        }

        ConsoleLog.info("");
        ConsoleLog.info(ConsoleColors.YELLOW + "===== LISTA DE HERÓIS =====" + ConsoleColors.RESET);
        for (int i = 0; i < indice; i++) {
            ConsoleLog.info(ConsoleColors.YELLOW + "Nome: " + heroisCadastrados[i].getNome());
            ConsoleLog.info(ConsoleColors.YELLOW + "Superpoder: " + heroisCadastrados[i].getSuperpoder());
            ConsoleLog.info(ConsoleColors.YELLOW + "Idade: " + heroisCadastrados[i].getIdade());
            ConsoleLog.info(ConsoleColors.YELLOW + "-----------------------------" + ConsoleColors.RESET);
        }
    }
}

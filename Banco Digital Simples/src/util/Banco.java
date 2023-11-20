package util;

import java.util.Scanner;

public class Banco {

        public static void exibirMensagem(String mensagem) {
            int larguraLinha = mensagem.length() + 12;
            String linha = "*".repeat(larguraLinha);
            String espacos = " ".repeat((larguraLinha - mensagem.length()) / 2-1);
            int seq = 1;
            String[] opcoes = new String[6];

            System.out.println(linha);
            System.out.println("*" + " ".repeat(larguraLinha - 2) + "*");
            System.out.println("*" + espacos + mensagem + espacos + "*");
            System.out.println("*" + " ".repeat(larguraLinha - 2) + "*");
            System.out.println(linha);

            opcoes[0] = "Depositar";
            opcoes[1] = "Sacar";
            opcoes[2] = "Transferir";
            opcoes[3] = "Consultar Saldo";
            opcoes[4] = "Cadastrar Conta";
            opcoes[5] = "Fechar";

            espacos = " ".repeat(3);
            System.out.println("*" + espacos + "Qual operação deseja realizar??" + espacos + "*");
            System.out.println(linha);
            //Exibe as opções
            for(int i = 0; i < opcoes.length; i++){
                System.out.println(seq + " - " + opcoes[i]);
                seq ++;
            }
            System.out.println(linha);
        }

}


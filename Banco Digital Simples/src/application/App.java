package application;

import java.util.Scanner;

import static util.Banco.*;

public class App {
    public static void main(String[] args) {

        opcoes();
    }

        public static void opcoes() {
            exibirMensagem("Bem-vindo ao Banco do Caio!");
            Scanner sc = new Scanner(System.in);

            int operacao = sc.nextInt();

            switch (operacao) {
                case 1:
                    depositar();
                    break;
//                case 2:
//                    sacar();
//                    break;
//                case 3:
//                    transferir();
//                    break;
//                case 4:
//                    consultarSaldo();
//                    break;
//                case 5:
//                    cadastrarConta();
//                    break;
//                case 6:
//                    fechar();
//                    System.exit(0);
//                    break;
                default:
                    System.out.println("Opção Inválida!");
                    opcoes();
            }
        }

        public static void depositar(){

        }

}
package atividadejavos.atividade3banco;

import java.util.ArrayList;
import java.util.Scanner;

public class Banco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Conta> contas = new ArrayList<>();

        while (true) {
            System.out.println("escolha a opcao:\n1.criar conta\n2.depositar saldo\n3.transferir saldo\n4.sair");
            System.out.print("digite sua ação:");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite seu nome: ");
                    String titular = scanner.next();
                    System.out.print("Digite a agencia ");
                    int agencia = scanner.nextInt();
                    System.out.print("Digite o saldo: ");
                    double saldo = scanner.nextDouble();

                    Conta novaConta = new Conta(titular, agencia, saldo);
                    contas.add(novaConta);
                    System.out.println("conta criada com sucesso! ");
                    break;

                case 2:
                    System.out.print("Digite a agencia ");
                    agencia = scanner.nextInt();
                    System.out.print("Digite o valor do deposito: ");
                    double valor = scanner.nextDouble();

                    for (Conta conta : contas) {
                        if (conta.getAgencia() == agencia) {
                            conta.depositar(valor);
                            System.out.println("deposito realizado para conta: " + conta);
                            break;
                        }
                    }
                    break;

                case 3:
                    System.out.print("Digite a agencia para transferir: ");
                    int agenciaOrigem = scanner.nextInt();
                    System.out.print("Digite a agencia ppara receber: ");
                    int agenciaDestino = scanner.nextInt();
                    System.out.print("Digite o valor da transferencia: ");
                    valor = scanner.nextDouble();

                    Conta contaOrigem = null, contaDestino = null;

                    for (Conta conta : contas) {
                        if (conta.getAgencia() == agenciaOrigem) {
                            contaOrigem = conta;
                        }
                        if (conta.getAgencia() == agenciaDestino) {
                            contaDestino = conta;
                        }
                    }

                    if (contaOrigem != null && contaDestino != null && contaOrigem.transferirPara(contaDestino, valor)) {
                        System.out.println("trasnferencia realizada!");
                    } else {
                        System.out.println("fransferencia falhou. Tente novamente...");
                    }
                    break;

                case 4:
                    System.out.println("voce saiu.");
                    scanner.close();
                    return;

                default:
                    System.out.println("opcao invalida.");
            }
        }
    }
}

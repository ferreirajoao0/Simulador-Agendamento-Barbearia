package Projetos.JAVA.Barber;
import java.time.LocalDateTime;
import java.util.Scanner;

public class MainBarber {
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("-------Simulador de Agendamentos-------");

        System.out.println("Informe o seu Nome: ");
        String nomeCliente = sc.nextLine();

        System.out.println("Informe o seu número de Telefone: ");
        String telefoneClinte = sc.nextLine();

        ClienteBarber.Cliente cliente = new ClienteBarber.Cliente(nomeCliente, telefoneClinte);

        String barbeiro = "";
        boolean barbeiroValido = false;

        while(!barbeiroValido) {
            System.out.println("\n--- Escolha o Barbeiro ---");
            System.out.println("1 - Rodolfo Junior");
            System.out.println("2 - Rafael Marques");

            int opcaoBarbeiro = sc.nextInt();
            sc.nextLine();

            switch (opcaoBarbeiro) {
                case 1:
                    barbeiro = "Rodolfo Junior";
                    barbeiroValido = true;
                    break;
                case 2:
                    barbeiro = "Rafael Marques";
                    barbeiroValido = true;
                    break;
                default:
                    System.out.println("Opção inválida! Escolha um barbeiro entre 1 e 2.");
            }
        }
        String nomeServico = "";
        double valorServico = 0.0;
        boolean servicoValida = false;

        while(!servicoValida) {
            System.out.println("\n--- Escolha o Serviço ---");
            System.out.println("1 - Corte e Barba             R$ 27.00");
            System.out.println("2 - Corte e Sobrancelha       R$ 25.00");
            System.out.println("3 - Corte                     R$ 20.00");
            System.out.println("4 - Barba ou Pezinho          R$ 10.00");

            int opcaoServico = sc.nextInt();
            sc.nextLine();

            switch (opcaoServico) {
                case 1:
                    nomeServico = "Corte e Barba";
                    valorServico = 27.00;
                    servicoValida = true;
                    break;
                case 2:
                    nomeServico = "Corte e Sobrancelha";
                    valorServico = 25.00;
                    servicoValida = true;
                    break;
                case 3:
                    nomeServico = "Corte";
                    valorServico = 25.00;
                    servicoValida = true;
                    break;
                case 4:
                    nomeServico = "Barba ou Pezinho";
                    valorServico = 10.00;
                    servicoValida = true;
                    break;
                default:
                    System.out.println("Opção inválida! Escolha um serviço entre 1 e 4.");
            }
        }
        ServiceBarber.Servico servico = new ServiceBarber.Servico(barbeiro, nomeServico, valorServico);
        AgendamentoBarber agendamentoBarber = new AgendamentoBarber(cliente, servico, LocalDateTime.now());

       System.out.println("====AGENDAMENTO CONFIRMADO====");
       System.out.println("Cliente: " + agendamentoBarber.getCliente().getNomeCliente());
       System.out.println("Telefone: " + agendamentoBarber.getCliente().getNumeroTelCliente());
       System.out.println("Barbeiro escolhido: " + agendamentoBarber.getServico().getEscolhaSeuBarbeiro());
       System.out.println("Serviço: " + agendamentoBarber.getServico().getNomeDoServico());
       System.out.println("Valor: R$ " + String.format("%.2f" , agendamentoBarber.getServico().getValorDoServico()));

    }
}

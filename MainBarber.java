package Projetos.JAVA.Barber;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class MainBarber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<AgendamentoBarber> listaAgendamentos = new ArrayList<>();
        boolean executando = true;

        while (executando) {
            System.out.println("\n-------Simulador de Agendamentos-------");
            System.out.println("1 - Novo Agendamento");
            System.out.println("2 - Ver Agendamento realizados");
            System.out.println("3 - Sair ");
            System.out.print("Escolha uma opção: ");

            int opcaoMenu = sc.nextInt();
            sc.nextLine();

            switch (opcaoMenu) {
                case 1:
                    System.out.println("\n--- NOVO AGENDAMENTO ---");
                    System.out.println("Informe o seu nome: ");
                    String nome = sc.nextLine();

                    System.out.println("Informe o seu Telefone: ");
                    String telefone = sc.nextLine();

                    ClienteBarber.Cliente cliente = new ClienteBarber.Cliente(nome, telefone);

                    String barbeiro = "";
                    boolean barbeiroValido = false;

                    while (!barbeiroValido) {
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
                    int duracaoMinutos = 0;

                    while (!servicoValida) {
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
                                duracaoMinutos = 60;
                                servicoValida = true;
                                break;
                            case 2:
                                nomeServico = "Corte e Sobrancelha";
                                valorServico = 25.00;
                                duracaoMinutos = 60;
                                servicoValida = true;
                                break;
                            case 3:
                                nomeServico = "Corte";
                                valorServico = 20.00;
                                duracaoMinutos = 60;
                                servicoValida = true;
                                break;
                            case 4:
                                nomeServico = "Barba ou Pezinho";
                                valorServico = 10.00;
                                duracaoMinutos = 60;
                                servicoValida = true;
                                break;
                            default:
                                System.out.println("Opção inválida! Escolha um serviço entre 1 e 4.");
                        }
                    }

                    ServiceBarber.Servico servico = new ServiceBarber.Servico(barbeiro, nomeServico, valorServico, duracaoMinutos);
                    AgendamentoBarber agendamentoBarber = new AgendamentoBarber(cliente, servico, LocalDateTime.now());

                    List<LocalDate> dias = agendamentoBarber.diasDisponiveis();
                    DateTimeFormatter formatadorDia = DateTimeFormatter.ofPattern("dd/MM - EEEE", new Locale("pt", "BR"));

                    System.out.println("\n--- Dias Disponíveis ---");
                    for (int i = 0; i < dias.size(); i++) {
                        String nomeDias = dias.get(i).format(formatadorDia);
                        System.out.println((i + 1) + " - " + nomeDias);
                    }

                    int opcaoDia = 0;
                    boolean opcaoDiaValida = false;

                    while (!opcaoDiaValida) {
                        System.out.println("\nEscolha o número do dia desejado:");
                        opcaoDia = sc.nextInt();
                        sc.nextLine();

                        if (opcaoDia >= 1 && opcaoDia <= dias.size()) {
                            opcaoDiaValida = true;
                        } else {
                            System.out.println("Opção inválida escolha um número entre 1 e " + dias.size());
                        }
                    }

                    LocalDate diaEscolhido = dias.get(opcaoDia - 1);

                    LocalTime horaAbertura = LocalTime.of(8, 0);
                    LocalTime horaFechamento = LocalTime.of(18, 0);

                    List<LocalTime> horariosDisponiveis = agendamentoBarber.gerarHorariosDisponiveis(horaAbertura, horaFechamento, diaEscolhido);

                    if (horariosDisponiveis.isEmpty()) {
                        System.out.println("\nDesculpe, não há mais horários disponíveis para este dia!");
                        break;
                    }

                    System.out.println("\n--- Horários Disponíveis ---");
                    for (int i = 0; i < horariosDisponiveis.size(); i++) {
                        System.out.println((i + 1) + " - " + horariosDisponiveis.get(i));
                    }

                    int opcaoHorario = 0;
                    boolean opcaoHorarioValido = false;

                    while (!opcaoHorarioValido) {
                        System.out.println("\nEscolha o número do horário desejado: ");
                        opcaoHorario = sc.nextInt();
                        sc.nextLine();

                        if (opcaoHorario >= 1 && opcaoHorario <= horariosDisponiveis.size()) {
                            opcaoHorarioValido = true;
                        } else {
                            System.out.println("Opção inválida! Escolha um número entre 1 e " + horariosDisponiveis.size());
                        }
                    }

                    LocalTime horarioEscolhido = horariosDisponiveis.get(opcaoHorario - 1);
                    LocalDateTime dataHoraFinal = LocalDateTime.of(diaEscolhido, horarioEscolhido);
                    agendamentoBarber.setDataHora(dataHoraFinal);

                    listaAgendamentos.add(agendamentoBarber);

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

                    System.out.println("\n==== AGENDAMENTO CONFIRMADO ====");
                    System.out.println("Cliente: " + agendamentoBarber.getCliente().getNomeCliente());
                    System.out.println("Telefone: " + agendamentoBarber.getCliente().getNumeroTelCliente());
                    System.out.println("Barbeiro escolhido: " + agendamentoBarber.getServico().getEscolhaSeuBarbeiro());
                    System.out.println("Serviço: " + agendamentoBarber.getServico().getNomeDoServico());
                    System.out.println("Data e Hora: " + agendamentoBarber.getDataHora().format(formatter));
                    System.out.println("Valor: R$ " + String.format("%.2f", agendamentoBarber.getServico().getValorDoServico()));
                    break;

                case 2:
                    System.out.println("\n--- LISTA DE AGENDAMENTOS REALIZADOS ---");
                    if (listaAgendamentos.isEmpty()) {
                        System.out.println("Nenhum agendamento cadastrado até o momento");
                    } else {
                        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                        for (int i = 0; i < listaAgendamentos.size(); i++) {
                            AgendamentoBarber ag = listaAgendamentos.get(i);
                            System.out.println("\nAgendamento #" + (i + 1));
                            System.out.println("Cliente: " + ag.getCliente().getNomeCliente() + " | Tel: " + ag.getCliente().getNumeroTelCliente());
                            System.out.println("Barbeiro: " + ag.getServico().getEscolhaSeuBarbeiro());
                            System.out.println("Serviço: " + ag.getServico().getNomeDoServico() + " (R$ " + String.format("%.2f", ag.getServico().getValorDoServico()) + ")");
                            System.out.println("Data/Hora: " + ag.getDataHora().format(fmt));
                        }
                    }
                    break;

                case 3:
                    System.out.println("\nSaindo do sistema... Obrigado!");
                    executando = false;
                    break;

                default:
                    System.out.println("\nOpção inválida! Escolha uma opção entre 1 e 3.");
            }
        }
        sc.close();
    }
}
package Projetos.JAVA.Barber;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoBarber {
    private ClienteBarber.Cliente cliente;
    private ServiceBarber.Servico servico;
    private LocalDateTime dataHora;

    public AgendamentoBarber(ClienteBarber.Cliente cliente, ServiceBarber.Servico servico, LocalDateTime dataHora) {
        this.cliente = cliente;
        this.servico = servico;
        this.dataHora = dataHora;
    }
    public ClienteBarber.Cliente getCliente() {
        return cliente;
    }
    public void setCliente(ClienteBarber.Cliente cliente) {
        this.cliente = cliente;
    }
    public ServiceBarber.Servico getServico() {
        return servico;
    }
    public void setServico(ServiceBarber.Servico servico) {
        this.servico = servico;
    }
    public LocalDateTime getDataHora() {
        return dataHora;
    }
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
    public List<LocalDate> diasDisponiveis() {
        List<LocalDate> dias = new ArrayList<>();
        LocalDate ponteiro = LocalDate.now();

        while(ponteiro.getDayOfWeek().getValue() <= DayOfWeek.SATURDAY.getValue()) {
            dias.add(ponteiro);
            ponteiro = ponteiro.plusDays(1);
        }
        return dias;
    }
    public List<LocalTime>gerarHorariosDisponiveis(LocalTime horaAbertura, LocalTime horaFechamento, LocalDate diaEscolhido) {

        List<LocalTime> disponiveis = new ArrayList<>();
        LocalTime ponteiro = horaAbertura;
        int duracao = this.servico.getDuracaoMinutos();
        while(!ponteiro.plusMinutes(duracao).isAfter(horaFechamento)) {
            boolean hoje = diaEscolhido.equals(LocalDate.now());
            boolean horarioPassado = ponteiro.isBefore(LocalTime.now());

            if(hoje) {
                if(ponteiro.isAfter(LocalTime.now())) {
                    disponiveis.add(ponteiro);
                }
            } else {
                disponiveis.add(ponteiro);
            }
            ponteiro = ponteiro.plusMinutes(duracao);
        }
        return disponiveis;
    }
}


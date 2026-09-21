package Projetos.JAVA.Barber;

import java.time.LocalDateTime;

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
}

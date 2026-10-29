package Projetos.JAVA.Barber;

public class ServiceBarber {
    public static class Servico {
        private String escolhaSeuBarbeiro;
        private String nomeDoServico;
        private double valorDoServico;
        private int duracaoMinutos;

        public Servico(String escolhaSeuBarbeiro, String nomeDoServico, double valorDoServico, int duracaoMinutos) {
            setEscolhaSeuBarbeiro(escolhaSeuBarbeiro);
            setNomeDoServico(nomeDoServico);
            setValorDoServico(valorDoServico);
            setDuracaoMinutos(duracaoMinutos);
        }
        public String getEscolhaSeuBarbeiro() {
            return escolhaSeuBarbeiro;
        }
        public void setEscolhaSeuBarbeiro(String escolhaSeuBarbeiro) {
            if(escolhaSeuBarbeiro != null && !escolhaSeuBarbeiro.trim().isEmpty()) {
                this.escolhaSeuBarbeiro = escolhaSeuBarbeiro;
            } else {
                System.out.println("Erro: Faça a escolha do seu Barbeiro para prosseguir.");
            }
        }
        public String getNomeDoServico() {
            return nomeDoServico;
        }
        public void setNomeDoServico(String nomeDoServico) {
            if(nomeDoServico != null && !nomeDoServico.trim().isEmpty()) {
                this.nomeDoServico = nomeDoServico;
            } else {
                System.out.println("Escolha um serviço válido!");
            }
        }
        public double getValorDoServico() {
            return valorDoServico;
        }
        public void setValorDoServico(double valorDoServico) {
            if(valorDoServico > 0) {
                this.valorDoServico = valorDoServico;
            } else {
                System.out.println("Erro: O valor do serviço deve ser maior que zero!");
            }
        }
        public int getDuracaoMinutos() {
            return duracaoMinutos;
        }
        public void setDuracaoMinutos(int duracaoMinutos) {
            if(duracaoMinutos > 0) {
                this.duracaoMinutos = duracaoMinutos;
            } else {
                System.out.println("Erro: A duração deve ser maior do que 0 minutos.");
            }
        }
    }
}

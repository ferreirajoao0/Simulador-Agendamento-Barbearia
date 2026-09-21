package Projetos.JAVA.Barber;

public class ClienteBarber {
    public static class Cliente {
        private String nomeCliente;
        private String numeroTelCliente;

        public Cliente(String nomeCliente, String numeroTelCliente) {
            setNomeCliente(nomeCliente);
            setNumeroTelCliente(numeroTelCliente);
        }
        public String getNomeCliente() {
            return nomeCliente;
        }

        public void setNomeCliente(String nomeCliente) {
            if(nomeCliente != null && !nomeCliente.trim().isEmpty()) {
                this.nomeCliente = nomeCliente;
            } else {
                System.out.println("Erro: Nome não Informado!");
            }
        }

        public String getNumeroTelCliente() {
            return numeroTelCliente;
        }

        public void setNumeroTelCliente(String numeroTelCliente) {
            if(numeroTelCliente != null && !numeroTelCliente.trim().isEmpty()) {
                this.numeroTelCliente = numeroTelCliente;
            } else {
                System.out.println("Erro: Número de Telefone não Informado!");
            }
        }
    }
}

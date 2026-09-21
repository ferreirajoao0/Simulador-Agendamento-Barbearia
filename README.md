# Simulador-Agendamento-Barbearia

💈 Sistema de Agendamento de Barbearia em Java

Um sistema via terminal desenvolvido em Java para simular e automatizar o fluxo de agendamentos de uma barbearia real, cobrindo desde o cadastro do cliente até a seleção de serviços e confirmação do horário.

---

## 🎯 Sobre o Projeto

O objetivo deste projeto nasceu da ideia de resolver um problema real do negócio de um grande amigo meu. Utilizeos os conceitos fundamentais da Programação Orientada a Objetos (POO) — como encapsulamento, modelagem de domínio e associação por referência entre objetos —, mantendo a estrutura limpa e pronta para evoluir.
Este código funciona como o "esqueleto" ou camada de domínio inicial que, em breve, será transformado numa API RESTful completa com interface gráfica.

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java (JDK 20+)
* **IDE:** IntelliJ IDEA
* **Entrada de Dados:** `Scanner`
* **Manipulação de Datas:** `LocalTime / LocalDateTime`

---

## ⚙️ Funcionalidades

1. **Cadastrar Cliente:** Registo dos dados do cliente (nome e telefone) com validação de campos.
2. **Selecionar Barbeiro:** Escolha do profissional responsável pelo atendimento através de menus interativos.
3. **Escolher Serviço:** Apresentação da tabela de serviços (Corte, Barba, Sobrancelha, Pezinho) com os respetivos valores.
4. **Gerar Agendamento:** Consolidação das informações, associando o cliente, o serviço e o horário num único registo de confirmação.

---

## 📁 Estrutura das Classes

```src/
 └── projetos/
      └── jva/
           └── barber/
                ├── ClienteBarber.java    # Modelo do cliente com validações e encapsulamento
                ├── ServiceBarber.java    # Modelo do serviço (nome, barbeiro e preço)
                ├── AgendamentoBarber.java# Associação de domínio (conecta Cliente + Serviço + Data/Hora)
                └── MainBarber.java       # Fluxo principal no terminal e menus interativos

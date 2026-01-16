# 🕒 Sistema de Ponto Eletrônico (Console)

Este projeto é uma aplicação Java baseada em console desenvolvida para simular o controle de jornada de trabalho de funcionários. O sistema foi criado como parte dos meus estudos focados em **Programação Orientada a Objetos (POO)** e lógica de programação.

O sistema permite o gerenciamento de funcionários e o registro preciso de horários de entrada e saída. O foco principal foi a estruturação do código em camadas (`Model`, `Service`, `Application`) e a manipulação de datas e identificadores únicos.

## 🚀 Funcionalidades

### 👥 Gestão de Usuários
- **Cadastro:** Criação de novos usuários com geração automática de um **ID único (UUID)** e definição de senha.
- **Listagem:** Visualização de todos os usuários cadastrados.
- **Remoção:** Exclusão de usuários do sistema através do ID.

### ⏰ Controle de Ponto
- **Registrar Entrada:** Validação por ID e Senha para marcar o início do expediente.
- **Registrar Saída:** Validação para marcar o fim do expediente (só permite saída se houver uma entrada em aberto).
- **Frequência:** Listagem geral de todos os registros de ponto do sistema.
- **Comprovante:** Geração de um "recibo" detalhado na tela, mostrando horários formatados de entrada e saída para um funcionário específico.

## 🛠️ Tecnologias e Conceitos Aplicados

- **Java (JDK 21)**
- **POO:** Uso de Classes, Objetos, Encapsulamento e Métodos.
- **Arquitetura em Camadas:** Separação de responsabilidades em `Model`, `Service` e `Application`.
- **Java Time API:** Uso de `LocalDateTime` e `DateTimeFormatter` para manipulação precisa de datas e horas.
- **Collections:** Uso de `ArrayList` para persistência de dados em memória.
- **UUID:** Geração de identificadores únicos universais para os usuários.
- **Tratamento de Exceções:** Uso de `try-catch` para garantir que dados inválidos (como letras onde deveriam ser números ou UUIDs mal formatados) não quebrem a execução.

## 📂 Estrutura do Projeto

O projeto segue uma arquitetura em camadas para organizar o código:

```text
src/
├── application/
│   └── Program.java       
├── model/
│   ├── Ponto.java         
│   └── Usuario.java       
└── service/
    ├── MenuService.java   
    ├── PontoService.java  
    └── UsuarioService.java
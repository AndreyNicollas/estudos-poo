# 🛒 Sistema de Vendas (Console Application)

Este é um projeto prático desenvolvido como atividade acadêmica na **Universidade Estadual do Maranhão (UEMA)**.

O objetivo principal foi aplicar conceitos fundamentais de **Programação Orientada a Objetos (POO)** em **Java**, criando um sistema de gerenciamento de vendas que opera via console. O projeto simula um pequeno ambiente comercial onde é possível gerenciar clientes, produtos e realizar venda, utilizando estruturas de dados em memória (`ArrayList`) para persistência temporária dos dados.

## 🚀 Funcionalidades

O sistema é dividido em três módulos principais de gerenciamento:

### 👤 Gestão de Clientes
* **Cadastrar:** Adiciona novos clientes com ID único (UUID), nome e e-mail.
* **Listar:** Exibe todos os clientes cadastrados.
* **Atualizar:** Permite alterar nome e e-mail de um cliente existente.
* **Buscar:** Localiza clientes pelo nome.
* **Remover:** Exclui um cliente da base de dados.

### 📦 Gestão de Produtos
* **Cadastrar:** Registra produtos com nome, quantidade inicial e preço.
* **Controle de Estoque:** Validação para não permitir quantidades negativas.
* **Listar:** Exibe o catálogo de produtos.
* **Atualizar:** Altera a quantidade em estoque e o preço unitário.
* **Remover:** Retira produtos do sistema.

### 💰 Gestão de Vendas
* **Realizar Venda:**
    * Associa um Cliente a um Produto por meio do ID único de ambos.
    * Verifica automaticamente a disponibilidade de estoque.
    * Calcula o valor total da compra.
    * Baixa automática no estoque do produto após a venda.
* **Listar Vendas:** Histórico geral de todas as vendas realizadas.
* **Filtros:**
    * Listar vendas por Cliente específico.
    * Listar vendas por Produto específico (exibe total vendido e estoque restante).

## 🛠️ Tecnologias e Conceitos Aplicados

* **Linguagem:** Java (JDK 21)
* **POO:** Abstração, Encapsulamento, Associação entre classes.
* **Collections:** Utilização de `ArrayList` para manipulação dinâmica de dados.
* **Tratamento de Exceções:** Uso de `try-catch` para capturar `InputMismatchException` e validações de lógica de negócio.
* **Identificadores Únicos:** Uso da classe `UUID` para gerar IDs únicos para objetos.
* **Entrada de Dados:** Classe `Scanner`.

## 📂 Estrutura do Projeto

O projeto segue uma arquitetura em camadas para organizar o código:

```text
src/
├── application/
│   └── SistemaVendasApp.java
├── model/
│   ├── Cliente.java
│   ├── Produto.java
│   └── Venda.java
└── service/
    ├── MenuService.java
    ├── ClienteService.java
    ├── ProdutoService.java
    └── VendasService.java


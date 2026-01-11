# 📚 Sistema Básico de Gerenciamento de Biblioteca

Este projeto é um sistema de gerenciamento de biblioteca via console, desenvolvido para praticar e consolidar conceitos fundamentais de **Programação Orientada a Objetos (POO)** com Java.

O sistema permite o cadastro de usuários e livros, além de gerenciar o fluxo completo de empréstimos e devoluções, garantindo a integridade dos dados através de validações de status (Disponível/Emprestado).

## 🚀 Funcionalidades

### 📖 Gestão de Livros
- Cadastro de novos livros (Título, Autor, ISBN).
- Geração automática de ID único (**UUID**).
- Listagem de todos os livros.
- Busca, atualização e remoção de livros por ID.
- **Controle de Status:** Os livros alternam automaticamente entre "Disponível" e "Emprestado".

### 👤 Gestão de Usuários
- Cadastro de usuários (Nome, CPF).
- Listagem e remoção de usuários.

### 🔄 Sistema de Empréstimos
- **Realizar Empréstimo:** Associa um usuário a um livro.
- **Validação:** O sistema impede o empréstimo se o livro já estiver emprestado.
- **Devolução:** Libera o livro novamente para "Disponível" e remove o registro de pendência.
- **Relatório:** Listagem de todos os itens emprestados no momento.

## 📂 Estrutura do Projeto

O projeto foi organizado em pacotes para melhor manutenção:
```text
src
├── application
│   └── SistemaBibliotecaApplication.java
│
├── model
│   ├── Biblioteca.java   
│   ├── Livro.java        
│   └── Usuario.java      
│
└── service 
    ├── BibliotecaService.java 
    ├── LivroService.java   
    ├── UsuarioService.java
    └── MenuService.java


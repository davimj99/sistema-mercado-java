# 🛒 Mini Mercado Java

<p align="center">

![Java](https://img.shields.io/badge/Java-8%2B-orange?style=for-the-badge&logo=openjdk)
![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow?style=for-the-badge)
![Git](https://img.shields.io/badge/Git-Versionamento-F05032?style=for-the-badge&logo=git&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-Repositório-181717?style=for-the-badge&logo=github)
![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)

</p>

---

# 📖 Sobre o Projeto

O **Mini Mercado Java** é um projeto desenvolvido com o objetivo de praticar e consolidar os principais conceitos da linguagem Java e Programação Orientada a Objetos (POO).

O projeto começou como uma aplicação simples executada via terminal e será evoluído gradativamente para um sistema completo, aplicando boas práticas de desenvolvimento, organização de código, arquitetura de software e versionamento com Git.

A proposta é simular um sistema de gerenciamento de um pequeno mercado, permitindo a evolução desde conceitos básicos da linguagem até conceitos avançados utilizados no mercado de trabalho.

---

# 🎯 Objetivos

- Aprender Java na prática
- Aplicar Programação Orientada a Objetos
- Desenvolver lógica de programação
- Criar um projeto real do zero
- Praticar organização de código
- Utilizar Git e GitHub
- Trabalhar com branches e Pull Requests
- Desenvolver boas práticas de programação
- Criar um projeto para portfólio

---

# 🚀 Tecnologias Utilizadas

- ☕ Java
- 💻 IntelliJ IDEA
- 🌱 Git
- 🐙 GitHub

---

# 📂 Estrutura Atual do Projeto

```text
src
└── br
    └── com
        └── davi
            └── mercado
                │
                ├── dominio
                │   └── Produto.java
                │
                ├── service
                │   └── ProdutoService.java
                │
                ├── repository
                │
                ├── test
                │
                └── Main.java
```

---

# 🏗️ Arquitetura

O projeto segue uma organização inicial baseada na separação de responsabilidades.

```text
Main
│
├── Interação com usuário
│
▼
ProdutoService
│
├── Cadastro de produtos
├── Listagem de produtos
├── Busca de produtos
└── Atualização de produtos
│
▼
Produto
│
└── Representa o objeto de domínio
```

---

# ✅ Funcionalidades

## Implementadas

- [x] Cadastro de produtos
- [x] Listagem de produtos
- [x] Busca de produtos por ID
- [x] Atualização de produtos por ID
- [x] Menu interativo no terminal
- [x] Organização inicial em pacotes
- [x] Encapsulamento utilizando getters e setters
- [x] Criação de objetos utilizando construtores
- [x] Manipulação de arrays de objetos

---

## 🚧 Em Desenvolvimento

- [ ] Controle de estoque
- [ ] Remoção de produtos
- [ ] Categorias de produtos
- [ ] Validação de dados
- [ ] Tratamento de exceções
- [ ] Melhorias na arquitetura
- [ ] Persistência em arquivos
- [ ] Persistência em banco de dados
- [ ] Sistema de vendas
- [ ] Relatórios
- [ ] Testes unitários

---

# 📚 Conceitos Estudados

| Conceito | Status |
|----------|--------|
| Variáveis | ✅ |
| Tipos Primitivos | ✅ |
| Operadores | ✅ |
| Estruturas Condicionais | ✅ |
| Estruturas de Repetição | ✅ |
| Arrays | ✅ |
| Métodos | ✅ |
| Classes | ✅ |
| Objetos | ✅ |
| Encapsulamento | ✅ |
| Getters e Setters | ✅ |
| Associação | ✅ |
| Arrays de Objetos | ✅ |
| Construtores | ✅ |
| Herança | 🚧 |
| Polimorfismo | ⏳ |
| Classes Abstratas | ⏳ |
| Interfaces | ⏳ |
| Exceptions | ⏳ |
| Collections | ⏳ |
| Generics | ⏳ |
| JDBC | ⏳ |
| API REST | ⏳ |

---

# 🗺️ Roadmap

## ✅ Versão 1.0 - Cadastro de Produtos

- Cadastro de produtos
- Listagem de produtos
- Busca por ID
- Atualização por ID
- Remoção de produtos

---

## 🚧 Versão 2.0 - Regras de Negócio

- Controle de estoque
- Organização em camadas
- Melhor separação de responsabilidades
- Herança
- Polimorfismo
- Tratamento de exceções

---

## ⏳ Versão 3.0 - Persistência

- Persistência em arquivos
- Leitura e gravação de dados
- Organização de dados

---

## ⏳ Versão 4.0 - Banco de Dados

- JDBC
- Integração com banco de dados
- CRUD completo
- Consultas SQL

---

## ⏳ Versão 5.0 - API REST

- Spring Boot
- Desenvolvimento de API REST
- Banco de dados relacional
- Arquitetura profissional

---

# 🌿 Git Flow

O projeto utiliza um fluxo baseado em branches para organizar o desenvolvimento.

Estrutura atual:

```text
main
│
├── feature/Produto
│
└── feature/README
```

Fluxo de desenvolvimento:

```text
feature/*
    │
    ▼
Desenvolvimento
    │
    ▼
Commit
    │
    ▼
Push
    │
    ▼
Pull Request
    │
    ▼
Merge
    │
    ▼
main
```

---

# 📈 Evolução

Este projeto acompanha minha evolução no aprendizado de Java.

Cada funcionalidade é desenvolvida separadamente e integrada ao projeto principal conforme o aprendizado avança.

O objetivo é transformar uma aplicação simples de terminal em um sistema completo, aplicando conceitos utilizados no desenvolvimento profissional.

---

# 📊 Progresso Atual

```text
Java Básico        ████████████████░░░░ 80%

POO                ██████████░░░░░░░░░░ 50%

Herança            ███░░░░░░░░░░░░░░░░░ 15%

Collections        ░░░░░░░░░░░░░░░░░░░░ 0%

Banco de Dados     ░░░░░░░░░░░░░░░░░░░░ 0%

JDBC               ░░░░░░░░░░░░░░░░░░░░ 0%

API REST           ░░░░░░░░░░░░░░░░░░░░ 0%
```

---

# 🤝 Contribuição

Este é um projeto de estudos e evolução pessoal.

Sugestões e melhorias são sempre bem-vindas.

---

# 👨‍💻 Autor

<div align="center">

## Davi Souza

Back-end Developer

[![LinkedIn](https://img.shields.io/badge/LinkedIn-Davi%20Souza-0A66C2?style=for-the-badge&logo=linkedin)](https://www.linkedin.com/in/davisouza99/)

[![GitHub](https://img.shields.io/badge/GitHub-davimj99-181717?style=for-the-badge&logo=github)](https://github.com/davimj99)

</div>

---

<p align="center">

⭐ Se este projeto foi útil ou você gostou da evolução, considere deixar uma estrela no repositório!

</p>
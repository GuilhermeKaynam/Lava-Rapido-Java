# Lava Rápido

Sistema de console em Java para a rotina de um lava-rápido: cadastro de clientes, agendamento de lavagens, controle de produtos em estoque e venda de produtos, tudo por um menu no terminal. Projeto final do Bloco 1 do bootcamp Generation Brasil.

## Objetivo

Modelar um negócio real com Programação Orientada a Objetos, separando entidades, regras e interface de texto, e aplicando validação de entrada e coleções em memória.

## Funcionalidades

Menu com as opções:

1. Cadastrar cliente (nome, contato e tipo de veículo)
2. Listar clientes
3. Adicionar produto (tipo, preço e estoque)
4. Listar produtos
5. Agendar serviço
6. Listar agendamentos
7. Comprar produto
0. Sair

**Regras implementadas**

- Três tipos de lavagem para o agendamento: simples, completa e rápida.
- O agendamento só é criado para clientes já cadastrados.
- Datas validadas no formato `dd/MM/yyyy` com `java.time`.
- A compra de produto verifica e baixa o estoque.
- Saída colorida no terminal (códigos ANSI).

## Tecnologias

- Java 17
- `java.time` (`LocalDate`, `DateTimeFormatter`)
- Java Collections (`ArrayList`)
- Eclipse IDE

## Arquitetura

| Pacote | Conteúdo |
|---|---|
| `lavaRapido.model` | `Cliente`, `Produto`, `Agendamento` (com validação de data) |
| `lavaRapido.Controller` | `LavaRapidoController` — regras de cadastro, agendamento, estoque e venda |
| `lavaRapido.util` | `cores` — constantes ANSI |
| `lavaRapido` | `menu` — ponto de entrada e laço do menu |

## Estrutura de diretórios

```
Lava-Rapido-Java/
└── src/lavaRapido/
    ├── menu.java
    ├── Controller/LavaRapidoController.java
    ├── model/Cliente.java, Produto.java, Agendamento.java
    └── util/cores.java
```

## Como executar

Pré-requisito: JDK 17+.

**Pelo Eclipse ou IntelliJ:** importe a pasta como projeto Java e execute `lavaRapido.menu`.

**Pelo terminal:**

```bash
git clone https://github.com/GuilhermeKaynam/Lava-Rapido-Java.git
cd Lava-Rapido-Java
javac -d out $(find src -name "*.java")
java -cp out lavaRapido.menu
```

Os dados ficam em memória e são perdidos ao encerrar o programa.

## Melhorias futuras

- Controlar horários disponíveis por dia para evitar agendamentos conflitantes.
- Remover a pasta `bin/` do versionamento e adicionar um `.gitignore`.
- Persistir dados em banco (evolução natural para uma API com Spring Boot).
- Interface web em React.

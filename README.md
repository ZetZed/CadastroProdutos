# Cadastro de Produtos

#### Disciplina
- Programação Desktop (5º Semestre)

#### Professores
- [André Martins do Nascimento](https://www.linkedin.com/in/andr%C3%A9-martins-do-nascimento-54b054224/)
- [Luis Aurélio Casoni](https://www.linkedin.com/in/luis-aurelio-casoni/)

#### Aluno
- [Zet Zed](https://www.linkedin.com/in/zet-zed-644813197/)

## Sobre a atividade
Este projeto é parte de uma atividade acadêmica na disciplina de Programação Desktop, com o objetivo de aplicar os conceitos aprendidos nas aulas na criação de um programa utilizando interface gráfica, caixas de diálogo, janela, escutando e reagindo a eventos, criando a tela de cadastro, introdução ao JDBC e listando os dados na tela principal.

A atividade tem como propósito desenvolver as habilidades dos alunos em programação desktop, assim como em lidar com banco de dados e interfaces gráficas de usuário.

## Sobre o programa Cadastro de Produtos
O Cadastro de Produtos é um programa desenvolvido em Java com o objetivo de permitir o cadastro de produtos em um banco de dados MySQL. O programa é capaz de inserir, editar, excluir e listar produtos cadastrados.

Para isso, utiliza-se a biblioteca Swing para a criação de interfaces gráficas, a biblioteca JDBC para o acesso ao banco de dados MySQL e a linguagem SQL para a criação e manipulação do banco de dados.

O programa é executado a partir da classe `src/view/TelaPrincipal.java` e requer que o banco de dados esteja configurado localmente. O arquivo `db/cadastro_produtos.sql` é responsável pela criação da estrutura do banco de dados e tabelas.

#### Bibliotecas e Ferramentas Utilizadas
 - Java 8
 - Swing - biblioteca gráfica para criação de interfaces gráficas de usuário
 - JDBC - biblioteca para acesso a banco de dados
 - MySQL - banco de dados utilizado no projeto

#### Como utilizar
Clone o repositório para sua máquina local.
Configure o banco de dados MySQL localmente.
Importe o arquivo `db/cadastro_produtos.sql` para criar a estrutura do banco de dados e tabelas.
Configure o arquivo `src/dao/Conexao.java` com as informações de conexão com o banco de dados.
Compile e execute o programa a partir da classe `src/view/TelaPrincipal.java`.

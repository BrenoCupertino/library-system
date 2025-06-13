README - Sistema de Gerenciamento de Biblioteca
Este documento fornece uma visão geral do projeto do Sistema de Biblioteca, detalhando as escolhas de design e implementação com base na especificação fornecida e um guia sobre como executar a aplicação.

1. Objetivo do Projeto
O objetivo central deste trabalho é aplicar conceitos de projeto e programação orientada a objetos na implementação de um sistema simples de gerenciamento de biblioteca. O sistema gerencia o empréstimo, devolução e reserva de livros para diferentes tipos de usuários de uma biblioteca acadêmica: alunos de graduação, alunos de pós-graduação e professores.

2. Funcionalidades
O sistema implementa as seguintes funcionalidades, acessíveis via linha de comando:

Empréstimo de Livro (emp): Permite que um usuário pegue um livro emprestado.

Devolução de Livro (dev): Permite que um usuário retorne um livro previamente emprestado.

Reserva de Livro (res): Permite que um usuário reserve um livro.

Observar Livro (obs): Permite que um professor se registre para receber notificações sobre um livro específico.

Consultar Livro (liv): Exibe informações detalhadas sobre um livro, incluindo seus exemplares e reservas.

Consultar Usuário (usu): Mostra o histórico de empréstimos e as reservas ativas de um usuário.

Consultar Notificações (ntf): Exibe a quantidade de notificações recebidas por um professor.

Sair (sai): Encerra a execução do sistema.

3. Design e Implementação
O projeto foi estruturado seguindo as exigências da especificação, com forte ênfase no uso de padrões de projeto para garantir um código coeso, desacoplado e extensível.

Gerenciamento de Dados
Conforme a especificação, o sistema não utiliza banco de dados para persistência. Todos os dados de usuários, livros e exemplares são instanciados em memória durante a inicialização da aplicação, como pode ser visto na classe Main.

Padrões de Projeto Utilizados
Singleton Pattern
A classe Repository é responsável por centralizar o acesso aos dados do sistema, como as listas de usuários e livros. Para garantir que exista apenas uma única fonte de dados em toda a aplicação, esta classe foi implementada seguindo o padrão Singleton. O acesso à instância única é feito através do método estático Repository.getInstace().

Command Pattern
Para atender à exigência de separar a lógica de negócio da interface de usuário, o sistema utiliza o padrão Command.

A classe Console atua como a Invoker. Ela é responsável por receber a entrada do usuário, mas não conhece os detalhes de como executar cada operação.

A interface Icommand define o contrato para todos os comandos, com um método execute().

Classes como LoanCommand, DevolutionCommand, ReserveCommand, etc., são as implementações concretas (Concrete Commands), cada uma encapsulando a lógica para uma funcionalidade específica.

A Console mantém um mapa que associa as strings de comando (ex: "emp") às suas respectivas instâncias de Icommand. Ao receber um comando, ela simplesmente localiza o objeto correspondente e invoca seu método execute(), passando os parâmetros necessários através do objeto LoadParameters.

Strategy Pattern
A especificação exige que as regras de empréstimo, que variam entre os tipos de usuário (alunos e professores), sejam implementadas sem o uso de condicionais como if ou switch para verificar o tipo do usuário. Para cumprir este requisito, foi utilizado o padrão Strategy.

A interface ILoanStrategy define um contrato para as diferentes políticas de empréstimo.

As classes StudentLoanStrategy e ProfessorLoanStrategy implementam esta interface, cada uma contendo o conjunto de regras de validação específico para seu respectivo tipo de usuário.

No momento da sua criação, cada objeto User é configurado com a estratégia de empréstimo apropriada (ex: Professor recebe uma ProfessorLoanStrategy).

Quando um empréstimo é solicitado (user.loanBook(book)), o método delega a validação para o objeto de estratégia que ele possui, selecionando dinamicamente o algoritmo correto a ser executado.

Observer Pattern
A funcionalidade que permite a um professor ser notificado quando um livro atinge um número elevado de reservas foi implementada com o padrão Observer. Este padrão foi escolhido por permitir uma evolução futura, como adicionar outros tipos de observadores (e.g., coordenadores) sem alterar as classes de negócio existentes.

A interface ISubject é implementada pela classe Book, que atua como o sujeito a ser observado.

A interface IObserver é implementada pela classe User (especificamente Professor neste caso), que atua como o observador.

Quando o comando obs é executado, um usuário (observador) é registrado na lista de observadores de um livro (sujeito).

Sempre que uma nova reserva é feita em um livro, ele verifica se a condição de notificação foi atingida. Se sim, ele chama o método notifyObservers(), que por sua vez itera sobre sua lista de observadores e chama o método update() de cada um, incrementando o contador de notificações do professor.

4. Tutorial de Execução
Pré-requisitos
Java Development Kit (JDK) instalado e configurado no seu sistema.

Passos para Compilação e Execução
Estrutura de Arquivos: Certifique-se de que todos os arquivos .java estão organizados em suas respectivas pastas de pacotes (businessstrategy, command, strategy, observer, etc.), conforme definido no código. O arquivo Main.java deve estar no diretório raiz do projeto.

Abra o Terminal: Navegue pelo terminal ou prompt de comando até o diretório raiz do projeto (a pasta que contém o Main.java e as pastas dos pacotes).

Compile o Código: Execute o seguinte comando para compilar todos os arquivos Java. Este comando irá procurar e compilar todos os arquivos .java nos subdiretórios e salvar os arquivos .class compilados na estrutura de pacotes correta.

javac -d . $(find . -name "*.java")

Se você estiver no Windows, pode usar o comando:

javac -d . businessstrategy\*.java command\*.java domain\books\*.java domain\user\*.java exceptions\*.java messages\*.java observer\*.java strategy\*.java strategy\rules\*.java *.java

Execute a Aplicação: Após a compilação bem-sucedida, execute o programa com o seguinte comando:

java Main

Interaja com o Sistema: O console aguardará a sua entrada. Utilize os comandos listados abaixo para interagir com o sistema.

5. Referência de Comandos
A seguir estão os comandos disponíveis e seus respectivos formatos:

Comando

Descrição

Formato

emp

Realiza o empréstimo de um livro para um usuário.

emp <código_usuário> <código_livro>

dev

Realiza a devolução de um livro por um usuário.

dev <código_usuário> <código_livro>

res

Reserva um livro para um usuário.

res <código_usuário> <código_livro>

obs

Registra um professor como observador de um livro.

obs <código_professor> <código_livro>

liv

Consulta informações detalhadas de um livro.

liv <código_livro>

usu

Consulta o histórico e as reservas de um usuário.

usu <código_usuário>

ntf

Consulta o número de notificações de um professor.

ntf <código_professor>

sai

Encerra o sistema.

sai

Exemplo de uso: Para que o usuário "João da Silva" (código 123) pegue emprestado o livro "Engenharia de Software" (código 100), o comando seria:

emp 123 100

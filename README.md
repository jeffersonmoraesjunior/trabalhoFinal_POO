<h1>Sistema de Gerenciamento de Estudantes</h1>

 <p>Este é um simples sistema de gerenciamento de estudantes em Java. Ele permite adicionar, editar, remover e listar informações de estudantes em um banco de dados simulado.</p>

 <h2>Passo 1: Definir as Classes</h2>

 <p>O projeto é composto por três classes principais:</p>

 <ul>
      <li><strong>SistemaGerenciamentoEstudantes:</strong> A classe principal que inicia o programa e interage com o usuário pelo console.</li>

   <li><strong>Estudante:</strong> Representa os dados de cada estudante, incluindo atributos como nome, ID e curso. Possui métodos construtores, getters e setters para manipulação dos dados do estudante.</li>
 </ul>

 <h2>Passo 2: Implementar a Classe de Banco de Dados</h2>

 <p><strong>BancoDeDados:</strong> Responsável por lidar com a conexão e operações no banco de dados simulado. Configura a conexão no construtor da classe e implementa métodos para adicionar, editar, remover e listar estudantes no banco de dados simulado.</p>

 <h2>Passo 3: Implementar o Menu do Usuário</h2>

 <p><strong>Menu:</strong> Interage com o usuário pelo console, permitindo que o usuário escolha entre as seguintes opções:</p>

 <ul>
      <li>Adicionar Estudante</li>
      <li>Editar Estudante</li>
      <li>Remover Estudante</li>
      <li>Listar Estudantes</li>
      <li>Sair</li>
 </ul>

 <p>Para cada opção do menu, métodos correspondentes são implementados, utilizando as classes Estudante e BancoDeDados para realizar as operações desejadas.</p>

 <h2>Passo 4: Tratamento de Exceções</h2>

 <p>O projeto inclui tratamento de exceções nas operações de banco de dados. Isso permite capturar exceções, como falhas na conexão ou consultas mal-sucedidas, fornecendo feedback adequado ao usuário em caso de erros.</p>

 <h2>Passo 5: Organização em Pacotes</h2>

 <p>O código está organizado em pacotes para manter uma estrutura organizada:</p>

 <ul>
     <li>O pacote "model" contém a classe Estudante.</li>
     <li>O pacote "data" contém a classe BancoDeDados.</li>
     <li>O pacote "view" contém a classe Menu.</li>
 </ul>
 <h2>Como Executar</h2>
 <p>Compile o projeto Java.</p>

<p>Execute a classe SistemaGerenciamentoEstudantes para iniciar o programa.</p>

<p>Certifique-se de que você tenha configurado seu ambiente Java corretamente antes de executar o projeto.</p>
</div>


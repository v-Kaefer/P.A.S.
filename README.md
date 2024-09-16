# P.A.S.
Repositório para a matéria de Projeto e Arquitetura de Software


### Foi necessário a utilização da referência direta, pelo arquivo `dockerfile`, para poder utilizar a imagem padronizada. (depreciado)

Ref.: https://mcr.microsoft.com/en-us/product/devcontainers/java/about

Trabalho

## Tarefa: implementando repositórios usando JDBC

### Considere a aplicação da biblioteca desenvolvida em aula cujo código está disponível no Moodle e faça o que se pede:
*App da biblioteca, pode ser encontrado no Moodle, em: "Material da Disciplina/Introdução a Arquitetura de Software e Sistemas WEB"

a) Converta o repositório que mantém a lista de livros implementado usando um ArrayList em memória usando JDBC para acessar um SGBD (local ou serviço de nuvem). Crie um script para pré-cadastrar pelo menos 5 livros na biblioteca. Além dos dados já previstos na aplicação atual, acrescente um campo para armazenar o código do usuário que retirou o livro ou “-1” caso o livro não esteja emprestado.

b) Crie um repositório para armazenar os dados dos usuários da biblioteca (código, nome, ano de nascimento). Apenas usuários cadastrados podem fazer retiradas de livros na biblioteca.

#### Acrescente “endpoints” para permitir a retiradas e devoluções de livros bem como para listar os livros que não estão emprestados e os que estão emprestados para um determinado usuário.

Explore a documentação da JDBC para verificar como implementar todas as consultas necessárias.

# To-Do

    * -[ ] Implementar ArrayList na lista que armazena os livros.
    * -[ ] Implementar SGBD (Neon), usando JDBC.
    * -[ ] Criar script para pré-cadastro de pelo menos 5 livros na biblioteca.
    * -[ ] Acrescentar um campo para armazenar o código do usuário, que retirou o livro ou "-1" caso o livro não esteja emprestado / esteja disponível.
    * -[ ] Criar um repo para armazenar os dados dos usuários da biblioteca (código, nome, ano de nascimento).
    * **Regra de Negócio:** Apenas usuários cadastrados podem fazer retiradas de livros na biblioteca.

## Utilitários

* Comandos:
- Rodar os testes (defaultGoal) `mvn -X -e`
- Caso tenha erros com URLs de caminho absoluto no classpath, isso deve desativar a verificação e permitir que os testes sejam executados corretamente. `mvn clean test`
- build: `mvn package`- build: `mvn package`

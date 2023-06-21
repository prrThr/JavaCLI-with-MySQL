## Implemente um sistema com interface de interação com usuário, que atenda aos seguintes requisitos:

### Requisitos funcionais:
* **RF1**. O sistema deve manter o registro de pagamentos de
mensalidades de condomínios de acordo com a RN01.
*  **RF2**. O sistema deve manter o registro de pagadores de acordo com
a RN02.
* **RF3**. O sistema deve manter o registro de unidades de acordo com a
RN03.
* **RF4**. O sistema deve possibilitar baixar o arquivo de comprovante de
determinado pagamento, recebendo como entrada o código do
pagamento. O arquivo de saída pode ser gerado em qualquer.
* **RF5**. A listagem de pagamentos deve ser ordenada pelo ano de
referência em primeiro nível, pelo mês de referência em segundo
nível e exibir o todas as colunas desta entidade, substituindo o código
do pagador pelo seu nome.

### Requisitos não funcionais:
* **RNF01**. O sistema deve utilizar o SGBD MySQL.
* **RNF02**. O sistema deve possuir telas para interação com usuário
para atendimento de todos os requisitos funcionais. As telas podem
ser implementadas em uma das seguintes plataformas: CLI, desktop
ou web.
* **RNF03**. O sistema pode ser implementado em uma das seguintes
tecnologias: Node.js, Python ou JAVA.
* **RNF04**. Não devem ser utilizados frameworks de ORM.
* **RNF05**. A inserção e deleção de registros em tabela deve ser
realizada por meio de chamada de store procedures.
* **RNF06**. A data de registro no sistema da entidade Pagamento deve
ser atribuída por meio de Trigger.


### Regras de negócio:
* **RN01**. O pagamento de condomínio necessita contar as seguintes
informações: identificador do pagador, data de pagamento,
comprovante (BLOB de arquivo pdf), ano de referência, mês de
referência, identificador da unidade, data de registro no sistema.
* **RN02**. O pagador registrado no sistema deve conter as seguintes
informações: nome completo, e-mail de contato, número de
documento de identificação, telefone de contato.
* **RN03**. Uma unidade é registrada pelo seu número identificador e
localização (ex. primeiro andar; bloco 2, etc.).
* **RN04**. Por manter registro, no contexto deste trabalho entende-se:
possibilidade de inserir novos registros, possibilidade de listar todos
os registros em tela, possibilidade de excluir um registro pelo código.

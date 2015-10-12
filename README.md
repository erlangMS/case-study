## Estudo de Caso ( Modernização do Sistema Sae )

Para que seja possível avaliar a abordagem proposta por ErlangMS, surge
a necessidade de aplicação em um ambiente real, de modo a
investigar como a arquitetura comporta-se, quais os desafios
técnicos e gerenciais, as dificuldades e os benefícios que
podem ser obtidos com o seu uso.

De forma resumida, o estudo visa modernizar o Sistema de
Assistência Estudantil (SAE) da UnB. Este sistema divide-se
em dois módulos (1 módulo em VB e outro em C#), ambos
com duplicidades de implementação de regras de negócio e
que o CPD tem interesse em modernizar. 

O trabalho que será realizado extrair a lógica negocial para
uma camada de negócio que será criada em Java, desenvolver a
fachada de serviços e registrar no catálogo de serviço. Por fim,
a camada front-end será reescrita para consumirem os serviços
disponíveis no catálogo de serviços através do barramento.

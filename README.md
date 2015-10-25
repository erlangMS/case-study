## Estudo de Caso ( Modernização do Sistema Sae )

Para que seja possível avaliar a abordagem proposta por ErlangMS, surge
a necessidade de aplicação em um ambiente real, de modo a
investigar como a arquitetura comporta-se.

De forma resumida, o estudo visa modernizar o Sistema de
Assistência Estudantil (SAE) da UnB. Este sistema divide-se
em dois módulos (1 módulo em VB e outro em C#), ambos
com duplicidades de implementação de regras de negócio e
que o CPD tem interesse em modernizar. 

O trabalho que será realizado visa extrair a lógica negocial para
uma camada de negócio que será criada em Java, desenvolver a
fachada de serviços e registrar os serviços no catálogo de serviço do barramento. Por fim,
a camada front-end será reescrita para consumirem os serviços
disponíveis no catálogo de serviços.

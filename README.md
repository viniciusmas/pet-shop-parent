# pet-shop-parent
#### API Pet Shop Separado em Módulos

## Estrutura multi-módulos

Foi escolhida a refatoração do projeto pet-shop-api (https://github.com/viniciusmas/pet-shop-api) e está dividido em:

* #### common-domain - Módulo de domínio compartilhado. Contém as classes de domínio (entidades JPA), enums e DTOs que são fundamentais para o negócio e precisam ser compartilhadas por múltiplos módulos.


* #### external-api-client - Módulo de cliente de APIs externas. Contém as Interfaces para as APIs Google Calendar e ViaCep


* #### main-application - Módulo da aplicação principal. Contém a lógica de negócio principal, os repositórios para persistência de dados, os controladores REST que expõem a API do sistema, a configuração do Spring Security, autenticação e autorização por URL.

## Uso de DTOs (Data Transfer Objects) na API PetShop

#### Os DTOs foram usados para separar a camada de domínio (entidades JPA) da camada de apresentação. Foram aplicados nas classes de domínio para representar os dados recebidos do cliente (Input) e os dados retornados pela API (Output). O cliente recebe somente as informações relevantes já formatadas, agregadas e simplificadas, sem expor detalhes técnicos do modelo interno.
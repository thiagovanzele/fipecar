# FIPE Car Application

Este projeto é uma aplicação Java que consome a [API da Tabela Fipe](https://deividfortuna.github.io/fipe/) para retornar informações sobre o valor de veículos (carros, motos e caminhões). A aplicação permite ao usuário selecionar o tipo de veículo, marca, modelo e ano, exibindo o valor atualizado do veículo escolhido.

## Estrutura do Projeto

- `br.com.vanzele.application.Principal`: Contém a lógica principal da aplicação, incluindo a interação com o usuário para escolher o tipo de veículo, marca, modelo e ano.

- `br.com.vanzele.application.model.entities.Dados`: Representa dados genéricos utilizados na aplicação.

- `br.com.vanzele.application.model.entities.Modelos`: Representa uma lista de modelos de veículos.

- `br.com.vanzele.application.model.entities.Veiculo`: Representa um veículo com suas características e valor.

- `br.com.vanzele.FipecarApplication`: Classe principal que inicia a aplicação Spring Boot.

- `br.com.vanzele.model.exceptions.FilterException`: Exceção personalizada para erros de filtro.

- `br.com.vanzele.model.exceptions.JsonException`: Exceção personalizada para erros de processamento JSON.

- `br.com.vanzele.model.services.ConsomeApiService`: Serviço responsável por consumir a API da Tabela Fipe.

- `br.com.vanzele.model.services.CriaObjetoService`: Serviço responsável por criar objetos a partir das respostas JSON da API.

## Exemplo de Uso

Ao iniciar a aplicação, você verá o seguinte menu:

[1] - Carros
[2] - Motos
[3] - Caminhões

Escolha a opção desejada digitando o número correspondente e pressione Enter. Em seguida, você será solicitado a informar a marca, modelo e ano do veículo. A aplicação irá exibir o valor do veículo conforme os dados fornecidos.

## Contato

Para mais informações, entre em contato com [thiagovanzele@gmail.com](mailto:seu-email@exemplo.com).

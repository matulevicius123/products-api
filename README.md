# products-api
Uma API REST simples para gerenciamento de produtos em um banco de dados de uma loja e-commerce. 

O repositório serve como meu envio para o desafio **'Publicando Sua API REST na Nuvem'** da DIO.

```mermaid
classDiagram
    class Product {
        Long id
        string name
        string seller
        float price
        int stock
        string description
        float rating
        Review[] reviews
    }

    class Review {
        Long id
        string user
        string comment
        float rating
    }

    Product "1" --> "*" Review : has
```

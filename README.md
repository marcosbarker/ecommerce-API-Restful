[🚧**issues**](https://github.com/marcosbarker/ecommerce-API-Restful/issues/1)
<!-- ALL-CONTRIBUTORS-BADGE:START - Do not remove or modify this section -->
[![All Contributors](https://img.shields.io/badge/all_contributors-1-orange.svg?style=flat-square)](#contributors-)
<!-- ALL-CONTRIBUTORS-BADGE:END -->
<a name="back-to-top">
<p align="center">
  <img height="400px" src="https://freevector-images.s3.amazonaws.com/uploads/vector/preview/36682/36682.png" alt="logo ecommerce"/>
</p>
<p align="center">
<i>Projeto de conclusão da disciplina feito em grupo como requisito parcial da disciplina Desenvolvimento de API Restful, da Residência de Software do Serratec.</i>
</p>
<h3 align="center">Professor Alexandre de Oliveira Paixão</h3>
</br>


## 🔑API para um Ecommerce atendendo os seguintes Requisitos:
- Utilizar um sistema de login de usuários:<br> 
  * Um Cliente poderá se cadastrar livremente.<br> 
  * Para o cadastro cliente deverá informar os dados mapeados na tabela "Cliente". O Endereço deverá ser validado através da API Via Cep.<br> 
  * Após logado o Cliente poderá fazer as seguintes operações:(Com exceção das duas ultimas todas não poderão ser realizadas sem o envio do token - autenticação na API).<br> 
- Atualizar seus proprios dados pessoais (como Endereço, Telefone, menos CPF):<br> 
  - Deletar sua propria conta.<br> 
  - Criar um novo Pedido.<br>   
  - Editar um pedido com status de não finalizado.<br> 
  - Finalizar um pedido, alterar seu status para finalizado. Ao finalizar o pedido enviar e-mail para o cliente informando data de entrega, produtos, quantidades e valor final do pedido.<br> 
  - Visualizar todas as categorias ou uma especifica pelo nome.<br> 
  - Visualizar todos os produtos ou um específico pelo nome.<br> 

### 📖Sem estar logado ele poderá:
- Visualizar todas as categorias ou uma especifica pelo nome.<br> 
- Criar uma nova categoria.<br> 
- Editar uma categoria.<br> 
- Deletar uma categoria.<br> 
- Visualizar todos os produtos ou um específico pelo nome.<br> 
- Criar um novo produto (Com imagem).<br> 
- Editar um produto.<br> 
- Deletar um produto.<br> 
- Visualizar todos os pedidos.<br> 
- Excluir algum pedido.<br><br> 

⚠️🔃**Os principais campos deverão ser validados, (cpf, produto não poderá ter valores negativos, etc.) e todas as exceções deverão serem tratadas.**<br><br> 
🖋**A Api deverá utilizar como documentação a ferramenta do Swagger.**<br><br> 
⚡**Desafio Extra (Opcional): opção de esqueci minha senha com envio de um código de verificação para o e-mail e posterior verificação se esse código pertence ao cliente.**<br> 
<br>
<details>
<summary>Diagrama ER</summary>
<img align="center" src="assets/diagrama.png">
</details>
<details>
<summary>Legenda Cardinalidade</summary>
<img align="center" height="400px" src="assets/cardinalidade.jpeg">
</details>
<br>

## <img  height="45px" align="center" src="https://github.com/marcosbarker/serratec.residencia/blob/main/assets/stockrocketgif.gif"> Tecnologia Utilizada
- [**DBeaver**](https://dbeaver.io/)    [(*Documentação*)](https://dbeaver.com/docs/wiki/)
- [**Mailtrap**](https://mailtrap.io/)    [(*Documentação*)](https://mailtrap.docs.apiary.io/#)    
- [**Java**](https://www.oracle.com/java/technologies/)    [(*Documentação*)](https://docs.oracle.com/en/java/)    [(*Documentação MDN*)](https://developer.mozilla.org/en-US/docs/Glossary/Java)
- [**PostgreSQL**](https://www.postgresql.org/)    [(*Documentação*)](http://pgdocptbr.sourceforge.net/pg80/index.html)
- [**Postman**](https://www.postman.com/downloads/)    [(*Documentação*)](https://learning.postman.com/docs/getting-started/introduction/)
- [**Spring Boot**](https://spring.io/)    [(*Documentação*)](https://spring.io/projects/spring-boot)
- [**Spring Tools 4**](https://spring.io/tools)    [(*Documentação*)](https://github.com/spring-projects/sts4/wiki)
- [**Swagger**](https://swagger.io/)    [(*Documentação*)](https://swagger.io/solutions/api-documentation/)      
<br>

&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;⬆️[**Back to top**](#back-to-top)⬆️

## Contributors ✨

Thanks goes to these wonderful people ([emoji key](https://allcontributors.org/docs/en/emoji-key)):

<!-- ALL-CONTRIBUTORS-LIST:START - Do not remove or modify this section -->
<!-- prettier-ignore-start -->
<!-- markdownlint-disable -->
<table>
  <tr>
    <td align="center"><a href="http://linktr.ee/marcos_barker"><img src="https://avatars.githubusercontent.com/u/57602117?v=4?s=100" width="100px;" alt=""/><br /><sub><b>Marcos Paulo Marques Corrêa </b></sub></a><br /><a href="https://github.com/marcosbarker/ecommerce-API-Restful/commits?author=marcosbarker" title="Code">💻</a></td>
  </tr>
</table>

<!-- markdownlint-restore -->
<!-- prettier-ignore-end -->

<!-- ALL-CONTRIBUTORS-LIST:END -->

This project follows the [all-contributors](https://github.com/all-contributors/all-contributors) specification. Contributions of any kind welcome!
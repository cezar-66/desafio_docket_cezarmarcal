# desafio_docket_cezarmarcal

<h3>Bem vindo ao sistema de Gerenciamentos de cartórios</h3>
<p>O projeto visa atender as necessidades básicas de um cartório como:</p>
<p>Cadastrar novo cartório, excluir, editar, vincular certidões que esse cartório emite entre outras funcionalidades</p>


<h3>Como configurar:</h3>

<p>1° Passo: Baixar o projeto e importar o mesmo na IDE de sua preferência atráves do arquivo pom.xml</p>

<p>2° Passo: Abrir o arquivo "application.properties" nele foi mapeado o caminho do banco de dados e suas respectivas configurações</p>

</p>3 Passo: Criar um banco de dados local (postgres) com o mesmo nome que foi configurado no atributo:
   spring.datasource.url=jdbc:postgresql://localhost:5432/(nome do banco de dados) e também setar nome do usuário e password do banco local</p>

<h3>Tecnologias utilizadas</h3>
.JAVA 11
.Spring boot, Spring security, Jpa, Flyway migration, Postgres, Lombook, Thymeleaf

<h3>Arquitetura</h3>
MVC (Model, View, Controller)

<h3>Importante*</h3>
<b>Ao rodar a aplicação pela primeira vez serão executados dois scripts de migração, sendo eles:</b>

V001__Cria_tabela_operador_e_permissoes_de_acesso.sql</br>
V002__Cria_tabela_cartorios_e_ certidoes.sql

<h3>Ao criar o scprit 001 será gerado dois usuários de acesso ao sistema</h3> 
<p>usuario: root password:123</p>
<p>usuario: user password:123</p>







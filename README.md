# GraphQLCompras

 
## :information_source: Information 

Project developed with SpringBoot and GraphQL. It was the object of study during development:
- Creating a GraphQL API connected to the MYSQL database;
- Creating custom queries with join between multiple tables to navigate the graph layers.
- The use of paging in GraphQL queries;
- Study on the GraphQL N+1 problem and how to use Cache;
- Creating and Handling custom exceptions.
## ⚠️ Prerequisite
[![Java Badge](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.oracle.com/br/java/technologies/javase-downloads.html) >= 8 

![Spring Badge](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)

![JSON Badge](https://img.shields.io/badge/json-5E5C5C?style=for-the-badge&logo=json&logoColor=white)

![mysql](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)

![JPA-hibernate (1)](https://user-images.githubusercontent.com/44611131/136869865-0e3d7476-5128-4471-8817-8df40315b970.jpg)

![GRAPHQL](https://img.shields.io/badge/GraphQl-E10098?style=for-the-badge&logo=graphql&logoColor=white)

![JUNIT](https://img.shields.io/badge/Junit5-25A162?style=for-the-badge&logo=junit5&logoColor=white)



##  🔧 Install 


![](https://img.shields.io/badge/Linux-FCC624?style=for-the-badge&logo=linux&logoColor=black)


```
https://github.com/RamonBecker/GraphQLCompras.git
```

![](https://img.shields.io/badge/Windows-0078D6?style=for-the-badge&logo=windows&logoColor=white)
```
git clone https://github.com/RamonBecker/GraphQLCompras.git
or install github https://desktop.github.com/ 
```


## ⚙️ Installing MySQL

Enter the following commands in the terminal.

```
sudo apt update
sudo apt install mysql-server

```
### Configuring MySQL

For new installations, you will want to run the security script that is included. This changes some of the less secure default options for things like root logins and example users. Enter the command below.

```
sudo mysql_secure_installation
```
This will take you through a series of prompts where you can make some changes to the security options of your MySQL installation. The first prompt will ask you if you want to configure the Validate Password Plugin, which can be used to test the strength of your MySQL password. Regardless of your choice, the next prompt will be to set the password for the MySQL root user. Sign in and then confirm a secure password of your choice.

From there, you can press Y and then ENTER to accept the default answers for all subsequent questions. This will remove some anonymous users and the test database, disable remote login for root, and load all of these new rules so that MySQL immediately respects the changes you made.

### Testing MySQL

To see if MYSQL is running, type the following command.

```
systemctl status mysql.service
```

If MySQL is not running, you can start it with the following command.
```
sudo systemctl start mysql

Now try to connect your root user to MySQL.
```
mysql -u root -p


### Attention when creating and connecting the database

Check the application.properties file

```
spring.datasource.url=jdbc:mysql://localhost:3306/udemy_purchases?useSSL=false&allowPublicKeyRetrieval=true
spring.datasource.username=username
spring.datasource.password=password
```

You must create the database in MYSQL with the name udemy_compras

## ⚙️ Testing the project


Open your browser and type: 

http://localhost:8080/graphiql


To test product features:

```
mutation{
saveProduto(produto:{id: "" ,nome:"teste", valor: 1000}){
      ...fragProduto
   }
 }

mutation{
   deleteProduto(id:6)
}

{
  produtos{
     ...fragProduto
   }
}

fragment fragProduto on Produto
{
    id, nome, valor
}

```

To test shopping features:

```
 mutation{
   saveCompra(compra:{
     clienteId:1,
     produtoId: 3,
     quantidade:30,
     status: "OK"
   }){
     id, quantidade, status
  }
 }
 
{
  compras{
    id,
    quantidade,
    status,
    cliente{
      id, nome
    },
    produto{
      id,nome, valor
    }
  }
}

 mutation{
  deleteCompra(id:1)
}

```

To test client features:

```
query GetCliente($id:ID!){
  
  cliente(id: $id){
    ...fragCliente
  }
}


mutation{
   saveCliente(cliente:{id:6, nome:"teste modelMappper ", email:"teste@gmail.com"}){
    id, nome, email
   }
}


mutation{
  deleteCliente(id:4)
}

{
   clientes{
     id, nome ,email
   }
}



{ 
c1: cliente(id:1){
     id, nome, email
},
c2:  cliente(id:2){
id, nome, email
 }
}


fragment fragCliente on Cliente
{
    id, nome, email
}

{
  
c1: cliente(id:1){
	...fragCliente
	},
   c2:  cliente(id:2){
 	...fragCliente 
   }
 }
```

## :zap: Technologies	

- Java
- JPA
- Spring Boot
- GraphQL
- JUNIT
- ModelMapper
- MYSQL

## :memo: Developed features

- [x] CRUD Purchases
- [x] CRUD Client
- [x] CRUD product



## :technologist:	 Author

By Ramon Becker 👋🏽 Get in touch!



[<img src='https://cdn.jsdelivr.net/npm/simple-icons@3.0.1/icons/github.svg' alt='github' height='40'>](https://github.com/RamonBecker)  [<img src='https://cdn.jsdelivr.net/npm/simple-icons@3.0.1/icons/linkedin.svg' alt='linkedin' height='40'>](https://www.linkedin.com/in/https://www.linkedin.com/in/ramon-becker-da-silva-96b81b141//)
![Gmail Badge](https://img.shields.io/badge/-ramonbecker68@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:ramonbecker68@gmail.com)

Title: Expense Helper

Project Description:

A full stack project using Spring Boot and React.js with a Mongodb database running on a docker container. 
Project serves as the basis for my learning of full stack development as future additions will be made to the webpage using other
web development tools/platforms and concepts/approaches. 

Currently project runs as a webpage on the users localhost:8080. Webpage allows the user to keep track of their 
monthly expenses in a easy on the eyes table. They can edit the budgeted amounts and choose from several categories to label. 
The table was made through a tutorial, link will be under description. Table has add, delete, edit, and update capabilites.

To take the project a step further of just a front end table, it is also in complete sync of a
local database using Mongodb running on a docker desktop container which the table interacts with through a back 
end of endpoints set up using Spring. Reference links will also be under description. 

The front and Back end run on the same port 8080. Typically React runs on localhost:3000. This was done using the webpack bundling tool. 
Webpack bundles all the React files into a single bundled file bundle.js which is ran in a html file that is 
loaded up by the Spring Boot thymeleaf template generator.   

The point of this being to make the webpage interactable with in the future with other services.

Project Learning Material: 

Creating React table  
https://www.youtube.com/watch?v=MINQoCSBmds

Setting up React with Java
https://spring.io/guides/tutorials/react-and-spring-data-rest
https://springjava.com/spring-boot/spring-boot-with-jpa-entity/

Setting up package.json and config.js for webpack

https://www.taniarascia.com/how-to-use-webpack/#basic-configuration

Connecting Spring with Mongo

https://www.geeksforgeeks.org/how-to-connect-mongodb-with-spring-boot/

How to set up project after File download: 

*********Mongo

Mongodb is running locally using Docker Desktop

1. Download docker desktop: https://docs.docker.com/get-docker/
2. Open up terminal and enter below commands to set up a mongodb container in docker using directions in below url

https://www.mongodb.com/docs/manual/tutorial/install-mongodb-community-with-docker/#:~:text=Run%20the%20Image%20as%20a%20Container&text=The%20%2Dp%2027017%3A27017%20in,in%20the%20Docker%20run%20command.

3. Once container has been install start it 
4. Once started click on container name and then in tabs options click the terminal or exec 
5. Start Mongosh sever by entering mongosh in terminal 
6. Enter ‘show dbs’ to list all databases
7. Enter use ‘userDatabase’ to create our expense database
8. Enter ‘db.createCollection(“Expense”)’ to create our expense collection
9. Enter ‘use Expense’ to enter our collection
10. Enter ‘db.Expense.find()’ to show all the documents in our expense database

********Front End

* Before starting front end open terminal and run following commands to install following React dependencies

npm install --save-dev css-loader

npm install --save-dev style-loader

npm i --save-dev html-webpack-plugin

npm install

Start front end enter
webpack --watch

********Back End
In Intellij terminal enter mvn clean install then run Intellij

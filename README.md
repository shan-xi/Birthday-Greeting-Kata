# Birthday Greeting Kata
In the project, there are 6 restful APIs providing 6 different versions of birthday greeting simple message.

## Prerequisite
- Java 11+
- Springboot 2.6+
- Gradle 7+
- Mysql 8+
- Mongo 5+
- [Mysql Database data](https://github.com/shan-xi/Birthday-Greeting-Kata/blob/main/src/main/resources/mysqldata)
- [MongoDB Database data](https://github.com/shan-xi/Birthday-Greeting-Kata/blob/main/src/main/resources/mongodata)

## Description
Springboot is used to build a restful API service. From Version 1, 2, 3, 4 and 6. Mysql database is used. In version 6, MongoDB database is used. In version 6, we use xml response instead of json response. Once you set the application in localhost, you can see response from the following endpoints: 
- http://127.0.0.1:8081/v1/birthday-greeting-messages/version1?pageNum=0
- http://127.0.0.1:8081/v1/birthday-greeting-messages/version2?pageNum=0
- http://127.0.0.1:8081/v1/birthday-greeting-messages/version3?pageNum=0
- http://127.0.0.1:8081/v1/birthday-greeting-messages/version4?pageNum=0
- http://127.0.0.1:8081/v1/birthday-greeting-messages/version5?pageNum=0
- http://127.0.0.1:8081/v1/birthday-greeting-messages/version6


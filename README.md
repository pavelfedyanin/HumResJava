HumResJava
=====================

Тестовое (домашнее) задание.


##База данных

Дамп базы расположен в файле humanres.sql 


##Подключение к БД

Чтобы подключиться к БД необходимо в файле web/WEB-INF/web.xml прописать данные параметры c вашими значениями:

    <context-param>
        <param-name>dbUser</param-name>
        <param-value>root</param-value>
    </context-param>
    <context-param>
        <param-name>dbPassword</param-name>
        <param-value>root</param-value>
    </context-param>
    <context-param>
        <param-name>dbURL</param-name>
        <param-value>jdbc:mysql://dbhost:3306/dbname?useUnicode=true&amp;characterEncoding=UTF-8</param-value>
    </context-param>
    


##Сборка приложения

Для сборки приложения используейте Apache Ant(TM) version 1.8.2

    
##Требования к окружению

При разработке данного приложения использовались:

* Tomcat  v.7.0.54
* Java    v.1.7_60 (JEE)
* Mysql   v.5.1

###Библиотеки

* javax.servlet-api-3.1.0.jar
* jstl-1.2.jar
* mysql-connector-java-5.1.31-bin.jar

##Возможные проблемы, баги и недоработки 

* Отсутствие валидации, реализована простейшая валидация средствами HTML5 на клиенте.
* Метод удаления сотрудника реализован "через одно место", а именно средстваими метода Get
* Частично реализован показ списка должнстей (только Back-end часть)

P.S. В связи с большой нагрузкой по работе, реализация задания стартовала всего за 4 дня до сдачи, поэтому заранее предостерегаю любопытного читателя сего творения не тешить себя большими надеждами и не надеятся на чудо.





    


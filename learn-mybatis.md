# MYBATIS

##Advantages of MYBATIS
* Supports stored procedures
* Supports inline SQL
* Supports dynamic SQL
* Supports O/RM

##Configuration XML

```
<configuration>

   <typeAliases>
      <typeAlias alias = "class_alias_Name" type = "absolute_clas_Name"/>
   </typeAliases>

   <environments default = "default_environment _name">
      <environment id = "environment_id">
         <transactionManager type = "JDBC/MANAGED"/>  

            <dataSource type = "UNPOOLED/POOLED/JNDI">
               <property name = "driver" value = "database_driver_class_name"/>
               <property name = "url" value = "database_url"/>
               <property name = "username" value = "database_user_name"/>
               <property name = "password" value = "database_password"/>
            </dataSource>

      </environment>
   </environments>

   <mappers>
      <mapper resource = "path of the configuration XML file"/>
   </mappers>

</configuration>
```

###environments tag
you can connect to multiple databases by configuring multiple environment elements.
the environment：**transactionManager**，**dataSource**
1. transactionManager tagMANAGED
	* JDBC：the application is responsible
	* MANAGED:the application server is responsible
2. dataSource tag
	* UNPOOLED: opens and closes a connection for every database operation.
	* POOLED:MyBatis will maintain a database connection pool
	* JNDI:get the connection from JNDI dataSource

3. typeAliases tag
4. mappers tag
	* resource:classpath of the XML file
	* url:the fully qualified path of the xml file
	* class: the class-path of the mapper interface
	* name:the package name of the mapper interface
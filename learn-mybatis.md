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

## Dynamic SQL
### if
```
<select id = "getRecByName" parameterType = "Student" resultType = "Student">

   SELECT * FROM STUDENT
   <if test = "name != null">
      WHERE name LIKE #{name}
   </if>
    <if test = "id != null">
      AND id LIKE #{id}
   </if>
</select>
```

###The choose(java:switch), when, and otherwise Statements

```
<select id = "getRecByName_Id_phone" parameterType = "Student" resultType = "Student">
   SELECT * FROM Student WHERE id != 0

   <choose>
      <when test = "name != null">
         AND name LIKE #{name}
      </when>

      <when test = "phone != null">
         AND phone LIKE #{phone}
      </when>
   </choose>

</select>
```

###The where Statement(better)

```
<select id = "getName_Id_phone" parameterType = "Student" resultType = "Student">
   SELECT * FROM STUDENT

   <where>
      <if test = "id != null">
         id = #{id}
      </if>

      <if test = "name != null">
         AND name LIKE #{name}
      </if>
   </where>

</select>
```

The where element inserts a WHERE only when the containing tags return any content. Furthermore, if that content begins with AND or OR, it knows to strip it off.
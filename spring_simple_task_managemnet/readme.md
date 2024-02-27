# Simple task management Backend

## Development server
First of you need to provide a database configuration in application.properties file as follows:

> Database Configuration for PostgreSQL
- spring.datasource.url=
- spring.datasource.username=
- spring.datasource.password=

For email sending you also set the email credential(SSL) in application.properties file:
This email credential send a mail if due date with in 2 days.
> Email configuration
- spring.mail.host=smtp.gmail.com
- spring.mail.port=465
- spring.mail.username=abc@gmail.com
- spring.mail.password=aaaaaa
- #spring.mail.properties.mail.smtp.auth=true
- #spring.mail.properties.mail.smtp.starttls.enable=true
- spring.mail.properties.mail.smtp.ssl.enable=true


    If you have ttl credentials then comment " spring.mail.properties.mail.smtp.ssl.enable" and uncomment the following two:
- spring.mail.properties.mail.smtp.auth=true
- spring.mail.properties.mail.smtp.starttls.enable=true


When we configure the database and run the application at that time automatically one user created.
- Username : admin
- Password : admin

I also attached the postman collection, you can directly import that into the postman.
==>pesto.postman_collection.json
  

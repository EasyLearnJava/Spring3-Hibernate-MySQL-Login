# Spring3-Hibernate-MySQL-Login
Spring 3 and Hibernate with Annotations

* This project as features how to display custom messages to the user 

```
Declaring the messages in the model along with attributes
Ex:
@NotEmpty
@Size(min = 6, max = 15, message = "User custom message says, min size is 6 and max is 15 characters")
private String password;
```

```
Declaring the messages in the properties file in a specific format
* ConstraintName.CommandName.propertyName=validation error message
Ex:
Size.myLoginForm.userName = Message from properties file. min Size is 6 and max 20 characters
```


**Backend For Expense Reimbursement System**

**Project Description**

The Expense Reimbursement System (ERS) will manage the process of reimbursing employees for expenses incurred while on company time. All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. Finance managers can log in and view all reimbursement requests and past history for all employees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement.

**Technologies Used**

Java 15
PostgreSQL
Hibernate
Javalin
JUnit
Angular

**Features**

Create requests
As a managaer they can approve/deny requests


**Getting Started**

git clone https://github.com/StotTot/DeBride_P1_Back.git

Be sure to include BOTH Windows and Unix command
Be sure to mention if the commands only work on a specific platform (eg. AWS, GCP)

The only file that you will have to provide yourself is a hibernate.cfg.xml file.

Fill in the blanks with your own information.


```
<?xml version='1.0' encoding='utf-8'?>
<!DOCTYPE hibernate-configuration PUBLIC
    "-//Hibernate/Hibernate Configuration DTD//EN"
    "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
    <session-factory>
            <property name="hibernate.connection.driver_class">org.postgresql.Driver</property>
            <property name="hibernate.connection.url">jdbc:postgresql://[your ip with port here]/[name of your database]</property>
            <property name="hibernate.dialect">org.hibernate.dialect.PostgreSQLDialect</property>
        
            <property name="hibernate.connection.username">[your username for the database]</property>
            <property name="hibernate.connection.password">[your password for the dataabase]</property>
            <property name="hibernate.show_sql">true</property>

            <mapping class="dev.debride.entities.Employee"></mapping>
            <mapping class="dev.debride.entities.Expense"></mapping>


        </session-factory>
</hibernate-configuration>
```


**License**
This project uses the following license: Apache-2.0 License.

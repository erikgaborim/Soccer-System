# School-System
Java Project developed to simulate a school system.
    
## How to use

Dependencies: you need JDBC, PgAdmin and JDK installed to run it.

1. Clone this repository:

    ```console
    git clone https://github.com/erikgaborim/School-System.git
    ```
2. Import it on your IDE;
3. Create a database on your PgAdmin, paste there the script "scriptSQL.txt", that's inside the folder "ScriptSQL", and run it there;
4. Change file "ConnectionFactory.java" inside the folder "jdbc". Where is write:
    ```console
    return DriverManager.getConnection("jdbc:postgresql://localhost/P2LP", "postgres", "password");"
    ```
    change "P2LP" to your database name and "password" to your password;
6. Run it on Eclipse.

<h4 align="right">
    Your system will now be able to save data in your database!
</h4>

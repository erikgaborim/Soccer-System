# Soccer-System
Java Project developed to simulate a soccer system to save information about teams and players in a database.
    
## How to use

Dependencies: you need JDBC, PgAdmin and JDK installed to run it.

1. Clone this repository:

    ```console
    git clone https://github.com/erikgaborim/Soccer-System.git
    ```
2. Import it on your IDE;
3. Create a database on your PgAdmin, paste there the script "scriptSQL.txt", that's inside the folder "ScriptSQL", and run it there;
4. Change file "ConnectionFactory.java" inside the folder "jdbc". Where is write:
    ```console
    return DriverManager.getConnection("jdbc:postgresql://localhost/P2LP", "postgres", "password");"
    ```
    change "P2LP" for your database name and "password" for your password;
6. Run it on Eclipse.

<h4 align="right">
    Your system will now be able to save data in your database!
</h4>

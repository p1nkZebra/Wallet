package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateDataBase {
    public static void main(String[] args) {
        Connection c = null;
        Statement stmt = null;
        String sql = "";
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "postgres", "12gjldbujd");

            stmt = c.createStatement();

            sql = "CREATE SCHEMA IF NOT EXISTS JAVA_TASK ";
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE IF NOT EXISTS JAVA_TASK.USER "
                    + " ( "
                    + " ID                      SERIAL PRIMARY KEY     NOT NULL, "
                    + " USER_NAME              VARCHAR(32)            NOT NULL "
                    + " ) ";
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE IF NOT EXISTS JAVA_TASK.TRANSACTION "
                    + " ( "
                    + " ID                      SERIAL PRIMARY KEY     NOT NULL, "
                    + " DATE_TIME               TIMESTAMP              NOT NULL, "
                    + " USER_ID                 INT                    NOT NULL, "
                    + " AMMOUNT                  INT                    NOT NULL,"
                    + " COMMENT                 VARCHAR(500),            "
                    + " TYPE_ID                 INT                    NOT NULL  "
                    + " ) ";
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE  IF NOT EXISTS JAVA_TASK.TYPE"
                    +" ( "
                    + " ID                      SERIAL PRIMARY KEY     NOT NULL,"
                    + " TYPE_NAME              VARCHAR(32)            NOT NULL,"
                    + " TRANSACTION_ID                 INT                    NOT NULL "
                    + " )";
            stmt.executeUpdate(sql);

            sql = "ALTER TABLE JAVA_TASK.TRANSACTION "
                    + " ADD CONSTRAINT FK_USER "
                    + " FOREIGN KEY (USER_ID) REFERENCES JAVA_TASK.USER (ID) MATCH FULL "
                    + " ";
            stmt.executeUpdate(sql);

            sql = "ALTER TABLE JAVA_TASK.TRANSACTION "
                    + " ADD CONSTRAINT FK_TYPE "
                    + " FOREIGN KEY (TYPE_ID) REFERENCES JAVA_TASK.TYPE(ID) MATCH FULL "
                    + " ";
            stmt.executeUpdate(sql);

//            sql = "ALTER TABLE JAVA_TASK.TYPE "
//                    + " DROP COLUMN TRANSACTION_ID"
//                    + " ";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
            System.exit(0);
        }
        System.out.println("Tables are created successfully");
    }
}

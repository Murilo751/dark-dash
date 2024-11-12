package com.example.dark_dash;

public class DDL_db {
    public static String getCreateTableTaskList(){
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE TaskList (");
        sql.append(" id INTEGER PRIMARY KEY");
        sql.append(" NOT NULL,");
        sql.append("title TEXT (100), ");
        sql.append(" description TEXT (200) DEFAULT (''),");
        sql.append(" status BOOLEAN DEFAULT True");
        sql.append(");");
        return sql.toString();
    }

    public static String getAllTasks(){
        StringBuilder sql = new StringBuilder();
        sql.append("Select id, title, description, status");
        sql.append(" from TaskList");
        return sql.toString();
    }
}

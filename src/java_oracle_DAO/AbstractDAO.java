package java_oracle_DAO;

import java_oracle_DTO.ColorDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;

public abstract class AbstractDAO {
    String dbURL = "jdbc:oracle:thin:@localhost:1521:orcl";
    String username = "c##1module";
    String password = "admin";

    abstract void addRow(ColorDTO dto);
    abstract void updateRow (ColorDTO dto, int id);
    abstract void deleteRow (int id);
}

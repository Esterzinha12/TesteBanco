package PrepareStatement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteInsert {
    public static void main(String[] args) throws SQLException {
        Contato contato = new Contato("Leo Rafaelli", "cabelinho123@netuno.com.br", "00000-0000", 18);
        String sql = "insert into contatos(nome, email, telefone, idade)" +
                "values ('" + contato.getNome() + "', '" + contato.getEmail() + "', '" + contato.getTelefone() + "', " + contato.getIdade() + ")";
        Conexao conexao = new Conexao();
        Connection connection = conexao.conectaBD();
        Statement statement = connection.createStatement();
        statement.execute(sql);
        connection.close();
    }
}

package PrepareStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteInsert {
    public static void main(String[] args) throws SQLException {
        Contato contato = new Contato("Leo Rafaelli", "cabelinho123@netuno.com.br", "00000-0000", 18);
        String sql = "insert into contatos(nome, email, telefone, idade)" +
                "values (?,?,?,?)";
        Conexao conexao = new Conexao();
        Connection connection = conexao.conectaBD();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, contato.getNome());
        statement.setString(2, contato.getEmail());
        statement.setString(3, contato.getTelefone());
        statement.setInt(4, contato.getIdade());
        statement.execute();
        connection.close();
    }
}

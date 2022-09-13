package Statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class TesteSelectAll {

    public static void main(String[] args) throws SQLException {
        Collection<Contato> contatoCollection = new ArrayList<>();

        String sql = "select * from contato";

        Conexao conexao = new Conexao();

        Connection connection = conexao.conectaBD();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet != null && resultSet.next()) {
            Contato contato = new Contato(
                    resultSet.getInt("id"),
                    resultSet.getString("nome"),
                    resultSet.getString("email"),
                    resultSet.getString("telefone"),
                    resultSet.getInt("idade"));

            contatoCollection.add(contato);
        }
        connection.close();
        System.out.println(contatoCollection);
    }
}

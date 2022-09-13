package PrepareStatement;

import java.sql.*;


public class TesteSelect {
    public static void main(String[] args) throws SQLException{
        select("2");
    }
    public static Contato select(Object id) throws SQLException {

        String sql = "select * from contato where id = ?" ;

        Conexao conexao = new Conexao();

        Connection connection = conexao.conectaBD();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, (Integer) id);
        ResultSet resultSet = statement.executeQuery(sql);

        Contato contato;
        if (resultSet != null) {
            if (resultSet.next()) {
                contato = new Contato(
                        resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("email"),
                        resultSet.getString("telefone"),
                        resultSet.getInt("idade"));

                System.out.print(contato);
                return contato;
            }
        }
        connection.close();
        throw new RuntimeException("Deu ruim");
    }
}


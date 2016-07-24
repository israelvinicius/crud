package crud;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PessoaDao extends FabricaDeConexoes {

	public void salvar(Pessoa pessoa) {

	}

	public void editar(Pessoa pessoa) {
		String sql = "update Pessoa set nome = ?,nascimento = ? where id = ?";
		try (Connection conexao = criaConexao()) {
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setLong(3, pessoa.getId());
			java.sql.Date data = new Date(pessoa.getNascimento().getTime());
			statement.setDate(2, data);
			statement.setString(1, pessoa.getNome());
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Pessoa[] listar() {
		String sql = "select * from Pessoa";

		return null;
	}

	public void deletar(Pessoa pessoa) {
		String sql = "delete from Pessoa where id=?";
		Connection conexao = criaConexao();
		try {
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setLong(1, pessoa.getId());
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conexao.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

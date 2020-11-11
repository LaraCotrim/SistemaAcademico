import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;
import daof.DaoLogin;
class TestesComJunit {

	@Test
	public void testarLogin() throws SQLException, InterruptedException {
		DaoLogin login = new DaoLogin();
		assertEquals("Teste1", true, login.validaSenha(1700, "123"));
	}
	
	@Test
	public void testarTurma() throws SQLException, InterruptedException {
		DaoLogin login = new DaoLogin();
		assertNotNull(login.dadosTurma(1000));
	}
}

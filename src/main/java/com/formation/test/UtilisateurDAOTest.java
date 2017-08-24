package com.formation.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.net.ConnectException;
import java.sql.SQLException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.formation.wiki.DAO.UtilisateurDAO;
import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;

public class UtilisateurDAOTest {

//	private UtilisateurDAO user = null;
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	public UtilisateurDAOTest() {
		// TODO Auto-generated constructor stub
	}
	
//	@BeforeClass
//	public void init() {
//		user = new UtilisateurDAO();
//	}
	
	@Test (expected = CommunicationsException.class)
	//@Test
	public void isUserExistTest() throws SQLException,ConnectException {
		assertFalse(UtilisateurDAO.isUserExist(null, null));
		assertFalse(UtilisateurDAO.isUserExist(null, "titi"));
		assertFalse(UtilisateurDAO.isUserExist("toto", null));
		assertFalse(UtilisateurDAO.isUserExist("toto", "titi"));
		assertTrue(UtilisateurDAO.isUserExist("jpa", "sp5"));
		assertFalse(UtilisateurDAO.isUserExist("**", "-"));
		exception.expect(AssertionError.class);

		
	}
	
	@Test (expected = AssertionError.class)
	public void getUserTest() {
//		assertFalse(UtilisateurDAO.getUser(0));
		
	}
}

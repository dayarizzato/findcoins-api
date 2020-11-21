package br.com.blockchain.api.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import br.com.blockchain.api.enumeration.AlgorithmEnum;
import br.com.blockchain.api.service.impl.CriptoDigesterServiceImpl;

public class CriptoDigesterServiceSHA256Test extends CriptoDigesterServiceImpl{


	
	@Test
	public void encodePasswordSucess() {
		String password = "123456789";
		String encodedPassword = encodePassword(password);
		System.out.println(encodedPassword);
		assertEquals("As senhas não são iguais: ", true, verifyPassword(encodedPassword, password));
	}
	
	@Test
	public void validateSenha() {
		String encode = "lY4UUuiLG4yoDhn5LT9g9LVHF1/Wzjl1PB9pwVpMmCYg/rEf4CIM5qpO5RYZ3Wzx";
		String senha = "123456789";
		boolean valida = verifyPassword(encode, senha);
		assertTrue(valida);
	}
	
	@Test
	public void encodePasswordError() {
		String password = "123456789";
		String encodedPassword = encodePassword(password);
		assertEquals("As senhas são iguais: ", false, verifyPassword(encodedPassword, "OutraSenha"));
	}
}

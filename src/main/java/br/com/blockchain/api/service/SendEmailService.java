package br.com.blockchain.api.service;

public interface SendEmailService {
	
	String CORPO_EMAIL = "Você solicitou recentemente uma redefinição de senha para conta da Find'Coins. \n\n"
			+ "E-mail: %s \n"
			+ "Senha: %s \n\n\n"
			+ "Caso não tenha solicitado a recuperação de senha, entre em contato com a equipe de Atendimento.";
	
	void send(final String email, final String newPassword) throws Exception;

}

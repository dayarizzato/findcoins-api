package br.com.blockchain.api.enumeration;

/**
 * Enum que representa os tipos de algoritmos disponíveis da API.
 * @author Dayana
 */
public enum AlgorithmEnum {

	SHA256("SHA-256"),
	SHA384("SHA-384"),
	SHA512("SHA-512"),
	MD3("MD3"),
	MD4("MD4"),
	MD5("MD5"); 
	
    private String algorithm;

    AlgorithmEnum(String algorithm) {
        this.algorithm = algorithm;
    }

    public String algorithm() {
        return algorithm;
    }
}

public class CPFValidator {
    
    /**
     * Método para validar um número de CPF.
     * @param cpf O número de CPF a ser validado.
     * @return true se o CPF for válido, false caso contrário.
     */
    public boolean isValid(String cpf) {
        // Remover caracteres especiais do CPF
        cpf = cpf.replaceAll("[^0-9]", "");
        
        // Verificar se o CPF possui 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }
        
        // Verificar se todos os dígitos são iguais
        if (isAllSameDigit(cpf)) {
            return false;
        }
        
        // Calcular os dígitos verificadores
        int[] digits = getDigits(cpf);
        int firstDigit = calculateFirstDigit(digits);
        int secondDigit = calculateSecondDigit(digits, firstDigit);
        
        // Comparar os dígitos verificadores calculados com os do CPF
        return (digits[9] == firstDigit && digits[10] == secondDigit);
    }
    
    /**
     * Método auxiliar para verificar se todos os dígitos do CPF são iguais.
     * @param cpf O número de CPF a ser verificado.
     * @return true se todos os dígitos forem iguais, false caso contrário.
     */
    private boolean isAllSameDigit(String cpf) {
        char firstDigit = cpf.charAt(0);
        for (int i = 1; i < cpf.length(); i++) {
            if (cpf.charAt(i) != firstDigit) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Método auxiliar para obter os dígitos do CPF.
     * @param cpf O número de CPF a ser processado.
     * @return um array de inteiros contendo os dígitos do CPF.
     */
    private int[] getDigits(String cpf) {
        int[] digits = new int[11];
        for (int i = 0; i < 11; i++) {
            digits[i] = Integer.parseInt(cpf.substring(i, i + 1));
        }
        return digits;
    }
    
    /**
     * Método auxiliar para calcular o primeiro dígito verificador do CPF.
     * @param digits Os dígitos do CPF.
     * @return o primeiro dígito verificador.
     */
    private int calculateFirstDigit(int[] digits) {
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += (10 - i) * digits[i];
        }
        int remainder = sum % 11;
        return (remainder < 2) ? 0 : 11 - remainder;
    }
    
    /**
     * Método auxiliar para calcular o segundo dígito verificador do CPF.
     * @param digits Os dígitos do CPF.
     * @param firstDigit O primeiro dígito verificador.
     * @return o segundo dígito verificador.
     */
    private int calculateSecondDigit(int[] digits, int firstDigit) {
        int sum = firstDigit * 2;
        for (int i = 0; i < 9; i++) {
            sum += (11 - i) * digits[i];
        }
        int remainder = sum % 11;
        return (remainder < 2) ? 0 : 11 - remainder;
    }
}

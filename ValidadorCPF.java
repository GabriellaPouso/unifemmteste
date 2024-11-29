public class ValidadorCPF {

    private final String cpf;

    public ValidadorCPF(String cpf) {
        this.cpf = cpf;
    }

    public boolean isValid() {
        // 1. Remover caracteres não numéricos e verificar tamanho
        String cpfNumerico = cpf.replaceAll("[^0-9]", "");
        if (cpfNumerico.length() != 11) {
            return false;
        }

        // 2. Verificar se todos os dígitos são iguais
        boolean todosIguais = true;
        for (int i = 1; i < cpfNumerico.length(); i++) {
            if (cpfNumerico.charAt(i) != cpfNumerico.charAt(0)) {
                todosIguais = false;
                break;
            }
        }
        if (todosIguais) {
            return false;
        }


        // 3. Calcular o primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Integer.parseInt(String.valueOf(cpfNumerico.charAt(i))) * (10 - i);
        }
        int resto = soma % 11;
        int digito1 = (resto < 2) ? 0 : 11 - resto;

        // 4. Calcular o segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Integer.parseInt(String.valueOf(cpfNumerico.charAt(i))) * (11 - i);
        }
        resto = soma % 11;
        int digito2 = (resto < 2) ? 0 : 11 - resto;

        // 5. Comparar os dígitos verificadores calculados com os fornecidos
        return digito1 == Integer.parseInt(String.valueOf(cpfNumerico.charAt(9))) &&
               digito2 == Integer.parseInt(String.valueOf(cpfNumerico.charAt(10)));
    }


    public static void main(String[] args) {
        ValidadorCPF validador1 = new ValidadorCPF("123.456.789-10");
        System.out.println("CPF 123.456.789-10 é válido? " + validador1.isValid()); //false

        ValidadorCPF validador2 = new ValidadorCPF("111.111.111-11");
        System.out.println("CPF 111.111.111-11 é válido? " + validador2.isValid()); //false

        ValidadorCPF validador3 = new ValidadorCPF("000.000.000-00");
        System.out.println("CPF 000.000.000-00 é válido? " + validador3.isValid()); //false

        ValidadorCPF validador4 = new ValidadorCPF("222.222.222-22");
        System.out.println("CPF 222.222.222-22 é válido? " + validador4.isValid()); //false

        ValidadorCPF validador5 = new ValidadorCPF("123.456.789-00");
        System.out.println("CPF 123.456.789-00 é válido? " + validador5.isValid()); //false


        ValidadorCPF validador6 = new ValidadorCPF("111.222.333-44");
        System.out.println("CPF 111.222.333-44 é válido? " + validador6.isValid()); //false

        ValidadorCPF validador7 = new ValidadorCPF("999.999.999-99");
        System.out.println("CPF 999.999.999-99 é válido? " + validador7.isValid()); //false

        ValidadorCPF validador8 = new ValidadorCPF("123.456.789-10");
        System.out.println("CPF 123.456.789-10 é válido? " + validador8.isValid()); //false

        ValidadorCPF validador9 = new ValidadorCPF("12345678900");
        System.out.println("CPF 12345678900 é válido? " + validador9.isValid()); //false

        ValidadorCPF validador10 = new ValidadorCPF("041.210.707-08");
        System.out.println("CPF 041.210.707-08 é válido? " + validador10.isValid()); //false

        ValidadorCPF validador11 = new ValidadorCPF("018.066.731-93");
        System.out.println("CPF 018.066.731-93 é válido? " + validador11.isValid()); //true
    }
}

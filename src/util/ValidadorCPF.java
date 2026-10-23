package util;

public class ValidadorCPF {
    public static String limparCPF(String cpf){
        return cpf.replace(".", "").replace("-","");
    }

    public static boolean validarTamanho(String cpf){
        String cpfLimpo = limparCPF(cpf);
        return cpfLimpo.length() == 11;
    }

    public static boolean validarNumeros(String cpf){
        String cpfLimpo = limparCPF(cpf);
        for (int i = 0; i < cpfLimpo.length(); i++){
            char character = cpfLimpo.charAt(i);
            if (!Character.isDigit(character)){
                return false;
            }
        }
        return true;
    }

    public static boolean validarFormato(String cpf) {
        return validarTamanho(cpf) && validarNumeros(cpf);
    }

    public static int calcularPrimeiroDigito(String cpf){
        String cpfLimpo = limparCPF(cpf);
        int soma = 0;
        int j = 0;
        for (int i = 10; i > 1; i--){
            int numero = Character.getNumericValue(cpfLimpo.charAt(j));
            soma += numero * i;
            j++;
        }
        soma = soma % 11;
        if (soma < 2){
            soma = 0;
        } else {
            soma = 11 - soma;
        }
        return soma;
    }

    public static int calcularSegundoDigito(String cpf) {
        String cpfLimpo = limparCPF(cpf);
        int soma = 0;
        int j = 0;
        for (int i = 11; i > 1; i--){
            int numero = Character.getNumericValue(cpfLimpo.charAt(j));
            soma += numero * i;
            j++;
        }
        soma = soma % 11;
        if (soma < 2){
            soma = 0;
        } else {
            soma = 11 - soma;
        }
        return soma;
    }

    public static boolean todosDigitosIguais(String cpf) {
        char primeiroDigito = cpf.charAt(0);

        for (int i = 1; i < cpf.length(); i++) {
            if (cpf.charAt(i) != primeiroDigito) {
                return false;
            }
        }

        return true;
    }


    public static boolean validarCPF(String cpf) {

        if (cpf == null) {
            return false;
        }

        if (!validarFormato(cpf)) {
            return false;
        }

        String cpfLimpo = limparCPF(cpf);

        if (todosDigitosIguais(cpfLimpo)) {
            return false;
        }

        if (calcularPrimeiroDigito(cpfLimpo) ==
                Character.getNumericValue(cpfLimpo.charAt(9))
                &&
                calcularSegundoDigito(cpfLimpo) ==
                        Character.getNumericValue(cpfLimpo.charAt(10))) {

            return true;
        }

        return false;
    }

}

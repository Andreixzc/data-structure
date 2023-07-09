package isJavaIterativo;
public class isiterativo {

    public static void main(String args[]) {
        String str = "";

        while (true) {

            if (str.equals("FIM")) {//Condição de parada.
                break;

            } else {
                str = MyIO.readLine();
                if (vogal(str)) {
                    MyIO.print("SIM ");
                } else {
                    MyIO.print("NAO ");
                }
                if (consoante(str)) {
                    MyIO.print("SIM ");                      
                } else {
                    MyIO.print("NAO ");
                }
                if (inteiro(str)) {
                    MyIO.print("SIM ");

                } else {
                    MyIO.print("NAO ");
                }
                if (real(str)) {
                    MyIO.println("SIM ");

                } else {
                    MyIO.println("NAO ");
                }

            }

        }

    }

    public static boolean vogal(String str) {
        int n = str.length();
        int cont = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i'
                    || str.charAt(i) == 'o' || str.charAt(i) == 'u' || str.charAt(i) == 'A'
                    || str.charAt(i) == 'E' || str.charAt(i) == 'I' || str.charAt(i) == 'O'
                    || str.charAt(i) == 'U') {
                cont++;//incrementa o contador se tiver alguma vogal na string.
            }
        }
        if (cont == n)// se o contador se igualar com o comprimento da string, conclui-se que ela é
                      // composta apenas por vogais.
        {
            return true; // Composta só de vogais
        } else {
            return false; // Não composta somente por vogais
        }

    }

    public static boolean consoante(String str) {
        int n = str.length();
        int cont = 0;
        for (int i = 0; i < n; i++)// Compara se a string contem vogal ou número.
        {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i'
                    || str.charAt(i) == 'o' || str.charAt(i) == 'u' || str.charAt(i) == 'A'
                    || str.charAt(i) == 'E' || str.charAt(i) == 'I' || str.charAt(i) == 'O'
                    || str.charAt(i) == 'U' || str.charAt(i) > '0' && str.charAt(i) < '9') {
                cont++;// Se sim, contador aumenta em 1;
            }
        }
        if (cont > 0) {
            return false;// Se o contador é maior que zero, conclui-se que a string possui vogal ou
                         // número.
        } else {
            return true;
        }

    }

    public static boolean inteiro(String str) {

        try {
            int num = Integer.parseInt(str);
            return true;//Tenta converter a string em um número inteiro, se conseguir retorna true.
        } catch (NumberFormatException e) 
        {
            return false;
        }


    }

    public static boolean real(String str) {
        try {
            Double.parseDouble(str);//Tenta converter a string em um número de tipo double, se conseguir retorna true.
            return true;
        } catch (NumberFormatException e) {
            return false;
        }


    }
}

public class isrecursivo {
    public static void main(String args[]) {

        String str = "";
        int cont = 0;
        int contfloat = 0;
        int i = 0;
        while (true) 
        {
            str = MyIO.readLine();
            int n = str.length() - 1;
            if (str.equals("FIM")) 
            {
                break;   
            }
            if (vogal(str, cont, i)) 
        {
            System.out.print("SIM ");
        } else 
        {
            System.out.print("NAO ");
        }
        if (consoante(str, cont, i)) 
        {
            System.out.print("SIM ");
        } else 
        {
            System.out.print("NAO ");
        }
        if (inteiro(str, n)) {
            System.out.print("SIM ");

        } else 
        {
            System.out.print("NAO ");
        }
        if (real(str, i, contfloat)) {

            System.out.println("SIM ");
        } else 
        {
            System.out.println("NAO ");
        }
      
        }
    
    }

    public static boolean vogal(String str, int cont, int i) {
        int n = str.length();
        if (cont == n) {
            return true;
        } else {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i'
                    || str.charAt(i) == 'o' || str.charAt(i) == 'u' || str.charAt(i) == 'A'
                    || str.charAt(i) == 'E' || str.charAt(i) == 'I' || str.charAt(i) == 'O'
                    || str.charAt(i) == 'U') {
                cont++;
                return vogal(str, cont, ++i);
            }
        }
        return false;
    }

    public static boolean consoante(String str, int cont, int i) {
        // int n = str.length();
        if (cont == str.length()) {
            return true;

        }
        if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            return false;

        } else if (str.charAt(i) != 'a' && str.charAt(i) != 'e' && str.charAt(i) != 'i'
                && str.charAt(i) != 'o' && str.charAt(i) != 'u' && str.charAt(i) != 'A'
                && str.charAt(i) != 'E' && str.charAt(i) != 'I' && str.charAt(i) != 'O'
                && str.charAt(i) != 'U') 
        {
            cont++;
            return consoante(str, cont, i+=1);
        }

        return false;

    }

    public static boolean inteiro(String str, int n) {
        if (str.charAt(n) < 47 || str.charAt(n) > 57) {
            return false;
        }
        if (n == 0) {
            return true;
        } else
            return inteiro(str, --n);

    }

    public static boolean real(String str, int i, int contfloat) {
        int n = str.length() - 1;
        if ((str.charAt(i) < 47 && str.charAt(i) != ',' && str.charAt(i) != '.')
                || str.charAt(i) > 57) {
            return false;
        } else if (str.charAt(i) == ',' || str.charAt(i) == '.') {
            contfloat++;
        }
        if (contfloat > 1) {
            return false;
        }
        if (i == n) {
            return true;

        } else
            return real(str, i += 1, contfloat);
    }
}


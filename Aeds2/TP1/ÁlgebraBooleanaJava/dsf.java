public class dsf {

    public static void main(String[] args) {
        int qntOp = MyIO.readInt();
        while (qntOp != 0) {
            char termos[] = retornaOp(qntOp);
            String str = MyIO.readLine();
            char[] str2 = transform(str, termos);
            char retorno = verificaEretorna(str2);
            MyIO.println(retorno);
            qntOp = MyIO.readInt();
        }

    }

    public static char verificaEretorna(char[] palavra) {
        int aux;

        for (int i = (palavra.length - 1); i >= 0; i--) {
            if (palavra[i] == '(') {
                switch (palavra[i - 1]) {
                    case 'r':
                        aux = i;

                        while (palavra[aux] != ')' && palavra[aux] != '1') {
                            aux++;
                        }

                        if (palavra[aux] == '1') {
                            palavra[i - 2] = '1';
                        } else {
                            palavra[i - 2] = '0';
                        }

                        aux = i - 1;

                        while (palavra[aux] != ')') {
                            palavra[aux] = '.';
                            aux++;
                        }

                        palavra[aux] = '.';

                        break;
                    case 't': // not
                        aux = i;

                        while (palavra[aux] != ')' && palavra[aux] != '0' && palavra[aux] != '1') {
                            aux++;
                        }

                        if (palavra[aux] == '1') {
                            palavra[i - 3] = '0';
                        } else {
                            palavra[i - 3] = '1';
                        }

                        aux = i - 2;

                        while (palavra[aux] != ')') {
                            palavra[aux] = '.';
                            aux++;
                        }

                        palavra[aux] = '.';

                        break;
                    case 'd':
                        aux = i;

                        while (palavra[aux] != ')' && palavra[aux] != '0') {
                            aux++;
                        }

                        if (palavra[aux] == '0') {
                            palavra[i - 3] = '0';
                        } else {
                            palavra[i - 3] = '1';
                        }

                        aux = i - 2;

                        while (palavra[aux] != ')') {
                            palavra[aux] = '.';
                            aux++;
                        }

                        palavra[aux] = '.';

                        break;
                }
            }
        }

        return palavra[0];
    }

    static char[] tiraSpace(String str) {
        char[] str2 = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                str2[i] = str.charAt(i);
                str2[i + 1] = '\0';
            }
        }
        return str2;
    }

    public static char[] transform(String str, char[] terms) {
        char str2[] = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case 'A':
                    str2[i] = terms[0];
                    break;
                case 'B':
                    str2[i] = terms[1];
                    break;
                case 'C':
                    str2[i] = terms[2];
                    break;
                default:
                    str2[i] = str.charAt(i);
                    break;
            }
        }

        return str2;
    }

    public static char[] retornaOp(int qnt) 
    {
        char termo[] = new char[qnt];
        for (int i = 0; i < qnt; i++) {
            termo[i] = MyIO.readChar();
            MyIO.readChar();
        }
        return termo;
    }

    static boolean isFim(String str) {
        boolean resp = false;

        if (str.charAt(0) == '0')
            resp = true;

        return resp;
    }
}
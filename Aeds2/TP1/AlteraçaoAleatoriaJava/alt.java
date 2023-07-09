import java.util.Random;

public class alt {
    public static void main(String args[]) 
    {
        String str;
        char primeiraLetra;
        char segundaLetra;
        Random gerador = new Random();
        gerador.setSeed(4);
        while (true) 
        {
            str = MyIO.readLine();
            if (str.equals("FIM")) //Condição de parada, caso digitar FIM.
            {
                break;
            }
            primeiraLetra = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));//Sorteia a primeira letra.
            segundaLetra = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));//Sorteia a segunda letra
            altera(str, primeiraLetra, segundaLetra);



        }

    }

    public static String altera(String str, char primeiraLetra, char segundaLetra) {
        String straux = "";//String auxiliar

        for (int i = 0; i < str.length(); i++) 
        {
            if (str.charAt(i) == primeiraLetra) //Se alguma letra da string recebida pelo input for igual a primeira letra sorteada;
            {
                straux += segundaLetra;//String auxiliar recebe a segunda letra

            } else 
            {
                straux += str.charAt(i);//Se não for igual, ela recebe o caracter contido na string dada pelo input
            }
        }

        MyIO.println(straux);//printa a string auxiliar altearada
        return straux;
    }
}

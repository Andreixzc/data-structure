
public class cifra3
{
    public static void main(String args[]) 
    {   String res = ""; 
        String str = ""; 
        while (true) 
        {   str = MyIO.readLine();
            res = ciframento(str);
            if (str.equals("FIM"))//checa se a entrada é fim
            {
                break;
            }
            MyIO.println(res);
        }
    }
    public static String ciframento(String str) 
    {
        int aux = 0;
        String aux2 = "";
        for (int i = 0; i < str.length(); i++) 
        {
            aux = (int)str.charAt(i);//converte cada char da string em int
            aux += 3; //Aumenta 3 do char convertido em inteiro
            char b = (char) aux;//converte o int incrementado em char.
            aux2 += String.valueOf(b);//armazena o resultado na variavel aux2
        }
        return aux2;
        
        
        
    }
}
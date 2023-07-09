public class ex4
{
    public static void main(String args[]) 
    {
        String str = "";
        while (true) 
        {
            str = MyIO.readLine();
            if (str.equals("FIM")) //condição de parada.
            {
                break;
                
            }
            else
            {
                tochararr(str);//chamada da funcao de converter string em char[]
            }
        }

    }
    public static void tochararr(String str) //Converte a string em um array de char
    {
        char[] c = new char[str.length()];
        for (int i = 0; i < str.length(); i++)
            c[i] = str.charAt(i);
        int n = c.length-1;
        cifra(c, n);//chama a funcao recursiva
    }
    public static void cifra(char[] c, int n) 
    {
        int key = 3;
        c[n] += key;//A cada execução soma-se 3 do caracter na posição n(strlenght) do array.
        if (n == 0 ) //quando n for 0, significa que todo o array foi percorrido.
        {
            String res = String.copyValueOf(c);
            MyIO.println(res);
            
        }
        else
        {
            cifra(c, --n);//Aplica-se a recursivdade diminuindo 1 do n pra percorrer todo o array.
        }
        
    }
    
}

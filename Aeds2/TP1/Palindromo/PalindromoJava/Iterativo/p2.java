public class p2 
{
    public static void main(String args[]) 
    {
        String[] entrada = new String [1000];
        
        for (int i = 0; i < entrada.length; i++) 
        {
            entrada[i] = MyIO.readLine();

            if (entrada[i].equals("FIM"))//verifica se a entrada é igual a FIM
                {   i = entrada.length;
                    i--;
                }
        else
        {

           if (isPal(entrada[i])) 
           {
               MyIO.println("SIM");
           }
           else
           {
               MyIO.println("NAO");
           }
        }
    } 
    }
    public static boolean isPal(String entrada)
    {
        int aux1 = 0;
        int aux2 = entrada.length()-1;
        while (aux1<aux2) 
        {
            if (entrada.charAt(aux1)!=entrada.charAt(aux2)) //Se primeiro ou ultimo caractere forem diferentes retornam false
            {
                return false;
            }
            aux1++;  //incremento dos ponteiros que apontam para a posição inicial e final da string
            aux2--;
        }
        return true;

        
    }   
}

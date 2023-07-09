public class bi
{
    public static void main(String args[]) 
    {
        String str = "radar";
        String aux = "";
        for (int i = str.length()-1; i >= 0; i--) 
        {
            aux += str.charAt(i);
            
        }
        System.out.println(confere(aux,str));
    }
    public static boolean confere(String aux, String str) 
    {
        for (int i = 0; i < str.length()-1; i++) 
        {
            if (aux.charAt(i)==str.charAt(i)) 
            {
                continue;
                
            }
            else
            return false;
            
        }
        return true;
        
    }
}

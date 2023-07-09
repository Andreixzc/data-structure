public class recursivopalindrom {
    public static void main(String args[]) 
    {
        String str = "";
        
        for (int i = 0; i < 1000; i++) 
        {
            str = MyIO.readLine();
            if (str.equals("FIM")) 
            {
                i = 1000;
                i--;
            }
            else{
            if (isPal(str)) 
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

    public static boolean isPal(String str)
    {
        if (str == null) 
        {
            return false;
            
        }
        if (str.length()<=1) 
        {
            return true;
            
        }
        String first = str.substring(0, 1);
        String last = str.substring(str.length()-1, str.length());
        if (!first.equals(last)) 
        {
            return false;
            
        }
        else
        {
            return isPal(str.substring(1, str.length()-1));
        }
    }

}

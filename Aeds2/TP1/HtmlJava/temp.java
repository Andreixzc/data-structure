import java.io.*;
import java.net.*;
// import javax.lang.model.util.ElementScanner14;
// import javax.swing.text.html.HTML;

class temp {
    public static String getHtml(String endereco) 
    {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String resp = "", line;

        try {
            url = new URL(endereco);
            is = url.openStream(); // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                resp += line + "\n";
            }
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try {
            is.close();
        } catch (IOException ioe) {
            // nothing to see here

        }

        return resp;
    }
    public static void main(String[] args) 
    {
        String aux = "áéíóúàèìòùãõâêîôû";//String que armazena os caracteres com acéntuo.
        String endereco, res; //endereço do site e resposta da funcao
        String nomeSite;
        while (true) 
        {
            nomeSite = MyIO.readLine();
            if (nomeSite.equals("FIM"))
            {
                break;
            }
            else
            endereco = MyIO.readLine();
            res = getHtml(endereco);
            vogal(res);
            vogagudo(res,aux);
            vogacento(res,aux);
            consoante(res);
            brtable(res);
            MyIO.println( nomeSite);    
        }
        

    }
    public static void vogal(String res) {
        int conta = 0;
        int conte = 0;
        int conti = 0;
        int conto = 0;
        int contu = 0;
        for (int i = 0; i < res.length() - 1; i++) 
        {
            switch (res.charAt(i)) //Compara as palavras, caso for vogal incrementa em sua respectiva variavel.
            {
                case 'a':
                    conta++;
                    break;
                case 'e':;
                    conte++;
                    break;
                case 'i':;
                    conti++;
                    break;
                case 'o':;
                    conto++;
                    break;
                case 'u':;
                    contu++;
                    break;
            }
            
        }
    //Printa as vogais.
      System.out.print("a(" + conta +") ");
      System.out.print("e(" + conte +") ");
      System.out.print("i(" + conti +") ");
      System.out.print("o(" + conto +") ");
      System.out.print("u(" + contu +") ");
    }
    public static void vogagudo(String res, String aux) 
    {
        //Variaveis que armazenam os caracteres com aéntuo (índice abaixo)
        int conta = 0;//á
        int conte = 0;//é
        int conti = 0;//í
        int conto = 0;//ó
        int contu = 0;//ú
        int conta2 = 0;//à
        int conte2 = 0;//è
        int conti2 = 0;//ì
        int conto2 = 0;//ò
        int contu2 = 0;//ù
        //á  é  í  ó  ú  à  é  ì  ò  ù  ã   õ   â   ê   î   ô  û
        //0  1  2  3  4  5  6  7  8  9  10  11  12  13  14  15  16 (índice das letras)

        for (int i = 0; i < res.length(); i++) 
        {
            if (res.charAt(i)==aux.charAt(0)) 
            {
                conta++;
            }
            else if (res.charAt(i)==aux.charAt(1)) 
            {
                conte++;
            }
            else if (res.charAt(i)==aux.charAt(2)) 
            {
                conti++;
            }
            else if (res.charAt(i)==aux.charAt(3)) 
            {
                conto++;
                
            }
            else if (res.charAt(i)==aux.charAt(4)) 
            {
                contu++;
            }
            if (res.charAt(i)==aux.charAt(5)) 
            {
                conta2++;
            }
            else if (res.charAt(i)==aux.charAt(6)) 
            {
                conte2++;
            }
            else if (res.charAt(i)==aux.charAt(7)) 
            {
                conti2++;
            }
            else if (res.charAt(i)==aux.charAt(8)) 
            {
                conto2++;
                
            }
            else if (res.charAt(i)==aux.charAt(9)) 
            {
                contu2++;
            }
        }
        //Printa as letras com acéntuo
        System.out.print("á(" + conta +") ");
        System.out.print("é(" + conte +") ");
        System.out.print("í(" + conti +") ");
        System.out.print("ó("+ conto +") ");
        System.out.print("ú(" + contu +") ");
        System.out.print("à(" + conta2 +") ");
        System.out.print("è(" + conte2 +") ");
        System.out.print("ì(" + conti2 +") ");
        System.out.print("ò(" + conto2 +") ");
        System.out.print("ù(" + contu2 +") ");
    }
    public static void vogacento(String res,String aux) {
        int contatiu = 0;//ã
        int contotiu = 0;//õ
        int contahat = 0;//â
        int contehat = 0;//ê
        int contihat = 0;//î
        int contohat = 0;//ô
        int contuhat = 0;//û
        //á  é  í  ó  ú  à  é  ì  ò  ù  ã   õ   â   ê   î   ô  û
        //0  1  2  3  4  5  6  7  8  9  10  11  12  13  14  15  16 (índice das letras)
        for (int i = 0; i < res.length(); i++) 
        {
            if (res.charAt(i)==aux.charAt(10)) 
            {
                contatiu++;
            }
            else if (res.charAt(i)==aux.charAt(11)) 
            {
                contotiu++;
            }
            else if (res.charAt(i)==aux.charAt(12)) 
            {
                contahat++;
            }
            else if (res.charAt(i)==aux.charAt(13)) 
            {
                contehat++;
                
            }
            else if (res.charAt(i)==aux.charAt(14)) 
            {
                contihat++;
            }
            else if (res.charAt(i)==aux.charAt(15)) 
            {
                contohat++;
            }
            else if (res.charAt(i)==aux.charAt(16)) 
            {
                contuhat++;
            }
        }
        System.out.print("ã(" + contatiu +") ");
        System.out.print("õ(" + contotiu +") ");
        System.out.print("â(" + contahat +") ");
        System.out.print("ê(" + contehat +") ");
        System.out.print("î(" + contihat +") ");
        System.out.print("ô(" + contohat +") ");
        System.out.print("û(" + contuhat +")");       
    }
    public static void consoante(String res) 
    {
        int cons = 0;
        for (int i = 0; i < res.length(); i++)//Verifica as consoantes
        {
            if (res.charAt(i) >= 'a' && res.charAt(i) <= 'z')
            {
                if (!(res.charAt(i)=='a'|| res.charAt(i)=='e'|| res.charAt(i)=='i'|| res.charAt(i)=='o'|| res.charAt(i)=='u')) 
                 {
                    cons++;
                 }
          
            }
        }
        
        System.out.print(" consoante(" + cons +")");
    }
    public static void brtable(String res) 
   {
      int br = 0;
      int table = 0;
        for (int i = 0; i < res.length(); i++) 
        {
            if (res.charAt(i)== '<' && res.charAt(i+1)=='b'
            && res.charAt(i+2)=='r'&& res.charAt(i+3)=='>') //Verifica se a palavra comparada é igual á '<br>'
            {
                br++;
                
            }
            else if (res.charAt(i)== '<' && res.charAt(i+1)=='t'
            && res.charAt(i+2)=='a'&& res.charAt(i+3)=='b'
            && res.charAt(i+4)=='l'&& res.charAt(i+5)=='e'//Verifica se a palavra comparada é igual á '<table>'
            && res.charAt(i+6)=='>')
            {
                table++;
                
            }
            
        }
        //printa o total de incidencia das tags br e table.
        System.out.print(" <br>(" + br +") ");
        System.out.print("<table>(" + table +") ");
   }
}


    



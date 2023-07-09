import java.io.*;
import java.net.*;
import javax.swing.text.html.HTML;

class ExemploURL {
   public static String getHtml(String endereco){
      URL url;
      InputStream is = null;
      BufferedReader br;
      String resp = "", line;

      try {
         url = new URL(endereco);
         is = url.openStream();  // throws an IOException
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
   public static void main(String[] args) {
      String endereco, res;
      endereco = "http://maratona.crc.pucminas.br/series/Friends.html";
      res = getHtml(endereco);
      vogal(res);
      vogagudo(res);
      vogacento(res);
      consoante(res);
      brtable(res);
   }
   public static void vogal(String res) 
   {
      int conta = 0;
      int conte = 0;
      int conti = 0;
      int conto = 0;
      int contu = 0;
      for (int i = 0; i < res.length()-1; i++) 
      {
         switch (res.charAt(i)) {
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
      MyIO.print("a(" + conta +")");
      MyIO.print("e(" + conte +")");
      MyIO.print("i(" + conti +")");
      MyIO.print("o>(" + conto +")");
      MyIO.print("u(" + contu +")");
   }
   public static void vogagudo(String res) 
   {
      int conta = 0;
      int conte = 0;
      int conti = 0;
      int conto = 0;
      int contu = 0;
      for (int i = 0; i < res.length()-1; i++) 
      {
         switch (res.charAt(i)) {
            case 'à':
            conta++;
            break;
            case 'è':;
            conte++;
            break;
            case 'ì':;
            conti++;
            break;
            case 'ò':;
            conto++;
            break;
            case 'ù':;
            contu++;
            break;  
         }   
      }
      MyIO.print("á(" + conta +")");
      MyIO.print("é(" + conte +")");
      MyIO.print("i(" + conti +")");
      MyIO.print("o>(" + conto +")");
      MyIO.print("u(" + contu +")");

   }
   public static void vogacento(String res) 
   {
      int contatiu = 0;
      int contotiu = 0;
      int contahat = 0;
      int contehat = 0;
      int contihat = 0;
      int contohat = 0;
      int contuhat = 0;
      for (int i = 0; i < res.length()-1; i++) 
      {
         switch (res.charAt(i)) {
            case 'ã':
            contatiu++;
            break;
            case 'õ':;
            contotiu++;
            break;
            case 'â':;
            contahat++;
            break;
            case 'ê':;
            contehat++;
            break;
            case 'î':;
            contihat++;
            break; 
            case 'ô':;
            contohat++;
            break;
            case 'û':;
            contuhat++;
            break;
         }   
      }
      MyIO.print(contatiu);
      MyIO.print(contotiu);
      MyIO.print(contahat);
      MyIO.print(contehat);
      MyIO.print(contihat);
      MyIO.print(contohat);
      MyIO.print(contuhat);
      
   }
   public static void consoante(String res) 
   {
      int cons = 0;
      for (int i = 0; i < res.length(); i++) 
      {
         
         if (res.charAt(i)!= 'a' && res.charAt(i)!= 'e' &&res.charAt(i)!= 'i' &&res.charAt(i)!= 'o' &&res.charAt(i)!= 'u' && res.charAt(i)!= 'A' &&
         res.charAt(i)!= 'E' &&res.charAt(i)!= 'I' &&res.charAt(i)!= 'O' &&res.charAt(i)!= 'U') 
         {
            cons++;
            
         }
         
      }
      MyIO.println(cons);
      
   }
   public static void brtable(String res) 
   {
      int br = 0;
      int table = 0;
        for (int i = 0; i < res.length(); i++) 
        {
            if (res.charAt(i)== '<' && res.charAt(i+1)=='b'
            && res.charAt(i+2)=='r'&& res.charAt(i+3)=='>')
            {
                br++;
                
            }
            else if (res.charAt(i)== '<' && res.charAt(i+1)=='t'
            && res.charAt(i+2)=='a'&& res.charAt(i+3)=='b'
            && res.charAt(i+4)=='l'&& res.charAt(i+5)=='e'
            && res.charAt(i+5)=='>')
            {
                table++;
                
            }
            
        }
        MyIO.print("<br>(" + br +")");
        MyIO.print("<table>(" + table +")");
      
   }
}

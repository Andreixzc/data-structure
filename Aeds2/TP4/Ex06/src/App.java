import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Date;
class Filme 
{
    private String nome;
    private String TituloOriginal;
    // private LocalDate dataLancamento;
    private String dataLancamento;
    private int duracao;
    private String genero;
    private String IdiomaOriginal;
    private String situacao;
    private float orcamento;
    private String[] palavraPasse;

    public Filme(){
        this.duracao = -1;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTituloOriginal() {
        return TituloOriginal;
    }
    public void setTituloOriginal(String tituloOriginal) {
        TituloOriginal = tituloOriginal;
    }
    public String getDataLancamento() {
        return dataLancamento;
    }
    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
    public int getDuracao() {
        return duracao;
    }
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getIdiomaOriginal() {
        return IdiomaOriginal;
    }
    public void setIdiomaOriginal(String idiomaOriginal) {
        IdiomaOriginal = idiomaOriginal;
    }
    public String getSituacao() {
        return situacao;
    }
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    public float getOrcamento() {
        return orcamento;
    }
    public void setOrcamento(float orcamento) {
        this.orcamento = orcamento;
    }
    public String[] getPalavraPasse() {
        return palavraPasse;
    }
    public void setPalavraPasse(String[] palavraPasse) {
        this.palavraPasse = palavraPasse;
    }
    public void imprimir() 
    {
        // MyIO.println(nome+" "+TituloOriginal+" "+dataLancamento+" "+duracao+" "+genero+" "+IdiomaOriginal+" "+situacao+" "+orcamento+" "+Arrays.toString(palavraPasse));
        System.out.println((nome+" "+TituloOriginal+" "+dataLancamento+" "+duracao+" "+genero+" "+IdiomaOriginal+" "+situacao+" "+orcamento+" "+Arrays.toString(palavraPasse)));

    }
    public void ler(String nomeArquivo)
    {         
                // Filme filme = new Filme();
                Arq.openRead("/tmp/filmes/"+nomeArquivo);
                String str = Arq.readAll();
                Arq.close();
                this.setNome(getData(str, "<meta property=\"og:title\" content=\"", "\">"));
                this.setTituloOriginal(checaTitulo(getData(str, "<p class=\"wrap\"><strong>Título original</strong> ", "</p>"), nome));
                this.setDataLancamento(getData(str, "<span class=\"release\">", "</span>").trim().split(" ")[0]);
                this.setDuracao(getRuntime(getData(str, "class=\"runtime\">", "</span>").trim()));
                this.setGenero(removeTags(getData(str, "<span class=\"genres\">", "</span>")));
                this.setIdiomaOriginal(getData(str, "<p><strong><bdi>Idioma original</bdi></strong> ", "</p>"));
                this.setSituacao(getData(str, "<strong><bdi>Situação</bdi></strong> ", "</p>").trim());
                this.setOrcamento(converteOrcamento(getData(str, "<p><strong><bdi>Orçamento</bdi></strong> ", "</p>")));
                this.setPalavraPasse(pegaPalavraPasse(removeTags(getData(str, "<h4><bdi>Palavras-chave</bdi></h4>", "</ul>"))));
                
    }
    public static String getData(String str, String TituloComeco, String TituloFinal)   
    {   
        int IndiceAuxiliar = str.indexOf(TituloComeco);
        IndiceAuxiliar += TituloComeco.length();
        int IndiceFinal = str.indexOf(TituloFinal,IndiceAuxiliar);
        return str.substring(IndiceAuxiliar, IndiceFinal);
    }
    public static int getRuntime(String run) 
    {
        String[] aux;
        int horasMin;
        int horasF;
        int minutos;
        int duracaoFinal;
        if (run.contains("h")) 
        {
            aux = run.split("h");
            horasMin = Integer.parseInt(aux[0]);
            aux = aux[1].split("m");
            String teste = aux[0].trim();
            minutos = Integer.parseInt(teste);
            horasF = horasMin * 60;
            duracaoFinal = horasF + minutos;
            return duracaoFinal;
        }
        else
        aux = run.split("m");
        horasMin = Integer.parseInt(aux[0]);
        duracaoFinal = horasMin;
        return duracaoFinal;        
    }
    public static float converteOrcamento(String rawOrcamento) 
    {
        if (!rawOrcamento.equals("-")) 
        {
        String res = rawOrcamento.replace("$", "").replace(",", "");
        return Float.parseFloat(res.substring(0,res.indexOf('.')));   
        }
        return 0;
    }
    public static String removeTags(String in) 
    {
        String resp = "";
        for (int i = 0; i < in.length(); i++) {
            if (in.charAt(i)=='<') {
                i++;
                while (in.charAt(i)!='>') i++;    
            }
            else
            {
                resp+=in.charAt(i);
            }
        }
        return resp.replace("&nbsp;", "").trim(); 
        
    }
    public static String[] pegaPalavraPasse(String aux) 
    {
        String[] noone = new String[0];
        if (aux.contains("Nenhuma palavra-chave foi adicionada.")) 
        {
            return noone;
        }
        String[] auxf;
        int j = 0;
        int k = 0;
        String[] aux2 = new String[1000];
        auxf = aux.split("\n");
        for (int i = 0; i < auxf.length; i=i+2) 
        {
            aux2[j] = auxf[i].trim();
            j++;
        }
        for (int i = 0; i < aux2.length; i++) {
            if (aux2[i]!=null) 
            {
                k++;  
            }
        }
        String[] finalRetorno = new String[k];
        for (int i = 0; i < k; i++) 
        {
         finalRetorno[i] = aux2[i];   
        }
        return finalRetorno;
        
    }
    public static String checaTitulo(String titulo,String nome) 
    {
       if (titulo.length()>50) 
       {
           return nome;
       }
       else return titulo;
    }
}
class HashM{
   Filme tabela[];
   int m;
   final int NULO = -1;

   public Filme[] getTabela() {
    return tabela;
}

public HashM() {
      this(21);
   }

   public HashM(int m) {
      this.m = m;
      this.tabela = new Filme[this.m];
      for (int i = 0; i < m; i++) {
         tabela[i] = null;
      }
   }

   public int h(int elemento) {
      return elemento % m;
   }

   public int reh(int elemento) {
      return ++elemento % m;
   }

   public boolean inserir(Filme filme) {
      if (filme != null) {
        int pos = h(getAscii(filme.getTituloOriginal()));
        if (tabela[pos] == null) {
            tabela[pos] = filme;
            return true;
        } else {
            pos = reh(getAscii(filme.getTituloOriginal()));
            if (tabela[pos] == null) {
                tabela[pos] = filme;
                return true;
            }
        }

      }
      return false;
   }

//    public boolean pesquisar(String tittle) {
//       boolean resp = false;
//     //Death on the Nile
//       int pos = h(getAscii(tittle));
//       if (tabela[pos]!= null) {
//         if (tabela[pos].getTituloOriginal().equals(tittle)) {
//             System.out.println("Posicao: "+pos);
//              resp = true;
//           } else if (tabela[pos] != null) {
//              pos = reh(getAscii(tittle));
//              if (tabela[pos].getTituloOriginal().equals(tittle)) {
//                 System.out.println("Posicao: "+pos);
//                 resp = true;
//              }
//           }
//           if (resp == false) {
//             System.out.println("NAO");
//           }
//       }
      
//       return resp;
//    }

   public boolean pesquisar(String tittle){
        int pos = h(getAscii(tittle));
        if (tabela[pos] == null) {
            System.out.println("NAO");
            return false;
        }else {
            if (tabela[pos].getTituloOriginal().equals(tittle)) {
                System.out.println("Posicao: "+pos);
                return true;
            }else {
                pos = reh(getAscii(tittle));
                if (tabela[pos] == null) {
                    System.out.println("NAO");
                    return false;
                } else {
                    if (tabela[pos].getTituloOriginal().equals(tittle)) {
                        System.out.println("Posicao: "+pos);
                        return true;
                    }
                }
            }
        }
        System.out.println("NAO");
        return false;

   }
   boolean remover(int elemento) {
      boolean resp = false;
      // ...
      return resp;
   }
   public int getAscii(String str){
            int total = 0;
            for (int i = 0; i < str.length(); i++) {
                total += (int)str.charAt(i);
            }
            return total;
        }
}
public class App {
    static int comparacoes = 0;
    public static void main(String[] args) throws Exception 
    {
        HashM hashM = new HashM();
        String nomePesquisa;
        String nome = "";
        Scanner scanner = new Scanner(System.in);

         do{
            nome = scanner.nextLine();
            if(!(nome.charAt(0) == 'F' && nome.charAt(1) == 'I' && nome.charAt(2) == 'M'))
            {
                    Filme filme = new Filme();
                    filme.ler(nome);
                    hashM.inserir(filme);
                    // hashhue.inserir(filme);
            }
        }while(!(nome.charAt(0) == 'F' && nome.charAt(1) == 'I' && nome.charAt(2) == 'M')); 
        while (true) 
        {
            nomePesquisa = scanner.nextLine();
            if (nomePesquisa.equals("FIM")) 
            {
                break;
            }
            System.out.println("=> "+nomePesquisa);
            hashM.pesquisar(nomePesquisa);
            //inserirTituloOriginal
        } 
    }

    public static boolean checaNomeList(ArrayList<Filme> lista,String nome) 
    {

 
       for (int i = 0; i < lista.size(); i++) 
       {
            comparacoes++;
           if (lista.get(i).getNome().equals(nome)) 
           {
               return true;
           }
       }
        return false;
        
    }
    public static long tempoPercorrido() 
    {
        return new Date().getTime();
    }

    }


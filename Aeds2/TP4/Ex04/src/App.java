import java.util.Date;
import java.util.Arrays;
import java.util.Scanner;
class Filme  
{
    private String nome;
    private String TituloOriginal;
    private String dataLancamento;
    private int duracao;
    private String genero;
    private String IdiomaOriginal;
    private String situacao;
    private float orcamento;
    private String[] palavraPasse;
    // private Date aux;

    // SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


    // public Date getAux() {
    //     return aux;
    // }
    // public void setAux(Date aux) {
    //     this.aux = aux;
    // }
    public Filme(String nome, String tituloOriginal, String dataLancamento, int duracao,
            String genero, String idiomaOriginal, String situacao, float orcamento,
            String[] palavraPasse) {
        this.nome = nome;
        TituloOriginal = tituloOriginal;
        this.dataLancamento = dataLancamento;
        this.duracao = duracao;
        this.genero = genero;
        IdiomaOriginal = idiomaOriginal;
        this.situacao = situacao;
        this.orcamento = orcamento;
        this.palavraPasse = palavraPasse;
    }
    public Filme() {}
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
    public void ler(String nomeArquivo)throws Exception
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
                // this.setAux(sdf.parse(getDataLancamento()));       
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
        String aux2 = run.trim();
        
        
        if (aux2.length() == 2 && aux2.contains("m")) 
        {
            return Integer.parseInt(aux2.replaceAll("m", ""));//2
        }
        else if (aux2.length() == 2) 
        {
            return Integer.parseInt(aux2.replaceAll("h", ""));//2
        }
            
       
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
    @Override
    protected Object clone() throws CloneNotSupportedException 
    {
        // TODO Auto-generated method stub
        return super.clone();
    }
    // @Override
    // public int compareTo(Filme o) {
    //     return this.TituloOriginal.compareTo(o.TituloOriginal);
    // }
    @Override
    public String toString() {
        return "TituloOriginal=" + TituloOriginal;
    }
   }


  class NoAN {
    public boolean cor;
    public Filme elemento;
    public NoAN esq, dir;
  
    // public NoAN() {
    //   this(-1);
    // }
  
    public NoAN(Filme elemento) {
      this(elemento, false, null, null);
    }
  
    public NoAN(Filme elemento, boolean cor) {
      this(elemento, cor, null, null);
    }
  
    public NoAN(Filme elemento, boolean cor, NoAN esq, NoAN dir) {
      this.cor = cor;
      this.elemento = elemento;
      this.esq = esq;
      this.dir = dir;
    }
  }
class Alvinegra {
    private NoAN raiz; // Raiz da arvore.
 
    /**
     * Construtor da classe.
     */
    public Alvinegra() {
       raiz = null;
    }
 
    /**
     * Metodo publico iterativo para pesquisar elemento.
     * 
     * @param elemento Elemento que sera procurado.
     * @return <code>true</code> se o elemento existir,
     *         <code>false</code> em caso contrario.
     */
    public boolean pesquisar(String elemento) {
      System.out.print("raiz ");
       return pesquisar(elemento, raiz);
    }
 
    /**
     * Metodo privado recursivo para pesquisar elemento.
     * 
     * @param elemento Elemento que sera procurado.
     * @param i        NoAN em analise.
     * @return <code>true</code> se o elemento existir,
     *         <code>false</code> em caso contrario.
     */
    private boolean pesquisar(String elemento, NoAN i) {
      App.comparacoes++;
       boolean resp;
       if (i == null) {
          resp = false;
          
       } else if (elemento.equals(i.elemento.getTituloOriginal())) {
          resp = true;
       } else if (elemento.compareTo(i.elemento.getTituloOriginal()) < 0) {
         System.out.print("esq ");
          resp = pesquisar(elemento, i.esq);
       } else {
         System.out.print("dir ");
          resp = pesquisar(elemento, i.dir);

       }
       return resp;
    }
 
    /**
     * Metodo publico iterativo para exibir elementos.
     */
    public void caminharCentral() {
       System.out.print("[ ");
       caminharCentral(raiz);
       System.out.println("]");
    }
 
    /**
     * Metodo privado recursivo para exibir elementos.
     * 
     * @param i NoAN em analise.
     */
    private void caminharCentral(NoAN i) {
       if (i != null) {
          caminharCentral(i.esq); // Elementos da esquerda.
          System.out.print(i.elemento + ((i.cor) ? "(p) " : "(b) ")); // Conteudo do no.
          caminharCentral(i.dir); // Elementos da direita.
       }
    }
 
    /**
     * Metodo publico iterativo para exibir elementos.
     */
    public void caminharPre() {
       System.out.print("[ ");
       caminharPre(raiz);
       System.out.println("]");
    }
 
    /**
     * Metodo privado recursivo para exibir elementos.
     * 
     * @param i NoAN em analise.
     */
    private void caminharPre(NoAN i) {
       if (i != null) {
          System.out.print(i.elemento + ((i.cor) ? "(p) " : "(b) ")); // Conteudo do no.
          caminharPre(i.esq); // Elementos da esquerda.
          caminharPre(i.dir); // Elementos da direita.
       }
    }
 
    /**
     * Metodo publico iterativo para exibir elementos.
     */
    public void caminharPos() {
       System.out.print("[ ");
       caminharPos(raiz);
       System.out.println("]");
    }
 
    /**
     * Metodo privado recursivo para exibir elementos.
     * 
     * @param i NoAN em analise.
     */
    private void caminharPos(NoAN i) {
       if (i != null) {
          caminharPos(i.esq); // Elementos da esquerda.
          caminharPos(i.dir); // Elementos da direita.
          System.out.print(i.elemento + ((i.cor) ? "(p) " : "(b) ")); // Conteudo do no.
       }
    }
 
    /**
     * Metodo publico iterativo para inserir elemento.
     * 
     * @param elemento Elemento a ser inserido.
     * @throws Exception Se o elemento existir.
     */
    public void inserir(Filme elemento) throws Exception {
       // Se a arvore estiver vazia
       if (raiz == null) {
          raiz = new NoAN(elemento);
 
       // Senao, se a arvore tiver um elemento
       } else if (raiz.esq == null && raiz.dir == null) {
          if (elemento.getTituloOriginal().compareTo(raiz.elemento.getTituloOriginal())<0) {
             raiz.esq = new NoAN(elemento);
          } else {
             raiz.dir = new NoAN(elemento);
          }
 
       // Senao, se a arvore tiver dois elementos (raiz e dir)
       } else if (raiz.esq == null) {
          if (elemento.getTituloOriginal().compareTo(raiz.elemento.getTituloOriginal())<0) {
             raiz.esq = new NoAN(elemento);
            
 
          } else if (elemento.getTituloOriginal().compareTo(raiz.dir.elemento.getTituloOriginal())<0) {
             raiz.esq = new NoAN(raiz.elemento);
             raiz.elemento = elemento;
             
 
          } else {
             raiz.esq = new NoAN(raiz.elemento);
             raiz.elemento = raiz.dir.elemento;
             raiz.dir.elemento = elemento;
             
          }
          raiz.esq.cor = raiz.dir.cor = false;
 
       // Senao, se a arvore tiver dois elementos (raiz e esq)
       } else if (raiz.dir == null) {
          if (elemento.getTituloOriginal().compareTo(raiz.elemento.getTituloOriginal())>0) {
             raiz.dir = new NoAN(elemento);
             
 
          } else if (elemento.getTituloOriginal().compareTo(raiz.dir.elemento.getTituloOriginal())>0) {
             raiz.dir = new NoAN(raiz.elemento);
             raiz.elemento = elemento;
            
 
          } else {
             raiz.dir = new NoAN(raiz.elemento);
             raiz.elemento = raiz.esq.elemento;
             raiz.esq.elemento = elemento;
             
          }
          raiz.esq.cor = raiz.dir.cor = false;
 
       // Senao, a arvore tem tres ou mais elementos
       } else {
          inserir(elemento, null, null, null, raiz);
       }
       raiz.cor = false;
    }
 
    private void balancear(NoAN bisavo, NoAN avo, NoAN pai, NoAN i) {
       // Se o pai tambem e preto, reequilibrar a arvore, rotacionando o avo
       if (pai.cor == true) {
          // 4 tipos de reequilibrios e acoplamento
          if (pai.elemento.getTituloOriginal().compareTo(avo.elemento.getTituloOriginal()) > 0) { // rotacao a esquerda ou direita-esquerda
            if (i.elemento.getTituloOriginal().compareTo(pai.elemento.getTituloOriginal()) > 0) {
                avo = rotacaoEsq(avo);
             } else {
                avo = rotacaoDirEsq(avo);
             }
          } else { // rotacao a direita ou esquerda-direita
             if (i.elemento.getTituloOriginal().compareTo(pai.elemento.getTituloOriginal()) < 0) {
                avo = rotacaoDir(avo);
             } else {
                avo = rotacaoEsqDir(avo);
             }
          }
          if (bisavo == null) {
             raiz = avo;
          } else if (avo.elemento.getTituloOriginal().compareTo(bisavo.elemento.getTituloOriginal()) < 0) {
             bisavo.esq = avo;
          } else {
             bisavo.dir = avo;
          }
          // reestabelecer as cores apos a rotacao
          avo.cor = false;
          avo.esq.cor = avo.dir.cor = true;
       } // if(pai.cor == true)
    }
 
    /**
     * Metodo privado recursivo para inserir elemento.
     * 
     * @param elemento Elemento a ser inserido.
     * @param avo      NoAN em analise.
     * @param pai      NoAN em analise.
     * @param i        NoAN em analise.
     * @throws Exception Se o elemento existir.
     */
    private void inserir(Filme elemento, NoAN bisavo, NoAN avo, NoAN pai, NoAN i) throws Exception {
       if (i == null) {
          if (elemento.getTituloOriginal().compareTo(pai.elemento.getTituloOriginal()) < 0) {
             i = pai.esq = new NoAN(elemento, true);
          } else {
             i = pai.dir = new NoAN(elemento, true);
          }
          if (pai.cor == true) {
             balancear(bisavo, avo, pai, i);
          }
       } else {
          // Achou um 4-no: eh preciso fragmeta-lo e reequilibrar a arvore
          if (i.esq != null && i.dir != null && i.esq.cor == true && i.dir.cor == true) {
             i.cor = true;
             i.esq.cor = i.dir.cor = false;
             if (i == raiz) {
                i.cor = false;
             } else if (pai.cor == true) {
                balancear(bisavo, avo, pai, i);
             }
          }
          if (elemento.getTituloOriginal().compareTo(i.elemento.getTituloOriginal()) < 0) {
             inserir(elemento, avo, pai, i, i.esq);
          } else if (elemento.getTituloOriginal().compareTo(i.elemento.getTituloOriginal()) > 0) {
             inserir(elemento, avo, pai, i, i.dir);
          } else {
             throw new Exception("Erro inserir (elemento repetido)!");
          }
       }
    }
 
    private NoAN rotacaoDir(NoAN no) {
       NoAN noEsq = no.esq;
       NoAN noEsqDir = noEsq.dir;
 
       noEsq.dir = no;
       no.esq = noEsqDir;
 
       return noEsq;
    }
 
    private NoAN rotacaoEsq(NoAN no) {
       NoAN noDir = no.dir;
       NoAN noDirEsq = noDir.esq;
 
       noDir.esq = no;
       no.dir = noDirEsq;
       return noDir;
    }
 
    private NoAN rotacaoDirEsq(NoAN no) {
       no.dir = rotacaoDir(no.dir);
       return rotacaoEsq(no);
    }
 
    private NoAN rotacaoEsqDir(NoAN no) {
       no.esq = rotacaoEsq(no.esq);
       return rotacaoDir(no);
    }
 }

 




public class App {
    static int comparacoes;
    public static void main(String[] args) throws Exception 
    { 
        long comeco = tempoPercorrido();
        Alvinegra alvinegra = new Alvinegra();    
        String nome = "";
        Scanner scanner = new Scanner(System.in);
         do{
            nome = scanner.nextLine();
            if(!(nome.charAt(0) == 'F' && nome.charAt(1) == 'I' && nome.charAt(2) == 'M'))
            {
                    Filme filme = new Filme();
                    filme.ler(nome);
                    alvinegra.inserir(filme);
                    // fArvore.emOrdem(fArvore.getRoot());
            }
        }while(!(nome.charAt(0) == 'F' && nome.charAt(1) == 'I' && nome.charAt(2) == 'M'));        
        do{
            nome = scanner.nextLine();
            if(!(nome.charAt(0) == 'F' && nome.charAt(1) == 'I' && nome.charAt(2) == 'M')){
            System.out.println(nome);
            if (alvinegra.pesquisar(nome)) {
                System.out.println("SIM");
                // System.out.println(temp.getTituloOriginal());
            }
            else{
                System.out.println("NAO");
                // System.out.println(temp.getTituloOriginal());
            }
        }
           
        }while(!(nome.charAt(0) == 'F' && nome.charAt(1) == 'I' && nome.charAt(2) == 'M')); 
        long fim = tempoPercorrido();
        double tempo = (fim - comeco)/1000.0;
        Arq.openWrite("matricula_Alvinegra.txt");
        Arq.print("Matricula: 749622\t");
        Arq.print("Tempo de execucao " + tempo + " segundos \t");
        Arq.print("Numero de comparações: "+comparacoes);
        Arq.close();
    }
    public static Filme lerAux(String arqNome) throws Exception 
    {
      Filme filme = new Filme();
      filme.ler(arqNome);
      return filme;  
    }
    public static long tempoPercorrido() 
    {
        return new Date().getTime();
    }
    
   
   
}

    



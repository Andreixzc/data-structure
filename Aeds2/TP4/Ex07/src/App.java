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







class Lista {

    private Node primeiro;
    private Node ultimo;
    private int n;

    public Node getPrimeiro() {
        return primeiro;
    }
    public void setPrimeiro(Node primeiro) {
        this.primeiro = primeiro;
    }
    public Node getUltimo() {
        return ultimo;
    }
    public void setUltimo(Node ultimo) {
        this.ultimo = ultimo;
    }
    public int getN() {
        return n;
    }
    public void setN(int n) {
        this.n = n;
    }
    public void inserirInicio(Filme valor) {
        Node node = new Node(valor);
        node.setProximo(primeiro);
        primeiro = node;
        n++;
    }
    public void inserirFim(Filme valor) {
        Node node = new Node(valor);
        if (primeiro == null && ultimo == null) {
            this.primeiro = node;
            this.ultimo = node;
        } else {
            this.ultimo.setProximo(node);
            this.ultimo = node;
        }
        n++;
    }
    public void inserir(Filme valor, int pos) throws Exception {
        if (pos > n) {
            throw new Exception("Erro caralho!");
        }
        if (pos == 0) {
            inserirInicio(valor);
        } else {
            Node node = new Node(valor);
            Node atual = new Node();
            Node aux = new Node();
            aux = this.primeiro;
            atual = this.primeiro;
            for (int i = 0; i < pos; i++) {
                aux = aux.getProximo();
            }
            for (int i = 0; i < pos - 1; i++) {
                atual = atual.getProximo();
            }
            atual.setProximo(node);
            node.setProximo(aux);
        }
        n++;

    }
    public Filme removerInicio() {
        Filme resp = primeiro.getValor();
        primeiro = primeiro.getProximo();
        n--;
        return resp;
    }
    public Filme removerFim() {
        if (n == 1) {
            return removerInicio();
        }
        else
        {
        Filme resp = this.ultimo.getValor();
        Node atual = new Node();
        Node anterior = null;
        atual = this.primeiro;
        for (int i = 0; i < n-1; i++) {
            anterior = atual;
            atual = atual.getProximo();
        }
        this.ultimo = anterior;
        anterior.setProximo(null);
        n--;
        return resp;
        }
        

    }
    public Filme remover(int pos) {
        if (pos == 0) {
            return removerInicio();
        }
        else
        {
            Filme resp;
        Node atual = new Node();
        Node anterior = null;
        atual = this.primeiro;
        for (int i = 0; i < pos; i++) {
            anterior = atual;
            atual = atual.getProximo();
        }
        resp = atual.getValor();
        anterior.setProximo(atual.getProximo());
        n--;
        return resp;
        }
    }
    public boolean pesquisar(String tittle) {
        Node node = new Node();
        node = this.primeiro;
        while (node != null) {
            if (node.getValor().getTituloOriginal().equals(tittle)) {
                return true;
            }
            node = node.getProximo();    
        }
        return false;
	}
    public void mostrar() {
        Node atual = this.primeiro;
        for (int i = 0; i <= n; i++) {
            if (atual != null) {
                System.out.print("["+i+"] " ); atual.getValor().imprimir();
                atual = atual.getProximo();
            }

        }
    }
}
class Node {
    
    private Filme valor;
    private Node proximo;
    private static int n;

    public static int getN() {
        return n;
    }
    public static void setN(int n) {
        Node.n = n;
    }
    public Node(Filme valor)
    {
        this.valor = valor;
    }
    public Node(){};

    public Filme getValor() {
        return valor;
    }
    public void setValor(Filme valor) {
        this.valor = valor;
    }
    public Node getProximo() {
        return proximo;
    }
    public void setProximo(Node proximo) {
        this.proximo = proximo;
    }
}
class HashM{
   Lista tabela[]; //array de lista ligada [f][f][f][f][f][f][f][f][f]
   int tamanho;
   final int NULO = -1;

   public HashM() {
      this(21);
   }

   public HashM(int tamanho) {
      this.tamanho = tamanho;
      tabela = new Lista[tamanho];
      for (int i = 0; i < tamanho; i++) {
         tabela[i] = new Lista();
      }
   }

   public int h(int elemento) {
      return elemento % tamanho;
   }

   boolean pesquisar(String tittle) {
      int pos = h(getAscii(tittle));//pego a posicao baseada da tabela beseada no codigo hash. Ex pos 4;
      if (tabela[pos].pesquisar(tittle)) { //Passo a posição da tabela que conteria minha palavra, e mando no metodo pesquisar.
        System.out.println("Posicao: "+pos);
        return true;
      }
      System.out.println("NAO");
      return false;
   }

   public void inserirInicio(Filme filme) {
      int pos = h(getAscii(filme.getTituloOriginal()));//2
      tabela[pos].inserirInicio(filme);
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
        HashM hashM = new HashM(21);
        String nomePesquisa;
        String nome = "";
        Scanner scanner = new Scanner(System.in);

         do{
            nome = scanner.nextLine();
            if(!(nome.charAt(0) == 'F' && nome.charAt(1) == 'I' && nome.charAt(2) == 'M'))
            {
                    Filme filme = new Filme();
                    filme.ler(nome);
                    hashM.inserirInicio(filme);
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


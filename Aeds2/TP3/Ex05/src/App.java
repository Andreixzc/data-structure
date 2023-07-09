import java.text.SimpleDateFormat;
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
                Arq.openRead("tmp/filmes/"+nomeArquivo,"UTF-8");
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
}
class lista 
{
    private Filme lista[] = new Filme[100];
    private int n;
    public void inserirInicio(Filme filme) throws Exception 
    {
        if (n>=lista.length) 
        {
            throw new Exception("ERRO!");  
        }
        for (int i = n; i > 0; i--) 
        {
            lista[i] = lista[i-1];
            
        }
        lista[0] = filme;
        n++;
        
    }
    public void inserir(Filme filme, int index) throws Exception
    {
        
        if (n>=lista.length||index<0||index>n) 
        {
            throw new Exception("ERRO!");
            
        }
        for (int i = n; i > index; i--) 
        {
            lista[i] = lista[i-1];
            
        }
        lista[index] = filme;
        n++;
        
    }
    public void inserirFim(Filme filme)throws Exception
    {
        if (n>=lista.length) 
        {
            throw new Exception("Erro");
            
        }
        lista[n] = filme;
        n++;
        
    }
    public Filme removerInicio()throws Exception
    {
        if (n==0) 
        {
            throw new Exception("ERRO!");            
        }
        Filme retorno = lista[0];
        n--;
        for (int i = 0; i < n; i++) 
        {
            lista[i] = lista[i+1];
        }
        return retorno;
    }
    public Filme removerFim() throws Exception
    {
        if (n == 0) 
        {
            throw new Exception("Erro!");            
        }
        return lista[--n];

    }
    public Filme remover(int pos)throws Exception
    {
        if (n == 0 || pos < 0 || pos >= n) 
        {
            throw new Exception("ERRO");
            
        }
        Filme resp = lista[pos];
        n--;
        for (int i = pos; i < n; i++) 
        {
            lista[i] = lista[i+1];
        }
        return resp;
    }
    public void mostrar() 
    {
        
        
        for (int i = 0; i < n; i++) 
        {
            lista[i].imprimir();
        }
        
    }
    public void ordenaLista()
    {   
        for (int i = n/2-1; i >=0; i--) {
            aplicaHeap(lista, n, i);
        }   
        for (int i = n-1; i >0; i--) {
            Filme aux = lista[0];
            lista[0] = lista[i];
            lista[i] = aux;
            aplicaHeap(lista, i, 0);
        }
    }
    public static void aplicaHeap(Filme[] vet,int n,int i) {
        int raiz = i;
        int esq = 2*i+1;
        int dir = 2*i+2;
        if (esq < n && vet[esq].getGenero().compareTo(vet[raiz].getGenero())>0) {
            raiz = esq;

        }
        if (dir < n && vet[dir].getGenero().compareTo(vet[raiz].getGenero())>0) {
            raiz = dir;   
        }
        if (raiz != i) {
            Filme aux = vet[i];
            vet[i] = vet[raiz];
            vet[raiz] = aux;
            aplicaHeap(vet, n, raiz);
        }
        App.comparacoes++;
    }
}
public class App {
    static int comparacoes;
    public static void main(String[] args) throws Exception 
    {    
        String nome = "";
        lista listaFilme = new lista();
        Scanner scanner = new Scanner(System.in);


         do{
            nome = scanner.nextLine();
            if(!(nome.charAt(0) == 'F' && nome.charAt(1) == 'I' && nome.charAt(2) == 'M'))
            {
                    Filme filme = new Filme();
                    filme.ler(nome);
                    listaFilme.inserirFim(filme);
            }
        }while(!(nome.charAt(0) == 'F' && nome.charAt(1) == 'I' && nome.charAt(2) == 'M'));

        scanner.close();
        long comeco = tempoPercorrido();
        listaFilme.ordenaLista();
        listaFilme.mostrar();
        long fim = tempoPercorrido();
        double tempo = (fim - comeco)/1000.0;
        Arq.openWrite("matricula_heapsort.txt");
        Arq.print("Matricula: 749622\t");
        Arq.print("Tempo de execucao " + tempo + " segundos \t");
        Arq.print("Numero de comparações: "+comparacoes);
        Arq.close();
    }
    public static long tempoPercorrido() 
    {
        return new Date().getTime();
    }
   
   
}

    



import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;
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
    public void ler(String nomeArquivo)
    {         
                // Filme filme = new Filme();
                Arq.openRead("/tmp/filmes/"+nomeArquivo,"UTF-8");
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
        String aux2 = run.trim();
        String aux3 = "";
        
        
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
    // private Filme lista[];
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
            System.out.print("["+i+"] " ); lista[i].imprimir();
        }
        
    }
}
public class App {
    static Filme[] removidos = new Filme[20];
    static int j = 0;  
    public static void main(String[] args) throws Exception 
    {    
        MyIO.setCharset("UTF-8");//MyIO não reconhece quebra de linha
        String nome = "";
        int contador = 0;
        String[] comando = new String[1000];
        lista listaFilme = new lista();
        Scanner scanner = new Scanner(System.in);


         do{
            nome = scanner.nextLine();
            if(!(nome.charAt(0) == 'F' && nome.charAt(1) == 'I' && nome.charAt(2) == 'M'))
            {
                    Filme filme = new Filme();
                    filme.ler(nome);
                    listaFilme.inserirFim(filme);
                    
                    // listaFilmes.add(filme);
                    // filme.imprimir();
            }
        }while(!(nome.charAt(0) == 'F' && nome.charAt(1) == 'I' && nome.charAt(2) == 'M'));

        int quantidadeFilme = scanner.nextInt();
        int hue = quantidadeFilme;
        String x = scanner.nextLine();// <---- 6 HORAS PRA RESOLVER ESTA DESGRAÇA
        for (int i = 0; i < hue; i++) 
        {
            comando[i] = scanner.nextLine();
            // System.out.println(comando[i]);
            acoes(comando[i], listaFilme);
        }

        
     
        printaRemovidos();
        listaFilme.mostrar();

    }
    public static void printaRemovidos() 
    {
        for (int i = 0; i < j; i++) 
        {
            System.out.println("(R) "+ removidos[i].getNome());
        }
        
    }
    public static Filme lerAux(String arqNome) 
    {
      Filme filme = new Filme();
      filme.ler(arqNome);
      return filme;
        
    }
    public static void acoes(String comando,lista lista)throws Exception
    {   
        //II,I*,IF,RI,R*,RF
        if (comando.substring(0,2).equals("II")) 
        {
            lista.inserirInicio(lerAux(comando.replace("II", "").trim()));
        }
        else if (comando.substring(0,2).equals("I*")) 
        {
            String novo = comando.replace("I*", "").trim();
            int index = Integer.parseInt(novo.split(" ")[0]);
            String aux = novo.split(" ")[0];
            lista.inserir(lerAux(novo.replace(aux, "").trim()), index);
        }
        else if (comando.substring(0,2).equals("IF")) 
        {
            lista.inserirFim(lerAux(comando.replace("IF", "").trim()));
        }
        else if (comando.substring(0,2).equals("RI")) 
        {
            removidos[j] =  lista.removerInicio();
            j++;
            
        }
        else if (comando.substring(0,2).equals("R*")) 
        {
            String novo = comando.replace("R*", "").trim();
           int indice = Integer.parseInt(novo);
           removidos[j] =  lista.remover(indice);
           j++;
        }
        else if (comando.substring(0,2).equals("RF")) 
        {
            removidos[j] = lista.removerFim();
            j++;
            
        }
}
}
    



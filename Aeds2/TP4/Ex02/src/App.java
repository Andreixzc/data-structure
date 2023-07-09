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
class No {
	public char chave; // Conteudo do no.
	public No esq; // No da esquerda.
	public No dir; // No da direita.
    public No2 outro;
	
	No(char chave) {
        this.chave = chave;
        this.esq = this.dir = null;
        this.outro = null;

    }

    No(char chave, No esq, No dir) {
        this.chave = chave;
        this.esq = esq;
        this.dir = dir;
        this.outro = null;

    }
}

class No2 {
	public String elemento; // Conteudo do no.
	public No2 esq; // No da esquerda.
	public No2 dir; // No da direita.
	
	No2(String elemento) {
		this.elemento = elemento;
		this.esq = this.dir = null;
	}

	No2(String elemento, No2 esq, No2 dir) {
		this.elemento = elemento;
		this.esq = esq;
		this.dir = dir;
	}
}

class ArvoreArvore {
    private No raiz;
    public int comparacoes = 0;

    public ArvoreArvore() throws Exception {
        raiz = null;
        inserir1('D');
        inserir1('R');
        inserir1('Z');
        inserir1('X');
        inserir1('V');
        inserir1('B');
        inserir1('F');
        inserir1('P');
        inserir1('U');
        inserir1('I');
        inserir1('G');
        inserir1('E');
        inserir1('J');
        inserir1('L');
        inserir1('H');
        inserir1('T');
        inserir1('A');
        inserir1('W');
        inserir1('S');
        inserir1('O');
        inserir1('M');
        inserir1('N');
        inserir1('K');
        inserir1('C');
        inserir1('Y');
        inserir1('Q');
    }

    public void inserir1(char chave) throws Exception {
        raiz = inserir1(chave, raiz);
    }
    private No inserir1(char chave, No i) {
        if(i == null){
            i = new No(chave);
        } else if(chave < i.chave){
            i.esq = inserir1(chave, i.esq);
        } else if(chave > i.chave){
            i.dir = inserir1(chave, i.dir);
        }

        return i;
    }

    public void inserir2(Filme filme){
        raiz = inserir2(filme, raiz);
    }

    public No inserir2(Filme filme, No i){
        if(filme.getTituloOriginal().charAt(0) == i.chave) {
            i.outro = inserirNome(filme.getTituloOriginal(), i.outro);
        } else if(filme.getTituloOriginal().charAt(0) < i.chave) {
            i.esq = inserir2(filme, i.esq); 
        } else if(filme.getTituloOriginal().charAt(0) > i.chave) {
            i.dir = inserir2(filme, i.dir);
        }

        return i;
    }

    private No2 inserirNome(String nome, No2 i){
    
        if(i == null) {
            i = new No2(nome);
        } else if(nome.compareTo(i.elemento) < 0) {
            i.esq = inserirNome(nome, i.esq);
        } else if(nome.compareTo(i.elemento) > 0) {
            i.dir = inserirNome(nome, i.dir);
        } 

        return i;
    }
    /* Fim metódo de Inserir */

    /* Inicio metódos de caminhar */
    public void caminharPre() {
        System.out.println("[ ");
        caminharPre(raiz);
        System.out.println(" ]");
    }

    private void caminharPre(No i) {
        if(i != null){
            System.out.println(i.chave + " ->");
            caminharNome(i.outro);
            caminharPre(i.esq);
            caminharPre(i.dir);
        }
    }

    private void caminharNome(No2 no) {
        if(no != null){
            System.out.println(no.elemento);
            caminharNome(no.esq);
            caminharNome(no.dir);
        }
    }
    /* Fim metódos de caminhar */

    /* Inicio metódos de pesquisa */
    public boolean pesquisar(String x){
        System.out.print("raiz ");
        return pesquisar(raiz, x);
    }

    private boolean pesquisar(No no, String x) {
        boolean resp;
        if (no == null) { 
            resp = false;
        } else {
            resp = pesquisarSegundaArvore(no.outro,x);
            if(resp == false) {
                System.out.print("esq ");
                resp = pesquisar(no.esq, x);

                if(resp == false){
                    System.out.print("dir ");
                    resp = pesquisar(no.dir, x);
                }
            }

        }
        return resp;
    }

    private boolean pesquisarSegundaArvore(No2 no, String x) {
        boolean resp;
        if (no == null) { 
            resp = false;
        } else {
            if(x.equals(no.elemento)) {
                comparacoes++;
                resp = true;
            } else {
                System.out.print("ESQ ");
                comparacoes++;
                resp = pesquisarSegundaArvore(no.esq, x);

                if(resp == false){
                    System.out.print("DIR ");
                    comparacoes++;
                    resp = pesquisarSegundaArvore(no.dir, x);
                }
            }
        }
        return resp;
    }
}


public class App {
    static int comparacoes;
    public static void main(String[] args) throws Exception 
    { 
        long comeco = tempoPercorrido();
        ArvoreArvore arvore = new ArvoreArvore();   
        String nome = "";
        String comando = "";
        int operacoes = 0;

        Scanner scanner = new Scanner(System.in);
         do{
            nome = scanner.nextLine();
            if(!(nome.charAt(0) == 'F' && nome.charAt(1) == 'I' && nome.charAt(2) == 'M'))
            {
                    Filme filme = new Filme();
                    filme.ler(nome);
                    arvore.inserir2(filme);
                    // fArvore.emOrdem(fArvore.getRoot());
            }
        }while(!(nome.charAt(0) == 'F' && nome.charAt(1) == 'I' && nome.charAt(2) == 'M'));
        operacoes = scanner.nextInt();
        
        comando = scanner.nextLine();
        for (int i = 0; i < operacoes; i++) {
            comando = scanner.nextLine();
            trataComando(comando,arvore);
            
        }
        do{
            nome = scanner.nextLine();
            if(!(nome.charAt(0) == 'F' && nome.charAt(1) == 'I' && nome.charAt(2) == 'M')){
            
            
            System.out.println("=> "+nome);
            if (arvore.pesquisar(nome)) {
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
        Arq.openWrite("matricula_arvoreBinaria.txt");
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
    public static void trataComando(String comando, ArvoreArvore faArvore) throws Exception {
        String filmeNome ="";
        filmeNome = comando.replaceFirst("I", "");
        faArvore.inserir2(lerAux(filmeNome.trim()));
         
    }
    public static long tempoPercorrido() 
    {
        return new Date().getTime();
    }
    
   
   
}

    



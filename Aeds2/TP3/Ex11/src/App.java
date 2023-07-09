import java.util.Arrays;
import java.util.Scanner;

class Filme {
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

    public void imprimir() {
        // MyIO.println(nome+" "+TituloOriginal+" "+dataLancamento+" "+duracao+" "+genero+"
        // "+IdiomaOriginal+" "+situacao+" "+orcamento+" "+Arrays.toString(palavraPasse));
        System.out.println((nome + " " + TituloOriginal + " " + dataLancamento + " " + duracao + " "
                + genero + " " + IdiomaOriginal + " " + situacao + " " + orcamento + " "
                + Arrays.toString(palavraPasse)));

    }

    public void ler(String nomeArquivo) {
        // Filme filme = new Filme();
        Arq.openRead("tmp/filmes/" + nomeArquivo, "UTF-8");
        String str = Arq.readAll();
        Arq.close();
        this.setNome(getData(str, "<meta property=\"og:title\" content=\"", "\">"));
        this.setTituloOriginal(checaTitulo(
                getData(str, "<p class=\"wrap\"><strong>Título original</strong> ", "</p>"), nome));
        this.setDataLancamento(
                getData(str, "<span class=\"release\">", "</span>").trim().split(" ")[0]);
        this.setDuracao(getRuntime(getData(str, "class=\"runtime\">", "</span>").trim()));
        this.setGenero(removeTags(getData(str, "<span class=\"genres\">", "</span>")));
        this.setIdiomaOriginal(
                getData(str, "<p><strong><bdi>Idioma original</bdi></strong> ", "</p>"));
        this.setSituacao(getData(str, "<strong><bdi>Situação</bdi></strong> ", "</p>").trim());
        this.setOrcamento(converteOrcamento(
                getData(str, "<p><strong><bdi>Orçamento</bdi></strong> ", "</p>")));
        this.setPalavraPasse(pegaPalavraPasse(
                removeTags(getData(str, "<h4><bdi>Palavras-chave</bdi></h4>", "</ul>"))));

    }

    public static String getData(String str, String TituloComeco, String TituloFinal) {
        int IndiceAuxiliar = str.indexOf(TituloComeco);
        IndiceAuxiliar += TituloComeco.length();
        int IndiceFinal = str.indexOf(TituloFinal, IndiceAuxiliar);
        return str.substring(IndiceAuxiliar, IndiceFinal);
    }

    public static int getRuntime(String run) {
        String[] aux;
        int horasMin;
        int horasF;
        int minutos;
        int duracaoFinal;
        String aux2 = run.trim();


        if (aux2.length() == 2 && aux2.contains("m")) {
            return Integer.parseInt(aux2.replaceAll("m", ""));// 2
        } else if (aux2.length() == 2) {
            return Integer.parseInt(aux2.replaceAll("h", ""));// 2
        }


        if (run.contains("h")) {
            aux = run.split("h");
            horasMin = Integer.parseInt(aux[0]);
            aux = aux[1].split("m");
            String teste = aux[0].trim();
            minutos = Integer.parseInt(teste);
            horasF = horasMin * 60;
            duracaoFinal = horasF + minutos;
            return duracaoFinal;
        } else
            aux = run.split("m");
        horasMin = Integer.parseInt(aux[0]);
        duracaoFinal = horasMin;
        return duracaoFinal;
    }

    public static float converteOrcamento(String rawOrcamento) {
        if (!rawOrcamento.equals("-")) {
            String res = rawOrcamento.replace("$", "").replace(",", "");
            return Float.parseFloat(res.substring(0, res.indexOf('.')));
        }
        return 0;
    }

    public static String removeTags(String in) {
        String resp = "";
        for (int i = 0; i < in.length(); i++) {
            if (in.charAt(i) == '<') {
                i++;
                while (in.charAt(i) != '>')
                    i++;
            } else {
                resp += in.charAt(i);
            }
        }
        return resp.replace("&nbsp;", "").trim();

    }

    public static String[] pegaPalavraPasse(String aux) {
        String[] noone = new String[0];
        if (aux.contains("Nenhuma palavra-chave foi adicionada.")) {
            return noone;
        }
        String[] auxf;
        int j = 0;
        int k = 0;
        String[] aux2 = new String[1000];
        auxf = aux.split("\n");
        for (int i = 0; i < auxf.length; i = i + 2) {
            aux2[j] = auxf[i].trim();
            j++;
        }
        for (int i = 0; i < aux2.length; i++) {
            if (aux2[i] != null) {
                k++;
            }
        }
        String[] finalRetorno = new String[k];
        for (int i = 0; i < k; i++) {
            finalRetorno[i] = aux2[i];
        }
        return finalRetorno;

    }

    public static String checaTitulo(String titulo, String nome) {
        if (titulo.length() > 50) {
            return nome;
        } else
            return titulo;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }
}


class Node {
    private Filme valor;
    private Node proximo;

    public Node(Filme valor) {
        this.valor = valor;
    }

    public Node() {};


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


class Pilha {
    private Node primeiro;
    private Node ultimo;
    private int n = 0;


    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

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


    public void empilhar(Filme valor) {
        Node node = new Node(valor);
        Node aux = new Node();
        aux = this.ultimo;
        if (n == 0) {
            this.primeiro = node;
            this.ultimo = node;
        } else {
            aux.setProximo(node);
            this.ultimo = node;
        }
        n++;

    }

    public Filme desempilhar() {
        Filme resp = this.ultimo.getValor();
        Node atual = new Node();
        Node anterior = null;
        atual = this.primeiro;
        for (int i = 0; i < n - 1; i++) {
            anterior = atual;
            atual = atual.getProximo();
        }
        this.ultimo = anterior;
        anterior.setProximo(null);
        n--;
        return resp;


    }

    public void mostrar() {
        Node atual = new Node();
        atual = this.primeiro;
        for (int i = 0; i <= n; i++) {
            if (atual != null) {
                System.out.print("["+i+"] " ); atual.getValor().imprimir();
                // System.out.println("[" + i + "] " + atual.getValor().getNome());

                atual = atual.getProximo();
            }
        }
    }

}


public class App {
    static Filme[] removidos = new Filme[20];
    static int j = 0;

    public static void main(String[] args) throws Exception {
        String nome = "";
        String[] comando = new String[1000];
        Pilha pilha = new Pilha();
        Scanner scanner = new Scanner(System.in);


        do {
            nome = scanner.nextLine();
            if (!(nome.charAt(0) == 'F' && nome.charAt(1) == 'I' && nome.charAt(2) == 'M')) {
                Filme filme = new Filme();
                filme.ler(nome);
                pilha.empilhar(filme);
                pilha.mostrar();
            }
        } while (!(nome.charAt(0) == 'F' && nome.charAt(1) == 'I' && nome.charAt(2) == 'M'));

        int quantidadeFilme = scanner.nextInt();

        int hue = quantidadeFilme;
        String x = scanner.nextLine();
        for (int i = 0; i < hue; i++) {

            comando[i] = scanner.nextLine();
            acoes(comando[i], pilha);
            // pilha.mostrar();

        }

        printaRemovidos();
        pilha.mostrar();

    }

    public static void printaRemovidos() {
        for (int i = 0; i < j; i++) {
            System.out.println("(R) " + removidos[i].getNome());
        }

    }

    public static Filme lerAux(String arqNome) {
        Filme filme = new Filme();
        filme.ler(arqNome);
        return filme;

    }

    public static void acoes(String comando, Pilha pilha) throws Exception {
        // II,I*,IF,RI,R*,RF
        if (comando.charAt(0) == 'I') {

            pilha.empilhar(lerAux(comando.replaceFirst("I", "").trim()));
        } else if (comando.charAt(0) == 'R') {

            removidos[j] = pilha.desempilhar();
            j++;
        }

    }
}



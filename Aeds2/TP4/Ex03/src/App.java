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
    public Filme elemento; // Conteudo do no.
    public No esq, dir;  // Filhos da esq e dir.
    public int nivel;

    /**
     * Construtor da classe.
     * @param elemento Conteudo do no.
     */
    public No(Filme elemento) {
        this(elemento, null, null,1);
    }

    /**
     * Construtor da classe.
     * @param elemento Conteudo do no.
     * @param esq No da esquerda.
     * @param dir No da direita.
     */
    public No(Filme elemento, No esq, No dir,int nivel) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
        this.nivel = nivel;
    }

    public void setNivel() {
		this.nivel = 1 + Math.max(getNivel(esq), getNivel(dir));
	}

	/**
	 * Retorna o número de níveis a partir de um vértice
	 * @param no nó que se deseja o nível.
	 */
	public static int getNivel(No no) {
		return (no == null) ? 0 : no.nivel;
	}

}


class ArvoreBinaria {
	private No raiz; // Raiz da arvore.

	/**
	 * Construtor da classe.
	 */
	public ArvoreBinaria() {
		raiz = null;
	}

	/**
	 * Metodo publico iterativo para pesquisar elemento.
	 * 
	 * @param x Elemento que sera procurado.
	 * @return <code>true</code> se o elemento existir, <code>false</code> em caso contrario.
	 */

    public boolean pesquisar(String x){
        System.out.print("raiz ");
        return pesquisar(x, raiz);
    }

    private boolean pesquisar(String x, No i) { 
        boolean resp;
        if(i == null) {
            resp = false;
        } else if(x.equals(i.elemento.getTituloOriginal())) {
            resp = true;
        } else if(x.compareTo(i.elemento.getTituloOriginal()) < 0) {
            resp = pesquisar(x, i.esq);
            System.out.print("esq ");
        } else {
            resp = pesquisar(x, i.dir);
            System.out.print("dir ");
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
	 * @param i No em analise.
	 */
	private void caminharCentral(No i) {
		if (i != null) {
			caminharCentral(i.esq); // Elementos da esquerda.
			System.out.print(i.elemento + " "); // Conteudo do no.
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
	 * @param i No em analise.
	 */
	private void caminharPre(No i) {
		if (i != null) {
			System.out.print(i.elemento.getTituloOriginal() + " "); // Conteudo do no.
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
	 * @param i No em analise.
	 */
	private void caminharPos(No i) {
		if (i != null) {
			caminharPos(i.esq); // Elementos da esquerda.
			caminharPos(i.dir); // Elementos da direita.
			System.out.print(i.elemento + " "); // Conteudo do no.
		}
	}


	/**
	 * Metodo publico iterativo para inserir elemento.
	 * 
	 * @param x Elemento a ser inserido.
	 * @throws Exception Se o elemento existir.
	 */
	public void inserir(Filme x) throws Exception {
		raiz = inserir(x, raiz);
	}

	/**
	 * Metodo privado recursivo para inserir elemento.
	 * 
	 * @param x Elemento a ser inserido.
	 * @param i No em analise.
	 * @return No em analise, alterado ou nao.
	 * @throws Exception Se o elemento existir.
	 */
	private No inserir(Filme x, No i) throws Exception {
        App.comparacoes++;
		if (i == null) {
			i = new No(x);

		} else if (x.getTituloOriginal().compareTo(i.elemento.getTituloOriginal())<0) {
            
			i.esq = inserir(x, i.esq);

		} else if (x.getTituloOriginal().compareTo(i.elemento.getTituloOriginal())>0) {
			i.dir = inserir(x, i.dir);

		} else {
			throw new Exception("Erro ao inserir!");
		}

        return balancear(i);
	}

	/**
	 * Metodo publico para inserir elemento.
	 * 
	 * @param x Elemento a ser inserido.
	 * @throws Exception Se o elemento existir.
	 */
	public void inserirPai(Filme x) throws Exception {
		if (raiz == null) {
			raiz = new No(x);
		} else if (x.getTituloOriginal().compareTo(raiz.elemento.getTituloOriginal())<0) {          
			inserirPai(x, raiz.esq, raiz);
		} else if (x.getTituloOriginal().compareTo(raiz.elemento.getTituloOriginal())>0) {
			inserirPai(x, raiz.dir, raiz);
		} else {
			throw new Exception("Erro ao inserirPai!");
		}
	}

	/**
	 * Metodo privado recursivo para inserirPai elemento.
	 * 
	 * @param x Elemento a ser inserido.
	 * @param i No em analise.
	 * @param pai No superior ao em analise.
	 * @throws Exception Se o elemento existir.
	 */
	private void inserirPai(Filme x, No i, No pai) throws Exception {
		if (i == null) {
			if (x.getTituloOriginal().compareTo(raiz.elemento.getTituloOriginal())<0) {
				pai.esq = new No(x);
			} else {
				pai.dir = new No(x);
			}
		} else if (x.getTituloOriginal().compareTo(i.elemento.getTituloOriginal()) < 0) {
			inserirPai(x, i.esq, i);
		} else if (x.getTituloOriginal().compareTo(i.elemento.getTituloOriginal()) > 0) {
			inserirPai(x, i.dir, i);
		} else {
			throw new Exception("Erro ao inserirPai!");
		}
	}


	/**
	 * Metodo publico iterativo para remover elemento.
	 * 
	 * @param x Elemento a ser removido.
	 * @throws Exception Se nao encontrar elemento.
	 */
	public void remover(Filme x) throws Exception {
		raiz = remover(x, raiz);
	}

	/**
	 * Metodo privado recursivo para remover elemento.
	 * 
	 * @param x Elemento a ser removido.
	 * @param i No em analise.
	 * @return No em analise, alterado ou nao.
	 * @throws Exception Se nao encontrar elemento.
	 */
	private No remover(Filme x, No i) throws Exception {
        App.comparacoes++;
		if (i == null) {
			throw new Exception("Erro ao remover!");

		} else if (x.getTituloOriginal().compareTo(i.elemento.getTituloOriginal()) < 0) {
			/*
			 * Se o valor a ser removido for menor que a raiz, chamo a função passando o node a
			 * esquerda da raiz como parametro.
			 */
			i.esq = remover(x, i.esq);

		} else if (x.getTituloOriginal().compareTo(i.elemento.getTituloOriginal()) > 0) {
			/*
			 * Se o valor a ser removido for menor que a raiz, chamo a função passando o node a
			 * direita da raiz como parametro.
			 */
			i.dir = remover(x, i.dir);

			// Sem no a direita.
		} else if (i.dir == null) {
			i = i.esq;

			// Sem no a esquerda.
		} else if (i.esq == null) {
			i = i.dir;

			// No a esquerda e no a direita.
		} else {
			i.esq = maiorEsq(i, i.esq);
		}

		return balancear(i);
	}

	/**
	 * Metodo para trocar o elemento "removido" pelo maior da esquerda.
	 * 
	 * @param i No que teve o elemento removido.
	 * @param j No da subarvore esquerda.
	 * @return No em analise, alterado ou nao.
	 */
	private No maiorEsq(No i, No j) {
		// Encontrou o maximo da subarvore esquerda.
		if (j.dir == null) {
			i.elemento = j.elemento; // Substitui i por j.
			j = j.esq; // Substitui j por j.ESQ.

			// Existe no a direita.
		} else {
			// Caminha para direita.
			j.dir = maiorEsq(i, j.dir);
		}
		return j;
	}

	/**
	 * Metodo que retorna o maior elemento da árvore
	 * 
	 * @return Filme maior elemento da árvore
	 */
	public Filme getMaior() {
		Filme resp = new Filme();

		if (raiz != null) {
			No i;
			for (i = raiz; i.dir != null; i = i.dir);
			resp = i.elemento;
		}

		return resp;
	}


	/**
	 * Metodo que retorna o menor elemento da árvore
	 * 
	 * @return Filme menor elemento da árvore
	 */
	public Filme getMenor() {
		Filme resp = new Filme();

		if (raiz != null) {
			No i;
			for (i = raiz; i.esq != null; i = i.esq);
			resp = i.elemento;
		}

		return resp;
	}


	/**
	 * Metodo que retorna a altura da árvore
	 * 
	 * @return Filme altura da árvore
	 */
	public int getAltura() {
		return getAltura(raiz, 0);
	}


	/**
	 * Metodo que retorna a altura da árvore
	 * 
	 * @return Filme altura da árvore
	 */
	public int getAltura(No i, int altura) {
		if (i == null) {
			altura--;
		} else {
			int alturaEsq = getAltura(i.esq, altura + 1);
			int alturaDir = getAltura(i.dir, altura + 1);
			altura = (alturaEsq > alturaDir) ? alturaEsq : alturaDir;
		}
		return altura;
	}
	public Filme getRaiz() throws Exception {
		return raiz.elemento;
	}

	public static boolean igual(ArvoreBinaria a1, ArvoreBinaria a2) {
		return igual(a1.raiz, a2.raiz);
	}

	private static boolean igual(No i1, No i2) {
		boolean resp;
		if (i1 != null && i2 != null) {
			resp = (i1.elemento == i2.elemento) && igual(i1.esq, i2.esq) && igual(i1.dir, i2.dir);
		} else if (i1 == null && i2 == null) {
			resp = true;
		} else {
			resp = false;
		}
		return resp;
	}

    private No balancear(No no) throws Exception {
		if (no != null) {
			int fator = No.getNivel(no.dir) - No.getNivel(no.esq);
			// Se balanceada
			if (Math.abs(fator) <= 1) {
				no.setNivel();
			// Se desbalanceada para a direita
			} else if (fator == 2) {
				int fatorFilhoDir = No.getNivel(no.dir.dir) - No.getNivel(no.dir.esq);
				// Se o filho a direita tambem estiver desbalanceado
				if (fatorFilhoDir == -1) {
					no.dir = rotacionarDir(no.dir);
				}
				no = rotacionarEsq(no);
			// Se desbalanceada para a esquerda
			} else if (fator == -2) {
				int fatorFilhoEsq = No.getNivel(no.esq.dir) - No.getNivel(no.esq.esq);
				// Se o filho a esquerda tambem estiver desbalanceado
				if (fatorFilhoEsq == 1) {
					no.esq = rotacionarEsq(no.esq);
				}
				no = rotacionarDir(no);
			} else {
				throw new Exception(
						"Erro no No(" + no.elemento + ") com fator de balanceamento (" + fator + ") invalido!");
			}
		}
		return no;
	}

	private No rotacionarDir(No no) {
		No noEsq = no.esq;
		No noEsqDir = noEsq.dir;

		noEsq.dir = no;
		no.esq = noEsqDir;
		no.setNivel(); // Atualizar o nivel do no
		noEsq.setNivel(); // Atualizar o nivel do noEsq

		return noEsq;
	}

	private No rotacionarEsq(No no) {	
		No noDir = no.dir;
		No noDirEsq = noDir.esq;

		noDir.esq = no;
		no.dir = noDirEsq;

		no.setNivel(); // Atualizar o nivel do no
		noDir.setNivel(); // Atualizar o nivel do noDir
		return noDir;
	}




}

public class App {
    static int comparacoes;
    public static void main(String[] args) throws Exception 
    { 
        long comeco = tempoPercorrido();
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();    
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
                    arvoreBinaria.inserir(filme);
                    // fArvore.emOrdem(fArvore.getRoot());
            }
        }while(!(nome.charAt(0) == 'F' && nome.charAt(1) == 'I' && nome.charAt(2) == 'M'));
        operacoes = scanner.nextInt();
        
        comando = scanner.nextLine();
        for (int i = 0; i < operacoes; i++) {
            comando = scanner.nextLine();
            trataComando(comando,arvoreBinaria);
            
        }
        do{
            nome = scanner.nextLine();
            if(!(nome.charAt(0) == 'F' && nome.charAt(1) == 'I' && nome.charAt(2) == 'M')){
            System.out.println(nome);
            if (arvoreBinaria.pesquisar(nome)) {
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
    public static void trataComando(String comando, ArvoreBinaria faArvore) throws Exception {
        String filmeNome ="";
        if (comando.charAt(0) == 'I') {
            filmeNome = comando.replaceFirst("I", "");
            faArvore.inserir(lerAux(filmeNome.trim()));
       }
       else {
            filmeNome = comando.replaceFirst("R", "");
            Filme temp = new Filme();
            temp.setTituloOriginal(filmeNome.trim());
            faArvore.remover(temp);
       }
    }
    public static long tempoPercorrido() 
    {
        return new Date().getTime();
    }
    
   
   
}

    



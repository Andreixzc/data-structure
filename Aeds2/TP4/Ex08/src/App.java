import java.util.Arrays;
import java.util.Scanner;

class ArvoreBinaria {
	private No raiz; // Raiz da arvore.
	public ArvoreBinaria() {
		raiz = null;
	}

	public void agrupaAPorraToda() {
		caminharPre();
		caminharCentral();
		caminharPos();
	}
	public boolean pesquisar(int x) {
		return pesquisar(x, raiz);
	}
	private boolean pesquisar(int x, No i) {
		boolean resp;
		if (i == null) {
			resp = false;

		} else if (x == i.elemento) {
			resp = true;

		} else if (x < i.elemento) {
			resp = pesquisar(x, i.esq);

		} else {
			resp = pesquisar(x, i.dir);
		}
		return resp;
	}
	public void caminharCentral() {
		caminharCentral(raiz);
	}
	private void caminharCentral(No i) {
		if (i != null) {
			caminharCentral(i.esq); // Elementos da esquerda.
			App.contador++;
			if (App.contador == App.qnt) {
				System.out.print(i.elemento);
			}else{
				System.out.print(i.elemento + " "); // Conteudo do no.
				
			}
			caminharCentral(i.dir); // Elementos da direita.
		}
	}

	public void caminharPre() {
		caminharPre(raiz);
	}
	private void caminharPre(No i) {
		if (i != null) {
			App.contador++;
			if (App.contador == App.qnt) {
				System.out.print(i.elemento);
			}else{
				System.out.print(i.elemento + " "); // Conteudo do no.
				
			}
			caminharPre(i.esq); // Elementos da esquerda.
			caminharPre(i.dir); // Elementos da direita.
		}
	}
	public void caminharPos() {
		caminharPos(raiz);
	}
	private void caminharPos(No i) {
		if (i != null) {
			caminharPos(i.esq); // Elementos da esquerda.
			caminharPos(i.dir); // Elementos da direita.
			App.contador++;
			if (App.contador == App.qnt) {
				System.out.print(i.elemento);
			}else{
				System.out.print(i.elemento + " "); // Conteudo do no.
				
			}
			
			
		}
		
	}
	public void inserir(int x) throws Exception {
		raiz = inserir(x, raiz);
	}
	private No inserir(int valor, No node) throws Exception {
		if (node == null) {
			node = new No(valor);

		} else if (valor < node.elemento) {
			node.esq = inserir(valor, node.esq);

		} else if (valor > node.elemento) {
			node.dir = inserir(valor, node.dir);

		} else {
			throw new Exception("Erro ao inserir!");
		}

		return node;
	}

	public void inserirPai(int x) throws Exception {
		if (raiz == null) {
			raiz = new No(x);
		} else if (x < raiz.elemento) {
			inserirPai(x, raiz.esq, raiz);
		} else if (x > raiz.elemento) {
			inserirPai(x, raiz.dir, raiz);
		} else {
			throw new Exception("Erro ao inserirPai!");
		}
	}
	private void inserirPai(int x, No i, No pai) throws Exception {
		if (i == null) {
			if (x < pai.elemento) {
				pai.esq = new No(x);
			} else {
				pai.dir = new No(x);
			}
		} else if (x < i.elemento) {
			inserirPai(x, i.esq, i);
		} else if (x > i.elemento) {
			inserirPai(x, i.dir, i);
		} else {
			throw new Exception("Erro ao inserirPai!");
		}
	}

	public int getRaiz() throws Exception {
		return raiz.elemento;
	}
}
class No {
    public int elemento; // Conteudo do no.
    public No esq, dir;  // Filhos da esq e dir.

    /**
     * Construtor da classe.
     * @param elemento Conteudo do no.
     */
    public No(int elemento) {
        this(elemento, null, null);
    }

    /**
     * Construtor da classe.
     * @param elemento Conteudo do no.
     * @param esq No da esquerda.
     * @param dir No da direita.
     */
    public No(int elemento, No esq, No dir) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }
}
public class App {
	static int qnt;
	static int contador;
    public static void main(String[] args) throws Exception {
		int x = 1;
		int cases;
		int[] numeros;
		Scanner sc = new Scanner(System.in);
		cases = sc.nextInt();
		sc.nextLine();
		
		
		
		
		for (int i = 0; i < cases; i++) {
			ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
			qnt = sc.nextInt();
			sc.nextLine();
			String str = sc.nextLine();
			numeros = stringToVet(str);
			for (int j = 0; j < numeros.length; j++) {
				arvoreBinaria.inserir(numeros[j]);
			}
			System.out.println("Case "+x+":");
			System.out.print("Pre.: ");
			App.contador = 0;
			arvoreBinaria.caminharPre();
			System.out.println();
			System.out.print("In..: ");
			App.contador = 0;
			arvoreBinaria.caminharCentral();
			System.out.println();
			System.out.print("Post: ");
			App.contador = 0;
			arvoreBinaria.caminharPos();
			System.out.println();
			x++;
			if (i<cases-1) {
				System.out.println();
			}
		}

    }
	public static int[] stringToVet(String str) {
		String[] strCut = str.split(" ");
		int[] retorno = new int[strCut.length];
		for (int i = 0; i < retorno.length; i++) {
			retorno[i] = Integer.parseInt(strCut[i]);
		}
		return retorno;

		
	}    
}

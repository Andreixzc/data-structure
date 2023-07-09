// public class ArvoreBinaria {
// 	private No raiz; // Raiz da arvore.
// 	public ArvoreBinaria() {
// 		raiz = null;
// 	}

// 	public boolean pesquisar(int x) {
// 		return pesquisar(x, raiz);
// 	}
// 	private boolean pesquisar(int x, No i) {
// 		boolean resp;
// 		if (i == null) {
// 			resp = false;

// 		} else if (x == i.elemento) {
// 			resp = true;

// 		} else if (x < i.elemento) {
// 			resp = pesquisar(x, i.esq);

// 		} else {
// 			resp = pesquisar(x, i.dir);
// 		}
// 		return resp;
// 	}
// 	public void caminharCentral() {
// 		System.out.print("[ ");
// 		caminharCentral(raiz);
// 		System.out.println("]");
// 	}
// 	private void caminharCentral(No i) {
// 		if (i != null) {
// 			caminharCentral(i.esq); // Elementos da esquerda.
// 			System.out.print(i.elemento + " "); // Conteudo do no.
// 			caminharCentral(i.dir); // Elementos da direita.
// 		}
// 	}

// 	public void caminharPre() {
// 		System.out.print("[ ");
// 		caminharPre(raiz);
// 		System.out.println("]");
// 	}
// 	private void caminharPre(No i) {
// 		if (i != null) {
// 			System.out.print(i.elemento + " "); // Conteudo do no.
// 			caminharPre(i.esq); // Elementos da esquerda.
// 			caminharPre(i.dir); // Elementos da direita.
// 		}
// 	}
// 	public void caminharPos() {
// 		System.out.print("[ ");
// 		caminharPos(raiz);
// 		System.out.println("]");
// 	}

// 	private void caminharPos(No i) {
// 		if (i != null) {
// 			caminharPos(i.esq); // Elementos da esquerda.
// 			caminharPos(i.dir); // Elementos da direita.
// 			System.out.print(i.elemento + " "); // Conteudo do no.
// 		}
// 	}
// 	public void inserir(int x) throws Exception {
// 		raiz = inserir(x, raiz);
// 	}
// 	private No inserir(int valor, No node) throws Exception {
// 		if (node == null) {
// 			node = new No(valor);

// 		} else if (valor < node.elemento) {
// 			node.esq = inserir(valor, node.esq);

// 		} else if (valor > node.elemento) {
// 			node.dir = inserir(valor, node.dir);

// 		} else {
// 			throw new Exception("Erro ao inserir!");
// 		}

// 		return node;
// 	}

// 	public void inserirPai(int x) throws Exception {
// 		if (raiz == null) {
// 			raiz = new No(x);
// 		} else if (x < raiz.elemento) {
// 			inserirPai(x, raiz.esq, raiz);
// 		} else if (x > raiz.elemento) {
// 			inserirPai(x, raiz.dir, raiz);
// 		} else {
// 			throw new Exception("Erro ao inserirPai!");
// 		}
// 	}
// 	private void inserirPai(int x, No i, No pai) throws Exception {
// 		if (i == null) {
// 			if (x < pai.elemento) {
// 				pai.esq = new No(x);
// 			} else {
// 				pai.dir = new No(x);
// 			}
// 		} else if (x < i.elemento) {
// 			inserirPai(x, i.esq, i);
// 		} else if (x > i.elemento) {
// 			inserirPai(x, i.dir, i);
// 		} else {
// 			throw new Exception("Erro ao inserirPai!");
// 		}
// 	}

// 	public int getRaiz() throws Exception {
// 		return raiz.elemento;
// 	}
// }


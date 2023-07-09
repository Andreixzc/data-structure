// public class Pilha {
//     private Node primeiro;
//     private Node ultimo;
//     private int n = 0;
    
    
//     public int getN() {
//         return n;
//     }
//     public void setN(int n) {
//         this.n = n;
//     }
//     public Node getPrimeiro() {
//         return primeiro;
//     }
//     public void setPrimeiro(Node primeiro) {
//         this.primeiro = primeiro;
//     }
//     public Node getUltimo() {
//         return ultimo;
//     }
//     public void setUltimo(Node ultimo) {
//         this.ultimo = ultimo;
//     }

//     public void empilhar(String valor) {
        
//         Node node = new Node(valor);
//         if (n == 0) {
//             this.primeiro = node;
//             this.ultimo = node;  
//         }
//         node.setProximo(primeiro);
//         this.primeiro = node;
//         n++;
//     }
//     public String desempilhar() {
//         Node node = new Node();
//         node = this.primeiro;
//         String resp = node.getValor();
//         this.primeiro = primeiro.getProximo();
//         n--;
//         return resp;
//     }
//     public void mostrar()
//     {
//         Node atual = new Node();
//         atual = this.primeiro;
//         for (int i = 1; i <= n; i++) {
//             if (atual!= null) {
//                 System.out.println(atual.getValor());
//                 atual = atual.getProximo();
//             }
//         }
//     }
    
// }

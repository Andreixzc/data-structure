// import java.util.List;
// import java.util.concurrent.ExecutionException;

// public class fila 
// {
//     Filme[] fila;
//     int primeiro, ultimo;
//     fila()
//     {
//         this(5);
//     }
//     fila(int tamanho)
//     {
//         fila = new int[tamanho+1];
//         primeiro = ultimo = 0;
//     }
//     void inserir(Filme filme)throws Exception
//     {
//         if (((ultimo+1)%fila.length) == primeiro) 
//         {
//             throw new Exception("ERRO");
            
//         }
//         fila[ultimo] = filme;
//         ultimo = (ultimo+1)% fila.length;    
//     }
//     Filme remover()throws Exception
//     {
//         if (primeiro == ultimo) 
//         {
//             throw new Exception("ERRO");
            
//         }
//         Filme resp = fila[primeiro];
//         primeiro = (primeiro+1)%fila.length;
//         return resp;

//     }
//     void mostrar()
//     {
//         int i = primeiro;
//         while (i!= ultimo) 
//         {
//             System.out.println(fila[i]);
//             i = (i+1) % fila.length;
//         }
//     }
//     public int media() 
//     {
//         int soma = 0;
//         for (int i = 0; i < fila.length; i++) 
//         {
//             soma += fila[i].getDuracao();
//         }
//         return soma/5;  
//     }

    
// }

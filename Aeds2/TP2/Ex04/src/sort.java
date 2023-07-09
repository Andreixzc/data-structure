import java.lang.reflect.Array;
import java.util.Arrays;
import javax.swing.event.SwingPropertyChangeSupport;

/**
 * App
 */
public class sort {

    public static void main(String args[]) 
    {
       
        String[] strings = new String[] {"007: Sem Tempo para Morrer", "A Era do Gelo: As Aventuras de Buck",
         "A Família Addams 2: Pé na Estrada", "Alerta Vermelho", "Batman", "Casa Gucci", 
         "Cruella", "Diário de um Banana", "Dog", "Encanto", "Exorcismo Sagrado", 
         "Ghostbusters: Mais Além", "Gold", "Homem-Aranha: Sem Volta Para Casa", "Infiltrado", 
         "Liga da Justiça de Zack Snyder", "Luca", "Matrix Resurrections, Mortal Kombat", 
         "O Esquadrão Suicida", "O Último Duelo", "Os Simpsons em Plusniversário", 
         "Patrulha Canina: O Filme", "Resident Evil: Bem-Vindo a Raccoon City", 
         "Ron Bugado", "The Commando", "Uncharted: Fora do Mapa", 
         "Velozes &amp; Furiosos 9", "Venom: Tempo de Carnificina", "Witch Hunt"};

        String[] res = ordena(strings);
        // Arrays.sort(strings);
        String palavra = "007: Sem Tempo para Morrer";
        // System.out.println(binarySearch(ordena(strings), palavra));
        System.out.println(binarySearchString(res, palavra));
    }
    public static String[] ordena(String[] nomes) 
    {
        String[] res = new String[nomes.length];
        String temp2 = "";
        for (int i = 0; i < nomes.length-1; i++) 
        {
            for (int j = i+1; j < nomes.length-1; j++) {
                if (nomes[j].compareTo(nomes[i])<0) 
                {
                    temp2 = nomes[i];
                    nomes[i] = nomes[j];
                    nomes[j] = temp2;
                }
            }
        }
        nomes[0] = "Sem Tempo para Morrer";
        res = nomes;
        return res;    
    }
    public static boolean binarySearchString(String[] res,String nome) 
    {
        int comeco = 0;
        int fim = res.length;
        int meio = 0;
        for (int i = 0; i < res.length; i++) 
        {
            meio = (comeco+fim)/2;
            if (res[meio].equals(nome)) 
            {
                return true;
                
            }
            if (nome.compareTo(res[meio])<0) //menor
            {
                fim = meio-1;
            }
            if (nome.compareTo(res[meio])>0) //maior
            {
                comeco = meio +1;
            }
        }
        return false;
    }
    static int binarySearch(String[] arr, String x)
    {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
 
            int res = x.compareTo(arr[m]);
 
            // Check if x is present at mid
            if (res == 0)
                return m;
 
            // If x greater, ignore left half
            if (res > 0)
                l = m + 1;
 
            // If x is smaller, ignore right half
            else
                r = m - 1;
        }
 
        return -1;
    }
}
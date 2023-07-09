import java.util.Arrays;
public class sorts {
    public static void main(String args[]) {
        int vet[] = {5,2,7,6,9,3,1,4};
        for (int i = 0; i < 17; i++) {
            System.out.println(i);
        }
        qckSort(vet, 0, vet.length-1);
        // quicksort(vet, 0, vet.length-1);
        // bubbleSort(vet);
        // selectionSort(vet);
        insertionSort(vet);
        System.out.println(Arrays.toString(vet));
    } 
    public static void quicksort(int[] vet, int comeco, int fim) {
        if (comeco < fim) {
            int p = particao(vet,comeco,fim);//2
            quicksort(vet, comeco, p-1);
            quicksort(vet, p+1, fim);
        }
    }
    public static int particao(int[]vet, int comeco, int fim) {
        int pivo = vet[fim];
        int i = comeco;

        for (int j = comeco; j < fim; j++) {
            if (vet[j] < pivo) {
                swap(vet, i, j);
                i++;
            }
        }
        swap(vet, i, fim);
        return i;
    }
    public static void bubbleSort(int[] vet) {
        for (int i = 0; i < vet.length; i++) {
            for (int j = i+1; j < vet.length; j++) {
                if (vet[j] < vet[i]) {
                    swap(vet, i, j);
                }
            }
        }
    }
    public static void selectionSort(int[]vet) {
        for (int i = 0; i < vet.length; i++) {
            int pos = i;
            for (int j = i+1; j < vet.length; j++) {
                if (vet[j] < vet[pos]) {
                    pos = j;
                }
            }
            swap(vet, i, pos);
        }
    }
    public static void insertionSort(int[] vet) {
        int tmp;
        int j;
        for (int i = 1; i < vet.length; i++) {
            tmp = vet[i];
            j = i -1;
            while (j>= 0 && vet[j] > tmp) {
                vet[j+1] = vet[j];
                j--;
            }
            vet[j+1] = tmp;
        }
    }
    public static void qckSort(int[]vet, int comeco, int fim) {
         if (comeco<fim) {
             int p = parteVetor(vet,comeco,fim);
             qckSort(vet, comeco, p-1);
             qckSort(vet, fim, p+1);
         }
    }
    public static int parteVetor(int[] vet, int comeco,int fim) {
        int pivo = vet[fim];
        int i = comeco;
        for (int j = comeco; j < fim; j++) {
            if (vet[j] < pivo) {
                swap(vet, i, j);
                i++;
            }
        }
        swap(vet, i, fim);

        return i;
    }




    public static void swap(int[]vet, int i, int j) {
        int tmp;
        tmp = vet[i];
        vet[i] = vet[j];
        vet[j] = tmp;
    }
    
    

}



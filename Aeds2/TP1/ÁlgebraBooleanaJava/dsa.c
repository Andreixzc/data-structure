#include <stdio.h>
#include <stdlib.h>
void bubble_sort (int vetor[], int n) {
    int k, j, aux;

    for (k = 1; k < n; k++) {
        printf("\n[%d] ", k);

        for (j = 0; j < n - 1; j++) {
            printf("%d, ", j);

            if (vetor[j] > vetor[j + 1]) {
                aux          = vetor[j];
                vetor[j]     = vetor[j + 1];
                vetor[j + 1] = aux;
            }
        }
    }
}
int main()
{
    int vetor[10] = {123,323,1234,2342,1,34,232,1233,232,123};
     bubble_sort(vetor,10);
}

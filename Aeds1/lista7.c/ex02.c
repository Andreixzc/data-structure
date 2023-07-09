#include <stdio.h>
#include <stdlib.h>
void fill(int *x, int n)
{
    int i;
    for (i = 0; i < n; i++)
    {
        printf("VALOR:\n");
        scanf("%i", &x[i]);
    }
}
int *vale(int *x, int n)
{
    int negativocont = 0;
    int *negativo = malloc(sizeof(int) * n);
    int i;

    for (int i = 0; i < n; i++)
    {
        if (x[i] < 0)
        {
            negativocont++;
        }
    }
    for (int j = 0; i < n; i++)
    {
        negativo[i] = x[i];
    }

    for (int k = 0; k < 5; k++)
    {
        printf("%i\n", negativo[k]);
    }

    return negativo;
}

int main()
{
    int *resultado;
    int x[5];
    fill(x, 5);
    vale(x, 5);
    resultado = vale(x, 5);
    for (int i = 0; i < 5; i++)
    {
        printf("%i\n", &resultado[i]);
    }
    //não consegui fazer o programa funcionar corretmanete, mas a funcao nao retornava o vetor.
}
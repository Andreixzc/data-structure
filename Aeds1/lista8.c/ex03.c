#include <stdio.h>
#include <stdlib.h>
void preencheVetor(int *v1, int *v2, int n)
{
    int i = 0;
    printf("VETOR 1:\n");
    for (i = 0; i < 5; i++)
    {
        printf("VALOR:\n");
        scanf("%i", &v1[i]);
    }
    printf("VETOR 2:\n");
    for (i = 0; i < 5; i++)
    {
        printf("VALOR:\n");
        scanf("%i", &v2[i]);
    }
}
void intercalaVetor(int *v1, int *v2, int n)
{
    int v3[10];
    int j;
    for (int i = 0; i < 10; i+=2)
    {
        v3[i] = v1[j];
        v3[i+1] = v2[j];    
        j++;
    }
    
}

int main()
{
    int x[5];
    int y[5];
    preencheVetor(x, y, 5);
    intercalaVetor(x, y, 5);
}
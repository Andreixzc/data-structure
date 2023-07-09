#include <stdio.h>
#include <stdlib.h>
#include <time.h>
void preencheMatriz(int M[10][10])
{
    srand(time(NULL));
    for (int i = 0; i < 10; i++)
    {
        for (int j = 0; j < 10; j++)
        {
            M[i][j] = rand() % 100;
        }
    }
    printf("Matriz princpial:\n");
    for (int i = 0; i < 10; i++)
    {
        for (int j = 0; j < 10; j++)
        {
            printf("%i ", M[i][j]);
        }
        printf("\n");
    }
}
void trocaLinha28(int M[10][10], int aux[10][3])
{
    for (int i = 0; i < 10; i++)
    {
        for (int j = 0; j < 10; j++)
        {
            if (i == 2)
            {
                aux[i][j] = M[i][j]; //recebe linha 2;
            }

            if (i == 8)
            {
                M[i][j] = M[i - 6][j - 6];
                M[i - 6][j - 6] = aux[2][2];
            }
        }
    }
    printf("Matriz Trocada:\n");
    for (int i = 0; i < 10; i++)
    {
        for (int j = 0; j < 10; j++)
        {
            printf("%i ", M[i][j]);
        }
        printf("\n");
    }
}
int main()
{
    int M[10][10];
    int aux[10][3];
    preencheMatriz(M);
    trocaLinha28(M, aux);
}
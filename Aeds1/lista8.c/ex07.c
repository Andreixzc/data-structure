#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void preencherMatriz(int a[4][6], int b[4][6])
{
    srand(time(NULL));
    for (int i = 0; i < 4; i++)
    {
        for (int j = 0; j < 6; j++)
        {
            a[i][j] = rand() % 100;
            b[i][j] = rand() % 100;
        }
    }
}
int **alocarMatriz1(int nrows, int ncols, int a[4][6], int b[4][6])
{
    int **matrix = (int **)(malloc(sizeof(int *) * nrows));
    for (int i = 0; i < nrows; i++)
    {
        matrix[i] = (int *)malloc(sizeof(int) * ncols);
    }
    for (int i = 0; i < 4; i++)
    {
        for (int j = 0; j < 6; j++)
        {
            matrix[i][j] = a[i][j] + b[i][j];
        }
    }
    return matrix;
}
int **alocarMatriz2(int nrows, int ncols, int a[4][6], int b[4][6])
{
    int **matrix2 = (int **)(malloc(sizeof(int *) * nrows));
    for (int i = 0; i < nrows; i++)
    {
        matrix2[i] = (int *)malloc(sizeof(int) * ncols);
    }
    for (int i = 0; i < 4; i++)
    {
        for (int j = 0; j < 6; j++)
        {
            matrix2[i][j] = a[i][j] - b[i][j];
        }
    }
    return matrix2;
}

int main()
{
    int **matrix;
    int **matrix2;
    int a[4][6];
    int b[4][6];
    preencherMatriz(a, b);
    matrix = alocarMatriz1(4, 6, a, b);
    matrix2 = alocarMatriz2(4, 6, a, b);
    printf("Matriz A:\n");
    for (int i = 0; i < 4; i++)
    {
        for (int j = 0; j < 6; j++)
        {
            printf("%i ", a[i][j]);
        }
        printf("\n");
    }
    printf("Matriz B:\n\n\n");
    for (int i = 0; i < 4; i++)
    {
        for (int j = 0; j < 6; j++)
        {
            printf("%i ", b[i][j]);
        }
        printf("\n");
    }
    printf("Soma das matrizes:\n\n\n");
    for (int i = 0; i < 4; i++)
    {
        for (int j = 0; j < 6; j++)
        {
            printf("%i ", matrix[i][j]);
        }
        printf("\n");
    }
    printf("Diferenca das matrizes:\n\n\n");
    for (int i = 0; i < 4; i++)
    {
        for (int j = 0; j < 6; j++)
        {
            printf("%i ", matrix2[i][j]);
        }
        printf("\n");
    }
    free(matrix2);
    free(matrix);
}
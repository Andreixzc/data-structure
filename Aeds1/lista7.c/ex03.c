#include <stdio.h>
#include <stdlib.h>

#define NUM_VETOR 10

void preenche_vetor(int *X, int *Y);
void soma_vetor(int *X, int *Y);

int main(void)
{

    int X[10], Y[10];

    preenche_vetor(X, Y);

    soma_vetor(X, Y);

    system("pause");
    return 0;
}

void preenche_vetor(int *X, int *Y)
{
    int i = 0;
    for (i = 0; i < NUM_VETOR; i++)

    {
        printf("Digite X (%i) e Y(%i) : ", i, i);
        scanf("%i %i", &X[i], &Y[i]);
    }

    for (i = 0; i < NUM_VETOR; i++)
    {
        printf("X(%i) = %i Y(%i)= %i \n", i, X[i], i, Y[i]);
    }
}

void soma_vetor(int *X, int *Y)
{
    int i = 0, pos_x = 0, pos_y = 0;
    int vetor_soma[20];

    for (i = 0; i < 20; i++)
    {

        if (i % 2 == 0)
        {

            vetor_soma[i] = Y[pos_y];
            pos_y++;
        }
        else
        {
            vetor_soma[i] = X[pos_x];
            pos_x++;
        }
    }

    for (i = 0; i < 20; i++)
    {
        printf("\nVetor soma(%i) = %i  \n", i, vetor_soma[i]);
    }
}
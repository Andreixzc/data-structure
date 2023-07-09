#include <stdio.h>
#include <stdlib.h>
void preencheNotas(float *notas, int n)
{
    int i = 0;
    for (i = 0; i < n; i++)
    {
        printf("VALOR NOTA %i: ", i + 1);
        scanf("%f", &notas[i]);
    }
}
void mediaNotas(float *notas, int n)
{
    float total = 0;
    float media = 0;
    int i = 0;
    int cont = 0;
    for (i = 0; i < 5; i++)
    {
        total = total + notas[i];
    }
    media = total / 5;
    for (int j = 0; j < 5; j++)
    {
        if (notas[j] >= media)
        {
            cont++;
        }
    }
    printf("A media dos alunos foi: %f\n",media);
    printf("\n%i Alunos acima da media\n", cont);
}

int main()
{
    float notas[5];
    preencheNotas(notas, 5);
    mediaNotas(notas, 5);
}
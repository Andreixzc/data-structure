#include <stdio.h>
#include <stdlib.h>
void preencheNotas(float *notas, int n)
{
    int i;
    for (i = 0; i < n; i++)
    {
        printf("Nota do aluno %i\n", i);
        scanf("%f", &notas[i]);
    }
}
void media(float *notas,int n)
{
    int cont = 0;
    int contm = 0;
    int i;
    float media = 0;
    for ( i = 0; i < n; i++)
    {
        cont = cont + notas[i];
    }
    media = cont/10;
    for ( i = 0; i < n; i++)
    {
        if (notas[i] >= media)
        {
            contm++;
        }
        
    }
    printf("A media da sala foi de %f\n",media);
    printf("%i alunos na media\n",contm);
    

}

int main()
{
    float notas[10];
    preencheNotas(notas, 10);
    media(notas,10);
    system("Pause");
}
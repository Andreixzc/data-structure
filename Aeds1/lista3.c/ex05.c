/*Faça um procedimento que recebe a média final de um aluno, identifica e exibe o seu 
conceito, conforme a tabela abaixo. Faça um programa que leia a média de N alunos, 
acionando o procedimento para cada um deles. (N deve ser lido do teclado)*/
#include <stdlib.h>
#include <stdio.h>
void pconceito(int nota)
{
    if (nota <= 39)
    {
        printf("CONCEITO F\n");
    }
    else if (nota >= 40 && nota <= 59)
    {
        printf("CONCEITO E\n");
    }
    else if (nota >= 60 && nota <= 69)
    {
        printf("CONCEITO D\n");
    }
    else if (nota >= 70 && nota <= 79)
    {
        printf("CONCEITO C\n");
    }
    else if (nota >= 80 && nota <= 89)
    {
        printf("CONCEITO B\n");
    }
    else
        printf("CONCEITO A\n");
}

int main()
{
    float nota;
    int i, n;
    printf("Digite a quantidade de alunos:\n");
    scanf("%i", &n);//armazena a quantidade de alunos
    for (i = 1; i <= n; i++)//determina que o loop rodara a mesma quantidade de alunos
    {
        printf("Digite a media final do aluno %i:\n",i);
        scanf("%f", &nota);//armazena a media final do aluno
        pconceito(nota);//aciona o procedimento
    }
    system("pause\n");
}
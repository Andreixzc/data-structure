/*Faça um procedimento que recebe as 3 notas de um aluno por parâmetro e uma letra. Se a 
letra for ‘A’, o procedimento calcula e escreve a média aritmética das notas do aluno, se for 
‘P’, calcula e escreve a sua média ponderada (pesos: 5, 3 e 2). Faça um programa que leia 3 
notas de N alunos e acione o procedimento para cada aluno. (N deve ser lido do teclado)*/
#include <stdio.h>
#include <stdlib.h>
void media(float n1, float n2, float n3, char op, int i)//procedimento que calcula as medias

{
    float res;
    if (op == 'A')
    {
        res = (n1 + n2 + n3) / 3;//media aritimetica
    }
    else if (op == 'P')
    {
        res = (n1 * 5) + (n2 * 3) + (n3 * 2) / 10;//media ponderada
    }
    printf("Media do aluno %i: %f\n", i, res);//printa o resultado
}

int main()
{
    int n, i;
    float n1, n2, n3, resultado;
    char op;
    printf("Digite a quantidade de alunos\n");
    scanf("%i", &n);//armazena a quantidade de alunos
    for (i = 1; i <= n; i++)//loop for que roda de acordo com a quantidade de alunos
    {
        printf("Digite o valor das notas:\n");
        scanf("%f%f%f", &n1, &n2, &n3);//variaveis que armazenam as notas
        fflush(stdin);
        printf("Digite a opcao: [A/P]\n");
        scanf("%c", &op);//armazena a opção
        media(n1, n2, n3, op, i);//chama o procedimento
    }
    system("pause\n");
}
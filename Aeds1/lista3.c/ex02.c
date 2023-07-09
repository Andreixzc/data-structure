/*A prefeitura de uma cidade fez uma pesquisa entre os seus habitantes, coletando dados 
sobre o salário e número de filhos. Faça um procedimento que leia esses dados para um 
número não determinado de pessoas, calcule e exiba a média de salário da população (a
condição de parada pode ser um flag ou a quantidade N). Faça um programa que acione o 
procedimento.*/
#include <stdlib.h>
#include <stdio.h>
void Pmedia()//procedimento para calcular a média do salario
{
    float salario, media, cont = 0, totals = 0;
    char op;
    while (op != 'N')
    {
        printf("Digite o salario\n");
        scanf("%f", &salario);//armazena salario
        cont += 1;//contador com a função de contar o numero de habitantes
        totals = salario + totals;//variavel que armazena o total dos salarios digitados
        fflush(stdin);
        printf("Deseja continuar? S/N\n");
        scanf("%c", &op);//condicao de parada
    }
    media = totals / cont;//calcula a media
    printf("A media do salario dos habitantes eh de %f\n", media);//printa o resultado da media
}
int main()
{
    Pmedia();//aciona o procedimento
    system("pause\n");
}
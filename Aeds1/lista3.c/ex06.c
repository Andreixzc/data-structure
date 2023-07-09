/*Escreva uma função que recebe por parâmetro um valor inteiro e positivo N e retorna o 
valor de S, calculado segundo a fórmula abaixo. 
S = 1 + 1/1! + 1/2! + 1/3! + ...+1 /N!*/
#include <stdio.h>
#include <stdlib.h>
float fatorial(int n)
{
    float e = 1.0,fat;
    int i,j;


    for (i = 1; i <= n; i++)//calcula a soma
    {
        fat = 1;
        for (j = 1; j <= i; j++)//calcula o fatorial
        {

            fat = fat * j;
        }

        e = e + 1.0 / fat;
    }
    return e;
}

int main()
{
    int n;
    float res;
    printf("Digite o valor de N\n");
    scanf("%i", &n);//armazena n
    res = fatorial(n);//armazena o retorno da função na variavel res
    printf("%f\n",res);//printa o resultado
    system("pause\n");
}

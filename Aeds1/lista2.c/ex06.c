/*Escreva um algoritmo que lê um valor n inteiro e positivo e que calcula a seguinte soma: 
S = 1 + 1/2 + 1/3 + 1/4 + ... + 1/n*/

#include <stdlib.h>
#include <stdio.h>
int main()
{
    int n;
    float soma, div, i;
    printf("Digite o valor de N:\n");
    scanf("%i", &n);
    for (i = 1; i <= n; i++) //comando FOR que inicia em 1 e vai até N com o incremento de 1 (incremento da soma do enunciado)
    {
        div = 1 / i;       //dividindo o 1 pelo incremento.
        soma = div + soma; //calculando a soma, que é o resultado da divisão e a soma
        printf("O valor do %.1f termo e de %f\n",i,soma);//Escrever a cada loop o valor da soma, consequentemente de cada termo.
    }
    printf("O valor de S e de %f\n", soma);

    system("pause\n");
}
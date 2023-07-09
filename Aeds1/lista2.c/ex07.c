/*Faça um programa que imprima os L primeiros elementos da série de Fibonacci. Por 
exemplo, se o usuário digitou o número 40, deverão ser apresentados os 40 números da 
sequência na tela*/
#include <stdlib.h>
#include <stdio.h>
int main()
{
    int l, t1 = 0, t2 = 1, i, prox;
    printf("Digite o valor de l\n"); //armazena o valor de termos
    scanf("%i", &l);
    for (i = 1; i <= l; i++)
    {                       //inicia o loop com i valendo 1 e indo ate o numero de termos digitado, com incremento de 1
        printf("%i\n", t1); //mostra o primeiro termo de cada loop
        prox = t1 + t2;     //O termo seguinte sera t1+t2
        t1 = t2;            //proximo passo do loop: passar o valor de t2 pra t1
        t2 = prox;          //passa o valor de t2 pra variavel prox
    }
    system("pause\n");
}

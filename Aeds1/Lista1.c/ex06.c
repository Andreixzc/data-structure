/* Faça um programa para ler os coeficientes de uma equação do primeiro grau (ax + b = 0), 
calcular e escrever a raiz da equação.
Nome: Andrei Gonçalves Rohlfs Massaini
Data de escrita: 08/09/2021*/
#include <stdio.h>
#include <stdlib.h>
int main (){
    float a,b,x;
    printf("Digite o valor de a:\n");
    scanf("%f",&a);
    printf("Digite o valor de b:\n");
    scanf("%f",&b);
    x= -b / a;
    printf("A solucao e %.1f\n",x);
system("pause");

}
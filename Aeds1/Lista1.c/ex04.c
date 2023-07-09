/*Faça um algoritmo que segundo uma nota informada pelo usuário, verifique em qual faixa 
a mesma se encaixa e imprima para o usuário a mensagem correspondente conforme a 
tabela abaixo:
Nome: Andrei Gonçalves Rohlfs Massaini
Data de escrita: 08/09/2021*/
#include <stdio.h>
#include <stdlib.h>
int main (){
    float x;
    printf("Digite sua nota:\n");
    scanf("%f",&x);
    if (x>=8 && x<=10)//Condições para exibir a mensagem//
    printf("OTIMO\n\n\n\n\n\n\n\n");
    else if (x>=7 && x<8)
    printf("BOM\n");
    else if (x>=5 && x<7)
    printf("REGULAR\n");
    else if (x<5)
    printf("INSATISFATORIO\n");
system("pause");   
    
}

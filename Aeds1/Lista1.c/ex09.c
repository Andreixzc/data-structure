/*Fazer um programa para:
• ler um símbolo do teclado;
• identificar com a estrutura SWITCH e mostrar as seguintes mensagens, segundo o 
caso:
o "SINAL DE MENOR"
o "SINAL DE MAIOR"
o "SINAL DE IGUAL"
o "OUTRO SINAL"
Nome: Andrei Gonçalves Rohlfs Massaini
Data de escrita: 08/09/2021
*/
#include <stdio.h>
#include <stdlib.h>
int main (){
    char simbolo;/*variavel que vai armazenar o simbolo*/
    printf("Digite o simbolo:\n");
    scanf("%c",&simbolo);
    switch (simbolo)
    {
    case '<':/*1 caso*/
        printf("sinal de menor\n");
        break;
    case '>':/*2 caso*/
        printf("Sinal de maior\n");
        break;
    case '=':/*3 caso*/
        printf("Sinal de igual\n");
        break;
    
    default:/*prinvar invalido, caso a resposta do usuario não estivar cadastrada nos casos acima*/
        printf("Invalido\n");
        break;
    }
system("pause");   
}
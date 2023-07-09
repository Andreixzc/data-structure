/*Faça um algoritmo que leia 2 números inteiros e faça sua adição. Se o resultado for maior 
ou igual a 10, some 5 a este número. Caso contrário some 7 a ele. Imprima o resultado 
final.
Nome: Andrei Gonçalves Rohlfs Massaini
Data de escrita: 08/09/2021
*/
#include <stdio.h>
#include <stdlib.h>
int main (){
    int x,z,s;
    printf("Digite dois numeros inteiros:\n");
    scanf("%i%i",&x,&z);
    s=x+z;
    if (s>=10)/*condição 1*/
    {
        s+=5;
        printf("A soma dos numeros e maior que 10, somando 5 o resultado fica %i\n",s);
    }else/*condição 2*/
    {
        s+=7;
        printf("A soma dos numeros e menor que 10, somando 7 o resultado fica %i\n",s);
  
    }
system("pause");}
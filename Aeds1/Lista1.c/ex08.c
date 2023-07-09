/*Construa um programa que lê uma opção conforme abaixo (usar estrutura SWITCH) e o 
salário atual do funcionário, calcula e exibe o novo salário:
 A = aumento de 8% no salário;
 B = aumento de 11% no salário;
 C = aumento fixo no salário 
(de R$ 350,00 se o salário atual for até R$ 1000 e de R$ 200,00 se o salário atual for 
maior que R$ 1000).
Nome: Andrei Gonçalves Rohlfs Massaini
Data de escrita: 08/09/2021*/
#include <stdlib.h>
#include <stdio.h>
int main (){
    char x;/*variavel que armazena a opção do usuario*/
    float salario;
    printf("Digite o salario atual:\n");
    scanf("%f",&salario);
    fflush(stdin);/*comando pra limpar o buffer do teclado, porque estava dando erro*/
    printf("\nA = 8 porcento de aumento\nB = 11 porcento de aumento\nC = Aumento fixo\n");
    scanf("%c",&x);
switch (x){
case 'a':/*Primeira opção, aumentar 8%*/
    salario+= salario*0.08;
    printf("O Salario e %.1f",salario);
    break;
case 'b':/*segunda opção, aumentar 11%*/
    salario+= salario*0.11;
    printf("o salario e de %.1f\n",salario);
case 'c':/*terceira opção, aumentoi fixo*/
    if (salario<=1000)
    {
        salario+=350;
        printf("O salario e %.1f\n",salario);
    }else{
        salario+=200;
        printf("O salario e %.1f\n",salario);
    }default:
    break;}
system("pause");   
}
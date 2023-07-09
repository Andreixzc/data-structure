/*Faça uma função que recebe um valor inteiro e verifica se o valor é positivo ou negativo. 
A função deve retornar um valor lógico (true ou false). Faça um programa que lê N 
números e para cada um deles exibe uma mensagem informando se ele é positivo ou não, 
dependendo se foi retornado verdadeiro ou falso pela função.*/
#include <stdio.h>
#include <stdlib.h>
int func(int n)
{
  if (n > 0)//condição true caso n for maior que 1
    return 1;
  else
    return 0;//false caso for menor que 1
}

int main()
{
  int num;
  char op;
  while (op != 'N')
  {
    printf("Digite o numero:\n");
    scanf("%i", &num);//armazena num
    fflush(stdin);
    if (func(num)==1)//caso o retorno for igual a 1 
    {
      printf("Numero positivo\n");
    }
    else
    {
      printf("Numero negativo\n");//caso não for maior que 1
    }

    printf("Deseja continuar? S/N\n");
    fflush(stdin);
    scanf("%c", &op);//armazena char que indica se o comando deve continuar
    system("pause");
  }
}
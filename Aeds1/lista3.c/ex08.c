/*Escreva uma função que recebe por parâmetro um valor inteiro e positivo N e retorna o 
valor de S, calculado segundo a fórmula abaixo. 
S = 2/4 + 5/5 + 10/6 + 17/7 + 26/8 + ... +(n2+1)/(n+3*/
#include <stdio.h>
#include <stdlib.h>

float soma(float n)
{
  float s = 0;
  float i = 2, j = 2, f = 4, l = 2;

  for (i = 1; i <= n; i++)//loop for que vai ate n
  {
    s = s + (j / f) + (((n * n) + 1) / (n + 3));
    f = f + 1;
    j = j + i + l;
    l = l + 1;
  }
  return s;//retorna a soma
}

int main()
{
  float n;
  float retorno;//variavel que armazena o retorno da função

  printf("Digite um valor inteiro e positivo:\n");
  scanf("%f*c", &n);

  retorno = soma(n);//acionamente da funcao

  printf("\nA soma dos valores e: %2.2f\n", retorno);

  system("pause\n");
}
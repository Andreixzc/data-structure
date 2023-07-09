#include <stdio.h>
#include <stdlib.h>
int main()
{
  int n, i, j;
  float fat, e = 1.0;
  printf("Digite o valor de N\n");
  scanf("%i", &n);
  for (i = 1; i <= n; i++)//comando for que calcula a soma
  {
    fat = 1;
    for (j = 1; j <= i; j++)//comando for que calcula o fatorial
    {

      fat = fat * j;
    }

    e = e + 1.0 / fat;//resultado conforme a formula do enunciado
  }
  printf("o valor de E: %f\n", e);
  system ("pause\n");
}
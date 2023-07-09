#include <stdio.h>
#include <stdlib.h>

int tam(int *arr)
{
  return sizeof(arr) / sizeof(arr[0]);
}

void fill(int *x, int n)
{
  int i;
  for (i = 0; i < n; i++)
  {
    printf("VALOR:\n");
    scanf("%d", &x[i]);
  }
}

int *vale(int x[], int n)
{
  int negativocont = 0;
  int *negativos = malloc(sizeof(int) * n);
  int i;

  for (i = 0; i < n; i++)
  {
    negativos[i] = 0;
    if (x[i] < 0)
    {
      negativos[negativocont] = x[i];
      negativocont++;
    }
  }

  printf("negativocont: %d", negativocont);

  int *retorno = malloc(sizeof(int) * negativocont);

  negativocont = 0;
  for (i = 0; i < n; i++)
  {
    if (negativos[i] < 0)
    {
      retorno[negativocont] = negativos[i];
      negativocont++;
    }
  }

  return retorno;
}

int main()
{
  int x[5];
  fill(x, 5);
  int *resultado = vale(x, 5);
  printf("tam: %d", tam(resultado));
  printf("sizeof: %d", sizeof(resultado));
  for (int i = 0; i < tam(resultado); i++)
  {
    printf("%i\n", resultado[i]);
  }
}
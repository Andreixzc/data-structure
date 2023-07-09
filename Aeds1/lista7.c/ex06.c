#include <stdio.h>
#include <stdlib.h>

int tam(int *arr, int maxSize)
{
  int count = 0;
  for (int i = 0; i < maxSize; i++)
  {
    if (arr[i] < 0)
    {
      count++;
    }
  }
  return count;
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
  int *negativos = (int *)calloc(n, sizeof(int));
  int i;

  for (i = 0; i < n; i++)
  {
    if (x[i] < 0)
    {
      negativos[negativocont] = x[i];
      negativocont++;
    }
  }

  int *retorno = (int *)calloc(negativocont, sizeof(int));

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
  for (int i = 0; i < tam(resultado, 5); i++)
  {
    printf("%i\n", resultado[i]);
  }
}
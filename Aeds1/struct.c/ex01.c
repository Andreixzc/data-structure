#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

struct registro
{
  char nome[40];
  int mes;
  int dia;
};

struct nomesMes
{
  int mes;
  struct registro pessoa[40];
  int total;
};

int main()
{
  char nome[20];
  srand(time(NULL));
  struct nomesMes mesPessoas[12];
  struct registro registros[40];

  for (int i = 0; i < 12; i++)
  {
    mesPessoas[i].mes = i + 1;
    mesPessoas[i].total = 0;
  }

  for (int i = 0; i < 40; i++)
  {
    // printf("Nome:");
    // scanf("%s", pessoas[i].nome);
    // scanf("%i", &pessoas[i].mes);
    // scanf("%i", &pessoas[i].dia);
    if (i % 2 == 0)
      strcpy(registros[i].nome, "Jane");//Coloquei os nomes fixos entre 'jane' e 'lucy' pra ficar mais fácil testar o programa
    else
      strcpy(registros[i].nome, "Lucy");
    registros[i].dia = rand() % (28 + 1 - 1) + 1;
    registros[i].mes = rand() % (12 + 1 - 1) + 1;


    
  }

  printf("***************************************************************************************************\n");

  int aux;
  for (int i = 0; i < 40; i++)
  {
    for (int j = 1; j <= 12; j++)
    {
      aux = j - 1;
      if (registros[i].mes == j)
      {
        mesPessoas[aux].pessoa[mesPessoas[aux].total] = registros[i];
        mesPessoas[aux].total++;
        break;
      }
    }
  }

  for (int i = 0; i < 12; i++)
  {
    aux = mesPessoas[i].total;
    printf("*******************************************************************\n");
    printf("Mes: %d\n", mesPessoas[i].mes);
    for (int j = 0; j < aux; j++)
    {
      printf("Nome: %s\n", mesPessoas[i].pessoa[j].nome);
      printf("Dia: %d\n", mesPessoas[i].pessoa[j].dia);
    }
  }
}
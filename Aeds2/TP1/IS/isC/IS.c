#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdbool.h>
#include <stdlib.h>
bool vogal(char str[])
{
    int n = strlen(str);
    int cont = 0;
    for (int i = 0; i < n; i++)
    {
        if (str[i] == 'a' || str[i] == 'e' || str[i] == 'i' || str[i] == 'o' || str[i] == 'u' || str[i] == 'A' || str[i] == 'E' || str[i] == 'I' || str[i] == 'O' || str[i] == 'U')
        {
            cont++;
        }
    }
    if (cont == n)//se o contador se igualar com o comprimento da string, conclui-se que ela é composta apenas por vogais.
    {
        return true; // Composta só de vogais
    }
    else
    {
        return false; // Não composta somente por vogais
    }
}
bool consoante(char str[])
{
    int n = strlen(str);
    int cont = 0;
    for (int i = 0; i < n; i++)//Compara se a string contem vogal ou número.
    {
        if (str[i] == 'a' || str[i] == 'e' || str[i] == 'i' || str[i] == 'o' || str[i] == 'u' || str[i] == 'A' || str[i] == 'E' || str[i] == 'I' || str[i] == 'O' || str[i] == 'U'||str[i]>'0' && str[i]<'9')
        {
            cont++;//Se sim, contador aumenta em 1;
        }
    }
    if (cont > 0)
    {
        return false;//Se o contador é maior que zero, conclui-se que a string possui vogal ou número.
    }
    else
    {
        return true;
    }
}
bool inteiro(char str[])
{
    for (int i = 0; str[i] != '\0'; i++)
    {
        if (isdigit(str[i]) == 0)
            return false; // não é int
    }
    return true; //é int
}
bool real(char str[])
{
    char *p;
    double converted = strtod(str, &p);//Função que tenta converter a string em double.
    if (*p)//A função retorna um ponteiro, que aponta pra primeira posição do começo da string no formato ASCII.
            //Sendo assim, se o conteudo de *p for diferente de 0, conclui-se que o input contem letras, logo ele não é um numero real.
    {
        return false;
    }
    else
    {
        return true;
    }
}
int main()
{
    char str[1000];
    char fim[100] = "FIM";//Vetor que armazena a condição de parada
    int resaux = 1;
    while (resaux != 0)
    {
        resaux = strcmp(str, fim);//Compara o input com a condição de parada
        if (resaux == 0)
        {
            break;
        }
        else
        {
            scanf("%[^\n]%*c", str);
            int res1 = vogal(str);
            int res2 = consoante(str);
            int res3 = inteiro(str);
            int res4 = real(str);
            switch (res1)//Printa os resultados de acordo com o retorno das funções.
            {
            case 0:
                printf("NAO ");
                break;

            case 1:
                printf("SIM ");
                break;
            }
            switch (res2)
            {
            case 0:
                printf("NAO ");
                break;

            case 1:
                printf("SIM ");
                break;
            }
            switch (res3)
            {
            case 0:
                printf("NAO ");
                break;

            case 1:
                printf("SIM ");
                break;
            }
            switch (res4)
            {
            case 0:
                printf("NAO \n");
                break;

            case 1:
                printf("SIM \n");
                break;
            }
        }
    }
}
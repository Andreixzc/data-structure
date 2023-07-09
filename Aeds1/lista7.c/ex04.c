#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void menor_maior(int *janeiro);

int media(int *janeiro);

void abaixo(int *janeiro, int media);

int main(void)
{

    int janeiro[31], i = 0;
    int temp = 0;
    int media_temp = 0;

    for (i = 0; i < 31; i++)
    {
        temp = (15 + rand() % 40);
        if (temp > 40)
        {
            temp = temp - 15;
            janeiro[i] = temp;
        }
        else
        {
            janeiro[i] = temp;
        }
    }

    for (i = 0; i < 31; i++)
    {
        printf("Temperatura dia(%i):%i\n", i + 1, janeiro[i]);
    }

    menor_maior(janeiro);

    media_temp = media(janeiro);

    abaixo(janeiro, media_temp);

    system("pause");
    return 0;
}

void menor_maior(int *janeiro)
{
    int i, menor = 1000000, maior = 0;

    for (i = 0; i < 31; i++)
    {
        if (menor > janeiro[i])
        {
            menor = janeiro[i];
        }
        if (maior < janeiro[i])
        {
            maior = janeiro[i];
        }
    }
    printf("\nMaior temperatura: %i\n", maior);
    printf("\nMenor Temperatura: %i\n", menor);
}

int media(int *janeiro)
{
    int i = 0, soma_total = 0, media_temp = 0;

    for (i = 0; i < 31; i++)
    {
        soma_total += janeiro[i];
    }

    media_temp = soma_total / 31;
    printf("\nA temperatura media eh de%i\n", media_temp);

    return media_temp;
}

void abaixo(int *janeiro, int media)
{
    int i;
    int inferior_media = 0;

    for (i = 0; i < 31; i++)
    {
        if (janeiro[i] < media)
        {
            inferior_media++;
        }
    }
    printf("\n\nO numero de dias nos quais a temperatura foi inferior a temperatura média: %i\n\n", inferior_media);
    system("pause");
}
/*Faça um programa que receba dez números e verifique se eles são divisíveis por 3 e 9 (ao 
mesmo tempo), por 2 e por 5. Caso algum número não seja divisível por nenhum desses 
números mostre a mensagem “Número não é divisível pelos valores”. Apresente também 
ao final a quantidade de números divisíveis por 3 e 9, por 2 e por 5*/
#include <stdio.h>
#include <stdlib.h>
int main()
{
    int cont = 1, entrada = 0, div39 = 0, div2 = 0, n = 0, div5 = 0, div25 = 0;
    while (cont <= 10)
    {
        printf("Digite o %io numero\n", cont);
        scanf("%i", &entrada);
        cont += 1;
        if (entrada % 3 == 0 && entrada % 9 == 0)//checa o resto da divisão, se for divisivel por 3 e 9
        {
            div39 += 1;
            printf("Numero e divisivel por 3 e 9 ao mesmo tempo\n");
        }
        else if (entrada % 2 == 0 && entrada % 5 == 0)//se for divisivel por 2 e 5 
        {
            div25 += 1;
            printf("Numero e divisivel por 2 e 5\n");
        }
        else if (entrada % 2 == 0)//se for divisivel por 2 somente.
        {
            div2 += 1;
            printf("Numero e divisivel por 2\n");
        }
        else if (entrada % 5 == 0)//somente dividido por 5
        {
            div5 += 1;
            printf("numero e divisivel por 5\n\n\n");
        }

        else
            printf("Numero nao e divisivel por nenhum dos numeros\n");
    }

    printf("Numeros divisiveis por 3 e 9: %i\n", div39);
    printf("Numeros divididos por 2 : %i\n", div2);
    printf("Numeros divididos por 5: %i\n", div5);
    printf("Numeros divisiveis por 2 e 5: %i\n", div25);
    system("pause\n");
}
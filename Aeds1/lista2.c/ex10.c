/*Em uma eleição presidencial existem quatro candidatos. Os votos são informados através 
de códigos. Os dados utilizados para a contagem dos votos obedecem à seguinte 
codificação: 
1,2,3,4 = voto para os respectivos candidatos;
5 = voto nulo; 
6 = voto em branco;
Elabore um algoritmo que leia o código do candidado em um voto. Calcule e escreva:
- total de votos para cada candidato; 
- total de votos nulos; 
- total de votos em branco.
 
Como finalizador do conjunto de votos, tem-se o valor 0*/
#include <stdio.h>
#include <stdlib.h>
int main()
{
    int c1 = 0, c2 = 0, c3 = 0, c4 = 0, nulo = 0, branco = 0, voto = 1;
    while (voto > 0)
    {
        printf("Em qual canditado deseja votar?\n");
        scanf("%i", &voto);
        if (voto == 1)//caso voto for igual a 1, armazena na variavel c1
            c1 += 1;
        else if (voto == 2)//caso voto for igual a 2, armazena na variavel c2
        {
            c2 += 1;
        }
        else if (voto == 3)//caso voto for igual a 3, armazena na variavel c3
        {
            c3 += 1;
        }
        else if (voto == 4)//caso voto for igual a 4, armazena na variavel c4
        {
            c4 += 1;
        }
        else if (voto == 5)//caso voto for igual a 5, armazena na variavel nulo
        {
            nulo += 1;
        }
        else if (voto == 6)////caso voto for igual a 6, armazena na variavel branco
        {
            branco += 1;
        }
    }
    printf("votos no candidato 1:%i\n", c1);
    printf("votos no canditado 2:%i\n", c2);
    printf("votos no canditado 3:%i\n", c3);
    printf("votos no canditado 4:%i\n", c4);
    printf("votos nulo:%i\n", nulo);
    printf("votos em branco:%i\n", branco);
    system("pause\n");
}
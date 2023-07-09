/*A prefeitura de uma cidade fez uma pesquisa entre seus habitantes, coletando dados sobre o 
salário e número de filhos de cada habitante. A prefeitura deseja saber: 
a) média do salário da população; 
b) média do número de filhos; 
c) maior salário; 
d) percentual de pessoas com salário até R$100,00. 
O final da leitura de dados se dará com a entrada de um salário negativo.
Nome: Andrei Gonçalves Rohlfs Massaini*/


#include <stdio.h>
#include <stdlib.h>
int main()
{
    float salario = 0, hab, filho, totals, totalf, negativo, msalario, s100, percentual, mfilho, maior = 0;
    while (1)
    {
        printf("Digite seu salario\n");
        scanf("%f", &salario);      //armazena o salario
        totals = +salario + totals; //incremento pra determinar a somatoria de todos os salarios digitados pelo usuario
        if (salario > maior)
        {                    //checa se o salario é maior do que o anterior (dentro do loop)
            maior = salario; //armazena o maior salario
        }
        if (salario > 0 && salario <= 100)
        {              //condicao pra contar o numero de pessoas com salario de ate 100 reais
            s100 += 1; //contador pra saber quantas pessoas tem o salario de ate 100 reais
        }
        if (salario < 1)
        {
            negativo = +salario + negativo; //variavel que armazena qual foi o valor negativo digitado pelo usuario,pra no final subtrair do total.
            break;
        } //caso numero digitado for negativo, o programa para
        printf("Digite a quantidade de filhos\n");
        scanf("%f", &filho);
        totalf = +filho + totalf;        //incremento pra que soma  a quantidade total de filhos
        hab += 1;                        //contador de habitantes. (aumenta em 1 a cada loop)
        percentual = (s100 * 100) / hab; //formula pra calcular o percentual de habitantes que recebem ate 100 reais de salrio
        msalario = totals / hab;         //formula da media do salario
        mfilho = totalf / hab;           //formula calcular media de filhos
    }
    printf("A media de salario da populacao e de %.2f\n", msalario);
    printf("A media do numero de filhos e de %.2f\n", mfilho);
    printf("O maior salario e de %.2f reais\n", maior);
    printf("O percentual de pessoas com o salario de ate 100 reais e de %.2f porcento\n", percentual);

    system("pause\n");
}
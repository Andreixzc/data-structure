/*Faça uma função que recebe a idade de um nadador por parâmetro e retorna a categoria 
desse nadador de acordo com a tabela abaixo.*/
#include <stdlib.h>
#include <stdio.h>
char categoria(int idade)
{
    char res;//variavel que vai armazenar a categoria do nadador
    if (idade >= 5 && idade <= 7)
    {
        res = 'F';
    }
    else if (idade >= 8 && idade <= 10)
    {
        res = 'E';
    }
    else if (idade >= 11 && idade <= 13)
    {
        res = 'D';
    }
    else if (idade >= 14 && idade <= 15)
    {
        res = 'C';
    }
    else if (idade >= 16 && idade <= 17)
    {
        res = 'B';
    }
    else
    {
        res = 'A';
    }
    return res;
}

int main()
{
    int idade;//variavel que recebe idade
    char resultado;//variavel que imprive o return da função
    printf("Digite a idade do nadador\n");
    scanf("%i", &idade);
    resultado = categoria(idade);//armazena o retorno da função na variavel resultado
    printf("%c\n",resultado);//printa o resultado
    system("pause\n");
}
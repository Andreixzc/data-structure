/*Faça um algoritmo que leia o ano de nascimento de uma pessoa e calcule sua idade, 
considerando o ano atual. Para verificar se já fez aniversário no ano atual pergunte se a 
pessoa já fez aniversário, sendo que ela pode entrar com a informação "S"(sim) ou "N" 
(não). Com isto é possível se ter maior precisão sobre a idade. Verifique também se a 
pessoa já tem idade para conseguir Carteira de Habilitação (18 anos ou mais) e imprima a 
mensagem referente a esta checagem. Imprima a idade da pesso
Nome: Andrei Gonçalves Rohlfs Massaini
Data de escrita: 08/09/2021*/

#include <windows.h>/* Biblioteca pra pegar o ano atual do sistema, e funcionar em qualquer ano*/
#include <stdio.h>
#include <stdlib.h>
int main (){
    SYSTEMTIME ano;
    GetLocalTime (&ano);
int idade,s,nas;
char aniversario;
printf("Digite o seu ano de nascimento:\n");
scanf("%i",&nas);
idade=ano.wYear - nas;//Formula pra calcular a idade//
printf("Voce ja fez aniversario? S (sim) ou N (nao)  \n");
fflush(stdin);
scanf("%c",&aniversario);


if (aniversario=='n'){//caso usuario não tiver feito aniversario, subtrair 1 ano na idade.
    idade-=1;
    printf("idade e %i\n",idade);
    if (idade>=18){
        printf("voce tem idade pra tirar cnh\n");
    }
}
else if (aniversario=='s'){//caso o usuario tiver feito aniversario, imprime a idade sem a subtração
    printf("idade e %i\n",idade);
    if (idade>=18){
        printf("voce tem idade pra tirar cnh\n");
    }

}
system("pause");







}
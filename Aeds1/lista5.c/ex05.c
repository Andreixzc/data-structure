/*Escreva um programa em C que declare variáveis para armazenar um valor inteiro, um valor 
real e um caracter. Deve existir no programa ponteiros associados a cada um deles. O 
programa deve solicitar novos dados para as variáveis e elas devem ser modificadas usando 
os respectivos ponteiros. Exiba os endereços e os conteúdos de todas as variáveis e ponteiros
antes e após a alteração.*/
#include <stdio.h>
#include <stdlib.h>
int main()
{
    int n1;
    float n2;
    char n3;
    int *aptrn1;
    float *aptrn2;
    char *aptrn3;
    aptrn1 = &n1;
    aptrn2 = &n2;
    aptrn3 = &n3;
    for (int i = 0; i < 5; i++)
    {
        printf("Valor inteiro:\n");
        scanf("%i", &n1);
        printf("O endereco eh %i e o conteudo eh %i\n",&aptrn1,*aptrn1);
        printf("Valor Real:\n");
        scanf("%f", &n2);
        printf("O endereco eh %i e o conteudo eh %f\n",&aptrn2,*aptrn2);
        fflush(stdin);
        printf("Caracter:\n");
        scanf("%c", &n3);
        printf("O endereco eh %i e o conteudo eh %c\n",&aptrn3,*aptrn3);
    }
    system("pause");
}

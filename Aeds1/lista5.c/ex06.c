#include <stdio.h>
#include <stdlib.h>
int main ()
{
    printf("No primeiro codigo o comando for incrementa o  conteudo do ponteiro, enquanto no segundo codigo o comando for incrementa o endereco do ponteiro.\n");
    printf("No primeiro codigo o valor impresso eh 15, pois  o comando for esta incrementando 5 ao valor inicial de ptr (10).\n");
    printf("No segundo codigo o valor exibido eh o endereco de ptr com incremento de 5 posicoes na memoria, por se tratar de um int que tem o valor de 4 bytes, o valor imprimido seria o endereco inicial + 20.\n");
    system("pause");

}
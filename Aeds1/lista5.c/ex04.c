/*Identifique o erro no programa a seguir, de modo que seja exibido o valor 10 na tela.*/
#include <stdio.h>
#include <stdlib.h>
int main ()
{
    int x, *p, **q;
    p = &x;
    q = &p;
    x = 10;
    printf("\n%d\n",**q);//Deve se indicar o conteudo que o ponteiro q aponta, colocando 2 asteriscos;
    system("pause");
}   
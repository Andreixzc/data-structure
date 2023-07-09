#include <stdio.h>
#include <stdlib.h>
int main()
{
    int n1, n2;
    printf("Primeiro valor:\n");
    scanf("%i", &n1);
    printf("Segundo valor:\n");
    scanf("%i", &n2);
    if (&n1 > &n2)
    {
        printf("%p\n",&n1);
    }
    else
    printf("%p\n",&n2);
    system("pause\n");
    
}
#include <stdio.h>

void imprimen(int r)
{
    for (int j = 1; j<=r; j++)
    {
        printf("  %i  ",j);
    }
    printf("\n");
    
}

int main()
{
    int n;
    n = 5;
    for (int i = 1; i <=n; i++)
    {
        imprimen(i);
    }
    
}
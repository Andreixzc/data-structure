#include <stdio.h>
#include <stdlib.h>
void intercalaVetor(int *v1, int *v2, int *v3, int n)
{
    int i = 0;
    int j = 0;
    for (i = 0; i < 10; i++)
    {
        v3[i * 2] = v1[i];
    }
    for (i = 0; i < 10; i++)
    {
        v3[i * 2 + 1] = v2[i];
    }
}
int main()
{
    int v1[5] = {1, 3, 5, 7, 9};
    int v2[5] = {2, 4, 6, 8, 10};
    int v3[10];
    intercalaVetor(v1, v2, v3, 5);
}
#include <stdio.h>
#include <stdlib.h>
void swap(int *xp, int *yp)
{
    int temp = *xp;
    *xp = *yp;
    *yp = temp;
}


 
void selectionSort(int vet[], int n)
{
    for (int i = 0; i < n; i++)
    {
        int menor = i;
        for (int j = i+1; j < n; j++)
        {
            if (vet[j] < vet[i])
            {
                menor = j;
            }
            
            
        }
        swap(&vet[menor], &vet[i]);
        
    }
    
}
 

void printArray(int arr[], int size)
{
    int i;
    for (i=0; i < size; i++)
        printf("%d ", arr[i]);
    printf("\n");
}
int main ()
{
    int vet[] = {2,5,1,8,5,7,2};
    size_t n = sizeof(vet)/sizeof(vet[0]);
    selectionSort(vet,n);
    printArray(vet,n);
    
    
    
    
    
}

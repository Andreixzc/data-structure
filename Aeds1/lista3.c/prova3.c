#include <stdio.h>
#include <stdbool.h>



bool triangulo(int X ,int Y ,int Z ){

    if ((X > Y + Z)||(Y> Z + X)||(Z>Y +X))
    {
        return false;   
          
    }else{ 
        return true;
    
    }
}    

void menu(int X ,int Y ,int Z ){

       
       if ((X == Y)&&(X==Z))
       {
         printf("Triangulo equilatero ");
       }else if ((X==Y)||(X==Z))
       {
           printf("Triangulo isosceles");
       }else if ((X != Y)&&(X != Z))
       {
           printf("Triangulo escaleno ");
       }

    
    
   

}

int main(void){
     
    int X = 0,Y = 0,Z = 0;
    int escolha = 0 ;
    bool triangulo_valido;
  
    while (escolha <5)
    {
        escolha++;
        
        printf("\nDigite o 3 valores para lados de um triangulo (positivos e não nulos):\n");
        scanf("%d %d %d",&X,&Y,&Z);
        
        if ((X>0)&&(Y>0)&&(Z>0))
        {
           triangulo_valido =  triangulo(X,Y,Z);

           if (triangulo_valido == true)
           {
               menu(X,Y,Z);
            }else{
            
            printf("\nNão forma um triangulo");
              }            
            
        }else{
            printf("valores invalidos");
        }
           

    
        

        
        
    }
    
    

    return 0;
}
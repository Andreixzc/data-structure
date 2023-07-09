#include <stdio.h>
#include <string.h>
#include <stdbool.h>
void isPalindrome(char str[])
{
	int inicio = 0;
	int fim = strlen(str) - 1;
	while (fim > inicio)
	{
		if (str[inicio++] != str[fim--])
		{
			printf("NAO\n");
			return;
		}
	}
	printf("SIM\n");
}
int main()
{
    char str[1000];
    char aux[1000] = "FIM";
    int res = 1;
    while (res != 0)
    {
        scanf ("%[^\n]%*c", str);
        // scanf("%s",str);
        res = strcmp(str,aux);
        if (res == 0)
        {
            break;
        }
        else
        {
            isPalindrome(str);
        }
    }
    

	return 0;
}

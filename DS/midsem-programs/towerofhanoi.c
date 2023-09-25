#include <stdio.h>

int toh (int n, char A, char B, char C)
{
    static int cnt = 0;
    // n is number of discs
    if (n==1)
    {   printf("Move disc from %c to %c\n", A, C);
        cnt++;
    }
    else
    {
        // A to B using C
        toh(n - 1, A, C, B);
        cnt++;
        printf("Move disc from %c to %c\n", A, C);
        // B to C using A
        toh(n - 1, B, A, C);
    }
    return cnt;
}

int main()
{
    printf("#discs: "); int n;
    scanf("%d", &n);
    int cnt = toh(n, 'A', 'B', 'C');
    printf("%d", cnt);
}
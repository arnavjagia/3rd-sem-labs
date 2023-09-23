/*
Create a structure as shown: struct DISTANCE {int feet; float inch;};
In main(), create pointers to the above struct and allocate memory using dynamic 
memory allocation. Read in and store values of distances d1and d2. Find the sum of 
the two distance values using function:
void addDist (struct DISTANCE *d1, struct DISTANCE *d2, struct DISTANCE
*result); Display the value of result in main()
*/

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<ctype.h>

typedef struct
{
    int feet;
    float inch;
} Distance;

void addDist(Distance *d1, Distance *d2, Distance *result);
void read(Distance *d);

int main()
{
    Distance *d1, *d2, *result;
    d1 = (Distance *)malloc(sizeof(Distance));
    d2 = (Distance *)malloc(sizeof(Distance));
    result = (Distance *)malloc(sizeof(Distance));

    read(d1);
    read(d2);
    addDist(d1, d2, result);
    printf("Result\nSum of d1 and d2 is %d feet and %.2f inches\n", result->feet, result->inch);

    return 0;
}

void read(Distance *d)
{
    printf("Feet: "); scanf("%d", &d->feet);
    printf("\nInches: "); scanf("%f", &d->inch);
}

void addDist(Distance *d1, Distance *d2, Distance *result)
{
    result->feet = d1->feet + d2->feet;
    result->inch = d1->inch + d2->inch;
}

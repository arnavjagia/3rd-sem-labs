/*
Define a structure stack
Functions 
push
pop
display
*/

#include<stdio.h>
#include<stdlib.h>
#define SIZE 50

typedef struct
{
    int arr[SIZE];
    int top;
} stack;

void push(stack *, int);
int pop(stack *);
int isfull(stack *);
int isempty(stack *);
void display(stack *);


void push(stack *s, int ele)
{
    if (isfull(s)) {printf("Stack overflow"); return;}
    s->arr[++s->top] = ele;
}

int pop(stack *s)
{
    if (isempty(s)) {printf("Stack Underflow"); return 999;}
    return s->arr[s->top--];
}

int isfull(stack *s)
{
    return s->top >= SIZE;
}

int isempty(stack *s)
{
    return s->top == -1;
}

void display(stack *s)
{
    if (isempty(s)) {
        printf("Stack is empty.\n");
        return;
    }
    printf("Stack: ");
    for (int i = 0; i <= s->top; i++)
        printf("%d ", s->arr[i]);
    printf("\nTop: %d\n", s->top);
}
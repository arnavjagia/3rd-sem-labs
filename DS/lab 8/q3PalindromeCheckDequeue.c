/*
Write a program to check whether given string is a palindrome using a dequeue.
*/

#include <stdio.h>
#include <stdlib.h>
#define MAX 30

typedef struct
{
    char *data[MAX];
    int rear, front;
} dequeue;

void initialize(dequeue *p) { p->rear = p->front = -1; }
int empty(dequeue *p) { return (p->rear == -1); }
int full(dequeue *p) { return ((p->rear + 1) % MAX == p->front); }

void enqueueR(dequeue *p, char *x)
{
    if (full(p))
    {
        printf("Queue is full\n");
        return;
    }
    if (empty(p))
    {
        p->rear = 0;
        p->front = 0;
    }
    else
        p->rear = (p->rear + 1) % MAX;
    p->data[p->rear] = x;
}

void enqueueF(dequeue *p, char *x)
{
    if (full(p))
    {
        printf("Queue is full\n");
        return;
    }
    if (empty(p))
    {
        p->rear = 0;
        p->front = 0;
    }
    else
        p->front = (p->front - 1 + MAX) % MAX;
    p->data[p->front] = x;
}

char *dequeueF(dequeue *p)
{
    char *x;
    if (empty(p))
    {
        printf("Queue is empty\n");
        exit(0);
    }
    x = p->data[p->front];
    if (p->rear == p->front)
        initialize(p);
    else
        p->front = (p->front + 1) % MAX;
    return x;
}

void display(dequeue *p)
{
    int i;
    if (empty(p))
    {
        printf("Queue is empty\n");
        return;
    }
    printf("Contents of queue are:\n");
    for (i = p->front; i != p->rear; i = (i + 1) % MAX)
        printf("%s\n", p->data[i]);
    printf("%s\n", p->data[i]);
}

int isPalindrome(dequeue *p)
{
    int i;
    if (empty(p))
    {
        printf("Queue is empty\n");
        return 999;
    }
    for (i = p->front; i != p->rear; i = (i + 1) % MAX)
    {
        int otherend = (p->rear - i + MAX) % MAX;
        if (p->data[i] != p->data[otherend])
            return 0;
    }
    return 1;
}

int main()
{
    dequeue q;
    initialize(&q);
    enqueueR(&q, "l");
    enqueueR(&q, "e");
    enqueueR(&q, "v");
    enqueueR(&q, "e");
    enqueueR(&q, "l");
    display(&q);
    isPalindrome(&q) ? printf("Palindrome\n") : printf("Not palindrome\n");

    return 0;
}
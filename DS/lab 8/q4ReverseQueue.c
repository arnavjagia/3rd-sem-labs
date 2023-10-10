/*
4)	Given a queue of integers, write a program to reverse the queue, using only the following operations:
i.	enqueue(x): Add an item x to rear of queue.
ii.	dequeue() : Remove an item from front of queue.
iii.	empty() : Checks if a queue is empty or not.
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
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

void reverseQueue(dequeue *p)
{
    char *temp;
    int i, j;
    if (empty(p))
    {
        printf("Queue is empty\n");
        return;
    }
    for (i = p->front, j = p->rear; i < j; i = (i+1) % MAX, j = (j+MAX-1) % MAX)
    {
        temp = p->data[i];
        p->data[i] = p->data[j];
        p->data[j] = temp;
    }
}

int main()
{
    dequeue q;
    initialize(&q);
    enqueueR(&q, "a");
    enqueueR(&q, "b");
    enqueueR(&q, "c");
    enqueueR(&q, "d");
    display(&q);
    reverseQueue(&q);
    display(&q);
    return 0;
}
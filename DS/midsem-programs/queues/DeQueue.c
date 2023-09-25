/*
Circular queue
*/

#include <stdio.h>
#include <stdlib.h>
#define SIZE 6

typedef struct
{
    int item[SIZE], front, rear;
} Queue;

Queue *createQ()
{
    Queue *q = (Queue *)malloc(sizeof(Queue));
    q->front = q->rear = 0;
    return q;
}

void addQR(Queue *q, int element)
{
    int x = q->rear;
    q->rear = (q->rear + 1) % SIZE;
    if (q->front == q->rear) { q->rear = x; printf("\nQueue is Full\n"); return;}
    q->item[q->rear] = element;
}

void addQF(Queue *q, int element)
{
    int x = q->rear;
    x = (x + 1) % SIZE;
    if (q->front == x) { printf("\nQueue is full\n"); return; }
    q->item[q->front] = element;
    q->front = (q->front + SIZE - 1) % SIZE;
}

int deleteQR(Queue *q)
{
    if (q->front == q->rear) { printf("\nQueue is empty"); return 999; }
    int x = q->rear;
    q->rear = (q->rear + SIZE - 1) % SIZE;
    return x;
}

int deleteQF(Queue *q)
{
    if (q->front == q->rear) { printf("Queue is Empty\n"); return 999;}
    q->front = (q->front + 1) % SIZE;
    return q->item[q->front];
}

void displayQ(Queue *q)
{
    printf("\nCircular Queue: ");
    for (int i = q->front + 1; i <= q->rear; i++)
        printf("%d ", q->item[i]);
    if (q->front > q->rear)
    {
        for (int i = q->front+1; i < SIZE; i++)
            printf("%d ", q->item[i]);
        for (int i = 0; i <= q->rear; i++)
            printf("%d ", q->item[i]);
    }
}

int main()
{
    Queue *q = createQ();
    displayQ(q);
    addQR(q, 1);
    addQR(q, 2);
    addQF(q, 3);
    addQF(q, 4);
    // addQR(q, 3);
    // addQR(q, 4);
    // addQR(q, 5);
    displayQ(q);
    deleteQR(q);
    deleteQR(q);
    deleteQR(q);
    displayQ(q);
    // deleteQF(q);
    // addQR(q, 6);
    // displayQ(q);
}
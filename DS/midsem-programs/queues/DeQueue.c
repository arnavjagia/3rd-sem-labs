/*
ALL HAIL SARTAJ SAHANI
*/
#include<stdio.h>
#include<stdlib.h>
#define MAX_SIZE 10

typedef struct
{
    int item[MAX_SIZE], front, rear;
} Cqueue;

Cqueue *createQueue();
void addQR(Cqueue *, int);
void addQF(Cqueue *, int);
int deleteQF(Cqueue *);
int deleteQR(Cqueue *);
void displayQ(Cqueue *);

int main()
{
    Cqueue *cq = createQueue(MAX_SIZE);
    displayQ(cq);
    addQR(cq, 1);
    addQR(cq, 2);
    addQR(cq, 3);
    addQR(cq, 4);
    addQR(cq, 5);
    addQR(cq, 6);
    addQR(cq, 7);
    addQR(cq, 8);
    addQR(cq, 9);
    addQR(cq, 10);
    displayQ(cq);
    deleteQF(cq);
    deleteQF(cq);
    deleteQF(cq);
    deleteQF(cq);
    deleteQF(cq);
    displayQ(cq);
    addQR(cq, 11);
    displayQ(cq);
}

Cqueue *createQueue()
{
    Cqueue *q = (Cqueue *)malloc(sizeof(Cqueue));
    q->front = q->rear = 0;
    return q;
}

void addQR(Cqueue *q, int element)
{
    int x = q->rear;
    q->rear = (q->rear + 1) % MAX_SIZE;
    if (q->front == q->rear) {q->rear = x; printf("Queue is full"); return;}
    q->item[q->rear] = element;
}

void addQF(Cqueue *q, int element)
{
    int x = q->rear;
    q->rear = (q->rear + 1) % MAX_SIZE;
    if (q->front == q->rear) {q->rear = x; printf("Queue is full"); return;}
    q->front = (q->front + MAX_SIZE - 1) % MAX_SIZE;
    if (q->front == MAX_SIZE - 1) {q->item[0] = element; return;}
    q->item[q->front + 1] = element;
}

int deleteQF(Cqueue *q)
{
    if (q->front == q->rear) { printf("Queue is empty"); return 999; }
    q->front = (q->front + 1) % MAX_SIZE;
    return q->item[q->front];
}

int deleteQR(Cqueue *q)
{
    if (q->front == q->rear) { printf("Queue is empty"); return 999; }
    return q->item[q->rear--];
}

void displayQ(Cqueue *q)
{
    printf("\nQueue: ");
    // Print the queue elements from front to rear
    for (int i = q->front + 1; i <= q->rear; i++)
        printf("%d ", q->item[i]);
    // If the queue is wrapped around (circular), print elements from 0 to rear
    if (q->front > q->rear)
    {
        for (int i = q->front+1; i <= MAX_SIZE-1; i++)
            printf("%d ", q->item[i]);
        for (int i = 0; i <= q->rear; i++)
            printf("%d ", q->item[i]);
    }
    printf("\n");
}
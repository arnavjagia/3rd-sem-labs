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
void addQ(Cqueue *, int);
int deleteQ(Cqueue *);
void displayQ(Cqueue *);

int main()
{
    Cqueue *cq = createQueue(MAX_SIZE);
    displayQ(cq);
    addQ(cq, 1);
    addQ(cq, 2);
    addQ(cq, 3);
    addQ(cq, 4);
    addQ(cq, 5);
    addQ(cq, 6);
    addQ(cq, 7);
    addQ(cq, 8);
    addQ(cq, 9);
    addQ(cq, 10);
    displayQ(cq);
    deleteQ(cq);
    deleteQ(cq);
    deleteQ(cq);
    deleteQ(cq);
    deleteQ(cq);
    displayQ(cq);
    addQ(cq, 11);
    displayQ(cq);
}

Cqueue *createQueue()
{
    Cqueue *q = (Cqueue *)malloc(sizeof(Cqueue));
    q->front = q->rear = 0;
    return q;
}

void addQ(Cqueue *q, int element)
{
    int x = q->rear;
    q->rear = (q->rear + 1) % MAX_SIZE;
    if (q->front == q->rear) {q->rear = x; printf("Queue is full"); return;}
    q->item[q->rear] = element;
}

int deleteQ(Cqueue *q)
{
    if (q->front == q->rear) { printf("Queue is empty"); return 999; }
    q->front = (q->front + 1) % MAX_SIZE;
    return q->item[q->front];
}

void displayQ(Cqueue *q)
{
    printf("\nQueue: ");
    // Print the queue elements from front to rear
    int i;
    for (i = q->front+1; i <= q->rear; i++)
        printf("%d ", q->item[i]);
    // If the queue is wrapped around (circular), print elements from 0 to rear
    if (q->front+1 > q->rear)
    {
        for (i = 0; i <= q->rear; i++)
            printf("%d ", q->item[i]);
    }

    // printf("\nQueue: ");
    // for (int i = q->front + 1; i <= q->rear; i++)
    //     printf("%d ", q->item[i]);
    // printf("\nSize is %d\n", q->rear - q->front);
}
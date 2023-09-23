/*
All hail Sartaj Sahani
*/
#include<stdio.h>
#include<stdlib.h>

typedef struct
{
    int *item, front, rear, capacity;
} Queue;

Queue *createQ(int);
void addQ(Queue *, int);
int deleteQ(Queue *);
void displayQ(Queue *);

int main()
{
    Queue *q;
    printf("MAX_SIZE: "); int capacity;
    scanf("%d", &capacity);
    q = createQ(capacity);
    addQ(q, 1);
    addQ(q, 2);
    addQ(q, 3);
    displayQ(q);

    deleteQ(q);
    deleteQ(q);
    displayQ(q);
}

Queue *createQ(int capacity)
{
    Queue *a = (Queue *)malloc(sizeof(Queue));
    a->item = (int *)malloc(capacity * sizeof(int));
    a->front = a->rear = -1;
    a->capacity = capacity;
    return a;
}

void addQ(Queue *q, int element)
{
    if (q->rear >= q->capacity-1) {printf("Queue is full"); return;}
    q->item[++q->rear] = element;
}

int deleteQ(Queue *q)
{
    if (q == createQ(q->capacity)) {printf("Queue is empty"); return 999;}
    return q->item[++q->front];
}

void displayQ(Queue *q)
{
    printf("\nQueue: ");
    for (int i = q->front + 1; i <= q->rear; i++)
        printf("%d ", q->item[i]);
    printf("\nSize: %d\n", q->rear - q->front);
}
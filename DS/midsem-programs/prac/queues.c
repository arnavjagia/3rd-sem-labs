#include <stdio.h>
#define SIZE 5

typedef struct
{
    int item[SIZE], front, rear;
} Queue;

Queue createQueue();
void addQ(Queue *, int);
int deleteQ(Queue *);
void displayQ(Queue *);

int main()
{
    Queue q = createQueue();
    displayQ(&q);
    addQ(&q, 1);
    addQ(&q, 2);
    addQ(&q, 3);
    addQ(&q, 4);
    addQ(&q, 5);
    addQ(&q, 6);
    displayQ(&q);
    deleteQ(&q);
    deleteQ(&q);
    displayQ(&q);
}

Queue createQueue()
{
    Queue t;
    t.front = t.rear = -1;
    return t;
}

void addQ(Queue *q, int ele)
{
    if (q->rear >= SIZE-1) { printf("Queue is full\n"); return; }
    q->item[++q->rear] = ele;
}

void displayQ(Queue *q)
{
    printf("Queue: ");
    for (int i = q->front + 1; i <= q->rear; i++)
    {
        printf("%d ", q->item[i]);
    }
    printf("\n");
}

int deleteQ(Queue *q)
{
    if (q->front == q->rear) { printf("Queue is empty"); return 999; }
    return q->item[++q->front];
}
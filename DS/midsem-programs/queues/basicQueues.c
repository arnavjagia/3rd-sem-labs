#include <stdio.h>
#include <stdlib.h>

typedef struct
{
    int *data, front, rear, capacity;
} Queue;

Queue *init(int);
void enqueue(Queue *, int);
int dequeue(Queue *);
void display(Queue *);

int main()
{
    Queue *q;
    printf("Capacity: "); int capacity;
    scanf("%d", &capacity);
    q = init(capacity);

    enqueue(q, 1);
    display(q);
    enqueue(q,2);
    display(q);
    
    dequeue(q);
    display(q);
    enqueue(q, 3);
    display(q);

    return 0;
}

Queue *init(int capacity)
{
    Queue *a = (Queue *)malloc(sizeof(Queue));
    a->data = (int *)malloc((unsigned) capacity * sizeof(int));
    a->front = 0;
    a->rear = -1;
    a->capacity = capacity;
    return a;
}
int isFull(Queue *q) { return q->rear >= q->capacity; }
int isEmpty(Queue *q) { return q->front == q->rear; }
void enqueue (Queue *q, int element)
{
    if (isFull(q)) {printf("\nQueue is full\n"); return;}
    q->data[++q->rear] = element;
}
int dequeue (Queue *q)
{
    if (isEmpty(q)) { printf("Queue is empty"); return 999; }
    return q->data[q->front++];
}
void display(Queue *q)
{
    printf("\nQueue: ");
    for (int i = q->front; i <= q->rear; i++)
        printf("%d ", q->data[i]);
    printf("\nSize: %d\n", q->rear - q->front + 1);
}
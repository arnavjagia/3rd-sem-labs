#include <stdio.h>
#include <stdlib.h>

typedef struct
{
    int *arr;
    int front, rear, size, capacity;
} Queue;

/// @brief dynamically allocates memory to pointers
Queue* createQueue(int);
/// @brief add element to rear of queue
void enque(Queue*, int);
/// @brief remove front element from queue
int deque(Queue*);
/// @brief returns whether queue is full
int isFull(Queue*);
/// @brief returns whether queue is empty
int isEmpty(Queue*);
/// @brief returns front element
int getFront(Queue*);
/// @brief returns rear element
int getRear(Queue*);
/// @brief displays queue
void display(Queue*);

Queue* createQueue(int capacity)
{
    // mem alloc for the struct pointer q
    Queue *q = (Queue *)malloc(sizeof(Queue));
    // mem alloc for q member integer array pointer
    q->arr = (int *)malloc(capacity * sizeof(int));
    // initialize 1. front -> 0; 2. rear -> capacity-1; 3. size -> 0; 4. capacity -> capacity
    q->front = q->size = 0; 
	q->rear = capacity - 1; 
    q->size = 0; q->capacity = capacity;
	return q; 
}

void enque(Queue *q, int x)
{
    if (isFull(q)) {printf("Overflow!!"); return;}
    q->rear = (q->rear + 1) % q->capacity;
    q->arr[q->rear] = x;
    q->size++;
}

int deque(Queue *q)
{
    if (isEmpty(q)) {printf("Underflow!!"); return 999;}
    int x = q->arr[q->front];
    q->front = (q->front + 1) % q->capacity;
    q->size--;
    return x;
}

int isFull(Queue *q) { return q->size >= q->capacity; }

int isEmpty(Queue *q) { return q->size == 0; }

int getFront(Queue *q)
{
    if (isEmpty(q)) {return -1;}
    return q->arr[q->front];
}

int getRear(Queue *q)
{
    if (isFull(q)) {return -1;}
    return q->arr[q->rear];
}

void display(Queue *q)
{
    if (isEmpty(q)) {printf("Queue is empty\n"); return;}
    printf("\nQueue: ");
    // Print the queue elements from front to rear
    int i;
    for (i = q->front; i <= q->rear; i++)
        printf("%d ", q->arr[i]);
    // If the queue is wrapped around (circular), print elements from 0 to rear
    if (q->front > q->rear)
    {
        for (i = 0; i <= q->rear; i++)
            printf("%d ", q->arr[i]);
    }
    printf("\nSize is %d\n", q->size);
}
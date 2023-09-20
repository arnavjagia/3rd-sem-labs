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
/// @brief displays queue
void display(Queue*);

int main()
{
    // taking capacity (length) of the queue i.e array
    printf("capacity of queue: "); int capacity;
    scanf("%d", &capacity);

    // Initializing queue
    Queue *q = createQueue(capacity);

    // displaying queue
    display(q);

    enque(q, 1);
    display(q);
    enque(q, 2);
    display(q);
    enque(q, 3);
    display(q);

    deque(q);
    display(q);
    deque(q);
    display(q);

    enque(q, 4);
    display(q);
    return 0;
}

Queue* createQueue(int capacity)
{
    // mem alloc for the struct pointer q
    Queue *q = (Queue *)malloc(sizeof(Queue));
    // mem alloc for q member integer array pointer
    q->arr = (int *)malloc(capacity * sizeof(int));
    // initialize 1. front -> -1; 2. rear -> -1; 3. size -> 0; 4. capacity -> capacity
    q->front = q->rear = -1;
    q->size = 0; q->capacity = capacity;
    return q;
}

void enque(Queue *q, int element)
{
    if (isFull(q)) {printf("Overflow!!"); return;}
    q->arr[++q->rear] = element;
    if (q->front == -1) {q->front = 0;}
    q->size++;
}

int deque(Queue *q)
{
    if (isEmpty(q)) {printf("Underflow!!"); return 999;}
    if (q->front == q->rear)
    {
        int x = q->arr[q->front];
        q->front = q->rear = -1;
        q->size--;
        return x;
    }
    q->size--;
    return q->arr[q->front++];
}

int isFull(Queue *q) { return q->rear >= q->capacity; }

int isEmpty(Queue *q) { return (q->front == -1 && q->rear == -1); }

void display(Queue *q)
{
    if (isEmpty(q)) {printf("Queue is empty\n"); return;}
    printf("\nQueue: ");
    for (int i = q->front; i <= q->rear; i++)
        printf("%d ", q->arr[i]);
    printf("\nSize is %d\n", q->size);
}
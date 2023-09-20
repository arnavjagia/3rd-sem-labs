#include "Stacks.h"

typedef struct
{
    stack stack1;
    stack stack2;
} queue;

void enqueue(queue *q, int ele)
{
    push(&q->stack1, ele);
}

int dequeue(queue *q)
{
    if (isempty(&q->stack1) && isempty(&q->stack2)) {
        printf("Queue is empty.\n");
        return -1;
    }

    if (isempty(&q->stack2)) {
        // Transfer elements from stack1 to stack2 if stack2 is empty
        while (!isempty(&q->stack1)) {
            int element = pop(&q->stack1);
            push(&q->stack2, element);
        }
    }

    return pop(&q->stack2);
}

int main()
{
    queue q;
    q.stack1.top = -1; // Initialize the stacks
    q.stack2.top = -1;

    // Enqueue elements
    enqueue(&q, 1);
    enqueue(&q, 2);
    enqueue(&q, 3);

    printf("Queue after enqueuing elements:\n");
    display(&q.stack1);

    // Dequeue elements
    printf("Dequeued: %d\n", dequeue(&q));
    printf("Dequeued: %d\n", dequeue(&q));

    printf("Queue after dequeuing elements:\n");
    display(&q.stack2);

    // // Enqueue more elements
    // enqueue(&q, 4);
    // enqueue(&q, 5);

    // printf("Queue after enqueuing more elements:\n");
    // display(&q.stack2);

    // // Dequeue remaining elements
    // printf("Dequeued: %d\n", dequeue(&q));
    // printf("Dequeued: %d\n", dequeue(&q));
    // printf("Dequeued: %d\n", dequeue(&q));

    // printf("Queue after dequeuing remaining elements:\n");
    // display(&q.stack2);

    return 0;
}

#include <stdio.h>
#include "CircularQueue.h"

int main()
{
    int capacity;
    printf("Enter the size of the array: ");
    scanf("%d", &capacity);

    if (capacity % 2 != 0)
    {
        printf("Size must be even for two circular queues.\n");
        return 1;
    }

    // Create a single array to hold both queues
    Queue *dq = createQueue(capacity);

    // Set the capacity for each queue
    int queue1Capacity = capacity / 2;
    int queue2Capacity = capacity - queue1Capacity;

    // Initialize the first queue to run from 0 to N/2-1
    Queue *queue1 = dq;
    queue1->capacity = queue1Capacity;

    // Initialize the second queue to run from N/2 to N-1
    Queue *queue2 = createQueue(queue2Capacity);

    int choice, value;

    while (1)
    {
        printf("\nChoose an operation:\n");
        printf("1. Enqueue in Queue 1\n");
        printf("2. Dequeue from Queue 1\n");
        printf("3. Enqueue in Queue 2\n");
        printf("4. Dequeue from Queue 2\n");
        printf("5. Display Queue 1\n");
        printf("6. Display Queue 2\n");
        printf("7. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice)
        {
        case 1:
            printf("Enter a value to enqueue in Queue 1: ");
            scanf("%d", &value);
            enque(queue1, value);
            break;

        case 2:
            value = deque(queue1);
            if (value != 999)
            {
                printf("Dequeued from Queue 1: %d\n", value);
            }
            break;

        case 3:
            printf("Enter a value to enqueue in Queue 2: ");
            scanf("%d", &value);
            enque(queue2, value);
            break;

        case 4:
            value = deque(queue2);
            if (value != 999)
            {
                printf("Dequeued from Queue 2: %d\n", value);
            }
            break;

        case 5:
            printf("Queue 1:\n");
            display(queue1);
            break;

        case 6:
            printf("Queue 2:\n");
            display(queue2);
            break;

        case 7:
            // Clean up and exit
            free(dq->arr);
            free(dq);
            free(queue2->arr);
            free(queue2);
            return 0;

        default:
            printf("Invalid choice. Please try again.\n");
        }
    }

    return 0;
}

#include <stdio.h>
#include "CircularQueue.h"

// Function to check if Vignesh and Lata can get money without Lata feeling insecure
char* canGetMoney(int N, int K) {
    // Create a queue to represent the people in the queue
    Queue* queue = createQueue(N);

    // Initialize the queue with values from 1 to N
    for (int i = 1; i <= N; i++) {
        enque(queue, i);
    }

    // Process the queue in groups of 3 until Vignesh and Lata are processed
    while (!isEmpty(queue)) {
        int group[3]; // Store the group of 3 people
        for (int i = 0; i < 3; i++) {
            group[i] = deque(queue); // Dequeue a person
        }

        // Check if Vignesh or Lata is in the current group
        if (group[0] == K || group[1] == K || group[2] == K) {
            for (int i = 0; i < 3; i++) {
                // Check if Lata is in the same group as Vignesh
                if (group[i] == K + 1) {
                    return "Yes"; // Lata feels insecure
                }
            }
        }
    }

    return "No"; // Vignesh and Lata can get money without insecurity
}

int main() {
    int T;
    printf("Enter the number of test cases: ");
    scanf("%d", &T);

    while (T--) {
        int N, K;
        printf("Enter N and K: ");
        scanf("%d %d", &N, &K);

        if (N % 3 != 0) {
            printf("N must be divisible by 3.\n");
            continue;
        }

        char* result = canGetMoney(N, K);
        printf("%s\n", result);
    }

    return 0;
}

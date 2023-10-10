/*
2)	Implement a queue of strings using an output restricted dequeue (no deleteRight). Note: An output-restricted deque is one where insertion can be made at both ends, but deletion can be made from one end only, where as An input-restricted deque is
one where deletion can be made from both ends, but insertion can be made at one end only.
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX 30

typedef struct {
    char *data[MAX]; int rear, front;
} dequeue;

void initialize(dequeue *p) {p->rear = p->front = -1;}
int empty (dequeue *p) {return (p->rear == -1);}
int full(dequeue *p) {return ((p->rear+1)%MAX == p->front);}

void enqueueR(dequeue *p, char *x) {
    if (full(p)) {printf("Queue is full\n"); return;}
    if (empty(p)) {p->rear = 0; p->front = 0;}
    else p->rear = (p->rear+1)%MAX;
    p->data[p->rear] = x;
}

void enqueueF(dequeue *p, char *x) {
    if (full(p)) {printf("Queue is full\n"); return;}
    if (empty(p)) {p->rear = 0; p->front = 0;}
    else p->front = (p->front-1+MAX)%MAX;
    p->data[p->front] = x;
}

char *dequeueF(dequeue *p) {
    char *x;
    if (empty(p)) {printf("Queue is empty\n"); exit(0);}
    x = p->data[p->front];
    if (p->rear == p->front) initialize(p);
    else p->front = (p->front+1)%MAX;
    return x;
}

void display(dequeue *p) {
    int i;
    if (empty(p)) {printf("Queue is empty\n"); return;}
    printf("Contents of queue are:\n");
    for (i = p->front; i != p->rear; i = (i+1)%MAX) printf("%s\n", p->data[i]);
    printf("%s\n", p->data[i]);
}

int main() {
    // init_dequeue
    dequeue q;
    initialize(&q);

    // enqueueR
    enqueueR(&q, "Hello1");
    enqueueR(&q, "World1");

    // enqueueF
    enqueueF(&q, "Hello2");
    enqueueF(&q, "World2");
    display(&q);

    // dequeueF
    dequeueF(&q);

    // display
    display(&q);

    return 0;
}
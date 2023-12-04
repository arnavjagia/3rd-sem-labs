#include <stdio.h>
#include <stdlib.h>

struct node
{
    int data;
    struct node *next;
};
struct node *head = NULL;

void insert_begin(int data)
{
    if (head == NULL)
    {
        head = (struct node *)malloc(sizeof(struct node));
        head->data = data;
        head->next = NULL;
    }
    else
    {
        struct node *temp;
        temp = malloc(sizeof(struct node));
        temp->data = data;
        temp->next = head;
        head = temp;
    }
}

void insert_end(int data)
{
    if (head == NULL)
    {
        head = malloc(sizeof(struct node));
        head->data = data;
        head->next = NULL;
    }
    else
    {
        struct node *temp, *ptr = head;
        temp = malloc(sizeof(struct node));
        temp->data = data;
        temp->next = NULL;
        while (ptr->next != NULL)
        {
            ptr = ptr->next;
        }
        ptr->next = temp;
    }
}

int delete_begin()
{
    struct node *temp = head;
    if (head->next == NULL) {head = NULL; return 999;}
    else{
        int d = head->data;
        head = head->next;
        free(temp);
        return d;
    }
}

int delete_end()
{
    struct node *ptr = head, *temp;
    while (ptr->next->next != NULL)
    {
        ptr = ptr->next;
    }
    temp = ptr->next;
    int d = temp->data;
    ptr->next = NULL;
    free(temp);
    return d;
}

void display()
{
    struct node *ptr = head;
    printf("List: ");
    while (ptr!=NULL)
    {
        printf("%d ", ptr->data);
        ptr = ptr->next;
    }
    printf("\n");
}

int main()
{
    // insert_begin(12);
    // insert_begin(14);
    // insert_begin(16);
    // insert_begin(35);
    // insert_begin(40);
    // display();
    // insert_end(9);
    // insert_end(7);
    // display();
    // delete_begin();
    // display();
    // delete_end();
    // display();a
    display();
    delete_begin();
    display();
}
#include <stdio.h>
#include <stdlib.h>

struct node
{
    int data;
    struct node *lchild;
    struct node *rchild;
};

struct node *getnode()
{
    return ((struct node *)malloc(sizeof(struct node)));
}

struct node *createBST(struct node *root, int item)
{
    if (root == NULL)
    {
        struct node *root = getnode();
        root->data = item;
        root->rchild = NULL;
        root->lchild = NULL;
        return root;
    }
    else if (item < root->data)
    {
        root->lchild = createBST(root->lchild, item);
    }
    else
    {
        if (item > root->data)
        {
            root->rchild = createBST(root->rchild, item);
        }
        else
        {
            printf("No dupliucates allowed");
        }
    }
    return root;
}

struct node *InorderPredecessor(struct node *root)
{
    struct node *cur = root->lchild;
    while (cur->rchild != NULL)
    {
        cur = cur->rchild;
    }
    return cur;
}

void Delete(struct node *root, int key)
{
    struct node *cur = root;
    struct node *parent = NULL;
    struct node *succ;
    struct node *q;
    if (root == NULL)
    {
        return;
    }
    while (cur && cur->data != key)
    {
        parent = cur;
        if (cur->data < key)
        {
            cur = cur->rchild;
        }
        else
        {
            cur = cur->lchild;
        }
    }
    if (!cur)
    {
        printf("Element not found\n");
        return;
    }
    if (!cur->lchild)
    {
        q = cur->rchild;
        if (cur == parent->rchild)
        {
            parent->rchild = q;
            free(cur);
        }
        else
        {
            parent->lchild = q;
            free(cur);
        }
        return;
    }
    else if (!cur->rchild)
    {
        q = cur->lchild;
        if (cur == parent->rchild)
        {
            parent->rchild = q;
            free(cur);
        }
        else
        {
            parent->lchild = q;
            free(cur);
        }
        return;
    }
    else
    {
        succ = InorderPredecessor(cur);
        cur->data = succ->data;
        Delete(cur->lchild, cur->data);
    }
}

void Inorder(struct node *root)
{
    if (root)
    {
        Inorder(root->lchild);
        printf("%d ", root->data);
        Inorder(root->rchild);
    }
}

void Ancestors(struct node *root, int z)
{
    struct node *temp = root;
    if (temp->data == z)
    {
        return;
    }
    else if (temp->data < z)
    {
        printf("%d ", temp->data);
        Ancestors(temp->rchild, z);
    }
    else
    {
        printf("%d ", temp->data);
        Ancestors(temp->lchild, z);
    }
}

int main()
{
    struct node *root = NULL;
    /* root=createBST(root,6);
     root=createBST(root,3);
     root=createBST(root,2);
     root=createBST(root,4);
     root=createBST(root,5);
     root=createBST(root,1);
     root=createBST(root,40);
     root=createBST(root,80);*/
    // root=createBST(root,8);
    //
    // Delete(root,2);
    // Delete(root,40);
    // printf("Inorder is: ");
    root = createBST(root, 2);
    root = createBST(root, 1);
    root = createBST(root, 3);
    Inorder(root);
    printf("\n");
    Delete(root, 2);
    Inorder(root);
    printf("\n");
    // Ancestors(root,1);
    return 0;
}
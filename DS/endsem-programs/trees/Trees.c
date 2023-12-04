#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <math.h>
#include <string.h>
typedef struct Node
{
    struct Node* left;
    struct Node* right;
    int val;
}Node;

typedef struct nodeStack{
    Node* arr[100];
    int top;
}nodeStack;

Node* newNode(int val)
{
    Node* node = (Node*)malloc(sizeof(Node));
    node->right = NULL;
    node->left = NULL;
    node->val = val;
    return node;
}

void push(nodeStack *s, Node* node)
{
    s->arr[++s->top] = node;
}

Node* pop(nodeStack *s)
{
    return s->arr[s->top--];
}

bool isEmpty(nodeStack* s)
{
    if(s->top == -1) return true;
    else return false;
}

void iterativeInorder(Node* root)
{
    nodeStack* s = malloc(sizeof(nodeStack));
    s->top = -1;
    if(root == NULL) return;

    Node* curr = root;
    while(curr || !isEmpty(s))
    {
        if(curr) {
            push(s, curr);
            curr = curr->left;
        } else {
        curr = pop(s);
        printf("%d ", curr->val);
        curr = curr->right;
        }
    }
}

void iterativePostorder(Node* root)
{
    nodeStack* s1 = malloc(sizeof(Node));
    nodeStack* s2 = malloc(sizeof(Node));
    Node* curr;
    s1->top = s2->top = -1;
    if(root ==  NULL) return;
    push(s1, root);
    while(!isEmpty(s1))
    {
        curr = pop(s1);
        push(s2, curr);
        if(curr->left) push(s1, curr->left);
        if(curr->right) push(s1, curr->right);
    }
    while(!isEmpty(s2))
    {
        printf("%d ", pop(s2)->val);
    }
}
void iterativePreorder(Node* root)
{
    nodeStack* s = malloc(sizeof(nodeStack));
    s->top = -1;
    if(root == NULL) return;

    push(s,root);
    while(!isEmpty(s))
    {
        Node* curr = pop(s);
        printf("%d ", curr->val);
        if(curr->right) push(s, curr->right);
        if(curr->left) push(s, curr->left);
    }


}
// void BSTCreator(Node* node, int val)
// {
//     // Node*  = newNode(val);
//     if(val > node)
//     {
//         BSTCreator(node->right,)
//     }
// }

Node* createBinaryTree(int item)
{
    int x;
    if(item != -1)
    {
        Node* temp = malloc(sizeof(Node));
        temp->val = item;
        printf("Enter the lchild of %d :",item);
        scanf("%d",&x);
        temp->left = createBinaryTree(x);
        printf("Enter the rchild of %d :",item);
        scanf("%d",&x);
        temp->right = createBinaryTree(x);
        return temp;
    }
    return NULL;
}
Node* maxBST(Node* root)
{
    while(root->right != NULL)
    {
        root = root->right;
    }
    return root;
}
Node* minBST(Node* root)
{
    while(root->left != NULL)
    {
        root = root->left;
    }
    return root;
}

Node* search(Node* root, int val)
{
    if(root == NULL) return NULL;
    if(val > root->val)
    {
        root->right = search(root->right, val);
    }
    else if (val < root->val)
    {
        root->left = search(root->left, val);
    }
    else return root;
}

Node* CreateBST(Node* root, int item){
    if(root == NULL) return newNode(item);
    if(item > root->val)
        root->right = CreateBST(root->right, item);
    else
        root->left  = CreateBST(root->left, item);
    return root;
}

void preorder(Node* root)
{
    if(root != NULL)
    {
        printf("%d ", root->val);
        preorder(root->left);
        preorder(root->right);
    }
}

void inorder(Node* root)
{
    if(root !=NULL)
    {
        inorder(root->left);
        printf("%d ", root->val);
        inorder(root->right);
    }
}

void postorder(Node * root)
{
    if(root != NULL)
    {
        postorder(root->left);
        postorder(root->right);
        printf("%d ", root->val);
    }
}
bool findAncesstor(Node* root, int val)
{
    if(root == NULL) return false;
    if(root->val == val) return true;
    if(findAncesstor(root->left, val) || findAncesstor(root->right, val))
    {
        printf("%d ", root->val);
        return true;
    }
    return false;
}
int isOperator(char x)
{
    switch(x)
    {
        case '+':
        case '*':
        case '-':
        case '/':
        return 1;
    }
    return 0;
}
Node* createExprTree(char expr[])
{
    nodeStack* s1 = malloc(sizeof(nodeStack)); 
    s1->top = -1;
    for(int i=0; i<strlen(expr); i++)
    {
        char symbol = expr[i];
        if(!isOperator(symbol))
        {
            push(s1, newNode(symbol));
        }
        else
        {
            Node* node = newNode(symbol);
            node->right = pop(s1);
            node->left = pop(s1);
            push(s1, node);
        }
    }
    return pop(s1);
}
int eval(Node* root)
{
    switch(root->val)
    {
        case '+': return eval(root->left) + eval(root->right);
        case '-': return eval(root->left) - eval(root->right);
        case '/': return eval(root->left) / eval(root->right);
        case '*': return eval(root->left) * eval(root->right);
        case '^': return pow(eval(root->left), eval(root->right));
        default: return root->val-'0';
    }
}

int deleteBST(Node* root)
{

}

int main()
{
    nodeStack* s = malloc(sizeof(nodeStack));
    s->top = -1;
    Node* root = NULL;
    int item;


    // printf("Creating the tree : \n");
    // printf("Enter the root : ");
    // scanf("%d",&item);
    // root=createBinaryTree(item);
    // printf("%d", root->val);


    root = CreateBST(root, 12);
    root = CreateBST(root, 3412);
    root = CreateBST(root, 32);
        root = CreateBST(root, 76);


    printf("Inorder: ");
    inorder(root);
    printf("\nIterative Inorder: ");
    iterativeInorder(root);
    printf("\nPreorder: ");
    preorder(root);
    printf("\nIterative Preorder: ");
    iterativePreorder(root);
    printf("\nPostorder: ");
    postorder(root);
    printf("\nIterative Postorder: ");
    iterativePostorder(root);
    printf("\nMax of the BST is: %d", maxBST(root)->val);
    printf("\nMin of the BST is: %d", minBST(root)->val);
    printf("\nValue %d is there", search(root, 3412)->val);
    printf("\nAncesstors of 32 are: ");
    findAncesstor(root, 32);
    inorder(createExprTree("23+"));
    printf("\nThe Postfix Evaluation of '231*+9-': %d", eval(createExprTree("231*+9-")));
}
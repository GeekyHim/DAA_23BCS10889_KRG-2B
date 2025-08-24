#include <iostream>
using namespace std;

// DOUBLY LINKED LIST 
struct DNode {
    int data;
    DNode* prev;
    DNode* next;
};

DNode* dHead = NULL;

void insertAtBeginDLL(int val) {
    DNode* newNode = new DNode{val, NULL, dHead};
    if (dHead != NULL) dHead->prev = newNode;
    dHead = newNode;
}

void insertAtEndDLL(int val) {
    DNode* newNode = new DNode{val, NULL, NULL};
    if (dHead == NULL) { dHead = newNode; return; }
    DNode* temp = dHead;
    while (temp->next) temp = temp->next;
    temp->next = newNode;
    newNode->prev = temp;
}

void deleteAtBeginDLL() {
    if (dHead == NULL) return;
    DNode* temp = dHead;
    dHead = dHead->next;
    if (dHead) dHead->prev = NULL;
    delete temp;
}

void deleteAtEndDLL() {
    if (dHead == NULL) return;
    if (dHead->next == NULL) { delete dHead; dHead = NULL; return; }
    DNode* temp = dHead;
    while (temp->next) temp = temp->next;
    temp->prev->next = NULL;
    delete temp;
}

void displayDLL() {
    DNode* temp = dHead;
    cout << "Doubly List: ";
    while (temp) { cout << temp->data << " "; temp = temp->next; }
    cout << endl;
}

// CIRCULAR LINKED LIST 
struct CNode {
    int data;
    CNode* next;
};

CNode* cHead = NULL;

void insertAtBeginCLL(int val) {
    CNode* newNode = new CNode{val, NULL};
    if (cHead == NULL) { newNode->next = newNode; cHead = newNode; return; }
    CNode* temp = cHead;
    while (temp->next != cHead) temp = temp->next;
    newNode->next = cHead;
    temp->next = newNode;
    cHead = newNode;
}

void insertAtEndCLL(int val) {
    CNode* newNode = new CNode{val, NULL};
    if (cHead == NULL) { newNode->next = newNode; cHead = newNode; return; }
    CNode* temp = cHead;
    while (temp->next != cHead) temp = temp->next;
    temp->next = newNode;
    newNode->next = cHead;
}

void deleteAtBeginCLL() {
    if (cHead == NULL) return;
    if (cHead->next == cHead) { delete cHead; cHead = NULL; return; }
    CNode* temp = cHead;
    while (temp->next != cHead) temp = temp->next;
    CNode* delNode = cHead;
    temp->next = cHead->next;
    cHead = cHead->next;
    delete delNode;
}

void deleteAtEndCLL() {
    if (cHead == NULL) return;
    if (cHead->next == cHead) { delete cHead; cHead = NULL; return; }
    CNode* temp = cHead;
    while (temp->next->next != cHead) temp = temp->next;
    delete temp->next;
    temp->next = cHead;
}

void displayCLL() {
    if (cHead == NULL) { cout << "Circular List: Empty\n"; return; }
    CNode* temp = cHead;
    cout << "Circular List: ";
    do {
        cout << temp->data << " ";
        temp = temp->next;
    } while (temp != cHead);
    cout << endl;
}


int main() {
    // Doubly linked list 
    insertAtBeginDLL(10);
    insertAtEndDLL(20);
    insertAtBeginDLL(5);
    displayDLL();
    deleteAtBeginDLL();
    displayDLL();
    deleteAtEndDLL();
    displayDLL();

    // Circular linked list 
    insertAtEndCLL(1);
    insertAtEndCLL(2);
    insertAtBeginCLL(0);
    displayCLL();
    deleteAtBeginCLL();
    displayCLL();
    deleteAtEndCLL();
    displayCLL();
    return 0;
}
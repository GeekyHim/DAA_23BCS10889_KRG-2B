
#include <iostream>
using namespace std;

const int MAX = 5; 

template <class T>
class Stack {
    T arr[MAX];
    int top;

public:
    Stack() { top = -1; }

    bool isEmpty() { return (top == -1); }
    bool isFull()  { return (top == MAX - 1); }

    void push(T x) {
        if (isFull()) {
            cout << "Stack Overflow! Cannot push " << x << endl;
            return;
        }
        arr[++top] = x;
        cout << x << " pushed into stack\n";
    }

    void pop() {
        if (isEmpty()) {
            cout << "Stack Underflow! Nothing to pop\n";
            return;
        }
        cout << arr[top--] << " popped from stack\n";
    }

    T peek() {
        if (isEmpty()) {
            cout << "Stack is empty!" << endl;
            return -1;
        }
        return arr[top];
    }
};

int main() {
    Stack<int> s; 

    s.push(10);
    s.push(20);
    s.push(30);
    cout << "Top element is: " << s.peek() << endl;

    s.pop();
    cout << "Top element is: " << s.peek() << endl;

    s.pop();
    s.pop();
    s.pop(); 

    return 0;
}
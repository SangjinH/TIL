
# 하나하나의 노드를 정의하는 Class
class Node:
    def __init__(self, item):
        self.data = item
        self.next = None


# LinkedList 의 초기값, Head는 맨앞 노드, Tail은 맨뒤 노드. 
class LinkedList:
    def __init__(self):
        self.nodeCount = 0
        self.head = None
        self.tail = None

    def getAt(self, pos):
        if pos <= 0 or pos > self.nodeCount:
            return None

        i = 1
        curr = self.head
        while i < pos:
            curr = curr.next
            i += 1
        
        return curr

    def insertAt(self, pos, newNode):
        if pos < 1 or pos > self.nodeCount + 1:
            return False

        if pos == 1:
            newNode.next = self.head
            self.head = newNode
        else:
            # Ver2. 만약 넣고자하는 Node가 가장 끝 노드라면?
            if pos  == self.nodeCount+1:
                prev = self.tail
            else:
            # Ver1. 순서를 주의하자.
            # 1. prev 의 next 를 newNode.next 로 바꿔주고
            # 2. prev.next = newNode
                prev = self.getAt(pos-1)
            newNode.next = prev.next
            prev.next = newNode
        
        if pos == self.nodeCount + 1:
            self.tail = newNode
        
        self.nodeCount += 1
        return True
    

    # def popAt(self, pos):


    def concat(self, L):
        '''
        두 개의 연결리스트를 합치는 법
        '''
        self.tail.next = L.head
        if L.tail:
            self.tail = L.tail
        self.nodeCount += L.nodeCount
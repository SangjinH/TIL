class Node:

    def __init__(self, item):
        self.data = item
        self.next = None


class LinkedList:

    def __init__(self):
        self.nodeCount = 0
        self.head = None
        self.tail = None


    def getAt(self, pos):
        if pos < 1 or pos > self.nodeCount:
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
            if pos == self.nodeCount + 1:
                prev = self.tail
            else:
                prev = self.getAt(pos - 1)
            newNode.next = prev.next
            prev.next = newNode

        if pos == self.nodeCount + 1:
            self.tail = newNode

        self.nodeCount += 1
        return True


    def popAt(self, pos):
        if pos < 1 or pos > self.nodeCount + 1:
            raise IndexError
        
        # 맨 첫번째 원소를 뽑는다면
        if pos == 1:
            self.getAt(pos).next = None
            self.head = self.getAt(pos+1)
        # 맨 마지막 원소라면
        elif pos == self.nodeCount + 1:
            self.tail = self.getAt(pos-1)
            self.getAt(pos-1).next = None

        # 사이에 있는 원소라면
        else:
            prev = self.getAt(pos-1)
            after = self.getAt(pos+1)
            prev.next = after
            now = self.getAt(pos)
            now.next = None
        
        self.nodeCount -= 1
        return True

    def traverse(self):
        result = []
        curr = self.head
        while curr is not None:
            result.append(curr.data)
            curr = curr.next
        return result


def solution(x):
    return 0
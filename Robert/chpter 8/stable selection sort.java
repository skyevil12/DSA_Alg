import java.util.LinkedList;
import java.util.Queue;

public class GFG {

    public static void main(String[] args) {

        MyLinkList<Integer> dataList = new MyLinkList<>();
        dataList.add(2);
        dataList.add(5);
        dataList.add(3);
        dataList.add(6);
        dataList.add(5);
        dataList.add(16);
        dataList.add(8);
        dataList.add(1);
        dataList.add(3);
        dataList.add(9);

        stableSelectionSort(dataList);
        for (int i = 0; i < dataList.size(); i++) {
            System.out.println(dataList.get(i));
        }
    }

    private static void stableSelectionSort(MyLinkList<Integer> dataList) {
        for (int i = 0; i < dataList.size(); i++) {
            int minValue = dataList.get(i);
            int minValueIndex = i;
            for (int j = i + 1; j < dataList.size(); j++) {
                int value = dataList.get(j);
                if (value < minValue) {
                    minValueIndex = j;
                    minValue = value;
                }
            }

            if (minValueIndex != i) {
                dataList.remove(minValueIndex);
                dataList.add(i, minValue);
            }
        }

    }

    private static class MyLinkList<T> {
        int length = 0;
        private MyNode<T> firstNode;
        private MyNode<T> lastNode;

        public void add(T data) {
            ++length;
            MyNode<T> newNode = new MyNode<>(data);
            if (firstNode == null) {
                firstNode = newNode;
                lastNode = newNode;
            } else {
                lastNode.setNext(newNode);
                lastNode = newNode;
            }
        }

        public boolean remove(T data) {
            if (firstNode == null) {
                return false;
            }

            MyNode<T> removeNode = firstNode;
            while (removeNode != null) {
                if (removeNode.data.equals(data)) {

                    if (removeNode == firstNode && removeNode == lastNode) {
                        firstNode = null;
                        lastNode = null;

                    } else {
                        if (removeNode == lastNode) {
                            lastNode = removeNode.previous;
                        }

                        removeNode.previous.setNext(removeNode.next);
                    }

                    --length;
                    return true;
                }
                removeNode = removeNode.next;
            }
            return false;
        }

        public T get(int index) {
            if (index < 0 || index >= length) {
                return null;
            }

            MyNode<T> targetNode;
            int position;
            if (index > length / 2) {
                position = length - 1;
                targetNode = lastNode;
                while (position > index) {
                    targetNode = targetNode.previous;
                    position--;
                }

                return targetNode.getData();
            } else {
                position = 0;
                targetNode = firstNode;
                while (position < index) {
                    targetNode = targetNode.next;
                    position++;
                }
                return targetNode.data;
            }
        }

        public boolean remove(int index) {
            if (index < 0 || index >= length) {
                return false;
            }

            MyNode<T> targetNode;
            int position;
            if (index > length / 2) {
                position = length - 1;
                targetNode = lastNode;
                while (position > index) {
                    targetNode = targetNode.previous;
                    position--;
                }

            } else {
                position = 0;
                targetNode = firstNode;
                while (position < index) {
                    targetNode = targetNode.next;
                    position++;
                }
            }

            if (targetNode == lastNode) {
                if (lastNode.previous == null) {
                    firstNode = null;
                    lastNode = null;

                } else {
                    lastNode.previous.next = null;
                    lastNode = lastNode.previous;
                }

            } else if (targetNode == firstNode) {
                firstNode = firstNode.next;
                if (firstNode == null) {
                    lastNode = null;
                }

            } else {
                targetNode.previous.setNext(targetNode.next);
            }

            length--;
            return true;
        }

        public void add(int index, T data) {
            System.out.println("index: " + index + " data: " + data);
            if (index < 0 || index > length) {
                return;
            }

            if (length == 0) {
                add(data);
                return;
            }


            MyNode<T> targetNode;
            int position;
            if (index > length / 2) {
                position = length - 1;
                targetNode = lastNode;
                while (position > index) {
                    targetNode = targetNode.previous;
                    position--;
                }

            } else {
                position = 0;
                targetNode = firstNode;
                while (position < index) {
                    targetNode = targetNode.next;
                    position++;
                }
            }

            MyNode<T> newNode = new MyNode<>(data);
            if (targetNode == firstNode) {
                newNode.setNext(firstNode);
                firstNode = newNode;

            } else {
                targetNode.previous.setNext(newNode);
                newNode.setNext(targetNode);
            }
            length++;
        }

        public int size() {
            return length;
        }
    }

    private static class MyNode<T> {

        private T data;

        private MyNode<T> next;

        private MyNode<T> previous;

        public MyNode(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public MyNode<T> getNext() {
            return next;
        }

        public void setNext(MyNode<T> next) {
            this.next = next;
            next.previous = this;
        }

        public MyNode<T> getPrevious() {
            return previous;
        }

        public void setPrevious(MyNode<T> previous) {
            this.previous = previous;
            previous.next = this;
        }
    }

}
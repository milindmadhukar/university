#include <iostream>
#include <queue>
#include <string>
#include <unordered_map>
#include <vector>

struct MinHeapNode {
  char data;
  unsigned int freq;
  MinHeapNode *left, *right;
  MinHeapNode(char data, unsigned int freq) {
    left = right = NULL;
    this->data = data;
    this->freq = freq;
  }
};

struct compare {
  bool operator()(MinHeapNode *left, MinHeapNode *right) {
    return left->freq > right->freq;
  }
};

std::priority_queue<MinHeapNode *, std::vector<MinHeapNode *>, compare> minHeap;
std::unordered_map<char, std::string> codes;

MinHeapNode *HuffmanCodes(char arr[], int freq[], int size) {
  struct MinHeapNode *top, *left, *right;

  for (int i = 0; i < size; i++) {
    minHeap.push(new MinHeapNode(arr[i], freq[i]));
  }

  while (minHeap.size() != 1) {
    left = minHeap.top();
    minHeap.pop();

    right = minHeap.top();
    minHeap.pop();

    top = new MinHeapNode('$', left->freq + right->freq);
    top->left = left;
    top->right = right;
    minHeap.push(top);
  }

  return minHeap.top();
}

void saveCodes(MinHeapNode *node, std::string code) {
  if (node == NULL)
    return;

  if (node->data != '$') {
    codes[node->data] = code;
  }

  saveCodes(node->left, code + "0");
  saveCodes(node->right, code + "1");
}

std::string decodeHuffMan(MinHeapNode *root, std::string message) {
  MinHeapNode *curr = root;

  std::string answer = "";

  for (int i = 0; i < message.length(); i++) {
    if (message[i] == '0') {
      curr = curr->left;
    } else if (message[i] == '1') {
      curr = curr->right;
    }

    if (curr->left == NULL && curr->right == NULL) {
      answer += curr->data;
      curr = root;
    }
  }

  return answer;
}

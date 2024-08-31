#include <iostream>
#include <queue>
#include <string>
#include <unordered_map>
#include <vector>

struct MinHeapNode {
  char data;
  int freq;
  MinHeapNode *left, *right;
  MinHeapNode(char data, int freq) {
    this->data = data;
    this->freq = freq;
    left = right = NULL;
  }
};

struct compare {
  bool operator()(MinHeapNode *left, MinHeapNode *right) {
    return left->freq > right->freq;
  }
};

std::priority_queue<MinHeapNode *, std::vector<MinHeapNode *>, compare> minHeap;
std::unordered_map<char, std::string> codes;

MinHeapNode *HuffmanCodes(char arr[], int freq[], int n) {
  MinHeapNode *left, *right, *top;

  for (int i = 0; i < n; i++) {
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
  if (node == NULL) {
    return;
  }

  if (node->data != '$') {
    codes[node->data] = code;
  }

  saveCodes(node->left, code + "0");
  saveCodes(node->right, code + "1");
}

std::string decodeHuffman(MinHeapNode *root, std::string message) {
  std::string ans = "";
  MinHeapNode *current = root;

  for (int i = 0; i < message.length(); i++) {
    if (message[i] == '0') {
      current = current->left;
    } else if (message[i] == '1') {
      current = current->right;
    }
    if (current->left == NULL && current->right == NULL) {
      ans += current->data;
      current = root;
    }
  }

  return ans;
}

int main() {
  int n = 6;
  char arr[] = {'c', 'd', 'g', 'u', 'm', 'a'};
  int freq[] = {34, 9, 35, 2, 2, 100};
  MinHeapNode *root = HuffmanCodes(arr, freq, n);
  saveCodes(root, "");

  for (auto i = codes.begin(); i != codes.end(); i++) {
    std::cout << "Char: " << i->first << " -> Code: " << i->second << std::endl;
  }

  const std::string message = "0101101101001";

  std::string decoded = decodeHuffman(root, message);

  std::cout << "Decoded message is: " << decoded << std::endl;
}


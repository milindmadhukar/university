#include <bits/stdc++.h>
#include <cstring>

using namespace std;

unordered_map<char, string> codes;

struct MinHeapNode {
  char data;
  unsigned freq;
  MinHeapNode *left, *right;
  MinHeapNode(char data, unsigned freq) {
    left = right = NULL;
    this->data = data;
    this->freq = freq;
  }
};

struct compare {
  bool operator()(MinHeapNode *l, MinHeapNode *r) {
    return (l->freq > r->freq);
  }
};

void saveCodes(struct MinHeapNode *root, string str) {
  if (!root)
    return;

  if (root->data != '$') {
    codes[root->data] = str;
  }

  saveCodes(root->left, str + "0");
  saveCodes(root->right, str + "1");
}

MinHeapNode *HuffmanCodes(char data[], int freq[], int size) {
  struct MinHeapNode *left, *right, *top;

  priority_queue<MinHeapNode *, vector<MinHeapNode *>, compare> minHeap;

  for (int i = 0; i < size; ++i)
    minHeap.push(new MinHeapNode(data[i], freq[i]));

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

  saveCodes(minHeap.top(), "");

  return top;
}

string decodeHuffman(struct MinHeapNode *root, string s) {
  string ans = "";
  struct MinHeapNode *curr = root;
  for (int i = 0; i < s.size(); i++) {
    if (s[i] == '0')
      curr = curr->left;
    else
      curr = curr->right;

    if (curr->left == NULL and curr->right == NULL) {
      ans += curr->data;
      curr = root;
    }
  }
  return ans + '\0';
}

int main() {

  char arr[] = {'c', 'd', 'g', 'u', 'm', 'a'};
  int freq[] = {34, 9, 35, 2, 2, 100};

  int size = sizeof(arr) / sizeof(arr[0]);

  MinHeapNode *root = HuffmanCodes(arr, freq, size);

  int total_bits = 0;

  for (auto code : codes) {
    total_bits += code.second.length();
    cout << code.first << " - " << code.second << std::endl;
  }

  std::cout << "Total number of bits required to store this file is: "
            << total_bits << std::endl;

  string encoded_message = "0101101101001";
  std::string original_message = decodeHuffman(root, encoded_message);

  std::cout << "Original message: " << original_message << std::endl;

  return 0;
}

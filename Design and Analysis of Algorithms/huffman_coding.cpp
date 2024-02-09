#include <bits/stdc++.h>
#include <cstring>
using namespace std;

unordered_map<char, string> codes;

// A Huffman tree node
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

// The main function that builds a Huffman Tree and
// print codes by traversing the built Huffman Tree
MinHeapNode *HuffmanCodes(char data[], int freq[], int size) {
  struct MinHeapNode *left, *right, *top;

  // Create a min heap & inserts all characters of data[]
  priority_queue<MinHeapNode *, vector<MinHeapNode *>, compare> minHeap;

  for (int i = 0; i < size; ++i)
    minHeap.push(new MinHeapNode(data[i], freq[i]));

  // Iterate while size of heap doesn't become 1
  while (minHeap.size() != 1) {

    // Extract the two minimum
    // freq items from min heap
    left = minHeap.top();
    minHeap.pop();

    right = minHeap.top();
    minHeap.pop();

    // Create a new internal node with
    // frequency equal to the sum of the
    // two nodes frequencies. Make the
    // two extracted node as left and right children
    // of this new node. Add this node
    // to the min heap '$' is a special value
    // for internal nodes, not used
    top = new MinHeapNode('$', left->freq + right->freq);

    top->left = left;
    top->right = right;

    minHeap.push(top);
  }

  // Print Huffman codes using
  // the Huffman tree built above
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

    // reached leaf node
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

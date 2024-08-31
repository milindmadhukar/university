// This is Farooq's Merge Sort Algorithm converted into C code

#include <stdio.h>

void merge(int A[], int BEG, int MID, int END) {
  int I = BEG, J = MID + 1, INDEX = 0;
  int OA[END - BEG + 1];

  while (I <= MID && J <= END) {
    if (A[I] < A[J]) {
      OA[INDEX++] = A[I++];
    } else {
      OA[INDEX++] = A[J++];
    }
  }

  while (I <= MID) {
    OA[INDEX++] = A[I++];
  }

  while (J <= END) {
    OA[INDEX++] = A[J++];
  }

  for (int K = 0; K < INDEX; K++) {
    A[BEG + K] = OA[K];
  }
}

void merge_sort(int A[], int BEG, int END) {
  if (BEG < END) {
    int MID = (BEG + END) / 2;
    merge_sort(A, BEG, MID);
    merge_sort(A, MID + 1, END);
    merge(A, BEG, MID, END);
  }
}

int main() {
  int A[] = {5, 3, 8, 6, 2, 7, 1, 4};
  int N = sizeof(A) / sizeof(int);

  merge_sort(A, 0, N - 1);

  for (int i = 0; i < N; i++) {
    printf("%d ", A[i]);
  }

  return 0;
}

#include <algorithm> // For sort and max
#include <iostream>
#include <queue>  // For std::priority_queue
#include <vector> // For std::vector

using namespace std;

struct Job {
  int id;
  int deadline;
  long long profit;
};

bool compareJobs(const Job &a, const Job &b) { return a.profit > b.profit; }

struct Node {
  int level;            // Current job level
  long long profit;     // Profit so far
  long long bound;      // Upper bound on profit for this path
  vector<int> schedule; // Time slots filled
};

struct CompareNode {
  bool operator()(const Node &a, const Node &b) { return a.bound < b.bound; }
};

long long calculateBound(const vector<Job> &jobs, int n, int level,
                         long long currentProfit) {
  long long bound = currentProfit;
  for (int i = level; i < n; ++i) {
    bound += jobs[i].profit;
  }
  return bound;
}

int findSlot(const vector<int> &schedule, int deadline) {
  // schedule[0] is unused, slots are 1-based
  int max_d = schedule.size() - 1;

  // Find latest possible slot
  for (int t = min(deadline, max_d); t >= 1; --t) {
    if (schedule[t] == -1) {
      return t; // Found an empty slot
    }
  }
  return -1; // No slot available
}

long long solveJobSequencing(vector<Job> &jobs) {
  int n = jobs.size();
  if (n == 0) {
    return 0;
  }

  // Sort jobs by profit in descending order
  sort(jobs.begin(), jobs.end(), compareJobs);

  int maxDeadline = 0;
  for (int i = 0; i < n; i++) {
    if (jobs[i].deadline > maxDeadline) {
      maxDeadline = jobs[i].deadline;
    }
  }

  long long maxProfit = 0;

  priority_queue<Node, vector<Node>, CompareNode> pq;

  Node root;
  root.level = 0;
  root.profit = 0;
  // -1 indicates an empty slot. Size is maxDeadline + 1
  root.schedule.assign(maxDeadline + 1, -1);
  root.bound = calculateBound(jobs, n, 0, 0);

  pq.push(root);

  while (!pq.empty()) {
    Node u = pq.top();
    pq.pop();

    // Prune if this branch can't beat our maxProfit
    if (u.bound <= maxProfit) {
      continue;
    }

    // Stop if we are at a leaf node
    if (u.level == n) {
      continue;
    }

    Job currentJob = jobs[u.level];

    // BRANCH 1: INCLUDE the job
    int slot = findSlot(u.schedule, currentJob.deadline);

    if (slot != -1) {
      // It's feasible, create the "include" child node
      Node v;
      v.level = u.level + 1;
      v.profit = u.profit + currentJob.profit;

      // Vector assignment handles the copy
      v.schedule = u.schedule;
      v.schedule[slot] = currentJob.id;

      v.bound = calculateBound(jobs, n, v.level, v.profit);

      // Update global max profit
      if (v.profit > maxProfit) {
        maxProfit = v.profit;
      }

      // Only add child if its bound is promising
      if (v.bound > maxProfit) {
        pq.push(v);
      }
    }

    // BRANCH 2: EXCLUDE the job
    Node w;
    w.level = u.level + 1;
    w.profit = u.profit;
    w.schedule = u.schedule; // Vector assignment handles the copy
    w.bound = calculateBound(jobs, n, w.level, w.profit);

    // Only add child if its bound is promising
    if (w.bound > maxProfit) {
      pq.push(w);
    }
  }

  return maxProfit;
}

int main() {
  int n;

  cout << "Enter the number of jobs: ";
  cin >> n;

  if (n <= 0) {
    cout << "Invalid number of jobs." << endl;
    return 1;
  }

  // Create a vector of Jobs with size n
  vector<Job> jobs(n);

  cout << "Enter job details (id deadline profit) for each job:" << endl;
  for (int i = 0; i < n; i++) {
    cout << "Job " << i + 1 << ": ";
    cin >> jobs[i].id >> jobs[i].deadline >> jobs[i].profit;
  }

  long long maxProfit = solveJobSequencing(jobs);

  cout << "\nMaximum Profit: " << maxProfit << endl;

  /*
   Test Input:
   6
   1 5 200
   2 3 180
   3 3 190
   4 2 300
   5 4 120
   6 2 100
   Expected Output: 870
  */

  return 0;
}

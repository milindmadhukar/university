const arr = [12, 34, 56, 78, 90, 23, 45, 67, 89, 10]

function findMin(arr) {
  let min = arr[0]
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] < min) {
      min = arr[i]
    }
  }

  const res = document.querySelector('#result')
  res.innerHTML = 'Minimum value is ' + min + '\n'
}

function findMax(arr) {
  let max = arr[0]
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] > max) {
      max = arr[i]
    }
  }

  const res = document.querySelector('#result')
  res.innerHTML = 'Max value is ' + max + '\n'
}

function findAverage(arr) {
  let sum = 0
  for (let i = 0; i < arr.length; i++) {
    sum += arr[i]
  }

  const res = document.querySelector('#result')
  res.innerHTML = 'Average value is ' + sum / arr.length + '\n'
}

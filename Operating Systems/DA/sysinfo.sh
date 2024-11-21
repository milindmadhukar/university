#!/bin/bash

echo "System Information:"
echo "==================="
echo "Hostname: $(hostname)"
echo "OS: $(uname -s)"
echo "Kernel Version: $(uname -r)"
echo "CPU: $(grep 'model name' /proc/cpuinfo | head -n1 | cut -d ':' -f2 | sed 's/^[ \t]*//')"
echo "Memory: $(free -h | awk '/^Mem:/ {print $2}')"
echo "Disk Usage: $(df -h / | awk 'NR==2 {print $5}')"

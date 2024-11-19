Create a new simulator set ns [new Simulator]
# Open trace and NAM files
set tf [open 22BCE2850_DV.tr w] set nf [open 22BCE2850_DV.nam w]
$ns namtrace-all $nf
$ns trace-all $tf
# Configure routing protocol to Distance Vector (DV)
$ns rtproto DV
# Define finish procedure to close files and start NAM proc finish {} {
global ns nf
$ns flush-trace close $nf
exec nam 22BCE3281_DV.nam & exit 0
}

# Define nodes
set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]
set n3 [$ns node]
set n4 [$ns node]
set n5 [$ns node]
set n6 [$ns node]

# Label nodes for better identification
$n0 label "node 0"
$n1 label "node 1"
$n2 label "node 2"
$n3 label "node 3"
$n4 label "node 4"
$n5 label "node 5"
$n6 label "node 6"

# Set node colors for visualization
$n0 color blue
$n1 color red
$n2 color red
$n3 color blue
$n4 color blue
$n5 color blue
$n6 color blue
# Create TCP agents and attach to nodes set tcp2 [new Agent/TCP]
$ns attach-agent $n0 $tcp2

set sink2 [new Agent/TCPSink]
$ns attach-agent $n3 $sink2
$ns connect $tcp2 $sink2
set traffic_ftp2 [new Application/FTP]
$traffic_ftp2 attach-agent $tcp2
# Establish duplex links between nodes with bandwidth, delay, and queue type
$ns duplex-link $n0 $n1 1.5Mb 10ms DropTail
$ns duplex-link $n1 $n2 1.5Mb 20ms DropTail
$ns duplex-link $n2 $n3 2.5Mb 10ms DropTail
$ns duplex-link $n3 $n4 1.5Mb 18ms DropTail
$ns duplex-link $n4 $n5 1.5Mb 18ms DropTail
$ns duplex-link $n5 $n6 1.5Mb 18ms DropTail
$ns duplex-link $n6 $n0 1.5Mb 18ms DropTail

# Set link orientation for better visualization in NAM
$ns duplex-link-op $n0 $n1 orient left-down
$ns duplex-link-op $n1 $n2 orient left-down
$ns duplex-link-op $n2 $n3 orient right-down
$ns duplex-link-op $n3 $n4 orient right
$ns duplex-link-op $n4 $n5 orient right-up
$ns duplex-link-op $n5 $n6 orient left-up
$ns duplex-link-op $n6 $n0 orient left-up
# Schedule FTP traffic
$ns at 1.0 "$traffic_ftp2 start"
$ns at 3.0 "$traffic_ftp2 stop

# Simulate link failure at 2.0 seconds and recovery at 2.6 seconds
$ns rtmodel-at 2.0 down $n2 $n3
$ns rtmodel-at 2.6 up $n2 $n3
# Schedule finish procedure at 5 seconds
$ns at 5.0 "finish"
# Run the simulation
$ns run

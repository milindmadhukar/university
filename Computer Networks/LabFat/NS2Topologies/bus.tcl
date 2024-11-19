# Create a simulator object
set ns [new Simulator]
# Define different colors
# for data flows (for NAM)
$ns color 1 Blue
$ns color 2 Red
# Open the NAM trace file
set nf [open out.nam w]
$ns namtrace-all $nf
# Define a 'finish' procedure
proc finish {} {
 global ns nf
 $ns flush-trace
 close $nf
 exec nam out.nam &
 exit 0
}
# Create seven nodes
set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]
set n3 [$ns node]
set n4 [$ns node]
set n5 [$ns node]
set n6 [$ns node]
# Create links between the backbone nodes (bus topology)
$ns duplex-link $n0 $n1 10Mb 10ms DropTail
$ns duplex-link $n1 $n2 10Mb 10ms DropTail
$ns duplex-link $n2 $n3 10Mb 10ms DropTail
$ns duplex-link $n3 $n4 10Mb 10ms DropTail

# Connect n5 to the backbone at n2
$ns duplex-link $n5 $n2 10Mb 10ms DropTail
# Connect n6 to the backbone at n3
$ns duplex-link $n6 $n3 10Mb 10ms DropTail
# Set positions (for NAM)
$ns duplex-link-op $n0 $n1 orient right
$ns duplex-link-op $n1 $n2 orient right
$ns duplex-link-op $n2 $n3 orient right
$ns duplex-link-op $n3 $n4 orient right
$ns duplex-link-op $n2 $n5 orient right-up
$ns duplex-link-op $n3 $n6 orient right-down

# Monitor the queue for link (n2-n3). (for NAM)
$ns duplex-link-op $n2 $n3 queuePos 0.5
# Setup a TCP connection from n5 to n6
set tcp [new Agent/TCP]
$tcp set class_ 2
$ns attach-agent $n5 $tcp
set sink [new Agent/TCPSink]
$ns attach-agent $n6 $sink
$ns connect $tcp $sink
$tcp set fid_ 1
# Setup a FTP over TCP connection
set ftp [new Application/FTP]
$ftp attach-agent $tcp
$ftp set type_ FTP

# Schedule events for the FTP agent
$ns at 0.1 "$ftp start"
$ns at 4.0 "$ftp stop"
# Call the finish procedure after 5 seconds of simulation time
$ns at 5.0 "finish"
# Run the simulation
$ns run

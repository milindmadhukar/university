# Hybrid Topology in NS2 (Star-Bus)
# Create the simulator object
set ns [new Simulator]
# Open the nam and trace files set
nf [open out.nam w]
$ns namtrace-all $nf

# Define the finish procedure
proc finish {} {
global ns nf
$ns flush-trace
close $nf
exec nam out.nam &
exit 0
}

# Create the central hub node for the star set hub
[$ns node]
# Create star topology nodes and connect them to the hub for {set i
0} {$i < 3} {incr i} {Heading 3
set node($i) [$ns node]
$ns duplex-link $hub $node($i) 1Mb 10ms DropTail
}
# Create bus topology nodes for
{set i 3} {$i < 6} {incr i} {
set node($i) [$ns
node]
}
# Connect bus nodes
for {set i 3} {$i < 5} {incr i} {
$ns duplex-link $node($i) $node([expr $i + 1]) 1Mb 10ms DropTail
}

# Connect the bus to the hub
$ns duplex-link $hub $node(3) 1Mb 10ms DropTail

# Run the simulation
$ns at 5.0 "finish"
$ns run

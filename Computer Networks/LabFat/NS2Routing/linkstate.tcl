set ns [new Simulator]
set tf [open 22BCE2850_LS.tr w] set nf [open22BCE2850_LS.nam w]
$ns namtrace-all $nf
$ns trace-all $tf
$ns rtproto LS proc finish {} {
global ns nf
$ns flush-trace close $nf
exec nam 22BCE3492_LS.nam & exit 0 9. }
set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]
set n3 [$ns node]
set n4 [$ns node]
set n5 [$ns node]
set n6 [$ns node]

$n0 label "node 0"
$n1 label "node 1"
$n2 label "node 2"
$n3 label "node 3"
$n4 label "node 4"
$n5 label "node 5"
$n6 label "node 6"

$n0 label-color blue
$n1 label-color red
$n2 label-color red
$n3 label-color blue
$n4 label-color blue
$n5 label-color blue
$n6 label-color blue
$ns duplex-link $n0 $n1 1.5Mb 10ms DropTail
$ns duplex-link $n1 $n2 1.5Mb 10ms DropTail
$ns duplex-link $n2 $n3 1.5Mb 10ms DropTail
$ns duplex-link $n3 $n4 1.5Mb 10ms DropTail
$ns duplex-link $n4 $n5 1.5Mb 10ms DropTail
$ns duplex-link $n5 $n6 1.5Mb 10ms DropTail
$ns duplex-link $n6 $n0 1.5Mb 10ms DropTail
$ns duplex-link-op $n0 $n1 orient left-down
$ns duplex-link-op $n1 $n2 orient left-down
$ns duplex-link-op $n2 $n3 orient right-down
$ns duplex-link-op $n3 $n4 orient right
set tcp0 [new Agent/TCP]
$ns attach-agent $n0 $tcp0 set sink0 [new Agent/TCPSink]
$ns attach-agent $n3 $sink0
$ns connect $tcp0 $sink0
set traffic_ftp [new Application/FTP]
$traffic_ftp attach-agent $tcp0
$ns at 0.5 "$traffic_ftp start"
$ns rtmodel-at 1.0 down $n2 $n3
$ns rtmodel-at 2.0 up $n2 $n3
$ns at 3.0 "$traffic_ftp start"
$ns at 4.0 "$traffic_ftp stop"
$ns at 5.0 "finish"
$ns run

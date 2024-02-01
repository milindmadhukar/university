module magnitude_comparator(A, B, AGreaterB, ALesserB, AEqualB);
  input [3:0] A, B;
  output AGreaterB, ALesserB, AEqualB;
  reg AGreaterB, ALesserB, AEqualB;
  
  always @ (A, B)
  begin
    AGreaterB <= (A > B);
    ALesserB <= (A < B);
    AEqualB <= (A == B);
  end
endmodule

module magnitude_comparator_tb;
  reg [3:0] A, B;
  wire AGreaterB, ALesserB, AEqualB;
  
  magnitude_comparator tb(A, B, AGreaterB, ALesserB, AEqualB);
  
  initial
  begin
    A = 4'b0000; B = 4'b0001;
    #10 A = 4'b0011; B = 4'b0010;
    #10 A = 4'b0100; B = 4'b0100;
    #30 $stop;
  end
endmodule